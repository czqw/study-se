package com.czq.thread;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/4/3
 */
public class ThreadLocalTest {

    public static ThreadLocal<String> threadName = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "-1";
        }
    };

    public static void main(String[] args) throws Exception{
        test1();
        test2();
    }


    public static void test1()throws Exception{
        ThreadLocalTest.threadName.set("789");
        Thread t1 = new Thread(){
            public void run() {
                ThreadLocalTest.threadName.set("123");
                System.out.println("ThreadLocalDemo.threadName in t1 is : " + ThreadLocalTest.threadName.get());
                ThreadLocalTest.threadName.remove();
                System.out.println("ThreadLocalDemo.threadName in t1 is : " + ThreadLocalTest.threadName.get());
            }
        };
        Thread t2 = new Thread(){
            public void run() {
                ThreadLocalTest.threadName.set("456");
                System.out.println("ThreadLocalDemo.threadName in t2 is : " + ThreadLocalTest.threadName.get());
                ThreadLocalTest.threadName.remove();
                System.out.println("ThreadLocalDemo.threadName in t2 is : " + ThreadLocalTest.threadName.get());
            }
        };
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("ThreadLocalDemo.threadName in main is : " + ThreadLocalTest.threadName.get());
    }

    public static void test2() {
        int k=0;
        for(int i=0;i<10;i++) {
            Thread t=new Thread(new ThreadLocalDemo(String.valueOf(i)));
            t.start();
        }
    }
}

class ThreadLocalDemo implements Runnable{
    private static ThreadLocal<Integer> tl=new ThreadLocal<Integer>();

    private String name;
    public ThreadLocalDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if(tl.get()==null)
            tl.set(Integer.valueOf(this.name));
        System.out.println(tl.get()+"  "+tl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}