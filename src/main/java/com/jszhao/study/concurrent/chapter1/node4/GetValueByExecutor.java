package com.jszhao.study.concurrent.chapter1.node4;

import java.util.concurrent.*;

/**
 * 通过线程池获取线程的返回值
 */
public class GetValueByExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);

        Callable<String> callable = () -> {
            return "success";
        };
        Future<String> submit = executor.submit(callable);

        try {
            String s = submit.get(1, TimeUnit.SECONDS);

            System.out.println(s);// "success"
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
