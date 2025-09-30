package com.fdmgroup.FdmTrianingProgramSprint4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.fdmgroup.FdmTrianingProgramSprint4.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Query to find customers by city in their address
    @Query("SELECT c FROM Customer c WHERE c.address.city = :city")
    List<Customer> findCustomersByCity(String city);
}

