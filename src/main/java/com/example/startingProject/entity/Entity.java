package com.example.startingProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.time.LocalDate;

@javax.persistence.Entity
@Table(name = "ACCOUNTS")
@Data
@AllArgsConstructor
public class Entity {

    static final Logger logger = LogManager.getLogger(Entity.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String clientName;
    @Column
    private String email;
    @Column
    private LocalDate dob;
    @Column
    private double balance;


    public Entity() {
        balance = 0.00;
        clientName = "";
    }

    public Entity(String clientName) {
        this.clientName = clientName;
        this.balance = 0.00;
    }

    public Entity(double balance, String clientName) {
        this.balance = balance;
        this.clientName = clientName;
    }

}
