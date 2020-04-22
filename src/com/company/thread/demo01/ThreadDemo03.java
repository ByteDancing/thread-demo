package com.company.thread.demo01;

/**
 * 通过匿名内部类创建多线程
 */
public class ThreadDemo03 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程: " + Thread.currentThread().getName());
            }
        }).start();
        System.out.println("main");
    }
}
