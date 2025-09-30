package com.fdmgroup.FdmTrianingProgramSprint4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FdmTrianingProgramSprint4.exception.CustomerNotFoundException;
import com.fdmgroup.FdmTrianingProgramSprint4.model.Customer;
import com.fdmgroup.FdmTrianingProgramSprint4.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create a new customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Find a customer by ID
    public Customer findCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found."));
    }

    // List all customers
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    // Delete a customer by ID
    public void deleteCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found, cannot delete.");
        }
        customerRepository.deleteById(customerId);
    }

    // Update a customer's details (name, postalCode, city, and province)
    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found, cannot update."));
        
        // Update fields
        existingCustomer.setName(updatedCustomer.getName());
        return customerRepository.save(existingCustomer);
    }

    // Find customers by city
    public List<Customer> listCustomersByCity(String city) {
        return customerRepository.findCustomersByCity(city);
    }
}
