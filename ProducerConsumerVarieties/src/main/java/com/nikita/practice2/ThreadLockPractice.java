package com.nikita.practice2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockPractice {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize=5;
        Lock lock = new ReentrantLock();
        Condition isEmpty = lock.newCondition();
        Condition isFull = lock.newCondition();
        new Thread(new Producer(queue, maxSize, lock, isEmpty, isFull),"Producer").start();
        new Thread(new Consumer(queue, isEmpty, isFull, lock), "Consumer").start();
        Thread.sleep(5000);
        System.exit(0);


    }
}
