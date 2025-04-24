package com.datastructure.javaproject.InterviewPreparations;

class SharedResource {
    synchronized void produce() throws InterruptedException {
        System.out.println("Producer is producing...");
        wait(); // Releasing lock and waiting
        System.out.println("Producer resumed");
    }

    synchronized void consume() {
        System.out.println("Consumer is consuming...");
        notify(); // Notifying the waiting thread
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        new Thread(() -> {
            try {
                obj.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> obj.consume()).start();
    }
}
