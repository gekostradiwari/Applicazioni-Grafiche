package CommercialistDB.CommercialistDB;

import javax.swing.*;
import java.awt.*;

public class StartFrame {
	public StartFrame() {
		Frame mainPanel = new Frame("Start Panel - Commercialist Manager",1000,800);
		mainPanel.setLayout(null);
		JLabel Title = new JLabel("Commercialist - Manager");
		JLabel StartMenu = new JLabel("Start Menu");
		Title.setFont(new Font("TitleFont",Font.BOLD,24));
		StartMenu.setFont(new Font("FontMenu",Font.BOLD,24));		
		mainPanel.add(Title);
		//mainPanel.add(StartMenu);
		//mainPanel.add(Title);
		//mainPanel.add(StartMenu);
		//mainPanel.add(Title,BorderLayout.NORTH);
		//mainPanel.add(StartMenu,BorderLayout.NORTH);
		//mainPanel.add(startPane,BorderLayout.NORTH);
	}
	
	
	

}
