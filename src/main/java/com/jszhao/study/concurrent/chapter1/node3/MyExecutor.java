package com.jszhao.study.concurrent.chapter1.node3;

import java.util.concurrent.*;

public class MyExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                20,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(50),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        // 创建只有一个线程的线程池
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        // 创建一个无限大的线程池，
        // 当有新任务到达时，一定需要一个线程来执行
        // 适用于线程执行时间短的场景
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        // 创建固定线程数量的线程池
        // corePoolSize = maximunPoolSize
        ExecutorService executorService3 = Executors.newFixedThreadPool(20);

        // 创建需要任务延迟执行的线程池
        ExecutorService executorService4 = Executors.newScheduledThreadPool(20);
    }
}
