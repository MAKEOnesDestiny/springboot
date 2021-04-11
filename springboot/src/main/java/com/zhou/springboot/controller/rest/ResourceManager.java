package com.zhou.springboot.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.zhou.springboot.anno.ApiDoc;
import com.zhou.springboot.anno.EnableResource;
import com.zhou.springboot.anno.MenuDoc;
import com.zhou.springboot.anno.ParamInfo;
import com.zhou.springboot.controller.rest.WebResource.WebResourceBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class ResourceManager implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(ResourceManager.class);
    public static final List<Class> REQUIRE_ANNO_SUPPORT = new ArrayList<Class>() {{
        add(RequestParam.class);
        add(RequestBody.class);
        add(RequestPart.class);
        //todo : add more ... e.g. PathVariable RequestAttribute
    }};
    public static final List<Class> SKIP_CLASS = new ArrayList<Class>() {{
        add(ServletRequest.class);
        add(ServletResponse.class);
        //todo : have more ?
    }};

    @Autowired
    private ApplicationContext ac;

    @Autowired
    private ConversionService conversionService;

    private Map<RequestMappingInfo, HandlerMethod> urlLookup;
    //todo : add lazy initial

    private volatile boolean initialized = false;

    //此方法是在容器全部初始化完成后执行的
    @Override
    public void run(String... args) throws Exception {
        RequestMappingHandlerMapping mapping = ac.getBean(RequestMappingHandlerMapping.class);
        Method method = AbstractHandlerMethodMapping.class.getDeclaredMethod("getMappingRegistry");
        method.setAccessible(true);
        Object mappingRegistry = ReflectionUtils.invokeMethod(method, mapping);
        Class c = Class.forName("org.springframework.web.servlet.handler.AbstractHandlerMethodMapping$MappingRegistry");
        Method getMappingsMethod = c.getDeclaredMethod("getMappings");
        getMappingsMethod.setAccessible(true);
        Map<RequestMappingInfo, HandlerMethod> urlLookup = (Map<RequestMappingInfo, HandlerMethod>) ReflectionUtils
                .invokeMethod(getMappingsMethod, mappingRegistry);
        this.urlLookup = ImmutableMap.copyOf(urlLookup);
        initialized = true;
    }

    public void checkState() {
        if (!initialized) {
            throw new IllegalStateException("Resource Manager is not initialized yet");
        }
    }

    public List<WebResource> getAllWebResource() {
        checkState();
        List<WebResource> webResources = new ArrayList<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : this.urlLookup.entrySet()) {
            if (shouldResolve(entry.getKey(), entry.getValue())) {
                WebResource wr = resolve(entry.getKey(), entry.getValue());
                webResources.add(wr);
            }
        }
        return webResources;
    }

    public WebResource resolve(RequestMappingInfo info, HandlerMethod method) {
        //这里不需要多个urlPath
        String urlPath = info.getPatternsCondition().getPatterns().stream().findFirst().get();
        ApiDoc apiDocAnn = method.getMethod().getAnnotation(ApiDoc.class);
        MenuDoc menuDocAnn = method.getBeanType().getAnnotation(MenuDoc.class);
        String apiDoc = apiDocAnn == null ? null : apiDocAnn.value();
        String menuDoc = menuDocAnn == null ? null : menuDocAnn.value();
        String consumeType = guessContentType(info, method);

        MethodParameter[] methodParameters = method.getMethodParameters();
        List<InputParam> inputParams = new ArrayList<>();
        String jsonExample = null;
        if (methodParameters != null && methodParameters.length > 0) {
            //解析参数
            for (MethodParameter p : methodParameters) {
                if (shouldSkip(p)) {
                    continue;
                }
                ParamInfo pi = p.getParameterAnnotation(ParamInfo.class);
                //越个性化的优先级越高，但是不同优先级的不能混用
                if (pi.complexInfo() != Void.class && Visualized.class.isAssignableFrom(pi.complexInfo())) {
                    WebResourceBuilder wrb = new WebResourceBuilder(urlPath, null, consumeType, null, apiDoc, menuDoc);
                    try {
                        Visualized vc = (Visualized) pi.complexInfo().newInstance();
                        vc.generateWebResource(wrb);
                        return wrb.build();
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                        return wrb.errorBuild();
                    }
                }
                if (MediaType.MULTIPART_FORM_DATA_VALUE.equals(consumeType)
                        || MediaType.APPLICATION_FORM_URLENCODED_VALUE.equals(consumeType)) {
                    if (BeanUtils.isSimpleProperty(p.getParameterType())) {
                        InputParam inputParam = new InputParam(p.getParameter().getName(), p.getParameterType(),
                                                               convert(p, pi, consumeType),
                                                               pi == null ? null : pi.meaning(),
                                                               isRequired(p));
                        inputParams.add(inputParam);
                    } else {
                        resolveComplexProperty(p, consumeType, inputParams, false);
                    }
                } else {
                    //复杂对象，例如Map Bean
                    jsonExample = resolveComplexProperty(p, consumeType, inputParams, true);
                }
            }
        }

        return new WebResource(urlPath, null, consumeType, null, apiDoc, menuDoc, inputParams, jsonExample);
    }


    private String resolveComplexProperty(MethodParameter p, String consumeType, List<InputParam> inputParams,
                                          boolean needJsonExample) {
        Class clazz = p.getParameterType();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> json = new HashMap<>();
        for (Field f : fields) {
            ParamInfo pi = f.getAnnotation(ParamInfo.class);
            if (pi != null) {
                Object v = convertWithFormData(pi.example(), f.getType());
                inputParams.add(new InputParam(f.getName(), f.getType(), v, pi == null ? null : pi.meaning(),
                                               isRequired(p)));
                if (needJsonExample) {
                    json.put(f.getName(), v);
                }
            }
        }
        try {
            return new ObjectMapper().writeValueAsString(json);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    private String guessContentType(RequestMappingInfo info, HandlerMethod method) {
        if (!info.getConsumesCondition().isEmpty()) {
            Set<MediaType> mediaTypes = info.getConsumesCondition().getConsumableMediaTypes();
            //只需要支持一个即可
            MediaType mediaType = mediaTypes.stream().findFirst().get();
            return mediaType.toString();
        }
        //guess form-data or json
        MethodParameter[] methodParameters = method.getMethodParameters();
        if (methodParameters != null && methodParameters.length > 0) {
            for (MethodParameter p : methodParameters) {
                if (p.getParameterAnnotation(RequestBody.class) != null) {
                    return MediaType.APPLICATION_JSON_UTF8_VALUE;
                }
            }
            return MediaType.MULTIPART_FORM_DATA_VALUE;
        }
        //default
        return MediaType.APPLICATION_FORM_URLENCODED_VALUE;
    }

    private boolean shouldSkip(MethodParameter p) {
        for (Class skip : SKIP_CLASS) {
            if (skip.isAssignableFrom(p.getParameterType())) {
                return true;
            }
        }
        return false;
    }

    private boolean shouldResolve(RequestMappingInfo info, HandlerMethod method) {
        EnableResource er = method.getMethod().getDeclaringClass().getAnnotation(EnableResource.class);
        if (er != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isRequired(MethodParameter p) {
        ParamInfo pi = p.getParameterAnnotation(ParamInfo.class);
        if (pi != null && pi.required()) {
            //就算程序上没有做限制，但是也可以在业务上强制限制其必填
            return true;
        }
        for (Class c : REQUIRE_ANNO_SUPPORT) {
            Annotation ann = p.getParameterAnnotation(c);
            if (RequestParam.class.equals(ann)) {
                return ((RequestParam) ann).required();
            }
            if (RequestBody.class.equals(ann)) {
                return ((RequestBody) ann).required();
            }
            if (RequestPart.class.equals(ann)) {
                return ((RequestPart) ann).required();
            }
        }
        return false;
    }

    private Object convert(MethodParameter p, ParamInfo pi, String consumeType) {
        if (pi == null) {
            return null;
        }
        if (StringUtils.isBlank(pi.example())) {
            return null;
        }
        if (MediaType.APPLICATION_JSON_UTF8_VALUE.equals(consumeType)) {
            return convertWithJson(pi.example(), p.getParameterType());
        } else if (MediaType.MULTIPART_FORM_DATA_VALUE.equals(consumeType)
                || MediaType.APPLICATION_FORM_URLENCODED_VALUE.equals(consumeType)) {
            return convertWithFormData(pi.example(), p.getParameterType());
        }
        log.warn("unknow consumeType ==> {}", consumeType);
        return null;
    }

    private Object convertWithFormData(String valueText, Class type) {
        if (valueText == null) {
            return null;
        }
        try {
            return conversionService.convert(valueText, type);
        } catch (Exception e) {
            log.error("can't convert {} to {}", valueText, type);
            return valueText;
        }
    }

    private Object convertWithJson(String valueText, Class type) {
        try {
            ObjectMapper ob = new ObjectMapper();
            return ob.convertValue(valueText, type);
        } catch (Exception e) {
            log.error("can't convert {} to {}", valueText, type);
            return valueText;
        }
    }

}
