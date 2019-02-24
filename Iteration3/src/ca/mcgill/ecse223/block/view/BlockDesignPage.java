package ca.mcgill.ecse223.block.view;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

/**
 * AddGame UI screen
 * @author Elie Elia
 *
 */
public class BlockDesignPage {
	static String error_msg = null; 

	public static void main(String[] args) {
		
	//UI Elements
	JFrame mainWindow = new JFrame("Block Settings"); 
	JTextArea Colour = new JTextArea("Colour:"); 
	JTextArea red = new JTextArea("R"); 
	JTextArea green = new JTextArea("G"); 
	JTextArea blue = new JTextArea("B");
	JTextArea points = new JTextArea("Points");
	JButton cancelButton = new JButton("Cancel"); 
	JButton updateButton = new JButton("Update"); 
	JButton deleteButton = new JButton("Delete from Game"); 
	JTextField redtextentry = new JTextField();
	JTextField greentextentry = new JTextField();
	JTextField bluetextentry = new JTextField();
	JTextField pointstextentry = new JTextField();
	JTextField updatetextentry = new JTextField();
	JTextArea errorMsg = new JTextArea(error_msg); 
	
	//frame related
	mainWindow.setVisible(true); 
	mainWindow.setLayout(null);
	
	//Setting attributes of components
	mainWindow.setSize(400, 300); //this should be consistent across all features
	Colour.setEditable(false);
	red.setEditable(false);
	green.setEditable(false);
	blue.setEditable(false);
	points.setEditable(false);
	
	Colour.setLocation(20, 60);
	Dimension BlockSettingsdimension = Colour.getPreferredSize();
	Colour.setSize(BlockSettingsdimension);
	Colour.setBackground(mainWindow.getBackground()); //added this so it doesnt stand out
	
	Dimension redDimension = red.getPreferredSize();
	red.setSize(redDimension);	
	red.setLocation(80, 60);
	red.setBackground(mainWindow.getBackground());
	
	Dimension pointsDimension = points.getPreferredSize();
	points.setSize(pointsDimension);	
	points.setLocation(20, 120);
	points.setBackground(mainWindow.getBackground());
	
	Dimension blueDimension = blue.getPreferredSize();
	blue.setSize(blueDimension);	
	blue.setLocation(280, 60);
	blue.setBackground(mainWindow.getBackground());
	
	Dimension greenDimension = green.getPreferredSize();
	green.setSize(greenDimension);	
	green.setLocation(180, 60);
	green.setBackground(mainWindow.getBackground());
	
	
	redtextentry.setSize(50, 20);
	greentextentry.setSize(50, 20);
	bluetextentry.setSize(50, 20);
	pointstextentry.setSize(100, 20);
	//setting location in a way that whenever the text moves, the text entry field is always next to it
	redtextentry.setLocation((int) (red.getLocation().x + red.getSize().getWidth() + 20), 
			red.getLocation().y);
	greentextentry.setLocation((int) (green.getLocation().x + green.getSize().getWidth() + 20), 
			green.getLocation().y);
	bluetextentry.setLocation((int) (blue.getLocation().x + blue.getSize().getWidth() + 20), 
			blue.getLocation().y);
	pointstextentry.setLocation((int) (points.getLocation().x + points.getSize().getWidth() + 20), 
			points.getLocation().y);
	
	cancelButton.setSize(75, 26);
	cancelButton.setLocation(20, 180);
	
	updateButton.setSize(95, 26);
	updateButton.setLocation(110, 180);
	
	deleteButton.setSize(150, 26);
	deleteButton.setLocation(220, 180);
	
	errorMsg.setEditable(false);
	errorMsg.setSize(300,20);
	errorMsg.setLocation(30, 20);
	errorMsg.setBackground(mainWindow.getBackground());
	
	//Adding all components to frame
	mainWindow.add(Colour);
	mainWindow.add(red);
	mainWindow.add(green);
	mainWindow.add(blue);
	mainWindow.add(points);
	mainWindow.add(cancelButton);
	mainWindow.add(updateButton);
	mainWindow.add(deleteButton);
	mainWindow.add(redtextentry);
	mainWindow.add(greentextentry);
	mainWindow.add(bluetextentry);
	mainWindow.add(pointstextentry);
	mainWindow.add(errorMsg); 

	//Design here:
	mainWindow.setBackground(Color.gray); //could probably do some rgb
	
	
//	//Listener for buttons
//	updateButton.addActionListener(new java.awt.event.ActionListener() {
//		public void actionPerformed(java.awt.event.ActionEvent evt) {
//			updateButtonActionPerformed(evt, updatetextentry);
//		}
//	});

	
	//testing
	System.out.println(Colour.getLocation().toString());
	System.out.println(red.getLocation().toString());
	System.out.println(cancelButton.getPreferredSize().toString());
	System.out.println(updateButton.getPreferredSize().toString());
	}
	
	/**
	 * Specification for addGame event when listener activated
	 * @param evt
	 */
	private static void addGameButtonActionPerformed(java.awt.event.ActionEvent evt, JTextField textEntry) {
		// clear error message
		error_msg = null;
		
		// call the controller
		try {
			Block223Controller.createGame(textEntry.getText());
		} catch (InvalidInputException e) {
			error_msg = e.getMessage();
		}
		
		// add method here to move on to next screen
	}
}
