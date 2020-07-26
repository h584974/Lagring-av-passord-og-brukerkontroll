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
	
	public boolean lagreBruker(Bruker bruker) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		boolean lagret = false;
		
		try {
			tx.begin();
			em.persist(bruker);
			tx.commit();
			lagret = true;
		}
		catch (Throwable e) {
            e.printStackTrace();
            if(tx.isActive()) {
            	tx.rollback();
            }
        } 
		finally {
			em.close();
		}
		return lagret;
	}

}