package meny;

import bruker.Bruker;
import bruker.BrukerEAO;
import bruker.PassordHash;

public class Meny {
	
	
	public Meny() {}
	
	public boolean login(String brukernavn, String passord) {
		BrukerEAO a = new BrukerEAO();
		Bruker b = a.finnBruker(brukernavn);

		if(b == null) {
			System.out.println("Bruker ikke funnet"); //Midlertidig
			return false;
		}
		else if(b.getSaltet_passord_hash().equals(PassordHash.hashSaltetPassord(passord + b.getSalt()))) {
			return true;
		}
		else {
			System.out.println("Feil passord oppgitt"); //Midlertidig
			return false;
		}
	}
	
	public boolean opprettNyBruker(String brukernavn, String passord) {
		BrukerEAO a = new BrukerEAO();
		Bruker nyBruker = null;
		
		if(a.finnBruker(brukernavn) == null) {
			nyBruker = new Bruker(brukernavn, passord);
			return a.lagreBruker(nyBruker);
		}
		else {
			System.out.println("Bruker eksisterer allerede"); //Midlertidig
			return false;
		}
	}

}