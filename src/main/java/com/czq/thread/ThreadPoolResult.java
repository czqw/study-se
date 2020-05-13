package com.czq.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/22
 */
public class ThreadPoolResult {


    public static void main(String[] args) throws InterruptedException {

//        testMyRunnable();
        testMyCallable();
        printMultiThread();
    }

    public static void printMultiThread(){
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo info: threadInfos) {
            System.out.println(info.getThreadId()+":"+info.getThreadName());
        }
    }

    public static void testMyCallable() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<Result>> list = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(12);
        for (int i = 1;i<=12;i++){
            Result result = new Result();
            result.setParam(i);
            MyCallable callable = new MyCallable(result,countDownLatch);
            list.add(pool.submit(callable));
        }

        countDownLatch.await();
        list.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }

    public static void testMyRunnable() throws InterruptedException {
        Executor pool = Executors.newCachedThreadPool();
        List<Result> list = new ArrayList<>(12);
        CountDownLatch countDownLatch = new CountDownLatch(12);
        for (int i = 1; i <= 12; i++) {
            Result result = new Result();
            result.setParam(i);
            list.add(result);

            MyRunnable runnable = new MyRunnable(result,countDownLatch);
            pool.execute(runnable);
        }
        countDownLatch.await();
        System.out.println(list);
        ((ExecutorService) pool).shutdown();
    }
}

class MyCallable implements Callable<Result>{

    private Result result;

    private CountDownLatch countDownLatch;

    MyCallable(Result result, CountDownLatch countDownLatch) {
        this.result = result;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public Result call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name+"  线程开始执行---param:"+result.getParam());
        for (int i =0; i<10000;i++){
            if (i==9999 && result != null){
                result.setResult(result.getParam()*10);
                result.setSuccess(true);
                System.out.println(name + " 线程正在进行计算---" + "-" + result.getParam());
            }else {
                result.setSuccess(false);
            }
        }
        System.out.println(name + " 线程执行完毕" + "-" + result.getParam());
        countDownLatch.countDown();
        return result;
    }
}


class MyRunnable implements Runnable{

    private Result result;

    private CountDownLatch countDownLatch;

    public MyRunnable(Result result,CountDownLatch countDownLatch){
        this.result = result;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"  线程开始执行---param:"+result.getParam());
        for (int i =0; i<10000;i++){
            if (i==9999 && result != null){
                result.setResult(result.getParam()*10);
                result.setSuccess(true);
                System.out.println(name + " 线程正在进行计算---" + "-" + result.getParam());
            }else {
                result.setSuccess(false);
            }
        }
        System.out.println(name + " 线程执行完毕" + "-" + result.getParam());
        countDownLatch.countDown();
    }
}




class Result{
    // 输入参数
    private Integer param;
    // 是否运算成功
    private Boolean success;
    // 运算结果
    private Integer result;
    public Integer getParam() {
        return param;
    }
    public void setParam(Integer param) {
        this.param = param;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }
    public String toString(){
        return "{\"param\":"+param+",\"success\":"+success+",\"result\":"+result+"}";
    }
}