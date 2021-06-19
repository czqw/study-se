package com.czq.design;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2021/3/21 9:08 上午
 **/
public class Singleton2 {
    private volatile static Singleton2 obj = null;

    private Singleton2(){

    }

    public static Singleton2 getINstance(){
        if(obj == null){
           synchronized(Singleton2.class){
               if(obj == null) obj = new Singleton2();
            }
        }
        return obj;
    }

}
