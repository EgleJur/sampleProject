package com.example.startingProject.transactions;

import com.example.startingProject.entity.Entity;

public class DepositService {

    public static double depositService(Entity entity, double amount) {
        entity.setBalance(entity.getBalance() + amount);
        return entity.getBalance();
    }
}