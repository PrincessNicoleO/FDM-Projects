package com.fdmgroup.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence; 

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabasic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		Dog dog1 = new Dog (1,"Max","Golden Retriever",false);
		Dog dog2 = new Dog(2, "Apolo", "French Bulldog", true);
		Dog dog3 = new Dog(3, "Cinnamon", "Chihuahua", true);
		
		txn.begin();
		em.persist(dog1);
		//em.merge(dog1);
		em.persist(dog2);
		em.persist(dog3);
		txn.commit();
		
		
		
		em.close();
		
		emf.close();
		
	}

}
