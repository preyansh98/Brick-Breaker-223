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

public class BlockDesignPage {
	static JFrame mainWindow = new JFrame("Block Settings");
	static String error_msg = null; 
	static HashMap<Integer, Integer> currentBlocks;
	static JComboBox<Integer> selectBlocks;
	public static void main(String[] args) {
	
	//UI Elements
	JTextArea selectBlockText = new JTextArea("Select a block: ");
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
	
	
	selectBlockText.setEditable(false);
	
	selectBlockText.setLocation(30, 55);
	Dimension selectBlockDimension = selectBlockText.getPreferredSize();
	selectBlockText.setSize(selectBlockDimension);
	selectBlockText.setBackground(mainWindow.getBackground()); 
	
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
	selectBlocks.setName("Game");
	selectBlocks.setLocation((int) (selectBlockText.getLocation().x + selectBlockText.getSize().getWidth() + 10)
			, (int) selectBlockText.getLocation().getY());
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
	
	Colour.setLocation(20, 100);
	Dimension BlockSettingsdimension = Colour.getPreferredSize();
	Colour.setSize(BlockSettingsdimension);
	Colour.setBackground(mainWindow.getBackground()); //added this so it doesnt stand out
	
	Dimension redDimension = red.getPreferredSize();
	red.setSize(redDimension);	
	red.setLocation(80, 100);
	red.setBackground(mainWindow.getBackground());
	
	Dimension pointsDimension = points.getPreferredSize();
	points.setSize(pointsDimension);	
	points.setLocation(20, 150);
	points.setBackground(mainWindow.getBackground());
	
	Dimension blueDimension = blue.getPreferredSize();
	blue.setSize(blueDimension);	
	blue.setLocation(280, 100);
	blue.setBackground(mainWindow.getBackground());
	
	Dimension greenDimension = green.getPreferredSize();
	green.setSize(greenDimension);	
	green.setLocation(180, 100);
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
	mainWindow.add(selectBlocks);
	mainWindow.add(selectBlockText);

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
	
	updateButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			updateButtonActionPerformed(evt);
		}
	});
	
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
	private static void updateButtonActionPerformed(java.awt.event.ActionEvent evt, HashMap<Integer, Integer> currentBlocks, JComboBox<Integer> selectBlocks) {
		// clear error message
		error_msg = null; 
		
		try {
			//close the main frame
			Block223Controller.updateBlock(id, red, green, blue, points);currentBlocks.get(selectBlocks.getSelectedItem());
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
}
