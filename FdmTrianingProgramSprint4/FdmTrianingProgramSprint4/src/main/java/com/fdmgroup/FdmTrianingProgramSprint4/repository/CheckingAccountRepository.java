package com.fdmgroup.FdmTrianingProgramSprint4.repository;

import com.fdmgroup.FdmTrianingProgramSprint4.model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
    // Custom query methods can go here if needed
}
