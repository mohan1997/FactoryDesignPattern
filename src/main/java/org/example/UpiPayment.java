package org.example;

public class UpiPayment implements Payment{
    @Override
    public void pay(String accountId, double amount) {
        double balance = InMemoryDatabase.getBalance(accountId);
        if(balance>=amount)
        {
            InMemoryDatabase.updateBalance(accountId,balance-amount);
            System.out.println("paid "+amount+"using Upi Payment"+"Remaining Balance is :"+InMemoryDatabase.getBalance(accountId));
        }
        else
        {
            throw new RuntimeException(" Insufficient Balance while trying to make Upi payment");
        }
    }
}
