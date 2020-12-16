package com.zhou.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(properties = {"logging.level.root=INFO"})
@WebAppConfiguration
public class MockTester {

    private static final Logger logger = LoggerFactory.getLogger(MockTester.class);
    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;
    protected String token;

    /**
     * post表单，无文件
     *
     * @param url      url
     * @param formData 表单，值之后会被转为string
     * @return BIMessage
     */
 /*   protected void postWithFormData(String url, Map<String, Object> formData, boolean isToken) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);
        if (MapUtils.isNotEmpty(formData)) {
            formData.forEach((key, val) -> {
                if (Arrays.isArray(val)) {
                    requestBuilder.param(key, JsonHelper.toJsonString(val));
                } else {
                    requestBuilder.param(key, val == null ? null : val.toString());
                }
            });
        }
        if (isToken) {
            requestBuilder.header(biAuthProperties.getTokenHeader(), token);
        }
        String contentAsString = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        logger.info("返回的数据==========start\n{}", contentAsString);
        logger.info("返回的数据==========end");

        return JsonHelper.toSimpleObject(contentAsString, BIMessage.class);
    }

    *//**
     * post表单，有文件
     *
     * @param url      url
     * @param formData 非文件表单参数
     * @param files    文件表单
     * @return BIMessage
     *//*
    protected BIMessage postWithFile(String url, Map<String, Object> formData, Map<String, Resource> files,
                                     boolean isToken)
            throws Exception {
        if (MapUtils.isEmpty(files)) {
            return postWithFormData(url, formData, isToken);
        }
        MockMultipartHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.multipart(url);
        //        files.forEach(requestBuilder::file);
        Set<Entry<String, Resource>> entries = files.entrySet();
        for (Entry<String, Resource> entry : entries) {
            String k = entry.getKey();
            Resource v = entry.getValue();
            MockMultipartFile f = new MockMultipartFile(k, v.getFilename(), MediaType.MULTIPART_FORM_DATA_VALUE,
                                                        v.getInputStream());
            requestBuilder.file(f);
            MockPart mockPart = new MockPart(k, getFileByte(v.getInputStream()));
            requestBuilder.part(mockPart);
        }
        if (MapUtils.isNotEmpty(formData)) {
            formData.forEach((key, val) -> {
                requestBuilder.param(key, val.toString());
            });
        }
        if (isToken) {
            requestBuilder.header(biAuthProperties.getTokenHeader(), token);
        }
        String contentAsString = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        logger.info("返回的数据==========start\n{}", contentAsString);
        logger.info("返回的数据==========end");
        return JsonHelper.toSimpleObject(contentAsString, BIMessage.class);
    }

    *//**
     * get 请求
     *
     * @param url    url
     * @param params 参数
     * @return BIMessage
     *//*
    protected BIMessage getWithParam(String url, LinkedMultiValueMap<String, String> params, boolean isToken)
            throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
        if (MapUtils.isNotEmpty(params)) {
            requestBuilder.params(params);
        }
        if (isToken) {
            requestBuilder.header(biAuthProperties.getTokenHeader(), token);
        }
        String contentAsString = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        logger.info("返回的数据==========start\n{}", contentAsString);
        logger.info("返回的数据==========end");

        return JsonHelper.toSimpleObject(contentAsString, BIMessage.class);
    }


    *//**
     * 通过json请求 content-type:application/json
     *
     * @param url     url
     * @param jsonObj json对象
     * @return BIMessage
     *//*
    protected BIMessage postWithJson(String url, Object jsonObj, boolean isToken) throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonHelper.toJsonString(jsonObj));
        if (isToken) {
            requestBuilder.header(biAuthProperties.getTokenHeader(), token);
        }
        String contentAsString = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        logger.info("返回的数据==========start\n{}", contentAsString);
        logger.info("返回的数据==========end");
        return JsonHelper.toSimpleObject(contentAsString, BIMessage.class);
    }*/
}
