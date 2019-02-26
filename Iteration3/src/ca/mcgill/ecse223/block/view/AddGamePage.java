package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

/**
 * AddGame UI screen
 * @author Preyansh
 *
 */
public class AddGamePage {
	static String error_msg = null; 
	static JFrame mainFrame = new JFrame("Add a Game"); 
	static JTextArea errorMsg; 
	
	public static void main(String[] args) {
		
	//UI Elements
	JTextArea addGameText = new JTextArea("Enter new game name: "); 
	JTextArea levelText = new JTextArea("Enter no. of Levels: "); 
	JButton cancelButton = new JButton("Cancel"); 
	JButton addGameButton = new JButton("Add Game"); 
	JTextField addGameTextEntry = new JTextField();
	JTextField levelTextEntry = new JTextField(); 
	errorMsg = new JTextArea(error_msg); 
	
	//frame related
	mainFrame.setVisible(true); 
	mainFrame.setLayout(null);
	
	//Setting attributes of components
	mainFrame.setSize(400, 300); //this should be consistent across all features

	addGameText.setEditable(false);
	levelText.setEditable(false);
	
	addGameText.setLocation(30, 60);
	Dimension addGameDimension = addGameText.getPreferredSize();
	addGameText.setSize(addGameDimension);
	addGameText.setBackground(mainFrame.getBackground()); //added this so it doesnt stand out
	
	Dimension levelDimension = levelText.getPreferredSize();
	levelText.setSize(levelDimension);	
	levelText.setLocation(30, 110);
	levelText.setBackground(mainFrame.getBackground());
	
	addGameTextEntry.setSize(200, 20);
	//setting location in a way that whenever the text moves, the text entry field is always next to it
	addGameTextEntry.setLocation((int) (addGameText.getLocation().x + addGameText.getSize().getWidth() + 20), 
			addGameText.getLocation().y);
	levelTextEntry.setSize(200, 20);
	levelTextEntry.setLocation((int) (addGameText.getLocation().x + addGameText.getSize().getWidth() + 20), 
			levelText.getLocation().y);
	
	cancelButton.setSize(75, 26);
	cancelButton.setLocation(20, 180);
	
	addGameButton.setSize(95, 26);
	addGameButton.setLocation(280, 180);
	
	errorMsg.setEditable(false);
	errorMsg.setSize(300,20);
	errorMsg.setLocation(30, 20);
	errorMsg.setBackground(mainFrame.getBackground());
	
	//Adding all components to frame
	mainFrame.add(addGameText);
	mainFrame.add(levelText);
	mainFrame.add(cancelButton);
	mainFrame.add(addGameButton);
	mainFrame.add(addGameTextEntry);
	mainFrame.add(levelTextEntry);
	mainFrame.add(errorMsg); 

	//Design here:
	mainFrame.setBackground(Color.gray); //could probably do some rgb
	
	
	//Listener for buttons
	addGameButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			addGameButtonActionPerformed(evt, addGameTextEntry);
		}
	});
	
	cancelButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			cancelButtonActionPerformed(evt);
		}
	});

	
	}
	
	/**
	 * Specification for addGame event when listener activated
	 * @param evt
	 */
	private static void addGameButtonActionPerformed(java.awt.event.ActionEvent evt, JTextField textEntry) {
		// clear error message
		error_msg = null;
		errorMsg.setText(error_msg);
		// call the controller
		try {
			Block223Controller.createGame(textEntry.getText());
			Block223Controller.saveGame();
		} 
		catch (InvalidInputException e) {
			error_msg = e.getMessage();
			errorMsg.setText(error_msg);
		}
		
		// add method here to move on to next screen
		
	}
	
	private static void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
