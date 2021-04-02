package com.nikita.practice3;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Inside consumer thread:"+ Thread.currentThread().getName());
        while(true){
            try {
                int taken = queue.take();
                System.out.println("Consumed :" + taken);
            }catch (InterruptedException e){}
        }
    }
}
