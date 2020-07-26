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
import javax.swing.JTextField;

public class GUI implements ActionListener {
	
	private JTextField textfield1;
	private JTextField textfield2;
	private JButton button1;
	private Meny meny;
	
	public GUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		textfield1 = new JTextField("Skriv brukernavn: ");
		textfield2 = new JTextField("Skriv passord: ");
		button1 = new JButton("Login");
		meny = new Meny();
		
		button1.addActionListener(this);
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setLayout(new GridLayout(0,1));
		panel.add(textfield1);
		panel.add(textfield2);
		panel.add(button1);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(meny.login(textfield1.getText(), textfield2.getText())) {
			System.out.println("Innlogging vellykket");
		}
		else {
			System.out.println("Innlogging feilet");
		}
	}

}