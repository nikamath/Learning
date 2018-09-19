package com.nikita.producerconsumer.practice;

import java.util.Queue;

public class Producer implements Runnable {

    Object lock;
    Queue<Object> queue;
    int maxsize;

    public Producer(Object lock, Queue<Object> queue, int maxsize) {
        super();
        this.lock = lock;
        this.queue = queue;
        this.maxsize = maxsize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (queue.size() >= maxsize) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            queue.offer(new Object());
            System.out.println("Producer queue size:" + queue.size());
            synchronized (lock) {
                lock.notifyAll();
            }

        }
    }

}
