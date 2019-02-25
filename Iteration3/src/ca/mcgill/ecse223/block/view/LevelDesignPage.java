package ca.mcgill.ecse223.block.view;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.*;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOBlock;
import ca.mcgill.ecse223.block.controller.TOGame;

/**
 * AddGame UI screen
 * @author Elie Elia
 *
 */

public class LevelDesignPage {
	static HashMap<Integer, Integer> currentlevels;
	static JComboBox<Integer> selectLevel;
	static JFrame mainWindow = new JFrame("Level Settings");
	static String error_msg = null; 
	static HashMap<Integer, Integer> currentBlocks;
	static JComboBox<Integer> selectBlocks;
	static HashMap<Integer, Integer> currentLevels;
	static JComboBox<Integer> selectLevels;
	static JTextField xentry = new JTextField();
	static JTextField yentry = new JTextField();
	public static void main(String[] args) {
	
	//UI Elements
	JTextArea inputx = new JTextArea("Input X: ");
	JTextArea inputy = new JTextArea("Input Y:"); 
	JTextArea selectblock = new JTextArea("Select Block:"); 
	JButton cancelButton = new JButton("Cancel"); 
	JButton saveButton = new JButton("Save"); 
	JButton removeButton = new JButton("Remove from level");
	JButton confirmButton = new JButton("Confirm Position");
	
	JTextArea errorMsg = new JTextArea(error_msg); 
	inputx.setEditable(false);
	inputy.setEditable(false);
	selectblock.setEditable(false);
	
	xentry.setLocation(30, 55);
	yentry.setLocation(30, 80);
	Dimension selectBlockDimension = selectblock.getPreferredSize();
	selectblock.setSize(selectBlockDimension);
	selectblock.setBackground(mainWindow.getBackground()); 
	
	HashMap<Integer, Integer> currentBlocks = null; 
	JComboBox<Integer> selectBlocks = new JComboBox<Integer>(new Integer[0]); 
	int blockIndex = 0;
	try {
		refreshblocks(currentBlocks, selectBlocks, blockIndex);
	} catch (InvalidInputException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	selectBlocks.setEditable(false);
	selectBlocks.setSize(110, 26);
	selectBlocks.setVisible(true);
	selectBlocks.setName("Block");
	selectBlocks.setLocation((int) (selectblock.getLocation().x + selectblock.getSize().getWidth() + 10)
			, (int) selectblock.getLocation().getY());
	//frame related
	mainWindow.setVisible(true); 
	mainWindow.setLayout(null);
	
	//Setting attributes of components
	mainWindow.setSize(400, 300); //this should be consistent across all features
	
	
	inputx.setLocation(20, 100);
	Dimension inputxdimension = inputx.getPreferredSize();
	inputx.setSize(inputxdimension);
	inputx.setBackground(mainWindow.getBackground()); //added this so it doesnt stand out
	
	Dimension inputyDimension = inputy.getPreferredSize();
	inputy.setSize(inputyDimension);	
	inputy.setLocation(80, 100);
	inputy.setBackground(mainWindow.getBackground());
	
	Dimension selectblockDimension = selectblock.getPreferredSize();
	selectblock.setSize(selectblockDimension);	
	selectblock.setLocation(20, 150);
	selectblock.setBackground(mainWindow.getBackground());
	
	
	xentry.setSize(50, 20);
	yentry.setSize(50, 20);
	
	xentry.setLocation((int) (inputx.getLocation().x + inputx.getSize().getWidth() + 20), 
			inputx.getLocation().y);
	yentry.setLocation((int) (inputy.getLocation().x + inputy.getSize().getWidth() + 20), 
			inputy.getLocation().y);
	
	
	cancelButton.setSize(75, 26);
	cancelButton.setLocation(20, 180);
	
	saveButton.setSize(95, 26);
	saveButton.setLocation(110, 180);
	
	confirmButton.setSize(150, 26);
	confirmButton.setLocation(220, 180);
	
	removeButton.setSize(150, 26);
	removeButton.setLocation(220, 180);
	
	errorMsg.setEditable(false);
	errorMsg.setSize(300,20);
	errorMsg.setLocation(30, 20);
	errorMsg.setBackground(mainWindow.getBackground());
	
	//Adding all components to frame
	mainWindow.add(xentry);
	mainWindow.add(yentry);
	mainWindow.add(inputx);
	mainWindow.add(inputy);
//	mainWindow.add(points);
//	mainWindow.add(cancelButton);
//	mainWindow.add(updateButton);
//	mainWindow.add(deleteButton);
//	mainWindow.add(redtextentry);
//	mainWindow.add(greentextentry);
//	mainWindow.add(bluetextentry);
//	mainWindow.add(pointstextentry);
//	mainWindow.add(errorMsg); 
//	mainWindow.add(selectBlocks);
//	mainWindow.add(selectBlockText);

	//Design here:
	mainWindow.setBackground(Color.gray); //could probably do some rgb
	
	
//	//Listener for buttons
//	updateButton.addActionListener(new java.awt.event.ActionListener() {
//		public void actionPerformed(java.awt.event.ActionEvent evt) {
//			updateButtonActionPerformed(evt, updatetextentry);
//		}
//	});

	cancelButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			cancelButtonActionPerformed(evt);
		}
	});
	
	saveButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			saveButtonActionPerformed(evt, currentBlocks, selectBlocks);
		}
	});
	
	removeButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			removeButtonActionPerformed(evt);
		}
	});
	
	
	}
	
	/**
	 * Specification for addGame event when listener activated
	 * @param evt
	 */
	private static void saveButtonActionPerformed(java.awt.event.ActionEvent evt, HashMap<Integer, Integer> currentBlocks, JComboBox<Integer> selectBlocks) {
		// clear error message
		error_msg = null; 
		try {
			Integer.parseInt(xentry.getText());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			Integer.parseInt(yentry.getText());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			//close the main frame
			Block223Controller.positionBlock(currentBlocks.get(selectBlocks.getSelectedItem()), Integer.parseInt(xentry.getText()), Integer.parseInt(xentry.getText()), Integer.parseInt(yentry.getText()), Integer.parseInt(pointstextentry.getText()));
			mainWindow.dispose(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
	private static void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// clear error message
		error_msg = null; 
		
		try {
			Block223Controller.deleteBlock(currentBlocks.get(selectBlocks.getSelectedItem()));
			mainWindow.dispose(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
public static void refreshblocks(HashMap<Integer, Integer> currentBlocks, JComboBox<Integer> selectBlocks, int blockid) throws InvalidInputException {
	
		
		currentBlocks = new HashMap<Integer, Integer>();
		selectBlocks.removeAllItems();
		blockid = 0;
		for (TOBlock blocks : Block223Controller.getBlocksOfCurrentDesignableGame()) {
			currentBlocks.put(blockid, blocks.getId());
			selectBlocks.addItem(blocks.getId());
			blockid++;
		};
		selectBlocks.setSelectedIndex(-1);
	}

public static void refreshlevels(HashMap<Integer, Integer> currentlevels, JComboBox<Integer> selectLevel, int levelnumber) throws InvalidInputException {
	
	
	currentBlocks = new HashMap<Integer, Integer>();
	selectBlocks.removeAllItems();
	levelnumber = 0;
	for (TOBlock levels : Block223Controller.getCurrentDesignableGame().get) {
		currentBlocks.put(blockid, blocks.getId());
		selectBlocks.addItem(blocks.getId());
		blockid++;
	};
	selectBlocks.setSelectedIndex(-1);
}
}