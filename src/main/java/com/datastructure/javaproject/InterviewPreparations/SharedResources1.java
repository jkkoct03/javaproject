package com.datastructure.javaproject.InterviewPreparations;

public class SharedResources1 {

    synchronized void methodA() {
        System.out.println(Thread.currentThread().getName() + " has acquired the lock on this object.");
        try {
        Thread.sleep(1000);
        wait();// Releasing the lock and waiting
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " is releasing the lock.");
        }

    synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + " notifying all the threads waiting on this object.");
        
        notifyAll(); // Notify all the threads waiting on this object
        }
}
