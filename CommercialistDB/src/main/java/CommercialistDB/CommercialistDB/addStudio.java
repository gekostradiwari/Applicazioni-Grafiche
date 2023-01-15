package CommercialistDB.CommercialistDB;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.lang.foreign.GroupLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

//import jdk.incubator.vector.VectorOperators.Test;

import javax.swing.*;

public class addStudio extends Frame {

	public addStudio(String title, int x, int y) {
		super(title, x, y);
		JPanel panel = new JPanel(new FlowLayout());
		final Frame cloned = this;
		panel.setSize(new Dimension(super.getSize()));
		JLabel NomeStudio = new JLabel("Nome Studio: ");
		JLabel IndirizzoStudio = new JLabel("Indirizzo di locazione: ");
		JLabel RecapitoTelefonico = new JLabel("Numero di Telefono: ");
		JButton Next = new JButton("Next");
		JTextField Name = new JTextField();
		JTextField Indirizzo = new JTextField();
		JTextField Telefono = new JTextField();
		JButton Back = new JButton("Back");
		Next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addCommercialista commercialista = new addCommercialista("Aggiunta Commercialista",500,500);
				cloned.setVisible(false);				
				commercialista.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
							cloned.setVisible(true);
							super.windowClosed(e);
					}
			
				});	
				
				commercialista.addContainerListener(new ContainerListener() {

					@Override
					public void componentAdded(ContainerEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void componentRemoved(ContainerEvent e) {
						final Studio s = new Studio(Indirizzo.getText(),Telefono.getText(),Name.getText());
						//IMPLEMENTAZIONE QUERY
						commercialista.dispose();
						cloned.dispose();
						
					}
					
				});
								
				commercialista.addComponentListener(new ComponentListener() {

					@Override
					public void componentResized(ComponentEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void componentMoved(ComponentEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void componentShown(ComponentEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void componentHidden(ComponentEvent e) {
						
					}	
					
				});
			}			
		});
		
		Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}			
		});
		
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
		panel.add(Box.createVerticalStrut(50));
		panel.add(IndirizzoStudio);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(Indirizzo);
		panel.add(Box.createVerticalStrut(50));
		panel.add(RecapitoTelefonico);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(Telefono);
		panel.add(Box.createVerticalStrut(50));
		panel.add(Back);
		panel.add(Box.createHorizontalStrut(300));
		panel.add(Next);
		super.add(panel); 
	}

	
}
