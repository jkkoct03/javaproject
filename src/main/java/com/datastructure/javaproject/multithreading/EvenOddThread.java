package com.datastructure.javaproject.multithreading;

public class EvenOddThread {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource();
        Thread th1 = new Thread(new TaskEvenOdd(sr, 10, false));
        Thread th2 = new Thread(new TaskEvenOdd(sr, 10, true));
        th1.start();
        th2.start();
    }
}

class TaskEvenOdd implements Runnable {
    private int max;
    private SharedResource sharedResource;
    private boolean isEvenNumber;

    TaskEvenOdd(SharedResource sharedResource, int max, boolean isEvenNumber) {
        this.sharedResource = sharedResource;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }
    @Override
    public void run() {
        int number = isEvenNumber == true ? 2 : 1;
        while (number <= max) {

            if (isEvenNumber) {
                //System.out.println("Even :"+ Thread.currentThread().getName());
                sharedResource.printEven(number);
                //number+=2;
            } else {
                //System.out.println("Odd :"+ Thread.currentThread().getName());
                sharedResource.printOdd(number);
                // number+=2;
            }
            number += 2;
        }
    }
    
}

class SharedResource{
    boolean isOdd = false;

    synchronized void printEven(int number) {
        while (isOdd == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even:" + number);
        isOdd = false;
        notifyAll();
    }

    synchronized void printOdd(int number) {
        while (isOdd == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd:" + number);
        isOdd = true;
        notifyAll();
    }
}
