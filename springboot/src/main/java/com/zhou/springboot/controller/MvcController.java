package com.zhou.springboot.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhou.springboot.anno.ApiDoc;
import com.zhou.springboot.anno.EnableResource;
import com.zhou.springboot.anno.MenuDoc;
import com.zhou.springboot.anno.ParamInfo;
import com.zhou.springboot.bean.TestMvcFatherBean;
import com.zhou.springboot.controller.rest.InputParam;
import com.zhou.springboot.controller.rest.Visualized;
import com.zhou.springboot.controller.rest.WebResource.WebResourceBuilder;
import com.zhou.springboot.model.TestBean;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Part;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/mvc")
@MenuDoc("一级菜单")
@EnableResource
public class MvcController {

    @RequestMapping("test")
    @ApiDoc("测试复杂Bean")
    public void testmvc(@ParamInfo(complexInfo = TestMvcFatherBean.class) @RequestBody TestMvcFatherBean fatherBean) {
        System.out.println(fatherBean.getSon().getId());
    }

    @RequestMapping("test1")
    @ApiDoc("测试")
    public void test1(@ParamInfo(example = "123", meaning = "用户id") Long id,
                      @ParamInfo(example = "小明", meaning = "名字") String name) {
        System.out.println("111");
    }


    //    @RequestMapping("file")
    public void testFile(@RequestPart(value = "fileName") Part part) {
        System.out.println(part.getContentType());
    }


    @RequestMapping("map")
    @ApiDoc("测试Map")
    public void testMap(@RequestBody @ParamInfo(complexInfo = MyMapInfo.class) Map map) {
        System.out.println(map);
    }

    //    @RequestMapping("obj")
    public void testObj(TestBean testBean) {

    }

    //    @RequestMapping("arr")
    public void testArr(Integer[] ints) {
        System.out.println();
    }

    public static final class MyMapInfo implements Visualized {

        @Override
        public void generateWebResource(WebResourceBuilder wrb) throws Exception {
            Map<String, Object> map = new HashMap<>();
            map.put("id", 123L);
            map.put("name", "zhf");
            map.put("isMan", true);
            wrb.setJsonExample(new ObjectMapper().writeValueAsString(map));

            wrb.addInputParam(new InputParam("id", Long.class, 123L, "用户名id", true));
            wrb.addInputParam(new InputParam("name", String.class, "zhf", "名称", true));
            wrb.addInputParam(new InputParam("isMan", Boolean.class, true, "是否是男人", true));
            wrb.build();
        }
    }

}
