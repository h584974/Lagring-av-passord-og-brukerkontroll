package brukergrensesnitt;

import meny.Meny;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	private JTextField userText;
	private JTextField passwordText;
	private Meny meny;
	private JLabel loggedInLabel;
	
	public GUI() {
		meny = new Meny();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JFrame frame = new JFrame();
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		
		JLabel userLabel = new JLabel("brukernavn:");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField();
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		JLabel passwordLabel = new JLabel("passord:");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		loginButton.addActionListener(this);
		panel.add(loginButton);
		
		JButton registerProfileButton = new JButton("Opprett profil");
		registerProfileButton.setBounds(100, 80, 120, 25);
		panel.add(registerProfileButton);
		
		loggedInLabel = new JLabel("Ikke innlogget");
		loggedInLabel.setBounds(10, 120, 200, 25);
		panel.add(loggedInLabel);
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(meny.login(userText.getText(), passwordText.getText())) {
			System.out.println("Innlogging vellykket");
			loggedInLabel.setText("Innlogget som: " + userText.getText());
		}
		else {
			System.out.println("Innlogging feilet");
		}
	}

}