package interviewTest;

public class Test5 {
    public static void main(String[] args) {
        ShareResource1 sr = new ShareResource1();
        Thread t1 = new Thread(()->sr.printA());
        Thread t2 = new Thread(()->sr.printB());

        t1.start();
        t2.start();
    }
}

class ShareResource1{

    boolean flag = false;

    public synchronized void printA() {
       for(int i=0;i<10;i++) {
            while(flag) {
                try {
                    wait();
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Print A: " + "A");
            flag = true;
            notify();
       }
    }

    public synchronized void printB() {
        for(int i=0;i<10;i++) {
             while(!flag) {
                 try {
                     wait();
                 }catch(InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             System.out.println("Print B: " + "B");
             flag = false;
             notify();
        }
     }
}
