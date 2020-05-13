package com.czq.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/14
 */
public class TestVolatile {

    private volatile int inc = 0;

    public void incre() {
        synchronized (this) {
            // this.inc++;
            inc = inc + 1;
        }
    }

    public synchronized void incre1() {
        inc = inc + 1;
    }

    public void incre2() {
        inc = inc + 1;
    }

    public static void test2() {
        final TestVolatile tv = new TestVolatile();
        for (int i = 0; i < 100; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        //  synchronized (tv){
                        tv.incre();
                        //   }
                    }
                }
            }.start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(tv.inc);
    }

    public static void getThreadInfo() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo info : threadInfos){
            System.out.println("["+info.getThreadId()+"]"+info.getThreadName());
        }
    }

    public static void main(String[] args) {
//       test2();
        VolatileExample e = new VolatileExample();
        e.test3();
        getThreadInfo();

    }
}

class VolatileExample {

    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a;
            System.out.println(i);
        }
    }

    public void test3() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                writer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                reader();
            }
        });
        t1.start();

        t2.start();

    }
}