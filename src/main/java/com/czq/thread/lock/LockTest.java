package com.czq.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/15
 */
public class LockTest {

    private static int count_lock = 0;

    private static int count_syn = 0;

    private static int count_mutex = 0;

    private Lock reentrantLock = new ReentrantLock();

    private Mutex mutex = new Mutex();

    public static void main(String[] args) {
        final LockTest test = new LockTest();

        //  ExecutorService exec = Executors.newCachedThreadPool();
        Long start1 = System.currentTimeMillis();
        test.synTest();
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(System.currentTimeMillis() - start1);

        Long start2 = System.currentTimeMillis();
        test.lockTest();
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(System.currentTimeMillis() - start2);

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }


        Long start3 = System.currentTimeMillis();
        test.mutexTest();
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(System.currentTimeMillis() - start3);

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("syn------->" + count_syn + "\n" + "lock------->" + count_lock + "\n" + "mutex------->" + count_mutex);
    }


    public void incryByLock() {
        reentrantLock.lock();
        try {
            count_lock++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public synchronized void incryBySyn() {
        count_syn++;
    }

    public void incryByMutex() {
        mutex.lock();
        try {
            count_mutex++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.unlock();
        }
    }

    public void synTest() {
        for (int i = 0; i < 10000; i++) {

            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        incryBySyn();
                    }
                }
            }.start();
        }
    }

    public void lockTest() {
        for (int i = 0; i < 10000; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        incryByLock();
                    }
                }
            }.start();
        }
    }

    public void mutexTest() {
        for (int i = 0; i < 10000; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        incryByMutex();
                    }
                }
            }.start();
        }
    }
}