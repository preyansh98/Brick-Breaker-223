package ca.mcgill.ecse223.block.view;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;


import javax.swing.*;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

/**
 * AddGame UI screen
 * @author Ragheed
 *
 */

public class NewBlockPage {
	
	static JFrame mainWindow = new JFrame("Add a Block");
	static String error_msg = null; 
	static JTextField redTextEntry = new JTextField();
	static JTextField greenTextEntry = new JTextField();
	static JTextField blueTextEntry = new JTextField();
	static JTextField pointsTextEntry = new JTextField();
		
	
	public static void main(String[] args) {
		
		JTextArea colourTextArea = new JTextArea("Colour:"); 
		JTextArea redTextArea = new JTextArea("R"); 
		JTextArea greenTextArea = new JTextArea("G"); 
		JTextArea blueTextArea = new JTextArea("B");
		JTextArea pointsTextArea = new JTextArea("Points");
		JButton cancelButton = new JButton("Cancel"); 
		JButton addButton = new JButton("Add"); 
		JTextArea errorMsg = new JTextArea(error_msg); 
		
		//frame related
		mainWindow.setVisible(true); 
		mainWindow.setLayout(null);
		
		//Setting attributes of components
		mainWindow.setSize(400, 300); //this should be consistent across all features
		
		//ColourTextArea formatting
		colourTextArea.setEditable(false);
		colourTextArea.setLocation(30, 50);
		Dimension ColourTextAreaDimension = colourTextArea.getPreferredSize();
		colourTextArea.setSize(ColourTextAreaDimension);
		colourTextArea.setBackground(mainWindow.getBackground());
		
		//redTextArea formatting
		redTextArea.setEditable(false);
		Dimension redDimension = redTextArea.getPreferredSize();
		redTextArea.setSize(redDimension);	
		redTextArea.setLocation(80, 50);
		redTextArea.setBackground(mainWindow.getBackground());
		
		//greenTextArea formatting
		greenTextArea.setEditable(false);
		Dimension greenDimension = greenTextArea.getPreferredSize();
		greenTextArea.setSize(greenDimension);	
		greenTextArea.setLocation(180, 50);
		greenTextArea.setBackground(mainWindow.getBackground());
		
		//blueTextaArea formatting
		blueTextArea.setEditable(false);
		Dimension blueDimension = blueTextArea.getPreferredSize();
		blueTextArea.setSize(blueDimension);	
		blueTextArea.setLocation(280, 50);
		blueTextArea.setBackground(mainWindow.getBackground());
		
		//pointsTextArea formatting
		pointsTextArea.setEditable(false);
		Dimension pointsDimension = pointsTextArea.getPreferredSize();
		pointsTextArea.setSize(pointsDimension);	
		pointsTextArea.setLocation(30, 130);
		pointsTextArea.setBackground(mainWindow.getBackground());
		
		redTextEntry.setSize(50, 20);
		greenTextEntry.setSize(50, 20);
		blueTextEntry.setSize(50, 20);
		pointsTextEntry.setSize(100, 20);
		
		//setting location in a way that whenever the text moves, the text entry field is always next to it
		redTextEntry.setLocation((int) (redTextArea.getLocation().x + redTextArea.getSize().getWidth() + 20), 
				redTextArea.getLocation().y);
		greenTextEntry.setLocation((int) (greenTextArea.getLocation().x + greenTextArea.getSize().getWidth() + 20), 
				greenTextArea.getLocation().y);
		blueTextEntry.setLocation((int) (blueTextArea.getLocation().x + blueTextArea.getSize().getWidth() + 20), 
				blueTextArea.getLocation().y);
		pointsTextEntry.setLocation((int) (pointsTextArea.getLocation().x + pointsTextArea.getSize().getWidth() + 20), 
				pointsTextArea.getLocation().y);
		
		//cancelButton formatting
		cancelButton.setSize(75, 26);
		cancelButton.setLocation(20, 200);
		
		//saveButton formatting
		addButton.setSize(95, 26);
		addButton.setLocation(260, 200);
	
		//errorMsg formatting
		errorMsg.setEditable(false);
		errorMsg.setSize(300,20);
		errorMsg.setLocation(30, 20);
		errorMsg.setBackground(mainWindow.getBackground());
		
		//Adding all components to frame
		mainWindow.add(colourTextArea);
		mainWindow.add(redTextArea);
		mainWindow.add(greenTextArea);
		mainWindow.add(blueTextArea);
		mainWindow.add(pointsTextArea);
		mainWindow.add(cancelButton);
		mainWindow.add(addButton);
		mainWindow.add(redTextEntry);
		mainWindow.add(greenTextEntry);
		mainWindow.add(blueTextEntry);
		mainWindow.add(pointsTextEntry);
		mainWindow.add(errorMsg); 
		
		//Design here:
		mainWindow.setBackground(Color.gray); //could probably do some RGB
		
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});
		
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});
	
		//testing
		System.out.println(colourTextArea.getLocation().toString());
		System.out.println(redTextArea.getLocation().toString());
		System.out.println(cancelButton.getPreferredSize().toString());
		System.out.println(addButton.getPreferredSize().toString());
	}
	
	/**
	 * Specification for cancelButton event when listener activated
	 * @param evt
	 */
	private static void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// clear error message
		error_msg = null; 
		
		try {
			//close the main frame
			mainWindow.dispose(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Specification for saveButton event when listener activated
	 * @param evt
	 */
	
	private static void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// clear error message
		error_msg = null; 
	
		try {
			Integer.parseInt(redTextEntry.getText());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Integer.parseInt(greenTextEntry.getText());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Integer.parseInt(blueTextEntry.getText());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Integer.parseInt(pointsTextEntry.getText());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		int red = Integer.parseInt(redTextEntry.getText());
		int green = Integer.parseInt(greenTextEntry.getText());
		int blue = Integer.parseInt(blueTextEntry.getText());
		int points = Integer.parseInt(pointsTextEntry.getText());
		
		try {
			//close the main frame
			Block223Controller.addBlock(red, green, blue, points);
			mainWindow.dispose(); 
			//constructor call for game settings
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
