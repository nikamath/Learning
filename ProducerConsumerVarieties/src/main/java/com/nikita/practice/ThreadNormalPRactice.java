package com.nikita.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadNormalPRactice {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<Integer>();
        int maxSize = 10;
        Object lock = new Object();
        Thread producer = new Thread( new Producer(queue, maxSize, lock), "Producer");
        Thread consumer = new Thread(new Consumer(queue, lock), "Consumer");
        producer.start();
        consumer.start();
        Thread.sleep(5000);
        System.exit(0);
    }
}
