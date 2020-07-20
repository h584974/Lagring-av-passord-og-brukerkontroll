package meny;

import brukere.AktivBruker;

public class Meny {
	
	private AktivBruker b;
	
	public Meny() {
		b = new AktivBruker();
	}
	
	public boolean login(String brukernavn, String saltet_passord_hash) {
		return b.login(brukernavn, saltet_passord_hash);
	}

}