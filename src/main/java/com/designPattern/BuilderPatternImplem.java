package com.designPattern;

public class BuilderPatternImplem {
    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest.Builder()
                                      .payer("John")
                                      .payee("Amazon")
                                      .amount(150.75)
                                      .build();
        System.out.println("Payment from " + request.getPayer() + " to " + request.getPayee());
    }
}

class PaymentRequest {
    private String payer;
    private String payee;
    private double amount;

    private PaymentRequest(Builder builder) {
        this.payer = builder.payer;
        this.payee = builder.payee;
        this.amount = builder.amount;
    }

    public String getPayer() {
        return payer;
    }

    public String getPayee() {
        return payee;
    }

    public double getAmount() {
        return amount;
    }

    static class Builder{
        private String payer;
        private String payee;
        private double amount;

        public Builder payer(String payer) {
            this.payer= payer;
            return this;
        }

        public Builder payee(String payee) {
            this.payee= payee;
            return this;
        }

        public Builder amount(double amount) {
            this.amount= amount;
            return this;
        }

        public PaymentRequest build() {
            return new PaymentRequest(this);
        }
    }
}
