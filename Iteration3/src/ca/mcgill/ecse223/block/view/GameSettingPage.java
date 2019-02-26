package ca.mcgill.ecse223.block.view;

import javax.swing.*; 

public class GameSettingPage {
	static JFrame mainFrame = new JFrame("Game Settings");

	public static void main(String[] args) {
		
		mainFrame.setSize(400, 300);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		
	}
	
	void initializeThis() {
		mainFrame.setVisible(true);
		this.main(null);
	}
}
