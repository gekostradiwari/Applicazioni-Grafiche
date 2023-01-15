package CommercialistDB.CommercialistDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartFrame {
	public StartFrame() {
		//Implementare il fetcheing degli studi
		String s1[] = {"prova1","prova2","prova3"};	
		//Implementare il fetcheing degli studi
		final Frame mainPanel = new Frame("Start Panel - Business Consultant Manager",1000,800);
		JPanel Panel = new JPanel(null);
		Panel.setSize(1000,900);
		JLabel Title = new JLabel("<html>Business Consultant Manger <br/><br/>&emsp;&emsp;&emsp;&emsp;Start Menu <html>"); 
		JLabel option1 = new JLabel("Selezionare uno studio:");
		JLabel Switch = new JLabel("OPPURE");
		JButton option2 = new JButton("Inserisci un nuovo studio");
		JComboBox studioList = new JComboBox(s1);
		studioList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = (String)studioList.getSelectedItem();
				OpFrame opPanel = new OpFrame(s+" "+"-"+" "+"Operations Pane",1000,800,s);
				mainPanel.setVisible(false);
				opPanel.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						mainPanel.setVisible(true);
						super.windowClosed(e);
					}
					
					
				});
				
				
			}
			
		});
		Title.setBounds(0,0,1000,200);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setVerticalAlignment(SwingConstants.TOP);
		Title.setFont(new Font("TitleFont",Font.BOLD,50));
		option1.setBounds(10, 250, 400, 100);
		option1.setFont(new Font("Option1Font",Font.ITALIC + Font.BOLD,30));
		studioList.setBounds(500, 286, 430, 30);
		Switch.setBounds(420, 400, 200, 100);
		Switch.setFont(new Font("SwitchFont",Font.ITALIC + Font.BOLD,30));
		option2.setBounds(250, 520, 500, 100);
		option2.setFont(new Font("Option2Font",Font.ITALIC + Font.BOLD,20));
		option2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addStudio studio = new addStudio("Aggiunta Studio",500,250);
				mainPanel.setVisible(false);
				studio.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						mainPanel.setVisible(true);
						super.windowClosed(e);
					}
				});			
			}			
		});
		//option1.setFont(new Font("Option1Font",Font.ITALIC + Font.BOLD,30));
		System.out.println(option1.getBounds());
		Panel.add(Title);
		Panel.add(option1);
		Panel.add(studioList);
		Panel.add(Switch);
		Panel.add(option2);
		mainPanel.add(Panel,BorderLayout.CENTER);
	}
	
	
	

}
