package com.corejava.multithreading;

class LoopValues implements Runnable{

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + 
            " Priority is " + Thread.currentThread().getPriority());
      for (int i = 1; i <= 10; i++) {
        System.out.println(Thread.currentThread().getName() + " : " + i);
      }      
    }
  }
  
  public class ThreadPriorityDemo {
    public static void main(String[] args) {
      Thread thread1 = new Thread(new LoopValues(), "Thread-1");
      Thread thread2 = new Thread(new LoopValues(), "Thread-2");    
      thread1.setPriority(Thread.MAX_PRIORITY);
      thread2.setPriority(Thread.MIN_PRIORITY);        
      thread1.start();
      thread2.start();   
      thread2.start();        
      try {        
        //Wait for the threads to finish
        thread1.join();
        thread2.join();            
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }            
      System.out.println("Done with looping values");
    }
  }