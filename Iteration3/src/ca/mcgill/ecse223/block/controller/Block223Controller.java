package ca.mcgill.ecse223.block.controller;

import java.util.List;

import ca.mcgill.ecse223.block.application.*;
import ca.mcgill.ecse223.block.model.*; 

public class Block223Controller {

	
	// ****************************
		// Modifier methods
		// ****************************
		public static void createGame(String name) throws InvalidInputException {
		}

		public static void setGameDetails(int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
				Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
		}

		public static void deleteGame(String name) throws InvalidInputException {
		}

		public static void selectGame(String name) throws InvalidInputException {
		}

		public static void updateGame(String name, int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
				Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
		}

		public static void addBlock(int red, int green, int blue, int points) throws InvalidInputException {
		}

		public static void deleteBlock(int id) throws InvalidInputException {
		}

		public static void updateBlock(int id, int red, int green, int blue, int points) throws InvalidInputException {
		}

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

		public static void moveBlock(int level, int oldGridHorizontalPosition, int oldGridVerticalPosition,
				int newGridHorizontalPosition, int newGridVerticalPosition) throws InvalidInputException {
		}

		public static void removeBlock(int level, int gridHorizontalPosition, int gridVerticalPosition)
				throws InvalidInputException {
		}

		public static void saveGame() throws InvalidInputException {
		}

		public static void register(String username, String playerPassword, String adminPassword)
				throws InvalidInputException {
		}

		public static void login(String username, String password) throws InvalidInputException {
		}

		public static void logout() {
		}

		// ****************************
		// Query methods
		// ****************************
		public static List<TOGame> getDesignableGames() {
		}

		public static TOGame getCurrentDesignableGame() {
		}

		public static List<TOBlock> getBlocksOfCurrentDesignableGame() {
		}

		public static TOBlock getBlockOfCurrentDesignableGame(int id) throws InvalidInputException {
		}

		public List<TOGridCell> getBlocksAtLevelOfCurrentDesignableGame(int level) throws InvalidInputException {
		}

		public static TOUserMode getUserMode() {
		}

}