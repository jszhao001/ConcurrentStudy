package com.jszhao.study.concurrent.chapter1.node1;

public class RunOrStart {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread a = new Thread(() -> System.out.println(Thread.currentThread().getName()));

        a.start();

        Thread b = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        b.run();

        // out
        // main
        // Thread-0
        // main
    }
}
