package com.jszhao.study.concurrent.chapter1.node1;

public class MyRunable implements Runnable {

    @Override
    public void run() {
        System.out.println("This's my Runable implement. name = " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread a = new Thread(new MyRunable());
        Thread b = new Thread(new MyRunable());

        a.start();
        b.start();
    }
}
