package com.nikita.producerconsumer.practice;

import java.util.Queue;

public class Consumer implements Runnable {

    Queue<Object> queue;
    Object lock;

    public Consumer(Queue<Object> queue, Object lock) {
        super();
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (queue.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            queue.poll();
            System.out.println("Consumer queue size: " + queue.size());

            synchronized (lock) {
                lock.notifyAll();
            }
        }

    }

}
