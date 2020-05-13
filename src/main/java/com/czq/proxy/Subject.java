package com.czq.proxy;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/5
 */
/**
 * 需要动态代理的接口
 */
public interface Subject
{
    /**
     * 你好
     *
     * @param name
     * @return
     */
    public String SayHello(String name);

    /**
     * 再见
     *
     * @return
     */
    public String SayGoodBye();
}
