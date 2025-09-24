package com.example.bank;

import org.example.InMemoryDatabase;
import org.example.Payment;
import org.example.PaymentFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentIntegrationTest {
    @BeforeEach
    void resetDb()
    {
        InMemoryDatabase.reset();
    }
    @Test
    void testCreditCardPaymentIntegration()
    {
        Payment payment = PaymentFactory.getPaymentMethod("credit");
        payment.pay("chase",1000);
        assertEquals(4000.0 ,InMemoryDatabase.getBalance("chase"));
    }
    void testNetBankingPayment()
    {
        Payment payment = PaymentFactory.getPaymentMethod("NetBanking");
        payment.pay("Bank Of America",500);
        assertEquals(5000.0,InMemoryDatabase.getBalance("Bank OF America"));
    }
    void testUpiPayment()
    {
        Payment payment = PaymentFactory.getPaymentMethod("UPI");
        payment.pay("wellsFargo",200);
        assertEquals(1000.0 ,InMemoryDatabase.getBalance("wellsFargo"));
    }
    void testInsufficientBalance()
    {
        Payment payment = PaymentFactory.getPaymentMethod("UPI");
        Exception ex = assertThrows(RuntimeException.class , () -> {
            payment.pay("Bank of America",10000);
        });
        assertEquals("Insufficient balance for UPI Payment" , ex.getMessage());
    }
}
