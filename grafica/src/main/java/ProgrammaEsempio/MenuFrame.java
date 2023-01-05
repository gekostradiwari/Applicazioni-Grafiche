package ProgrammaEsempio;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuFrame extends JFrame {
	public MenuFrame() {
		sampleField = new JLabel("Big Java");
		add(sampleField,BorderLayout.CENTER);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		menuBar.add(createFontMenu());
		facename = "Serif";
		fontsize = 24;
		fontstyle = Font.PLAIN;
		setSampleFont();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
	}
	
	public JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		return menu;
	}
	public JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	public JMenu createFontMenu() {
		JMenu menu = new JMenu("Font");
		menu.add(createFaceMenu());
		menu.add(createSizeMenu());
		menu.add(createStyleMenu());
		return menu;
	}
	
	public JMenu createFaceMenu() {
		JMenu menu = new JMenu("Face");
		menu.add(createFaceItem("Serif"));
		menu.add(createFaceItem("SansSerif"));
		menu.add(createFaceItem("Monospaced"));
		return menu;
	}
	
	public JMenu createSizeMenu() {
		JMenu menu = new JMenu("Size");
		menu.add(createSizeItem("Smaller",-1));
		menu.add(createSizeItem("Larger",1));
		return menu;
	}
	
	public JMenu createStyleMenu() {
		JMenu menu = new JMenu("Style");
		menu.add(createStyleItem("Plain",Font.PLAIN));
		menu.add(createStyleItem("Bold",Font.BOLD));
		menu.add(createStyleItem("Italic",Font.ITALIC));
		menu.add(createStyleItem("Bold Italic",Font.BOLD+Font.ITALIC));
		return menu;
	}
	public JMenuItem createFaceItem(final String name) {
		JMenuItem item = new JMenuItem(name);
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				facename = name;
				setSampleFont();
			}
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	public JMenuItem createSizeItem(String name,final int ds) {
		JMenuItem item = new JMenuItem(name);
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				fontsize = fontsize + ds;
				setSampleFont();
			}
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	public JMenuItem createStyleItem(String name, final int style) {
		JMenuItem item = new JMenuItem(name);
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				fontstyle = style;
				setSampleFont();
			}
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}
	public void setSampleFont() {
		Font f = new Font(facename,fontstyle,fontsize);
		sampleField.setFont(f);
		sampleField.repaint();
	}
	private JLabel sampleField;
	private String facename;
	private int fontstyle;
	private int fontsize;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;

}
