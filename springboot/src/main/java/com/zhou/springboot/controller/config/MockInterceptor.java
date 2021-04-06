package com.zhou.springboot.controller.config;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class MockInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(MockInterceptor.class);
    public static final String HEADER_MOCK = "mock";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        String mockValue = request.getHeader(HEADER_MOCK);
        if (StringUtils.isBlank(mockValue)) {
            //true代表继续接下来的处理流程
            return true;
        } else if (!mockValue.toLowerCase().equals("true")) {
            return true;
        } else {
            logger.debug("执行mock方法 ==> ");
            response.getOutputStream().write("{\"a\":123}".getBytes("utf-8"));
            response.setHeader("Content-type", ContentType.APPLICATION_JSON.getMimeType());
            return false;
        }
    }

}
