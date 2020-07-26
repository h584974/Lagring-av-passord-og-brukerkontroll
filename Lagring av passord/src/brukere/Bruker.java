package brukere;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bruker", schema = "lagring_passord")
public class Bruker {
	
	@Id
	private String brukernavn;
	
	private String saltet_passord_hash;
	private String salt;
	
	public Bruker() {}
	
	public Bruker(String brukernavn, String passord) {
		this.brukernavn = brukernavn;
		salt = genererSalt();
		saltet_passord_hash = PassordHash.hashSaltetPassord(passord + salt);
	}
	
	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getSaltet_passord_hash() {
		return saltet_passord_hash;
	}

	public void setSaltet_passord_hash(String saltet_passord_hash) {
		this.saltet_passord_hash = saltet_passord_hash;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	private static String genererSalt() {
		String salt = "";
		Random r = new Random();
		for(int i = 0; i < 100; i++) {
			salt += (char)(r.nextInt(26) + 'a');
		}
		return salt;
	}
	
}