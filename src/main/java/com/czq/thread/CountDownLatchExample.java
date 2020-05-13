package com.czq.thread;

import com.czq.thread.help.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/15
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Service service = new Service(latch);
        Runnable task = () -> service.exec();
//        Runnable task1 = new Runnable() {
//            @Override
//            public void run() {
//                service.exec();
//            }
//        };
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }

        System.out.println("main thread await. ");
        latch.await();
        System.out.println("main thread finishes await. ");
    }
}