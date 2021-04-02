package com.nikita.practice2;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    Queue<Integer> queue;
    int maxSize;
    Lock lock;
    Condition isEmpty;
    Condition isFull;
    int n=1;

    public Producer(Queue<Integer> queue, int maxSize, Lock lock, Condition isEmpty, Condition isFull) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.lock = lock;
        this.isEmpty = isEmpty;
        this.isFull = isFull;
    }

    @Override
    public void run() {
        System.out.println("Inside producer thread:"+ Thread.currentThread().getName());
        while(true){
            lock.lock();
            try {
                while (queue.size() >= maxSize)
                    isEmpty.await();
                queue.add(n);
                System.out.println("Producing:"+ n++);
                isFull.signal();
            }catch (InterruptedException e){}
            finally {
                lock.unlock();
            }
        }

    }
}
