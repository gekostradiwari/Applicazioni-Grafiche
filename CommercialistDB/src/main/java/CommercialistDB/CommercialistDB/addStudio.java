package CommercialistDB.CommercialistDB;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.foreign.GroupLayout;

import javax.swing.JPanel;

import jdk.incubator.vector.VectorOperators.Test;

import javax.swing.*;

public class addStudio extends Frame {

	public addStudio(String title, int x, int y) {
		super(title, x, y);
		JPanel panel = new JPanel(new FlowLayout());
		Frame cloned = this;
		panel.setSize(new Dimension(super.getSize()));
		JLabel NomeStudio = new JLabel("Nome Studio: ");
		JLabel IndirizzoStudio = new JLabel("Indirizzo di locazione: ");
		JLabel RecapitoTelefonico = new JLabel("Numero di Telefono: ");
		JButton Next = new JButton("Next");
		Next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addCommercialista commercialista = new addCommercialista("Aggiunta Commercialista",500,300);
				cloned.setVisible(false);				
				commercialista.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {	
						cloned.setVisible(true);
						super.windowClosed(e);
					}				
				});				
			}			
		});
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}			
		});
		JTextField Name = new JTextField();
		JTextField Indirizzo = new JTextField();
		JTextField Telefono = new JTextField();
		Name.setEditable(true);
		Name.setPreferredSize(new Dimension(359,25));
		Name.setAlignmentX(JTextField.RIGHT);
		NomeStudio.setAlignmentX(JLabel.LEFT);
		Indirizzo.setEditable(true);
		Indirizzo.setPreferredSize(new Dimension(300,25));
		Indirizzo.setAlignmentX(JTextField.RIGHT);
		IndirizzoStudio.setAlignmentX(JLabel.LEFT);
		Telefono.setEditable(true);
		Telefono.setAlignmentX(JTextField.RIGHT);
		RecapitoTelefonico.setAlignmentX(JTextField.LEFT);;
		Telefono.setPreferredSize(new Dimension(313,25));
		panel.add(NomeStudio);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(Name);
		panel.add(IndirizzoStudio);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(Indirizzo);
		panel.add(RecapitoTelefonico);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(Telefono);
		panel.add(Back);
		panel.add(Box.createHorizontalStrut(100));
		panel.add(Next);
		super.add(panel); 
	}
}
