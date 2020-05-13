package com.czq.collection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/19
 */
public class HashMapTest  {

    public static void main(String[] args) throws Exception{
      /*  Map<String,Integer> map = new HashMap<>();

        map.put("score",11);
        Integer ai = map.put("score",12);
        System.out.println(ai);

        map.put(null,1);
        System.out.println(map.get(null));

        System.out.println(isNaN(new Float(0.0/0.0)));
        capacityTest(1);
        capacityTest(2);
        capacityTest(3);
        capacityTest(4);
        capacityTest(7);
        capacityTest(21);
        capacityTest(1500000000);
        thresholdTest();
*/
        Map table = new Hashtable();
        table.put(null,1);
    }

    public static int capacityTest(int initCapacity) throws Exception {
        Map<String,Integer> map = new HashMap<>(initCapacity);
        Method capacity = map.getClass().getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        Integer realCapacity = (Integer)capacity.invoke(map);
        System.out.println("入参容量为" + initCapacity + "时，实际容量为" + realCapacity);


        Field t;Field[] f;
        Class m = Class.forName("java.util.HashMap");
        f = m.getDeclaredFields();
        AccessibleObject.setAccessible(f,true);
        for (Field field : f){
            if ( "table".equals(field.getName())){
                t = field;
                System.out.println(t.toString());
            }
        }


  //      System.out.println("table.length:"+f.get(map));

        return realCapacity;
    }

    public static void thresholdTest() throws Exception {

        Map<String, String> map = new HashMap<String, String>();

        // 获取map扩容时临界阈值  阈值 = 容量 * 加载因子
        // 默认容量 为16，加载因子 默认为0.75
        Field threshold = map.getClass().getDeclaredField("threshold");
        Field size = map.getClass().getDeclaredField("size");
        Method capacity = map.getClass().getDeclaredMethod("capacity");

        threshold.setAccessible(true);
        size.setAccessible(true);
        capacity.setAccessible(true);

        // 未存放对象时，各项值测试
        System.out.println("start:临界值" + threshold.get(map));
        System.out.println("start:size" + size.get(map));
        System.out.println("start:容量" + capacity.invoke(map));

        // 临界值、容量测试
        for (int i=1; i<26; i++) {
            map.put(String.valueOf(i), i + "**");
            if (i == 11 || i == 12 || i == 13 || i == 23 || i == 24 || i == 25) {
                System.out.println("第" + i + "个对象, size为" + size.get(map) + ", 临界值为" + threshold.get(map) + ", 容量为" + capacity.invoke(map));
            }
        }
    }


    public static boolean isNaN(float v) {
        return (v != v);
    }

}
