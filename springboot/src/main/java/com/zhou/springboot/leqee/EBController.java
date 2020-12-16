package com.zhou.springboot.leqee;

import com.zhou.springboot.bean.HasbaniSynsLog;
import com.zhou.springboot.dao.TimeOutMapper;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
@RequestMapping(value = "/eb")
@Lazy
public class EBController {

    @Resource
    private TimeOutMapper timeOutMapper;

    @RequestMapping(value = "/test")
    @ResponseBody
    public List<String> exceptionTest(String tables) {
        String[] tablesArray = tables.split(",");
        List<String> res = timeOutMapper.selectLog(tables, tablesArray.length);
        return res;
    }


}
