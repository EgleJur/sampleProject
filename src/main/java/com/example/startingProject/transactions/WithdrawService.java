package com.example.startingProject.transactions;

import com.example.startingProject.entity.Entity;

public class WithdrawService {
    public static boolean withdraw(Entity entity, double amount) {
        if (amount <= entity.getBalance()) {
            entity.setBalance(entity.getBalance() - amount);
            return true;
        }
        System.out.println("Insufficient funds.");
        return false;
    }
}
