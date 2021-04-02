package com.nikita.practice3;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    BlockingQueue<Integer> queue;
    int n=1;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Inside producer:"+ Thread.currentThread().getName());
        while(true){
            try {
                queue.put(n);
                System.out.println("Produced:"+ n++);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
