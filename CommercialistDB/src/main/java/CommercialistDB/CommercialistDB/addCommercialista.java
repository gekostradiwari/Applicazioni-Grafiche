package CommercialistDB.CommercialistDB;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.*;

import javax.swing.JPanel;

public class addCommercialista extends Frame {

	public addCommercialista(String title, int x, int y) {
		super(title, x, y);
		JPanel panel = new JPanel(new FlowLayout());
		panel.setSize(new Dimension(super.getSize()));
		JLabel Nome = new JLabel("Nome: ");
		JLabel Cognome = new JLabel("Cognome: ");
		JLabel NumeriTelefono = new JLabel("Recapiti Telefonici (MAX 3): ");
		JLabel CodiceFiscale = new JLabel("Codice Fiscale:");
		JLabel NumeroClientiACarico = new JLabel("Numero Clienti seguiti: ");
		JTextArea numeriTelefono = new JTextArea(3,11);
		JTextField name = new JTextField();
		JTextField surname = new JTextField();
		JTextField telephoneNumbers = new JTextField();
		JTextField codiceFiscale = new JTextField();
		JTextField clientiAcarico = new JTextField();
		name.setEditable(true);
		name.setPreferredSize(new Dimension(400,25));
		surname.setEditable(true);
		surname.setPreferredSize(new Dimension(400,25));
		codiceFiscale.setEditable(true);
		codiceFiscale.setPreferredSize(new Dimension(380,25));
		panel.add(Nome);
		panel.add(name);
		panel.add(Cognome);
		panel.add(surname);
		panel.add(CodiceFiscale);
		panel.add(codiceFiscale);
		panel.add(NumeroClientiACarico);
		panel.add(clientiAcarico);
		super.add(panel);
	}
	

}
