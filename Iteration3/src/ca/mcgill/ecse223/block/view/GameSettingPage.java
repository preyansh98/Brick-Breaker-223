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
		
		
		//Texts
		JTextArea newGameNameText = new JTextArea("Enter new name: "); 
		JTextArea BallMinSpeedYText = new JTextArea("Enter Ball's minimum Speed Y: "); 
		JTextArea BallMinSpeedXText = new JTextArea("Enter Ball's minimum Speed X: ");
		JTextArea BallSpeedFactorText = new JTextArea("Enter Ball's Speed increase factor: ");
		JTextArea PaddleMinText = new JTextArea("Enter Paddle minimum length: ");
		JTextArea PaddleMaxText = new JTextArea("Enter Paddle maximum length: ");
		//Buttons
		JButton goBackButton = new JButton("Go Back"); 
		JButton updateGameButton = new JButton("Updte"); 
		//Redirected Buttons
		JButton blockSettingsButton = new JButton("Block Settings"); 
		JButton levelSettingsButton = new JButton("Level Settings"); 
		JButton addBlockButton = new JButton("Add a Block"); 
		//PlayArea is Constant now
		
		//Layout
		mainFrame.setSize(400, 300); //constant across all features
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		//Design
		mainFrame.setBackground(Color.gray); //Not set
		
		//newGame Text Style
		newGameNameText.setLocation(30, 60);
		Dimension newGameNameDimension = newGameNameText.getPreferredSize();
		newGameNameText.setSize(newGameNameDimension);
		newGameNameText.setBackground(mainFrame.getBackground()); 

		
		
		newGameNameText.setEditable(false);
		BallMinSpeedXText.setEditable(false);
		BallMinSpeedYText.setEditable(false);
		BallSpeedFactorText.setEditable(false);
		PaddleMaxText.setEditable(false);
		PaddleMinText.setEditable(false);
		
		//BallMinSpeedX Text Style
				BallMinSpeedXText.setLocation(30, 70);
				Dimension BallMinSpeedXDimension = BallMinSpeedXText.getPreferredSize();
				BallMinSpeedXText.setSize(BallMinSpeedXDimension);
				BallMinSpeedXText.setBackground(mainFrame.getBackground()); 
		//BallMinSpeedY Text Style
				BallMinSpeedYText.setLocation(30, 70);
				Dimension BallMinSpeedYDimension = BallMinSpeedYText.getPreferredSize();
				BallMinSpeedYText.setSize(BallMinSpeedYDimension);
				BallMinSpeedYText.setBackground(mainFrame.getBackground()); 
		//Paddle Min Style
				PaddleMinText.setLocation(30, 60);
				Dimension PaddleMinDimension = PaddleMinText.getPreferredSize();
				PaddleMinText.setSize(PaddleMinDimension);
				PaddleMinText.setBackground(mainFrame.getBackground()); 
		//Paddle Max Style
				PaddleMaxText.setLocation(30, 60);
				Dimension PaddleMaxDimension = PaddleMaxText.getPreferredSize();
				PaddleMaxText.setSize(PaddleMaxDimension);
				PaddleMaxText.setBackground(mainFrame.getBackground()); 

		//Buttons
				goBackButton.setSize(75, 26);
				updateGameButton.setLocation(20, 180);
				blockSettingsButton.setLocation(20, 180);
				levelSettingsButton.setLocation(20, 180);
				addBlockButton.setLocation(20, 180);
		
		

		//Adding elements into the main frame
				//Texts
				mainFrame.add(newGameNameText);
				mainFrame.add(BallMinSpeedYText);
				mainFrame.add(BallMinSpeedXText);
				mainFrame.add(PaddleMaxText);
				mainFrame.add(PaddleMinText);
				mainFrame.add(BallSpeedFactorText);
				//Buttons
				mainFrame.add(goBackButton);
				mainFrame.add(updateGameButton);
				mainFrame.add(addBlockButton);
				mainFrame.add(levelSettingsButton);
				mainFrame.add(blockSettingsButton);
		
		goBackButton.addActionListener(new java.awt.event.ActionListener() {
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
