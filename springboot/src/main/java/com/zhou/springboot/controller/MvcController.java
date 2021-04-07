package com.zhou.springboot.controller;


import com.zhou.springboot.anno.ApiDoc;
import com.zhou.springboot.anno.EnableResource;
import com.zhou.springboot.anno.MenuDoc;
import com.zhou.springboot.anno.ParamInfo;
import com.zhou.springboot.bean.TestMvcFatherBean;
import com.zhou.springboot.model.TestBean;
import java.util.List;
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
    public void testmvc(@ParamInfo() TestMvcFatherBean fatherBean) {
        System.out.println(fatherBean.getSon().getId());
    }

    @RequestMapping("test1")
    @ApiDoc("测试")
    public void test1(@ParamInfo(example = "123", meaning = "用户id") Long id,
                      @ParamInfo(example = "小明", meaning = "名字") String name) {
        System.out.println("111");
    }


    @RequestMapping("file")
    public void testFile(@RequestPart(value = "fileName") Part part) {
        System.out.println(part.getContentType());
    }

    @RequestMapping("map")
    public void testMap(@RequestBody @ParamInfo(example = "{\"a\":123}",meaning = "测试map") List<Integer> map) {
        System.out.println(map);
    }

    @RequestMapping("obj")
    public void testObj(TestBean testBean){

    }

    @RequestMapping("arr")
    public void testArr(Integer[] ints){
        System.out.println();
    }

}
