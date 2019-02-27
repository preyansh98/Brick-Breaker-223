package ca.mcgill.ecse223.block.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOBlock;
import ca.mcgill.ecse223.block.controller.TOGame;
import ca.mcgill.ecse223.block.model.BlockAssignment;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.Level;

/**
 * AddGame UI screen
 * @author Elie Elia
 *
 */

public class LevelDesignPage {
	static HashMap<Integer, Integer> currentlevels;
	static JComboBox<String> selectLevel;
	static JFrame mainWindow = new JFrame("Level Settings");
	static String error_msg = null; 
	static JComboBox<String> selectBlocks;
	static HashMap<Integer, Integer> currentBlocks;
	static HashMap<Integer, Integer> currentLevels;
	static JTextField xentry = new JTextField();
	static JTextField yentry = new JTextField();
	static int blockid=0;
	static int levelindex=0;
	
	
	
	public static void main(String[] args) throws InvalidInputException {
		
		mainWindow.setVisible(true);
		mainWindow.setLayout(null);
		mainWindow.setSize(400, 300);
		
	
	//UI Elements
	
	
	JTextArea inputx = new JTextArea("Input X:");
	JTextArea inputy = new JTextArea("Input Y:"); 
	JTextArea selectblock = new JTextArea("Select Block:"); 
	JTextArea selectlevel = new JTextArea("Select Level:"); 
	JButton cancelButton = new JButton("Cancel"); 
	JButton saveButton = new JButton("Save"); 
	JButton removeButton = new JButton("Remove");
	JButton confirmButton = new JButton("Confirm");
	
	
	
	JTextArea errorMsg = new JTextArea(error_msg); 
	inputx.setEditable(false);
	inputy.setEditable(false);
	selectblock.setEditable(false);
	selectlevel.setEditable(false);
	
	
	
	
	Dimension selectBlockDimension = selectblock.getPreferredSize();
	selectblock.setSize(selectBlockDimension);
	selectblock.setBackground(mainWindow.getBackground()); 
	
	

	HashMap<Integer, Integer> currentLevels = null; 
	JComboBox<String> selectLevels = new JComboBox<String>(new String[0]); 
	int levelnumber = 0;
	try {
		refreshlevels(currentlevels, selectLevels, levelnumber);
	} catch (InvalidInputException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	selectLevels.setEditable(false);
	selectLevels.setSize(110,26);
	selectLevels.setVisible(true);
	selectLevels.setName("Level");
	selectLevels.setLocation((int) (selectlevel.getLocation().x + selectlevel.getSize().getWidth() + 100)
			, (int) selectlevel.getLocation().getY()+25);
	
	refreshlevels(currentlevels, selectLevel,levelindex);
	selectBlocks.setEditable(false);
	selectBlocks.setSize(110, 26);
	selectBlocks.setVisible(true);
	selectBlocks.setName("Block");
	selectBlocks.setLocation((int) (selectblock.getLocation().x+20)
			, (int) selectblock.getLocation().getY()+170);
	
	JTextArea listofblockassignments = new JTextArea("List of current Block Assignments: " + "\n" + refreshspecificlevel());
listofblockassignments.setEditable(false);
listofblockassignments.setLocation(200,50);
	Dimension listassignmentsize = listofblockassignments.getPreferredSize();
	listofblockassignments.setSize(listassignmentsize);
	listofblockassignments.setBackground(mainWindow.getBackground());
	
	
	//frame related
	mainWindow.setVisible(true); 
	mainWindow.setLayout(null);
	
	//Setting attributes of components
	mainWindow.setSize(500, 400); //this should be consistent across all features
	
	selectlevel.setLocation(20, 30);
	Dimension selectleveldimension = selectlevel.getPreferredSize();
	selectlevel.setSize(selectleveldimension);
	selectlevel.setBackground(mainWindow.getBackground());
	
	inputx.setLocation(20, 70);
	Dimension inputxdimension = inputx.getPreferredSize();
	inputx.setSize(inputxdimension);
	inputx.setBackground(mainWindow.getBackground()); //added this so it doesnt stand out
	
	Dimension inputyDimension = inputy.getPreferredSize();
	inputy.setSize(inputyDimension);	
	inputy.setLocation(20, 100);
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
	cancelButton.setLocation(20, 250);
	
	saveButton.setSize(95, 26);
	saveButton.setLocation(300, 250);
	
	confirmButton.setSize(80, 20);
	confirmButton.setLocation(220, 190);
	
	removeButton.setSize(80, 20);
	removeButton.setLocation(300, 190);
	
	
	
	errorMsg.setEditable(false);
	errorMsg.setSize(300,20);
	errorMsg.setLocation(30, 20);
	errorMsg.setBackground(mainWindow.getBackground());
	
	//Adding all components to frame
	mainWindow.add(xentry);
	mainWindow.add(yentry);
	mainWindow.add(inputx);
	mainWindow.add(inputy);
	mainWindow.add(selectlevel);
	mainWindow.add(selectLevels);
	mainWindow.add(selectBlocks);
	mainWindow.add(selectblock);
	mainWindow.add(cancelButton);
	mainWindow.add(saveButton);
	mainWindow.add(removeButton);
	mainWindow.add(confirmButton);
	mainWindow.add(listofblockassignments);
	mainWindow.setBackground(Color.gray); //could probably do some rgb
	
	
//	//Listener for buttons
//	updateButton.addActionListener(new java.awt.event.ActionListener() {
//		public void actionPerformed(java.awt.event.ActionEvent evt) {
//			updateButtonActionPerformed(evt, updatetextentry);
//		}
//	});

	selectBlocks.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			try {
				selectBlocksActionPerformed(evt);
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
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
	private static void saveButtonActionPerformed(java.awt.event.ActionEvent evt, HashMap<Integer, Integer> currentBlocks, JComboBox<String> selectBlocks) {
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
			Block223Controller.positionBlock(currentBlocks.get(selectBlocks.getSelectedItem()), Integer.parseInt(xentry.getText()), Integer.parseInt(xentry.getText()), Integer.parseInt(yentry.getText()));
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
public static void refreshblocks(HashMap<Integer, Integer> currentBlocks, JComboBox<String> selectBlocks, int blockid) throws InvalidInputException {
	
		
		currentBlocks = new HashMap<Integer, Integer>();
		selectBlocks.removeAllItems();
		blockid = 0;
		for (TOBlock block : Block223Controller.getBlocksOfCurrentDesignableGame()) {
			currentBlocks.put(blockid, block.getId());
			String RGBPoints = "R:"+block.getRed()+ "G:" + block.getGreen() + "B:"+ block.getBlue() + "P:" +block.getPoints();
			selectBlocks.addItem(RGBPoints);
			blockid++;
		};
		selectBlocks.setSelectedIndex(-1);
	}

public static void refreshlevels(HashMap<Integer, Integer> currentlevels, JComboBox<String> selectLevel, int levelindex) throws InvalidInputException {
	
	
	currentLevels = new HashMap<Integer, Integer>();
	selectLevel.removeAllItems();
	levelindex = 0;
	for (Level level : Game.getWithName(Block223Controller.getCurrentDesignableGame().getName()).getLevels()) {
		currentLevels.put(levelindex,levelindex+1);
		selectLevel.addItem("Level:" + (levelindex+1));
		levelindex++;
	};
	selectBlocks.setSelectedIndex(-1);
	refreshblocks(currentBlocks,selectBlocks,blockid);
}
public static String refreshspecificlevel () throws InvalidInputException {
	Level currentlevel = (Level) selectLevel.getSelectedItem();
	
	int y=0;
	int x =0;
	int blockid=0;
	List<BlockAssignment> listof = null; 
	listof = currentlevel.getBlockAssignments();
	String assignmentrepresentation = "";
	for (BlockAssignment thisassignment : listof) {
		y=thisassignment.getGridVerticalPosition();
		x = thisassignment.getGridHorizontalPosition();
		blockid = thisassignment.getBlock().getId();
		assignmentrepresentation+= +blockid+ " " + "X:"+x+"Y:"+y+ "\n"; 
	}
	return assignmentrepresentation;
}

public static void refreshspecificblock () throws InvalidInputException {
	TOBlock currentblock = Block223Controller.getBlockOfCurrentDesignableGame(selectBlocks.getSelectedIndex());
	
	
	}

private static void selectBlocksActionPerformed(java.awt.event.ActionEvent evt) throws InvalidInputException {
	try {
	refreshspecificblock();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
