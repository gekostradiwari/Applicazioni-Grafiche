package CommercialistDB.CommercialistDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class addCommercialista extends Frame {

	public addCommercialista(String title, int x, int y) {
		super(title, x, y);
		JFrame Cloned = this;
		JPanel panel = new JPanel(new FlowLayout());
		panel.setSize(new Dimension(super.getSize()));
		JLabel Nome = new JLabel("Nome: ");
		JLabel Cognome = new JLabel("Cognome: ");
		JLabel NumeriTelefono = new JLabel("Recapiti Telefonici (MAX 3): ");
		
		JLabel CodiceFiscale = new JLabel("Codice Fiscale:");
		JLabel NumeroClientiACarico = new JLabel("Numero Clienti seguiti: ");
		JLabel num1 = new JLabel("Num .1: ");
		JLabel num2 = new JLabel("Num .2: ");
		JLabel num3 = new JLabel("Num .3: ");
		JButton FINISH = new JButton("Finish");
		
		
		JTextField name = new JTextField();
		JTextField surname = new JTextField();
		//JTextField telephoneNumbers = new JTextField();
		JTextField codiceFiscale = new JTextField();
		JTextField clientiAcarico = new JTextField();
		JTextField Num1 = new JTextField();
		JTextField Num2 =  new JTextField();
		JTextField Num3 = new JTextField();
		name.setEditable(true);
		name.setPreferredSize(new Dimension(425,25));
		surname.setEditable(true);
		surname.setPreferredSize(new Dimension(400,25));
		codiceFiscale.setEditable(true);
		codiceFiscale.setPreferredSize(new Dimension(372,25));
		clientiAcarico.setEditable(true);
		clientiAcarico.setPreferredSize(new Dimension(300,25));
		Num1.setEditable(true);
		Num2.setEditable(true);
		Num3.setEditable(true);
		Num1.setPreferredSize(new Dimension(425,25));
		Num2.setPreferredSize(new Dimension(425,25));
		Num3.setPreferredSize(new Dimension(425,25));
		FINISH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Commercialista c = new Commercialista(codiceFiscale.getText(),name.getText(),surname.getText(),Num1.getText(),Num2.getText(),Num3.getText());
				//IMPLEMENTAZIONE QUERY
				Cloned.remove(FINISH);
				dispose();
			}
		});
		panel.add(Nome);
		panel.add(name);
		panel.add(Box.createVerticalStrut(50));
		panel.add(Cognome);
		panel.add(surname);
		panel.add(Box.createVerticalStrut(50));
		panel.add(CodiceFiscale);
		panel.add(codiceFiscale);		
		panel.add(Box.createVerticalStrut(50));
		panel.add(Box.createHorizontalStrut(60));
		panel.add(NumeriTelefono);
		panel.add(Box.createVerticalStrut(70));
		panel.add(Box.createHorizontalStrut(200));
		panel.add(num1);
		panel.add(Num1);
		panel.add(num2);
		panel.add(Num2);
		panel.add(num3);
		panel.add(Num3);
		panel.add(Box.createVerticalStrut(50));
		panel.add(FINISH);
		
		//panel.add(Box.createVerticalStrut(100));
		
		
		//panel.add(FINISH);
		//panel.add(NumeroClientiACarico,panel.LEFT_ALIGNMENT);
		//panel.add(clientiAcarico,panel.RIGHT_ALIGNMENT);
		//panel.add(Box.createVerticalStrut(50));
		super.add(panel);
	}
}
