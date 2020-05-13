package com.czq.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/19
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> cmap = new ConcurrentHashMap<>();
        cmap.put("data",1);
        cmap.get("data");
        Collections.synchronizedMap(cmap);
    }

}

