package com.nikita.producerconsumer.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerPractice3 {

    public static void main(String[] args) throws InterruptedException {
        Queue<Object> queue = new LinkedList<>();
        int maxsize = 10;
        final Object lock = new Object();
        new Thread(new Producer(lock, queue, maxsize), "Producer").start();
        new Thread(new Consumer(queue, lock), "Consumer").start();

        Thread.sleep(100000);
        System.exit(0);
    }

}
