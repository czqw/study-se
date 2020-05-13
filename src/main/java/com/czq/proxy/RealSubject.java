package com.czq.proxy;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/5
 */
/**
 * 实际对象
 */
public class RealSubject implements Subject,Subject2 {

    /**
     * 你好
     *
     * @param name
     * @return
     */
    public String SayHello(String name)
    {
        return "hello " + name;
    }

    /**
     * 再见
     *
     * @return
     */
    public String SayGoodBye()
    {
        return " good bye ";
    }

    @Override
    public void hello() {
        System.out.println("Subject2 hello");
    }

    public void real(){

    }
}
