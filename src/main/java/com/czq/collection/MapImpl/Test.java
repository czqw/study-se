package com.czq.collection.MapImpl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/20
 */
public class Test {

    public static void main(String[] args) throws Exception {
       // czqMap();
       // hashMap();
    }

    public static void czqMap() throws Exception{
        Long s = System.currentTimeMillis();
        Map<String,String> map = new CzqMap<>(10);
        for (int i = 0; i < 1000; i++) {
            map.put(String.valueOf(i),"czq"+i);
        }
        System.out.println("czqMap:"+"  100--->" + map.get(String.valueOf(100)) +"\n size:"+ map.size());
        System.out.println(" time:" + (System.currentTimeMillis() - s));

        Method m = map.getClass().getDeclaredMethod("capacity");
        m.setAccessible(true);
        System.out.println("capacity:"+m.invoke(map));

        System.out.println();
        for (int i = 0; i < 10; i++) {
            if (!map.containsKey(String.valueOf(i))){
                System.out.print(i + "\t");
            }
        }
        System.out.println("repeat:"+((CzqMap<String, String>) map).repeatList);
        System.out.println();
    }

    public static void hashMap() throws Exception{
        Long s = System.currentTimeMillis();
        Map<String,String> map = new HashMap<>(10);
        for (int i = 0; i < 1000; i++) {
            map.put(String.valueOf(i),"czq"+i);
        }
        System.out.println("hashMap:"+"  100--->" + map.get(String.valueOf(100)) + "\n size:"+map.size());
        System.out.println(" time:" + (System.currentTimeMillis() - s));
        Method m = map.getClass().getDeclaredMethod("capacity");
        m.setAccessible(true);
        System.out.println("capacity:"+m.invoke(map));
    }
}
