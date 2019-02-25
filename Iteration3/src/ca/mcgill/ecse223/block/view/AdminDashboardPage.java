package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.*;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOGame;
import ca.mcgill.ecse223.block.model.Game;

/**
 * AdminDashboardPage UI screen
 * @author Preyansh
 *
 */
public class AdminDashboardPage {
	static String error_msg = null; 
	static JFrame mainFrame = new JFrame("Admin DashBoard"); 

	//for updating the game

	public static void main(String[] args) throws InvalidInputException {
		
	//UI Elements
	JTextArea selectGameText = new JTextArea("Select a game: "); 
	JTextArea orText = new JTextArea("OR: "); 
	JButton deleteGameButton = new JButton("Delete Game"); 
	JButton addGameButton = new JButton("Add Game"); 
	JButton updateGameButton = new JButton("Update Game");;
	JTextArea errorMsg = new JTextArea(error_msg); 
	
	//frame related
	mainFrame.setVisible(true); 
	mainFrame.setLayout(null);
	
	//Setting attributes of components
	mainFrame.setSize(400, 300); //this should be consistent across all features

	addGameButton.setSize(95, 26);
	addGameButton.setLocation(140, 40);
	
	
	selectGameText.setEditable(false);
	orText.setEditable(false);
	
	selectGameText.setLocation(30, 150);
	Dimension selectGameDimension = selectGameText.getPreferredSize();
	selectGameText.setSize(selectGameDimension);
	selectGameText.setBackground(mainFrame.getBackground()); //added this so it doesnt stand out
	
	Dimension orDimension = orText.getPreferredSize();
	orText.setSize(orDimension);	
	orText.setLocation(170, 110);
	orText.setBackground(mainFrame.getBackground());
	
	HashMap<Integer, String> currentGames = null; 
	JComboBox selectGames = new JComboBox<String>(new String[0]); //hash map of games?
	int gameIndex = 0;
	refreshGames(currentGames, selectGames, gameIndex);
	
	
	selectGames.setEditable(false);
	selectGames.setSize(110, 26);
	selectGames.setVisible(true);
	selectGames.setName("Game");
	selectGames.setLocation((int) (selectGameText.getLocation().x + selectGameText.getSize().getWidth() + 10)
			, (int) selectGameText.getLocation().getY());

	
	deleteGameButton.setSize(115,26);
	deleteGameButton.setLocation((int) (selectGames.getLocation().x + selectGames.getSize().getWidth() + 10)
			, (int) (selectGames.getLocation().getY()));
	
	updateGameButton.setSize(115,26);
	updateGameButton.setLocation((int) (deleteGameButton.getLocation().getX()),
	(int) (deleteGameButton.getLocation().getY() + deleteGameButton.getSize().getHeight() + 10));
	updateGameButton.setVisible(true);

	
	errorMsg.setEditable(false);
	errorMsg.setSize(300,20);
	errorMsg.setLocation(30, 20);
	errorMsg.setBackground(mainFrame.getBackground());
	
	//Adding all components to frame
	mainFrame.add(selectGameText);
	mainFrame.add(orText);
	mainFrame.add(selectGames);
	mainFrame.add(deleteGameButton);
	mainFrame.add(addGameButton);
	mainFrame.add(updateGameButton);
	mainFrame.add(errorMsg); 

	//Design here:
	mainFrame.setBackground(Color.gray); //could probably do some rgb
	
	
	//Listener for buttons
	addGameButton.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			addGameButtonActionPerformed(evt);
		}
	});

	
	//testing
	System.out.println(selectGameText.getLocation().toString());
	System.out.println(orText.getLocation().toString());
	System.out.println(deleteGameButton.getPreferredSize().toString());
	System.out.println(addGameButton.getPreferredSize().toString());
	}
	
	/**
	 * Specification for addGame event when listener activated
	 * @param evt
	 */
	private static void addGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// clear error message
		error_msg = null;
		
		// call the controller
		try {
			 mainFrame.dispose();
			new AddGamePage().initializeThis(); 
		} catch (Exception e) {
			error_msg = e.getMessage();
		}
		
		// add method here to move on to next screen
	}
	
	public static void refreshGames(HashMap<Integer, String> currentGames, JComboBox<String> selectGames, int gameIndex) throws InvalidInputException {
		
		
		currentGames = new HashMap<Integer, String>();
		selectGames.removeAllItems();
		gameIndex = 0;
		for (TOGame game : Block223Controller.getDesignableGames()) {
			currentGames.put(gameIndex, game.getName());
			selectGames.addItem(game.getName());
			gameIndex++;
		};
		selectGames.setSelectedIndex(-1);
	}
}
