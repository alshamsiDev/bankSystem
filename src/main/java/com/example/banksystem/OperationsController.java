package com.example.banksystem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class OperationsController {
    protected List<Customer> customers = new ArrayList<Customer>();

    /**
     * Get all the customers
     * <p>
     * Add new customers
     * <p>
     * Update customers
     * <p>
     * Delete customers
     * <p>
     * Deposit money to customer
     * <p>
     * Withdraw money from customers
     */

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    @PostMapping("/customers")
    public ResponseEntity createTodo(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(201).body("Added Succefully");
    }

    @PutMapping("/customers/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customers.set(id, customer);
        return ResponseEntity.status(200).body("UPDATE");
    }


    @DeleteMapping("/customers/{id}")
    public ResponseEntity destroyTodo(@PathVariable int id) {
        customers.remove(id);
        return ResponseEntity.status(200).body("DELETE");
    }

    @PutMapping("/customers/update/increase/balance/{id}")
    public ResponseEntity IncreaseCustomerMoney(@PathVariable int id, @RequestBody int money) {
        Customer customer;
        customer = customers.get(id);
        int newBalance = customer.getBalance() + money;
        customer.setBalance(newBalance);
        customers.set(id, customer);
        return ResponseEntity.status(200).body("UPDATE");
    }

    @PutMapping("/customers/update/decrease/balance/{id}")
    public ResponseEntity DecreaseCustomerMoney(@PathVariable int id, @RequestBody int money) {
        Customer customer;
        customer = customers.get(id);
        int newBalance = customer.getBalance() - money;
        customer.setBalance(newBalance);
        customers.set(id, customer);
        return ResponseEntity.status(200).body("UPDATE");
    }


}
