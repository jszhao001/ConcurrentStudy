package com.jszhao.study.concurrent.chapter1.node1;

public class MyLambdaDemo {
    public static void main(String[] args) {
        // 方式A
        Runnable runnable = () -> System.out.println("lambda to create a new thread. A");
        Thread a = new Thread(runnable);

        // 方式B
        Thread b = new Thread(() -> System.out.println("lambda to create a new thread. B"));

        a.start();
        b.start();

        // out
        // lambda to create a new thread. A
        // lambda to create a new thread. B
    }
}
