package com.company.thread.demo01;

/**
 * 实现线程的第一种方式：继承Thread类,重写run()方法
 */
public class ThreadDemo01 extends Thread {
    @Override
    public void run() {
        System.out.println("我是子线程:" + Thread.currentThread().getName());
    }
}

class Test {
    public static void main(String[] args) {
        ThreadDemo01 t1 = new ThreadDemo01();
        ThreadDemo01 t2 = new ThreadDemo01();
        t1.start();
        t2.start();
        System.out.println("我是主线程main");

    }

}