package Sprint4Project.service;

import Sprint4Project.exception.CustomerNotFoundException;
import Sprint4Project.model.Customer;
import Sprint4Project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Customer> customer = customerRepository.findById(customerId);
        
        // Throw exception if the customer is not found
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
        }
        
        return customer.get(); // Return the found customer
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
        Optional<Customer> existingCustomerOpt = customerRepository.findById(customerId);

        if (!existingCustomerOpt.isPresent()) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found, cannot update.");
        }

        Customer existingCustomer = existingCustomerOpt.get();

        // Update the fields that are allowed
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setPostalCode(updatedCustomer.getPostalCode());
        existingCustomer.setCity(updatedCustomer.getCity());
        existingCustomer.setProvince(updatedCustomer.getProvince());

        // Save the updated customer
        return customerRepository.save(existingCustomer);
    }
}