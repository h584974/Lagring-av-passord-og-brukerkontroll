package bruker;

public class PassordHash {
	
	public static String hashSaltetPassord(String saltetPassord) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(saltetPassord);
	}

}
