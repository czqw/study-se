package com.czq.thread;

import java.util.Timer;

public class ThreadTest {
    private static  volatile int a = 1;
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Runnable() {
            public void run() {
                ThreadTest.a = 2;
            }
        });
        t.start();
        Thread.sleep(100);
       // t.join();
        System.out.println(a);
    }
}
