package com.zhou.springboot.memory;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MemoryTest {

    @Test
    public void testGCOverhead(){
        List<String> res = new ArrayList<>();
        while(true){
            res.add("aaaaaa");
        }
    }

}
