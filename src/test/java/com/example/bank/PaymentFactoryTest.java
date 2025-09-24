package com.example.bank;

import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PaymentFactoryTest {
@Test
    void testCreditCardPayment()
{
    Payment payment = PaymentFactory.getPaymentMethod("Credit");
    assertNotNull(payment);
    assertTrue(payment instanceof CreditCardPayment);
}
@Test
    void testUpiPayment()
{
    Payment payment = PaymentFactory.getPaymentMethod("UPI");
    assertNotNull(payment);
    assertTrue(payment instanceof UpiPayment);
}
@Test
    void testNetBankingPayment()
{
    Payment payment = PaymentFactory.getPaymentMethod("NetBanking");
    assertNotNull(payment);
    assertTrue(payment instanceof NetBankingPayment);
}
    @Test
    void testInvalidPaymentType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PaymentFactory.getPaymentMethod("BITCOIN");
        });
        assertEquals("Unknown payment type: BITCOIN", exception.getMessage());
    }
}
