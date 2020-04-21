package com.company.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListTest {
    public static void main(String[] args) throws InterruptedException {
        /*初始化*/
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            stringList.add("abc_" + i);
        }
        handleList(stringList);

    }

    private static void handleList(List<String> stringList) throws InterruptedException {
        /*CopyOnWriteArrayList copy = (CopyOnWriteArrayList) stringList;*/
        int count = stringList.size();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        CountDownLatch downLatch = new CountDownLatch(count);
        /*List<Object> result = new ArrayList<>();*/
        Vector<String> result = new Vector<>();
        for (int i = 0; i < count; i++) {
            int finalI = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    if (finalI < 300 && finalI > 155) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    result.add(stringList.get(finalI));

                    System.out.println(Thread.currentThread().getName() + "--" + stringList.get(finalI));
                    downLatch.countDown();
                }
            });
        }

        downLatch.await();
        System.out.println("main----------------------over");
    }
}
