package com.datastructure.javaproject.InterviewPreparations;

public class ObjectLockDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedResources sharedResource = new SharedResources();

        Thread t1 = new Thread(() -> sharedResource.methodA(), "Thread-1");
        Thread t2 = new Thread(() -> sharedResource.methodA(), "Thread-2");
        // Thread t3 = new Thread(() -> sharedResource.methodB(), "Thread-3");
        t1.start();
        t2.start();
        Thread.sleep(2000); // To ensure that t1 and t2 are in waiting state
        // t3.start();
        System.out.println("Main thread completes.");
    }
}

class SharedResources {

    synchronized void methodA() {
        System.out.println(Thread.currentThread().getName() + " has acquired the lockon this object.");
        try {
            Thread.sleep(1000);
            wait();// Releasing the lock and waiting
            // resource 2
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " is releasing the lock.");
    }

    synchronized void methodB() {
        // resource 2
        // wait
        // resource 1
        System.out.println(Thread.currentThread().getName() + " notifying all thethreads waiting on this object.");

        notifyAll(); // Notify all the threads waiting on this object
    }
}
