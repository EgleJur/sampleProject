package com.example.startingProject.transactions;

import com.example.startingProject.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public class TransferService {
    public static boolean transfer(Entity fromEntity, Entity toEntity, double amount, JpaRepository repository) {
        if (amount <= fromEntity.getBalance()) {
            fromEntity.setBalance(fromEntity.getBalance() - amount);
            toEntity.setBalance(toEntity.getBalance() + amount);
            repository.save(fromEntity);
            repository.save(toEntity);
            return true;
        }
        System.out.println("Insufficient funds for transfer.");
        return false;
    }
}
