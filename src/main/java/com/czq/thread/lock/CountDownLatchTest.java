package com.czq.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/15
 */
public class CountDownLatchTest {

    private static final int runner_num = 5;



    public static void main(String[] args) {
        //初始化设定线程个数
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(runner_num);
        List<Runner>  runners = new ArrayList<>(runner_num);

        for (int i = 0; i < runner_num; i++) {
           runners.add(new Runner(start,end,i));
        }

        ExecutorService exe = Executors.newFixedThreadPool(runner_num);

        for (Runner r : runners){
            exe.execute(r);
        }

        System.out.println("start.....");

        start.countDown();

        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("end.....");
            exe.shutdown();
        }

    }
}
class Runner implements Runnable{

    private CountDownLatch start;
    private CountDownLatch end;
    private int id;

    Random random = new Random();

    public Runner(CountDownLatch start,CountDownLatch end,int id){
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public void run() {
        {
            try {
                start.await();
                TimeUnit.SECONDS.sleep(random.nextInt(10));
                System.out.println("Runner-"+id+"finished!!!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                end.countDown();
            }
        }
    }
}
