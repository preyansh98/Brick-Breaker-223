package ca.mcgill.ecse223.block.controller;

import java.util.List;

import ca.mcgill.ecse223.block.application.*;
import ca.mcgill.ecse223.block.model.*; 

public class Block223Controller {

	
	
	
	//Modifier method to position block
	public static void positionBlock(int Id, int level, int gridHorizontalPosition, int gridVerticalPosition) 
			throws InvalidInputException{
				
		Game game = Block223Application.getCurrentGame(); 
		
		Level currentlevel = game.getLevel(level); 
	
		//findBlock has to be implemented
		Block block = game.findBlock(Id); 
		
		BlockAssignment blockassignment = new BlockAssignment(gridHorizontalPosition, gridVerticalPosition, currentlevel, 
				block, game); 
		
	}
}
