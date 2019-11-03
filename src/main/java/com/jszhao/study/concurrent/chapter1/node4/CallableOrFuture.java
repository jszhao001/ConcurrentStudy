package com.jszhao.study.concurrent.chapter1.node4;

import com.google.common.collect.Lists;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Callable和Future接口的差异
 */
public class CallableOrFuture {
    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);

        Callable<String> callable = ()-> "success";

        List<Callable<String>> callables = Lists.newArrayList(callable);
        List<Future<String>> futures = executor.invokeAll(callables);

        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        FutureTask<String> futureTask = new FutureTask(() -> "futureTask");
        Thread thread = new Thread(futureTask);
        thread.start();
        while (thread.isAlive());
        String o = futureTask.get();
        System.out.println(o);
    }
}
