package com.datastructure.javaproject.InterviewPreparations;

public class ObjectLockDemo2 {
    public static void main(String[] args) throws InterruptedException {
        SharedResources1 sharedResource = new SharedResources1();

        Thread t1 = new Thread(() -> sharedResource.produce(), "Thread-1");
        Thread t2 = new Thread(() -> sharedResource.consume(), "Thread-2");
        // Thread t3 = new Thread(() -> sharedResource.methodB(), "Thread-3");
        // t3.start();
        t2.start();

        t1.start();
        System.out.println("Main thread completes.");
    }
}

class SharedResources1 {

    private boolean available = false;

    synchronized void produce() {
        while (available) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to produce...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " produced an item.");
        available = true;
        notify(); // Notify consumer
    }

    synchronized void consume() {
        while (!available) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to consume...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " consumed an item.");
        available = false;
        notify(); // Notify producer
    }

}
