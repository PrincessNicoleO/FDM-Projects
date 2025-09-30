package com.fdmgroup.FdmTrianingProgramSprint4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fdmgroup.FdmTrianingProgramSprint4.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query("SELECT a FROM Account a WHERE a.customer.address.city = :city")
	List<Account> findAccountsByCustomerCity (String city);
	
	

}
