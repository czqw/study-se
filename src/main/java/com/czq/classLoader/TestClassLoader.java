package com.czq.classLoader;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/5
 */
public class TestClassLoader {

    public static void main(String[] args) {

        ClassLoader loader = TestClassLoader.class.getClassLoader();

        System.out.println(loader.toString());

        System.out.println(loader.getParent().toString());

        System.out.println(loader.getParent().getParent());

        System.out.println(Object.class.getClassLoader());
    }
}
