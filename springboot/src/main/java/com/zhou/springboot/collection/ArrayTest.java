package com.zhou.springboot.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    public void list2Array() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.toArray(new Integer[0]);
    }

    public void array2List() {
        Integer[] a = new Integer[]{1, 2, 3};
        List<Integer> list = Arrays.asList(a);
    }

}
