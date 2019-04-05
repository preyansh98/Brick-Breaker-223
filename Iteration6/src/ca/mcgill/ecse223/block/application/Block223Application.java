package ca.mcgill.ecse223.block.application;
import ca.mcgill.ecse223.block.model.Game;

import javax.swing.UIManager;

import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.PlayedGame;
import ca.mcgill.ecse223.block.model.Player;
import ca.mcgill.ecse223.block.model.UserRole;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;
import ca.mcgill.ecse223.block.view.SignInUI;

public class Block223Application {
	
	private static Block223 block223; 
	private static Game currentGame;
	private static UserRole currentUserRole; 
	private static PlayedGame currentPlayableGame;
	private static Player secondPlayer; 
	private static PlayedGame secondPlayableGame;
	
	public static PlayedGame getSecondPlayableGame() {
		return secondPlayableGame;
	}
	public static void setSecondPlayableGame(PlayedGame secondPlayableGame) {
		Block223Application.secondPlayableGame = secondPlayableGame;
	}
	public static Player getSecondPlayer() {
		return secondPlayer;
	}
	public static void setSecondPlayer(Player secondPlayer) {
		Block223Application.secondPlayer = secondPlayer;
	}
	public static PlayedGame getCurrentPlayableGame() {
		return currentPlayableGame;
	}
	public static void setCurrentPlayableGame(PlayedGame currentPlayableGame) {
		Block223Application.currentPlayableGame = currentPlayableGame;
	}
	public static void main(String [] args) {
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		SignInUI.init();
	}
	public static Game getCurrentGame() {
		return currentGame;
	}

	public static void setCurrentGame(Game currentGame) {
		Block223Application.currentGame = currentGame;
	}

	public static UserRole getCurrentUserRole() {
		return currentUserRole;
	}

	public static void setCurrentUserRole(UserRole currentUserRole) {
		Block223Application.currentUserRole = currentUserRole;
	}

	public static Block223 getBlock223() {
		//temporary implementation
		if(block223 == null) {
			block223=Block223Persistence.load();
		}
		return block223; 
	}
	
	
	public static void resetBlock223() {
		if(block223!=null) {
			block223.delete();
		}
		setCurrentGame(null);
		setCurrentPlayableGame(null);
		block223=Block223Persistence.load();
	}
}