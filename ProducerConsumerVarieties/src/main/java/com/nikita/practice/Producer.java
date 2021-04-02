package com.nikita.practice;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Producer  implements Runnable{
    Queue<Integer> queue;
    int maxSize;
    Object lock;
    int n;

    public Producer(Queue<Integer> queue, int maxSize, Object lock) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.lock = lock;
        n=1;
    }


    public void run() {
        System.out.println("Inside Producer:"+ Thread.currentThread().getName());
        while(true) {
            synchronized (lock) {
                while (queue.size() >= maxSize) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(n);
                System.out.println(Thread.currentThread().getName() + " produced:" + n++);
                lock.notifyAll();
            }
        }
    }
}
