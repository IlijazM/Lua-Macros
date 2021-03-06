package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import frame.Frame;

public class Main {
	
	static Frame frame;
	
	public static void main(String[] args) {
		setLookAndFeel();
		
		Init.initAll();
	}
	
	static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
}
