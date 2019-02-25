package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import ca.mcgill.ecse223.block.controller.Block223Controller;

public class PlayerPage {
	static JFrame mainFrame = new JFrame("Player Mode");
	public static void main(String[] args) {

		// UI Elements1
		JTextArea displayText=new JTextArea("Player Mode is not Available at the moment");
		JButton logoutButton=new JButton("Logout");
		// frame related
		mainFrame.setVisible(true);
		mainFrame.setLayout(null);
		mainFrame.setBackground(Color.gray);
		mainFrame.setSize(400, 300); 
		
		// text output related parameters
		displayText.setEditable(false);
		displayText.setFont(new Font("test", 1, 17));
		displayText.setSize(displayText.getPreferredSize());
		displayText.setLocation(10,60);
		displayText.setBackground(mainFrame.getBackground());
		
		// Button related attributes
		logoutButton.setSize(100, 25);
		logoutButton.setLocation(20, 200);
		
		// Components initialization
		mainFrame.add(logoutButton);
		mainFrame.add(displayText);
		
		logoutButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt);
			}
		});
	}
	protected static void registerButtonActionPerformed(ActionEvent evt) {
		Block223Controller.logout();
		
	}
}
