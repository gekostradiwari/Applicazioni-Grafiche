package CommercialistDB.CommercialistDB;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Frame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Frame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public Frame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public Frame(String title, int x, int y) {
		super(title);
		this.setSize(x,y);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

}
