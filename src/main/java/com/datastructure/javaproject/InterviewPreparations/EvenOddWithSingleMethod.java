package com.datastructure.javaproject.InterviewPreparations;

public class EvenOddWithSingleMethod {
    public static void main(String[] args) {
        NumberPrinter2 numberPrinter = new NumberPrinter2();

        Thread oddThread = new Thread(() -> numberPrinter.printNumber("Odd"), "Thread-Odd");
        Thread evenThread = new Thread(() -> numberPrinter.printNumber("Even"), "Thread-Even");
        // Starting the threads
        oddThread.start();
        evenThread.start();
    }
}

class NumberPrinter2 {

    public static int number = 1;
    public static final int MAX = 10;

    // This method is synchronized to ensure that only one thread can access it at a
    // time
    public synchronized void printNumber(String threadName) {
        while (number <= MAX) {
            if ((threadName.equals("Odd") && number % 2 == 0) || (threadName.equals("Even") && number % 2 != 0)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number > MAX)
                break; // Prevent extra execution
            System.out.println(Thread.currentThread().getName() + " - " + number);
            number++;
            notify();
        }
    }
}
