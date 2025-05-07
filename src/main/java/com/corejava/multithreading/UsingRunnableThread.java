package com.corejava.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingRunnableThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService excutor = Executors.newFixedThreadPool(1);
        Future<String> res = excutor.submit(new TestCallable());
        String s = res.get();
        System.out.println(s);
        excutor.shutdown();

        Printer pr = new Printer();
        Thread thOdd = new Thread(()-> pr.oddPrint(), "Odd Print");
        Thread thEven = new Thread(()->pr.evenPrint(), "Even Print");
        thOdd.start();
        thEven.start();
       
        SharedResource sr = new SharedResource();
        Thread producer = new Thread(()-> sr.producer(), "Producer");
        Thread consumer = new Thread(()->sr.consumer(), "Consumer");

        producer.start();
        consumer.start();

        A a = new A();
        B b = new B();
        a.methodA(b);
        b.methodB(a);


        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
            System.out.println("Task completed by: " + Thread.currentThread().getName());
            latch.countDown();
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }

        latch.await();
        System.out.println("All tasks completed!");

        new UsingRunnableThread().fetchcombinedDetails();
        
    }
    // get Order
 
    CompletableFuture<String> fetchOrderDetails (){
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000);
           if(false) throw new RuntimeException("Order API Failed");
            return "Order#123";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Handled Order Error: " + ex.getMessage());
                return "Unknown Order";
            } else {
                return result;
            }
        });
        // }).exceptionally(ex -> {
        //     System.out.println("Handled Order Error: " + ex.getMessage());
        //     return "Unknown Order";
        // });
    }

    CompletableFuture<String> fetchPaymentDetails(){
        return CompletableFuture.supplyAsync(() -> {
            return "Payment#456";
        });
    }

    CompletableFuture<String> fetchUserId() {
        return CompletableFuture.supplyAsync(() -> {
            return "UserId#987";
        });
    }

    public void fetchcombinedDetails() {
        CompletableFuture<String> order = fetchOrderDetails();
        CompletableFuture<String> payment = fetchPaymentDetails();
        CompletableFuture<String> user = fetchUserId();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(order, payment, user);
       // System.out.println(allOf);
        allOf.thenRun(() -> {
            try {
                String hashOrder = order.get();
                System.out.println("Final Result: " + hashOrder);
                String hashPayment = payment.get();
                String hashUser = user.get();

                System.out.println("Order : " + hashOrder + " Payment" + hashPayment + " User" + hashUser);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        sleep(2000);
    }

    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

// 6. Create Deadlock
class A {
    synchronized void methodA(B b) {
        System.out.println("Thread 1: Locked A");
        b.last();
    }
    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread 2: Locked B");
        a.last();
    }
    synchronized void last() {
        System.out.println("Inside B.last()");
    }
}


class TestCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
      return "return callable";
    }
    
}
// Class RunnableSharedResource
class Printer{
    private boolean flag = false;
    public synchronized void evenPrint(){
        for(int i=2;i<=10;i+=2) {
            while(!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even: " + i);
            notify();
            flag = false;
        }
    }

    public synchronized void oddPrint() {
        for(int i=1;i<=10;i+=2) {
            while(flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Odd: " + i);
            notify();
            flag = true;
        }
    }
}

class SharedResource {
    private boolean flag = false;
    public synchronized void producer(){
        for(int i=2;i<21;i+=2) {
            while(!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Producer: " + i);
            notify();
            flag = false;
        }
    }

    public synchronized void consumer() {
        for(int i=1;i<21;i+=2) {
            while(flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consumer: " + i);
            notify();
            flag = true;
        }
    }
}