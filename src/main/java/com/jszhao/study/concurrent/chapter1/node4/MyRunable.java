package com.jszhao.study.concurrent.chapter1.node4;


import lombok.Getter;

public class MyRunable implements Runnable {

    private String param;

    @Getter
    private String result;

    public MyRunable(String param) {
        this.param = param;
    }

    @Override
    public void run() {
        result = this.param + " success";
    }

    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable("jszhao");
        Thread a = new Thread(myRunable);
        a.start();

        while (a.isAlive()) ;
        System.out.println(myRunable.getResult()); // "jszhao success"
    }
}