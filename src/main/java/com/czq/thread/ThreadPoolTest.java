package com.czq.thread;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/22
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test2(){
        Executor pool = Executors.newCachedThreadPool();
        CountDownLatchTest1  test = new CountDownLatchTest1();
        for (int i=0;i<10;i++){
            pool.execute(test);
        }
    }


    public static void test1(){
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int j = 0; j < 10; j++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

//    public static void execute(List<Runnable> runnables) {
//        //创建包含10个线程的执行器
//        Executor executor = Executors.newFixedThreadPool(10);
//        for (Runnable r : runnables) {
//            //*提交任务
//            executor.execute(r);
//        }
//    }
}

class CountDownLatchTest1 implements Runnable{

    final AtomicInteger number = new AtomicInteger();
    volatile boolean bol = false;

    @Override
    public void run() {
        System.out.println(number.getAndIncrement());
        synchronized (this){
            try {
                if (!bol){
                    System.out.println(bol);
                    bol = true;
                    Thread.sleep(10000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("并发数量："+number.intValue());
        }
    }
}