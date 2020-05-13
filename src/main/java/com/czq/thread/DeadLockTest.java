package com.czq.thread;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/22
 */
public class DeadLockTest {

    public static  Object o1 = new Object();
    public static  Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
              synchronized (o1){   //获取o1的监视器锁
                  System.out.println(Thread.currentThread()+"getO1");
                  try {
                      Thread.sleep(1000);//休眠1秒
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread()+"waiting for o2");
                  synchronized (o2){
                      System.out.println(Thread.currentThread()+"getO2");
                  }
              }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                synchronized (o2){   //获取o1的监视器锁
                    System.out.println(Thread.currentThread()+"getO2");
                    try {
                        Thread.sleep(1000);//休眠1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"waiting for o1");
                    synchronized (o1){
                        System.out.println(Thread.currentThread()+"getO1");
                    }
                }
            }
        }.start();
    }
}
