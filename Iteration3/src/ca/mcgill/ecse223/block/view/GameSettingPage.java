package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException; 


//GAME SETTING SCREEN
public class GameSettingPage {
	static JFrame mainFrame = new JFrame("Game Settings");
	static JTextArea errorMsg; 
	static String error_msg = null; 
	
	
	
	public static void main(String[] args) {
		
		JTextArea newGameName = new JTextArea("Enter new name: "); 
		JTextArea BallMinSpeedY = new JTextArea("Enter Ball's minimum Speed Y: "); 
		JTextArea BallMinSpeedX = new JTextArea("Enter Ball's minimum Speed X: ");
		JTextArea BallSpeedFactor = new JTextArea("Enter Ball's Speed increase factor: ");
		JTextArea PaddleMin = new JTextArea("Enter Paddle minimum length: ");
		JTextArea PaddleMax = new JTextArea("Enter Paddle maximum length: ");
		JButton goBack = new JButton("Go Back"); 
		JButton updateGame = new JButton("Updte"); 
		//Dont know about this:
		JButton blockSettings = new JButton("Block Settings"); 
		JButton levelSettings = new JButton("Level Settings"); 
		JButton addBlock = new JButton("Add a Block"); 
		//PlayArea is Constant now
		
		mainFrame.setSize(400, 300); //constant across all features
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		
		
		goBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBackActionPerformed(evt);
			}
		});
		
	}
	
	private static void goBackActionPerformed(java.awt.event.ActionEvent evt) {
		// clear error message
		error_msg = null; 
		
		try {
			//close the main frame
			mainFrame.dispose(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	void initializeThis() {
		mainFrame.setVisible(true);
		this.main(null);
	}
}
