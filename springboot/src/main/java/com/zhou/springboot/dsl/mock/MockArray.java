package com.zhou.springboot.dsl.mock;

import java.util.ArrayList;
import java.util.List;

public class MockArray implements Mock {

    private List<Object> list = new ArrayList<>();

    private Mock parent;

}
