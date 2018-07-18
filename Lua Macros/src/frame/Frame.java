package frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame {
	
	public JFrame frame;
	
	public MainPanel mainPanel;
	
	public Frame(String title, int width, int height) {
		frame = new JFrame(title);
		
		setBounds(width, height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new MainPanel();
		frame.setContentPane(mainPanel);
		
		frame.setVisible(true);
	}
	
	private void setBounds(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (int) ((screenSize.width - width)*0.5);
		int y = (int) ((screenSize.height - height)*0.5);
		
		frame.setBounds(x, y, width, height);
	}
	
}