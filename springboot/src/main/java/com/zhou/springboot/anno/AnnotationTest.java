package com.zhou.springboot.anno;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@MyAnnotation(value = "aa")
@Service("aaa")
public class AnnotationTest {

    @Test
    public void test(){
        MyAnnotation m = AnnotationUtils.findAnnotation(this.getClass(),MyAnnotation.class);
        System.out.println(m.value());
        System.out.println(m.alias());

        Service s = AnnotationUtils.findAnnotation(this.getClass(), Service.class);
        System.out.println(s.value());
    }

}
