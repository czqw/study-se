package com.czq.thread.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author zhiqiang.cheng
 * @description 自定义独占锁实现  Exclusive
 * @date 2020/3/15
 */
public class Sync extends AbstractQueuedSynchronizer {

    /**
     * 检测是否有线程持有锁只需看 state 是不是等于 1,state == 1 时
     * 锁被其他线程使用，当等于 0 时未被其他线程得到
     */
    @Override
    public boolean isHeldExclusively() {
        return getState() == 1;
    }

    /**
     * 尝试着获取锁，当 status 为 0 时获取成功返回 true，否则返回 false
     */
    @Override
    public boolean tryAcquire(int arg) {
        if (compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    /**
     * 尝试着释放锁
     */
    @Override
    public boolean tryRelease(int arg) {
        //没有线程获取锁却释放
        if (getState() == 0) {
            throw new IllegalArgumentException("没有线程持有锁");
        }
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }
}
