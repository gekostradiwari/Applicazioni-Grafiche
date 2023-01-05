package grafica.grafica;

import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Frame finestra = new Frame("Nuova Finestra",300,400);
    	final RectangleComponent rectangle = new RectangleComponent();
    	class MousePressListener implements MouseListener{
    		public void mousePressed(MouseEvent event) {
    			int x = event.getX();
    			int y = event.getY();
    			rectangle.moveTo(x, y);
    		}

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
    			int y = e.getY();
    			rectangle.moveTo(x, y);
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
    	}
    	MouseListener listener = new MousePressListener();
    	rectangle.addMouseListener(listener);
    	finestra.add(rectangle);
    }
}
