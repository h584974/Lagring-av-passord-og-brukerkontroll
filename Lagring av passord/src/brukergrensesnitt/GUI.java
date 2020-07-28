package brukergrensesnitt;

import meny.Meny;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	private JTextField userText;
	private JTextField passwordText;
	private Meny meny;
	
	public GUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		userText = new JTextField();
		passwordText = new JPasswordField();
		JButton button1 = new JButton("Login");
		JButton button2 = new JButton("Opprett profil");
		meny = new Meny();
		
		button1.addActionListener(this);
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setLayout(new GridLayout(0,1));
		panel.add(userText);
		panel.add(passwordText);
		panel.add(button1);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(meny.login(userText.getText(), passwordText.getText())) {
			System.out.println("Innlogging vellykket");
		}
		else {
			System.out.println("Innlogging feilet");
		}
	}

}