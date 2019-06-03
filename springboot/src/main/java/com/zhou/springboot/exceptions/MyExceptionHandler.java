package com.zhou.springboot.exceptions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhou.springboot.model.Result;
import com.zhou.springboot.model.TestBean;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.zhou.springboot.model.Result.Builder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestControllerAdvice
@Log4j2
public class MyExceptionHandler{

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletRequest request,Exception e) {
        /*       TestMap testMap = new TestMap();
        testMap.put("aa",1);
        testMap.put("bb","zhf");*/
        TestBean testBean = new TestBean();
        testBean.name="zhf";
        testBean.num=1;
//        JSONObject data = JSONObject.parse(JSONObject.toJSONString(testBean));
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(testBean));
        Result result = Builder.Builder().setStatusCode("500").setMsg("服务器异常").setData(jsonObject).build();
        return result;
    }

    private JSONObject analysisBody(HttpServletRequest request){
        String str = getBodyFromRequest(request);
        if(StringUtils.isEmpty(str)){
            log.error("传入body的字符串为空");
            return null;
        }
        return JSONObject.parseObject(str);
    }

    private String getBodyFromRequest(HttpServletRequest request){
        String str = null;
        try {
            str = IOUtils.toString(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
