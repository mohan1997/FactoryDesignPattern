package org.example;

public class Main {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.getPaymentMethod("credit");
        payment.pay("chaseBank" , 400);
        Payment payment1 = PaymentFactory.getPaymentMethod("UPI");
        payment1.pay("Bank Of America" , 500.0);
        Payment payment2 = PaymentFactory.getPaymentMethod("NetBanking");
        payment2.pay("Wells Fargo" , 1000.0);
    }
}