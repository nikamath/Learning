package com.nikita.practice2;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable{
    Queue<Integer> queue;
    Condition isEmtpy;
    Condition isFull;
    Lock lock;

    public Consumer(Queue<Integer> queue, Condition isEmtpy, Condition isFull, Lock lock) {
        this.queue = queue;
        this.isEmtpy = isEmtpy;
        this.isFull = isFull;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Inside thread "+ Thread.currentThread().getName());
        while(true) {
            lock.lock();
            try {
                while (queue.isEmpty())
                    isFull.await();
                System.out.println("Consumed:" + queue.poll());
                isEmtpy.signal();
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        }
    }
}
