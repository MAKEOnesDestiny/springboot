package com.zhou.springboot.dsl.mock;

import java.util.HashMap;
import java.util.Map;

public class MockObj implements Mock {

    private Map<String, Object> map = new HashMap<>();

    private Mock parent;

}
