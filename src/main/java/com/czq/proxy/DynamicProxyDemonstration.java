package com.czq.proxy;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/5
 */

//import sun.misc.ProxyGenerator;
//import sun.plugin.javascript.navig.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理演示
 */
public class DynamicProxyDemonstration
{
    public static void main(String[] args)
    {

        //代理的真实对象
        Subject realSubject = new RealSubject();

        /**
         * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
         * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用.
         * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
         */
        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = realSubject.getClass().getClassLoader();
        System.out.println("loader"+loader);
        Class[] interfaces = realSubject.getClass().getInterfaces();
        System.out.println("interfaces"+ Arrays.toString(interfaces) +"  "+interfaces.length);

        Object o = Proxy.newProxyInstance(loader,interfaces,handler);
        /**
         * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
         */
       // Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);

        Subject subject = (Subject)o;
        System.out.println("动态代理对象的类型："+subject.getClass().getName());

        String hello = subject.SayHello("jiankunking");
        System.out.println(hello);

        System.out.println("==============================================");
    //    Subject2 subject2 = (Subject2) Proxy.newProxyInstance(loader,interfaces,handler);
        Subject2 subject2 = (Subject2)o;
        subject2.hello();

//        String goodbye = subject.SayGoodBye();
//        System.out.println(goodbye);

        // 将生成的字节码保存到本地，
        createProxyClassFile(realSubject.getClass());
    }

    private static void createProxyClassFile(Class c){
        String name = "ProxySubject";
        String name2 = "ProxySubject2";

       // byte[] data = ProxyGenerator.generateProxyClass(name,new Class[]{Subject.class});
        byte[] data = new byte[1];//ProxyGenerator.generateProxyClass(name,c.getInterfaces());
       // byte[] data2 = ProxyGenerator.generateProxyClass(name2,new Class[]{Subject2.class});
        FileOutputStream out =null;
        try {
            out = new FileOutputStream(name+".class");
            System.out.println((new File("hello")).getAbsolutePath());
            out.write(data);

           // out = new FileOutputStream(name2+".class");
         //   out.write(data2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
