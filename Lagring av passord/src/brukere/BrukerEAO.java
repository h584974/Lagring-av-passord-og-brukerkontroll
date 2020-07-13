package brukere;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class BrukerEAO {
	
	private EntityManagerFactory emf;
	
	public BrukerEAO() {
		emf = Persistence.createEntityManagerFactory("passordPersistenceUnit");
	}
	
	public Bruker finnBruker(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		Bruker bruker = null;
		
		try {	
			bruker = em.find(Bruker.class, brukernavn);
		}
		finally {
			em.close();
		}
		
		return bruker;
	}

}