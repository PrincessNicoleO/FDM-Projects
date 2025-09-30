package Sprint4Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Sprint4Project.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}

