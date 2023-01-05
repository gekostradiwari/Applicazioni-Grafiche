package grafica.grafica;

import javax.swing.JComponent;
import java.awt.*;

public class RectangleComponent extends JComponent {
	private Rectangle box;
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		box = new Rectangle((getWidth()-100)/2,(getHeight()-100)/2,100,100);
		g2.setColor(Color.RED);
		g2.fill(box);
		g2.draw(box);
	}
	public void moveTo(int x, int y) {
		box.setLocation(x,y);
		repaint();
	}
	

}
