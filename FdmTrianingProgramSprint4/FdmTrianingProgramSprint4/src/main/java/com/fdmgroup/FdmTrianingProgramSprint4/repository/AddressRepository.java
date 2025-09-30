package com.fdmgroup.FdmTrianingProgramSprint4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdmgroup.FdmTrianingProgramSprint4.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
