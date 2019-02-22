package ca.mcgill.ecse223.block.application;
import ca.mcgill.ecse223.block.model.Game;

import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.Level;

public class Block223Application {
	
	private static Block223 block223; 
	private static Game game;
	
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
//to be implemented
		return null;
	}

	public static void getLevel(Level level) {
		// TODO Auto-generated method stub
	}
}