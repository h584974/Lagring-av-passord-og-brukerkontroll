package meny;

import bruker.AktivBruker;

public class Meny {
	
	private AktivBruker b;
	
	public Meny() {
		b = new AktivBruker();
	}
	
	public boolean login(String brukernavn, String passord) {
		return b.login(brukernavn, passord);
	}

}