package com.jszhao.study.concurrent.chapter1.node1;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("This's my thread implement. name = " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread a = new MyThread();
        Thread b = new MyThread();

        a.start();
        b.start();

    }
}
