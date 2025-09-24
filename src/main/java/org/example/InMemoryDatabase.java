package org.example;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {

    private static final Map<String,Double> accounts = new HashMap<>();
    static
    {
        accounts.put("chaseBank", 500.0);
        accounts.put("Bank Of America",700.0);
        accounts.put("Wells Fargo",1000.0);
    }
    public static double getBalance(String accountId)
    {
        return accounts.getOrDefault(accountId, 0.0);
    }
    public static void updateBalance(String accountId , double newBalance)
    {
        accounts.put(accountId , newBalance);
    }
    public static void reset()
    {
        accounts.clear();
        accounts.put("chaseBank", 500.0);
        accounts.put("Bank Of America",700.0);
        accounts.put("Wells Fargo",1000.0);
    }
}
