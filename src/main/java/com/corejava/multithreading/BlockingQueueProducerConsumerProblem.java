package com.corejava.multithreading;

import java.util.concurrent.*;

public class BlockingQueueProducerConsumerProblem {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();
        Thread th1 = new Thread(() -> sr.produce(), "Producer ");
        Thread th2 = new Thread(() -> sr.consume(), "Consumer ");
        th1.start();
        th2.start();
    }
}

class ShareResource {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

    public void produce() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " -- Producing: " + i);
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() {
        for (int i = 0; i < 10; i++) {
            try {
                int val = queue.take();
                System.out.println(Thread.currentThread().getName() + " -- Consuming: " + val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

