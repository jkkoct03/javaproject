package com.designPattern;

public class StrategyPatternsImp {
    public static void main(String[] args) {
        PaymentService service1 = new PaymentService(new CreditCard());
        service1.makePayment(500);

        PaymentService service2 = new PaymentService(new PayPalPayment());
        service2.makePayment(1500);

        PaymentService service3 = new PaymentService(new UPI());
        service3.makePayment(3500);
    }
}

class CreditCard implements PaymentStratgy {

    @Override
    public void pay(double amount) {
        System.out.println("Credit Bill Payment :" + amount);
    }
    
}

class UPI implements PaymentStratgy {

    @Override
    public void pay(double amount) {
        System.out.println("UPI Payment :" + amount);
    }
    
}

class PayPalPayment implements PaymentStratgy {

    @Override
    public void pay(double amount) {
        System.out.println("PayPal Bill Payment :" + amount);
    }
    
}

class PaymentService {

   private PaymentStratgy paymentStratgy;

   public PaymentService(PaymentStratgy paymentStratgy) {
    this.paymentStratgy = paymentStratgy;
   }

   public void makePayment(double amount) {
      paymentStratgy.pay(amount);
   }
    
}