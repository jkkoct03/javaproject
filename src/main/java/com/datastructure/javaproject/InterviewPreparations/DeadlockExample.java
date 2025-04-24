package com.datastructure.javaproject.InterviewPreparations;

class Resource {
    String name;

    public Resource(String name) {
        this.name = name;
    }
}

public class DeadlockExample implements Runnable {
    private Resource resource1;
    private Resource resource2;

    public DeadlockExample(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource1) {
            //System.out.println(Thread.currentThread().getName() + " locked " + resource1.name);
            System.out.println("Hello World!!");
            // Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(System.out::println);
            // try {
            // Thread.sleep(100);
            // } catch (InterruptedException e) {
            // }
            // for (int i = 0; i < 10; i++) {
            // System.out.println(i + " " + Thread.currentThread().getName());

            // }
            synchronized (resource2) {
               // System.out.println(Thread.currentThread().getName() + " locked " + resource2.name);
            }
        }
    }

    public static void main(String[] args) {
        Resource res1 = new Resource("Resource-1");
        Resource res2 = new Resource("Resource-2");

        Thread t1 = new Thread(new DeadlockExample(res1, res2), "Thread-1");
        Thread t2 = new Thread(new DeadlockExample(res2, res1), "Thread-2");

        t1.start();
        t2.start();
        System.out.println("Main thread completes.");
    }
}
