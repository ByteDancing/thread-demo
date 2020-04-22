package com.company.thread.demo01;

/**
 * 实现线程的第二种方式,实现runnable接口
 */
public class ThreadDemo02 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是子线程: " + Thread.currentThread().getName());
    }
}

class ThreadDemo02Test {
    public static void main(String[] args) {
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        Thread t1 = new Thread(threadDemo02, "xc1");
        Thread t2 = new Thread(threadDemo02, "xc2");
        Thread t3 = new Thread(threadDemo02, "xc3");
        t2.start();
        t1.start();
        t3.start();
        System.out.println("main");
    }
}