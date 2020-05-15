package com.dxy.basic.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(3);
        map.put("123","value1");
        map.put("1234","value2");
        map.put("12345","value3");
        map.put("123455",null);
        map.put("123456","value5");
        map.put("1234567","value6");
        System.out.println(map);
        Map<String,String> map2 = new HashMap<>(map);
        System.out.println(map2);
        List<String> list = new ArrayList<>(1);
        list.add("1");
        list.add("2");
        System.out.println(list);
    }
}
