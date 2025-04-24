package com.datastructure.javaproject.InterviewPreparations;

class LivelockExample {
    private boolean resourceInUse = false;

    public synchronized void attemptAction(Thread t) {
        while (resourceInUse) {
            System.out.println(t.getName() + " waiting...");
            try {
                wait();
                // Thread.sleep(100); // Simulating some waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resourceInUse = true;
        System.out.println(t.getName() + " is working...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resourceInUse = false; // Releases the resource
        notifyAll();
        System.out.println(t.getName() + " is done working...");
    }
}

public class LivelockDemo {
    public static void main(String[] args) {
        LivelockExample resource = new LivelockExample();

        Thread t1 = new Thread(() -> {
            while (true) {
                resource.attemptAction(Thread.currentThread());
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            while (true) {
                resource.attemptAction(Thread.currentThread());
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
