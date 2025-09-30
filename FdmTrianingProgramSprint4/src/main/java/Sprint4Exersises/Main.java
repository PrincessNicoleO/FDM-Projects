package Sprint4Exersises;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabasic");
		EntityManager em = emf.createEntityManager();
		
		em.clear();
		emf.close();

	}

}
