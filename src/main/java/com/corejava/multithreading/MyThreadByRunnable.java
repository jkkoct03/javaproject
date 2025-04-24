package com.corejava.multithreading;

public class MyThreadByRunnable{
    
    public static void main(String[] args) {
        Thread th1 = new Thread(new MyThreadUsingRunnable());
        th1.start();

    }
}

class MyThreadUsingRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello World from Runnable");
    }
}
