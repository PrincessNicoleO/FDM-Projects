package com.fdmgroup.FdmTrianingProgramSprint4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fdmgroup.FdmTrianingProgramSprint4.exception.CustomerNotFoundException;
import com.fdmgroup.FdmTrianingProgramSprint4.model.Customer;
import com.fdmgroup.FdmTrianingProgramSprint4.service.CustomerService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        // Ensure the customer type is specified (Person or Company)
        if (customer == null || customer.getClass() == Customer.class) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }

        Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(savedCustomer); // 200 OK
    }

    // Find a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        try {
            Customer customer = customerService.findCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (CustomerNotFoundException ex) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // List all customers
    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        return ResponseEntity.ok(customers); // 200 OK
    }

    // Find customers by city
    @GetMapping("/city")
    public ResponseEntity<List<Customer>> findCustomersByCity(@RequestParam String city) {
        List<Customer> customers = customerService.listCustomersByCity(city);
        return ResponseEntity.ok(customers); // 200 OK
    }

    // Delete a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (CustomerNotFoundException ex) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    // Update a customer's details (name, postalCode, city, and province)
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        try {
            Customer updated = customerService.updateCustomer(id, updatedCustomer);
            return ResponseEntity.ok(updated); // Return updated customer
        } catch (CustomerNotFoundException ex) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
