package com.czq.aboutclass;

import java.util.TreeMap;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/5/28 11:04 下午
 **/
public class ClassTest {

    /**
     * 1。静态代码块只执行一次。构造代码块在每次创建对象是都会执行。   静态代码块> 普通代码块 > 构造代码块
     * */
    public static void main(String[] args) throws Exception{
        Father f = new Son();
        f = new Son();
        //Father static
        //Son static
        //Father block
        //Father
        //Son block
        //Son

        //Father block
        //Father
        //Son block
        //Son

        Class c1 = f.getClass();

        Class c2 = Father.class;
        Class c3 = Son.class;

        Class c4 = Class.forName("com.czq.aboutclass.Son");

        System.out.println(c1 + "   "+c2+"  "+c3+"  "+c4);

        System.out.println(c1.getMethods());

        System.out.println(Runtime.getRuntime().maxMemory()+"" +
                "\n"+Runtime.getRuntime().freeMemory()+"\n"+Runtime.getRuntime().totalMemory());


        Father father = new Son();
        father.say1();
    }
}


class Father{

    static {
        System.out.println("Father static");
    }
    {
        System.out.println("Father block");
    }
    Father(){
        System.out.println("Father");
    }
    public void say1(){
        System.out.println("Father");
    }

}

class Son extends Father{
    static {
        System.out.println("Son static");
    }
    {
        System.out.println("Son block");
    }
    Son(){
        System.out.println("Son");
    }
    public void say(){

    }
    public void say1(){
        System.out.println("Son");
    }
}