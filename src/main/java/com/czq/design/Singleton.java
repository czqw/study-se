package com.czq.design;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhiqiang.cheng
 * @description
 * @date 2020/3/22
 */
public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws Exception{
        Executor executor = Executors.newCachedThreadPool();
        List<Singleton> list = new ArrayList<>();
        List<Singleton> ll = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(Singleton.getInstance());
                }
            });
        }
        Thread.sleep(1000);
        list.forEach(singleton1 -> {
            System.out.println(singleton1);
            if (singleton1 == Singleton.getInstance())
                ll.add(singleton1);
        });
        System.out.println(ll.size() + "\n========" + Singleton.getInstance() + "=========");
        ((ExecutorService) executor).shutdown();
    }
}
class User {
    private User(){}

    static enum SingletonEnum{
        INSTANCE;
        private User user;
        private SingletonEnum(){
            user = new User();
        }
        public User getInstance(){
            return user;
        }
    }
    public static User getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }

}