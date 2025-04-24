package com.datastructure.javaproject.InterviewPreparations;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource5 {
    private final Lock lock = new ReentrantLock(true); // Unfair lock

    public void accessResource(String threadName) {
        if (lock.tryLock()) { // Threads compete unfairly for the lock
            try {
                System.out.println(threadName + " got access.");
                Thread.sleep(2000); // Simulating long work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(threadName + " is starving...");
        }
    }
}

public class StarvationDemo {
    public static void main(String[] args) {
        SharedResource5 resource = new SharedResource5();

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                resource.accessResource(Thread.currentThread().getName());
                try {
                    Thread.sleep(100); // Delay before retry
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread greedyThread1 = new Thread(task, "Greedy-1");
        Thread greedyThread2 = new Thread(task, "Greedy-2");
        Thread starvingThread = new Thread(task, "Starving-Thread");

        greedyThread1.start();
        greedyThread2.start();
        starvingThread.start();
    }
}
