package CommercialistDB.CommercialistDB;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class OpFrame extends Frame {
	String nomeStudio;
	public OpFrame(String title,int x, int y,String nomeStudio) {
		super(title,x,y);
		this.nomeStudio = nomeStudio;
		JPanel panel = new JPanel(new BorderLayout());
		panel.setSize(this.getSize());
		
	}
	
	

}
