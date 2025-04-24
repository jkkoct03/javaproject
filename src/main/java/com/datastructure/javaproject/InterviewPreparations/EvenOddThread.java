package com.datastructure.javaproject.InterviewPreparations;

class NumberPrinter {
    public int number = 1;
    public static final int MAX = 10;

    // This method is synchronized to ensure that only one thread can access it at a
    // time
    public synchronized void printOddNumber() {
        while (number <= MAX) {
            while (number % 2 == 0) {
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

    public synchronized void printEvenNumber() {
        while (number <= MAX) {
            while (number % 2 != 0) {
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

// This class contains the main method which is the entry point of the program
public class EvenOddThread {

    // This is the main method which is called when the program is run
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

        Thread oddThread = new Thread(numberPrinter::printOddNumber, "Odd");
        Thread evenThread = new Thread(numberPrinter::printEvenNumber, "Even");

        // Starting the threads
        oddThread.start();
        evenThread.start();
    }
}
