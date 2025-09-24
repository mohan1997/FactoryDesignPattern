package org.example;

public class CreditCardPayment implements Payment{

    @Override
    public void pay(String accountId, double amount) {
        double balance = InMemoryDatabase.getBalance(accountId);
        if(balance >=amount)
        {
            InMemoryDatabase.updateBalance(accountId , balance-amount);
            System.out.println("paid "+amount+" "+"using credit card" + "Remaining balance is "+InMemoryDatabase.getBalance(accountId));
    }
        else
        {
            throw new RuntimeException("InSufficient balance in credit card");
        }
        InMemoryDatabase.getBalance(accountId);
}
}
