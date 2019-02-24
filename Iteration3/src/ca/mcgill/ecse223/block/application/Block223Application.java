package ca.mcgill.ecse223.block.application;
import ca.mcgill.ecse223.block.model.Game;

import ca.mcgill.ecse223.block.model.Admin;
import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.Level;
import ca.mcgill.ecse223.block.model.UserRole;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;

public class Block223Application {
	
	private static Block223 block223; 
	private static Game currentGame;
	private static UserRole currentUserRole; 
	
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
		block223=Block223Persistence.load();
	}



}