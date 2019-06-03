package com.zhou.springboot.test;

public class ExtendsTest {

    public void method(){
        System.out.println("parent");
    }

    public void entry(){
        method();
    }

    public static class ChildExtends extends ExtendsTest{
        @Override
        public void entry() {
            super.entry();
        }

        @Override
        public void method() {
            System.out.println("child");
        }
    }

    public static void main(String[] args) {
        new ChildExtends().entry();
    }

}
