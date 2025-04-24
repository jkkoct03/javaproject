package com.corejava.multithreading;

public class MyThreadByThread {
    
    public static void main(String[] args) {
        MyThreadDemo th1 = new MyThreadDemo();
        th1.start();
    }
}

class MyThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("Hello World from Thread");
    }
}
