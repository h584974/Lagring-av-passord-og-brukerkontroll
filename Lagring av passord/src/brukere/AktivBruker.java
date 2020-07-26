package brukere;

public class AktivBruker {
	
	private Bruker bruker;
	
	public AktivBruker() {
		bruker = null;
	}
	
	public boolean erInnlogget() {
		return bruker != null;
	}
	
	public boolean login(String brukernavn, String passord) {
		BrukerEAO a = new BrukerEAO();
		Bruker b = a.finnBruker(brukernavn);

		
		if(b == null) {
			System.out.println("Bruker ikke funnet"); //Midlertidig
			return false;
		}
		else if(erInnlogget()) {
			System.out.println("Allerede innlogget på en bruker"); //Midlertidig
			return false;
		}
		else if(b.getSaltet_passord_hash().equals(PassordHash.hashSaltetPassord(passord + b.getSalt()))) {
			bruker = b;
			return true;
		}
		else {
			System.out.println("Feil passord oppgitt"); //Midlertidig
			return false;
		}
	}

}