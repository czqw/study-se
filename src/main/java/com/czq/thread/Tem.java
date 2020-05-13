package com.czq.thread;



import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Tem {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo info : threadInfos){
            System.out.println("["+info.getThreadId()+"]"+info.getThreadName());
        }
        Thread t = new Thread();
        t.setPriority(1);
        LockSupport lockSupport ;
        Lock lock = new ReentrantLock();
    }
}
