package org.example;

public class PaymentFactory {
    public static Payment getPaymentMethod(String type)
    {
        if("CREDIT".equalsIgnoreCase(type))
        {
            return new CreditCardPayment();
        } else if ("UPI".equalsIgnoreCase(type)) {
            return new UpiPayment();
        }
        else if("NetBanking".equalsIgnoreCase(type))
        {
            return new NetBankingPayment();
        }
        throw new IllegalArgumentException("Unknown payment type: " + type);
    }
}
