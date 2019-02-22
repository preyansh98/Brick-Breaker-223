package ca.mcgill.ecse223.block.application;

import ca.mcgill.ecse223.block.model.Admin;
import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.Level;

public class Block223Application {
	
	private static Block223 block223; 
	
	public static Block223 getBlock223() {
		//temporary implementation
		if(block223 == null) {
			return (new Block223()); 
		}
		else {
		return block223; 
		}
	}

	public static Game getCurrentGame() {
		// temporary
		return null; 
	}

	public static void getLevel(Level level) {
		// TODO Auto-generated method stub
	}

	public static Admin getCurrentUserRole() {
		// TODO Auto-generated method stub
		return null;
	}
}