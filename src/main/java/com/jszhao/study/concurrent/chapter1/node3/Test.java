package com.jszhao.study.concurrent.chapter1.node3;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(
//                50,
//                100,
//                0,
//                TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(150),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
        ThreadPoolExecutor executor =(ThreadPoolExecutor) Executors.newScheduledThreadPool(50);


        Thread a = new Thread(() -> {
            while (true) {
                try {
                    executor.execute(() -> {
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
//                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("add error");
                }
            }
        });

        Thread b = new Thread(() -> {
            while (true) {
                System.out.println("poolList=  " + executor.getPoolSize() + ",queue.size = " + executor.getQueue().size());
            }
        });

        a.start();
        b.start();
    }
}
