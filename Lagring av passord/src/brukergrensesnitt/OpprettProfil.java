package brukergrensesnitt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import meny.Meny;

public class OpprettProfil implements ActionListener {
	
	private JTextField userText;
	private JTextField passwordText;
	private JLabel loggedInLabel;
	private Meny meny;
	
	public OpprettProfil(JTextField userText, JTextField passwordText, JLabel loggedInLabel, Meny meny) {
		this.userText = userText;
		this.passwordText = passwordText;
		this.loggedInLabel = loggedInLabel;
		this.meny = meny;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		
		if(meny.opprettNyBruker(user, passwordText.getText())) {
			loggedInLabel.setText("Profil opprettet: " + user);
		}
		else {
			loggedInLabel.setText("Kunne ikke opprette profil med brukernavn: " + user);
		}
	}

}
