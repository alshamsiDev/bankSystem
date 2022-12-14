package com.example.banksystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    public int id;
    public String username;
    public int balance;
}
