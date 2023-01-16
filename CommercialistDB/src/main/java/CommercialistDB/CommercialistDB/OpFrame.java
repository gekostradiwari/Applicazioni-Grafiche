package CommercialistDB.CommercialistDB;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OpFrame extends Frame {
	String nomeStudio;
	public OpFrame(String title,int x, int y,String nomeStudio) {
		super(title,x,y);
		this.nomeStudio = nomeStudio;
		JPanel panel = new JPanel(new BorderLayout());
		panel.setSize(this.getSize());
		JTextArea output = new JTextArea();
		JButton op1 = new JButton("op1");
		JButton op2 = new JButton("op2");
		JButton op3 = new JButton("op3");
		
		panel.add(op1,BorderLayout.WEST);
		panel.add(op2,BorderLayout.WEST);
		panel.add(op3,BorderLayout.WEST);
		panel.add(output,BorderLayout.CENTER);
		
		add(panel);
	}
	
	

}
