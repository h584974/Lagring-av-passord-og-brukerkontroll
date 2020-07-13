package brukere;

public class AktivBruker {
	
	private Bruker bruker;
	
	public AktivBruker() {
		bruker = null;
	}
	
	public boolean erInnlogget() {
		return bruker != null;
	}
	
	public boolean login(String brukernavn, String saltet_passord_hash) {
		BrukerEAO a = new BrukerEAO();
		Bruker b = a.finnBruker(brukernavn);
		
		if(bruker == null) {
			System.out.println("Bruker ikke funnet");
			return false;
		}
		else if(erInnlogget()) {
			System.out.println("Allerede innlogget på en bruker");
			return false;
		}
		else if(bruker.getSaltet_passord_hash().equals(saltet_passord_hash)) {
			bruker = b;
			return true;
		}
		else {
			System.out.println("Feil passord oppgitt");
			return false;
		}
	}

}