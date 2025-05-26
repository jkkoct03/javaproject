package interviewTest;

public class Test3 {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();
        Thread t1 = new Thread(()->sr.evenProduce());
        Thread t2 = new Thread(()->sr.oddProduce());

        t1.start();
        t2.start();
    }
}


class ShareResource {

    boolean flag = true;
    public synchronized void evenProduce() {
        for(int i=2;i<=10;i=i+2) {
            while(flag) {
                try{
                    wait();
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even Number: " + i);
            flag = true;
            notify();
        }
        
    }

    public synchronized void oddProduce() {
        for(int i=1;i<=10;i=i+2) {
            while(!flag) {
                try{
                    wait();
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Odd Number: " + i);
            flag = false;
            notify();
        }
    }

}