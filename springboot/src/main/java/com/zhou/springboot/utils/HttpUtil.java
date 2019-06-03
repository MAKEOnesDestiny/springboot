package com.zhou.springboot.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Log4j2
public class HttpUtil {

    /**
     * 从request中获取body，封装成对应的JSONObject
     * @param request
     * @return
     */
    public static JSONObject analysisBody(HttpServletRequest request){
        String str = getBodyFromRequest(request);
        if(StringUtils.isEmpty(str)){
            log.error("传入body的字符串为空");
            return null;
        }
        return JSONObject.parseObject(str);
    }

    /**
     * 从request中获取body,以String形式返回
     * @param request
     * @return
     */
    public static String getBodyFromRequest(HttpServletRequest request){
        String str = null;
        try {
            str = IOUtils.toString(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
