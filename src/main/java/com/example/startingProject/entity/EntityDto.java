package com.example.startingProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityDto {

    private String clientName;

    private String email;

    private LocalDate dob;

//    private double balance;
}
