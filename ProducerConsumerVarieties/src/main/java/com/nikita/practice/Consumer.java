package com.nikita.practice;

import java.util.Queue;

public class Consumer implements Runnable {

    Queue<Integer> queue;
    Object lock;

    public Consumer(Queue<Integer> queue, Object lock) {
        this.queue = queue;
        this.lock = lock;
    }

    public void run() {
        System.out.println("Inside Consumer:"+ Thread.currentThread().getName());
      while(true) {
          synchronized (lock) {
              while (queue.isEmpty()) {
                  try {
                      lock.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

              }
              System.out.println(Thread.currentThread().getName() + " consumed:" + queue.peek());
              queue.poll();
              lock.notifyAll();
          }
      }
    }
}
