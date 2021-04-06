package com.zhou.springboot.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.zhou.springboot.anno.ApiDoc;
import com.zhou.springboot.anno.MenuDoc;
import com.zhou.springboot.anno.ParamInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class ResourceManager implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(ResourceManager.class);

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
            WebResource wr = resolve(entry.getKey(), entry.getValue());
            webResources.add(wr);
        }
        return webResources;
    }

    public WebResource resolve(RequestMappingInfo info, HandlerMethod method) {
        //这里不需要多个urlPath
        String urlPath = info.getPatternsCondition().getPatterns().stream().findFirst().get();
        ApiDoc apiDocAnn = method.getMethod().getAnnotation(ApiDoc.class);
        MenuDoc menuDocAnn = method.getMethod().getAnnotation(MenuDoc.class);
        String apiDoc = apiDocAnn == null ? null : apiDocAnn.value();
        String menuDoc = menuDocAnn == null ? null : menuDocAnn.value();

        MethodParameter[] methodParameters = method.getMethodParameters();
        List<InputParam> inputParams = new ArrayList<>();
        if (methodParameters != null && methodParameters.length > 0) {
            //解析参数
            for (MethodParameter p : methodParameters) {
                ParamInfo pi = p.getParameterAnnotation(ParamInfo.class);
                InputParam inputParam = new InputParam(p.getParameter().getName(), p.getParameterType(), convert(p, pi),
                                                       pi == null ? null : pi.meaning(), isRequired()); //todo : test
                inputParams.add(inputParam);
            }
        }
        return new WebResource(urlPath, null, null, null, apiDoc, menuDoc, inputParams);
    }

    private boolean isRequired() {
        //todo : to do
        return true;
    }

    private Object convert(MethodParameter p, ParamInfo pi) {
        if (pi == null) {
            return null;
        }
        if (StringUtils.isBlank(pi.example())) {
            return null;
        }
        return convertWithJson(pi.example(), p.getParameterType());
    }

    private <T> T convertWithFormData(String valueText, Class<T> type) {
        if (valueText == null) {
            return null;
        }
        try {
            return conversionService.convert(valueText, type);
        } catch (Exception e) {
            log.error("can't convert {} to {}", valueText, type);
            return null;
        }
    }

    private <T> T convertWithJson(String valueText, Class<T> clazz) {
        ObjectMapper ob = new ObjectMapper();
        return ob.convertValue(valueText, clazz);
    }

}
