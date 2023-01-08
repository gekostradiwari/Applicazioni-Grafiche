package CommercialistDB.CommercialistDB;

import javax.swing.*;
import java.awt.*;



public class StartFrame {
	public StartFrame() {
		Frame mainPanel = new Frame("Start Panel - Commercialist Manager",1000,800);
		JPanel titlePane = new JPanel(new BorderLayout());
		JLabel Title = new JLabel("Commercialist - Manager");
		JLabel StartMenu = new JLabel("Start Menu");		
		Title.setFont(new Font("TitleFont",Font.BOLD,24));
		StartMenu.setFont(new Font("FontMenu",Font.BOLD,24));
		titlePane.add(Title,BorderLayout.NORTH);
		titlePane.add(StartMenu,BorderLayout.CENTER);
		mainPanel.add(titlePane,BorderLayout.PAGE_START);
		//mainPanel.add(Title);
		//mainPanel.add(StartMenu);
		//mainPanel.add(Title,BorderLayout.NORTH);
		//mainPanel.add(StartMenu,BorderLayout.NORTH);
		//mainPanel.add(startPane,BorderLayout.NORTH);
	}
	
	
	

}
