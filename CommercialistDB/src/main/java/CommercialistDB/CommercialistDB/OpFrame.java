package CommercialistDB.CommercialistDB;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OpFrame extends Frame {
	String nomeStudio;
	public OpFrame(String title,int x, int y,String nomeStudio) {
		super(title,x,y);
		this.nomeStudio = nomeStudio;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setBounds(10, 10, 200, 1000);
	
		JPanel panel2 = new JPanel(null);
		panel2.setBounds(220, 10, 760, 1000);	
		JTextArea output = new JTextArea();
		output.setBounds(0, 0, 760, 1000);
		output.setEditable(false);
		JButton op1 = new JButton("op1");
		op1.setPreferredSize(new Dimension(150,30));
		op1.setMaximumSize(new Dimension(190,30));		
		JButton op2 = new JButton("op2");
		op2.setPreferredSize(new Dimension(150,30));
		op2.setMaximumSize(new Dimension(190,30));
		JButton op3 = new JButton("op3");
		op3.setPreferredSize(new Dimension(150,30));
		op3.setMaximumSize(new Dimension(190,30));
		JButton op4 = new JButton("op4");
		op4.setPreferredSize(new Dimension(150,30));
		op4.setMaximumSize(new Dimension(190,30));
		JButton op5 = new JButton("op5");
		op5.setPreferredSize(new Dimension(150,30));
		op5.setMaximumSize(new Dimension(190,30));
		JButton op6 = new JButton("op6");
		op6.setPreferredSize(new Dimension(150,30));
		op6.setMaximumSize(new Dimension(190,30));
		JButton op7 = new JButton("op7");
		op7.setPreferredSize(new Dimension(150,30));
		op7.setMaximumSize(new Dimension(190,30));
		JButton op8 = new JButton("op8");
		op8.setPreferredSize(new Dimension(150,30));
		op8.setMaximumSize(new Dimension(190,30));
		JButton op9 = new JButton("op9");
		op9.setPreferredSize(new Dimension(150,30));
		op9.setMaximumSize(new Dimension(190,30));
		JButton op10 = new JButton("op10");
		op10.setPreferredSize(new Dimension(150,30));
		op10.setMaximumSize(new Dimension(190,30));
		JButton op11 = new JButton("op11");
		op11.setPreferredSize(new Dimension(150,30));
		op11.setMaximumSize(new Dimension(190,30));
		JButton op12 = new JButton("op12");
		op12.setPreferredSize(new Dimension(150,30));
		op12.setMaximumSize(new Dimension(190,30));
		JButton op13 = new JButton("op13");
		op13.setPreferredSize(new Dimension(150,30));
		op13.setMaximumSize(new Dimension(190,30));
		JButton op14 = new JButton("op14");
		op14.setPreferredSize(new Dimension(150,30));
		op14.setMaximumSize(new Dimension(190,30));
		JButton op15 = new JButton("op15");
		op15.setPreferredSize(new Dimension(150,30));
		op15.setMaximumSize(new Dimension(190,30));
		JButton op16 = new JButton("op16");
		op16.setPreferredSize(new Dimension(150,30));
		op16.setMaximumSize(new Dimension(190,30));
		JButton op17 = new JButton("op17");
		op17.setPreferredSize(new Dimension(150,30));
		op17.setMaximumSize(new Dimension(190,30));
		JButton op18 = new JButton("op18");
		op18.setPreferredSize(new Dimension(150,30));
		op18.setMaximumSize(new Dimension(190,30));
		JButton op19 = new JButton("op19");
		op19.setPreferredSize(new Dimension(150,30));
		op19.setMaximumSize(new Dimension(190,30));
		JButton op20 = new JButton("op20");
		op20.setPreferredSize(new Dimension(150,30));
		op20.setMaximumSize(new Dimension(190,30));
		JButton op21 = new JButton("op21");
		op21.setPreferredSize(new Dimension(150,30));
		op21.setMaximumSize(new Dimension(190,30));
		JButton op22 = new JButton("op22");
		op22.setPreferredSize(new Dimension(150,30));
		op22.setMaximumSize(new Dimension(190,30));
		JButton op23 = new JButton("op23");
		op23.setPreferredSize(new Dimension(150,30));
		op23.setMaximumSize(new Dimension(190,30));
		JButton op24 = new JButton("op24");
		op24.setPreferredSize(new Dimension(150,30));
		op24.setMaximumSize(new Dimension(190,30));
		
		panel.add(op1);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op2);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op3);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op4);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op5);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op6);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op7);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op8);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op9);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op10);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op11);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op12);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op13);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op14);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op15);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op16);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op17);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op18);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op19);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op20);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op21);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op22);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op23);
		panel.add(Box.createVerticalStrut(10));
		panel.add(op24);
		panel.add(Box.createVerticalStrut(10));
		panel2.add(output);
	
		
	
		add(panel);
		add(panel2);	
	}
	
	

}
