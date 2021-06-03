package com.zhou.springboot.test;

import com.zhou.springboot.model.TestBean;
import java.util.List;

//泛型测试
public class ParamterTest {


    public static void main(String[] args) {
        Class clazz = ListenerImpl.class;
        Class clazz1 = ListenerImpl1.class;

        clazz.getGenericInterfaces();
    }


    static final class ListenerImpl1 implements Listener<List<TestBean>> {

        @Override
        public List<TestBean> doBiz() {
            return null;
        }
    }

    static final class ListenerImpl implements Listener<TestBean> {

        @Override
        public TestBean doBiz() {
            return null;
        }
    }

    interface Listener<T> {

        T doBiz();

    }

}
