package com.datastructure.javaproject.InterviewPreparations;

class SharedResource3 {
    // Static synchronized method - locks the class
    public static synchronized void staticSyncMethod() {
        System.out.println(Thread.currentThread().getName() + " entered staticSyncMethod.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exited staticSyncMethod.");
    }

    public static synchronized void staticSyncMethod2() {
        System.out.println(Thread.currentThread().getName() + " entered staticSyncMethod2.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exited staticSyncMethod2.");
    }

    // Instance synchronized method - locks object
    public synchronized void instanceSyncMethod() {
        System.out.println(Thread.currentThread().getName() + " entered instanceSyncMethod.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exited instanceSyncMethod.");
    }
}

public class StaticSynchronizedExample {
    public static void main(String[] args) {
        SharedResource3 obj1 = new SharedResource3();
        SharedResource3 obj2 = new SharedResource3();

        // Thread 1 and Thread 2 try to call static synchronized method
        Thread t1 = new Thread(() -> SharedResource3.staticSyncMethod(), "Thread-1");
        Thread t2 = new Thread(() -> SharedResource3.staticSyncMethod(), "Thread-2");
        Thread t5 = new Thread(() -> SharedResource3.staticSyncMethod2(), "Thread-5");

        // Thread 3 and Thread 4 try to call instance synchronized method on different
        // objects
        Thread t3 = new Thread(() -> obj1.instanceSyncMethod(), "Thread-3");
        Thread t4 = new Thread(() -> obj2.instanceSyncMethod(), "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
