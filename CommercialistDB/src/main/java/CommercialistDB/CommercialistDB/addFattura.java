package CommercialistDB.CommercialistDB;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class addFattura extends Frame {

	public addFattura() {
		super("Aggiunta Fattura",500,500);
		JPanel panel = new JPanel(null);
		JLabel date = new JLabel("Data Emissione: ");
		date.setLocation(10, 10);
		panel.add(date);
		add(panel);
	}
	
	

}
