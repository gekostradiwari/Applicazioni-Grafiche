package CommercialistDB.CommercialistDB;

import javax.swing.*;
import java.awt.*;

public class StartFrame {
	public StartFrame() {
		Frame mainPanel = new Frame("Start Panel - Commercialist Manager",1000,800);
		mainPanel.setLayout(new GridLayout(3,3));
		JLabel Title = new JLabel("<html>Commercialist - Manager <br/><br/>&emsp;&emsp;&emsp;&emsp;Start Menu <html>");//<html>Line1 <br/> Line2 <br/> Line3</html>		
		Title.setFont(new Font("TitleFont",Font.BOLD,50));
		Title.setVerticalTextPosition(JLabel.TOP);
		Title.setVerticalAlignment(JLabel.TOP);
		Title.setHorizontalTextPosition(JLabel.CENTER);
		Title.setHorizontalAlignment(JLabel.CENTER);
		JLabel option1 = new JLabel("Selezionare uno studio:");
		option1.setFont(new Font("Option1Font",Font.ITALIC + Font.BOLD,30));
		option1.setVerticalTextPosition(JLabel.CENTER);
		option1.setVerticalAlignment(JLabel.CENTER);
		option1.setHorizontalTextPosition(JLabel.LEFT);
		option1.setHorizontalAlignment(JLabel.LEFT);
		mainPanel.add(Title);
		mainPanel.add(option1);
		
	}
	
	
	

}
