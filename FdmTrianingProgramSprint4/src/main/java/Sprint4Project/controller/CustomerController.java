package Sprint4Project.controller;

import Sprint4Project.exception.CustomerNotFoundException;
import Sprint4Project.model.Customer;
import Sprint4Project.service.CustomerService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Create a new customer
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		Customer savedCustomer = customerService.createCustomer(customer);
		return ResponseEntity.ok(savedCustomer);
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
		return ResponseEntity.ok(customers);
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