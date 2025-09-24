package org.example;

public class NetBankingPayment implements Payment{

    @Override
    public void pay(String accountId, double amount) {
        double balance = InMemoryDatabase.getBalance(accountId);
        if(balance>=amount)
        {
            InMemoryDatabase.updateBalance(accountId , balance-amount);
        System.out.println("Paid "+amount+" "+"using Net Banking"+"Remaining Balance is"+InMemoryDatabase.getBalance(accountId));
}
        else
        {
            throw new RuntimeException("Insufficient balance for net banking payment");
        }
    }
}
