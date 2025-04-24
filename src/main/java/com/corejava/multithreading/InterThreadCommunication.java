package com.corejava.multithreading;


//proper inter-thread communication between produce() and consume() 
//using a single shared resource and synchronized wait/notify mechanism

// changing the value in for loop for odd and even, it will work


public class InterThreadCommunication {
    public static void main(String[] args) {

        ShareResource sr = new ShareResource();

        Thread th1 = new Thread(new Producer(sr), "Producer ");
        Thread th2 = new Thread(new Consumer(sr), "Consumer ");
        th1.start();
        th2.start();
    }
}

class Producer implements Runnable {
    private ShareResource sr;
    public Producer(ShareResource sr){
        this.sr = sr;
    }
    @Override
    public void run() {
        sr.produce();
    }
    
}


class Consumer implements Runnable {
    private ShareResource sr;
    public Consumer(ShareResource sr){
        this.sr = sr;
    }
    @Override
    public void run() {
        sr.consume();
    }
    
}

class ShareResource {
    private boolean isProduced = false;

    public synchronized void produce() {
        for (int i = 0; i < 10; i++) {
            while (isProduced) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " -- Producing: " + i);
            isProduced = true;
            notify();  // Notify consumer
        }
    }

    public synchronized void consume() {
        for (int i = 0; i < 10; i++) {
            while (!isProduced) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " -- Consuming: " + i);
            isProduced = false;
            notify();  // Notify producer
        }
    }
}
