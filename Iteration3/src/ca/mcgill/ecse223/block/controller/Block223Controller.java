package ca.mcgill.ecse223.block.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import ca.mcgill.ecse223.block.application.*;
import ca.mcgill.ecse223.block.controller.TOUserMode.Mode;
import ca.mcgill.ecse223.block.model.*;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;

public class Block223Controller {

	// ****************************
	// Modifier methods
	// ****************************
	public static void createGame(String name) throws InvalidInputException {
		Block223 block223 = Block223Application.getBlock223();

		// get Current User role has to be implemented
		Admin admin = (Admin) Block223Application.getCurrentUserRole(); // TODO: Add checks

		Game game = new Game(name, 1, admin, 1, 1, 1, 10, 10, block223);
	}

	public static void setGameDetails(int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
	}

	public static void deleteGame(String name) throws InvalidInputException {
		Game game = Game.getWithName(name);
		if (game != null) {
			game.delete();
		}
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
		Game game = Block223Application.getCurrentGame();
		Block block = game.findBlock(id);

		block.setRed(red);
		block.setGreen(green);
		block.setBlue(blue);
		block.setPoints(points);

	}

	// Modifier method to position block
	public static void positionBlock(int Id, int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {

		Game game = Block223Application.getCurrentGame();

		Level currentlevel = game.getLevel(level);

		// findBlock has to be implemented
		Block block = game.findBlock(Id);

		BlockAssignment blockassignment = new BlockAssignment(gridHorizontalPosition, gridVerticalPosition,
				currentlevel, block, game);

	}

	public static void moveBlock(int level, int oldGridHorizontalPosition, int oldGridVerticalPosition,
			int newGridHorizontalPosition, int newGridVerticalPosition) throws InvalidInputException {
	}

	public static void removeBlock(int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {
	}

	public static void saveGame() throws InvalidInputException {
		UserRole role = Block223Application.getCurrentUserRole();
		if (role instanceof Admin) {
			Game currentGame = Block223Application.getCurrentGame();
			if (currentGame != null) {
				if (currentGame.getAdmin() == (Admin) role) {
					Block223 block223 = Block223Application.getBlock223();
					Block223Persistence.save(block223);
				} else {
					throw new InvalidInputException("Only the admin who created the game can save it.");
				}
			} else {
				throw new InvalidInputException("A game must be selected to save it.");
			}
		} else {
			throw new InvalidInputException("Admin privileges are required to save a game.");
		}

	}

	public static void register(String username, String playerPassword, String adminPassword)
			throws InvalidInputException {
		
	}

	public static void login(String username, String password) throws InvalidInputException {
	}

	public static void logout() {
		Block223Application.setCurrentUserRole(null);
	}

	// ****************************
	// Query methods
	// ****************************
	public static List<TOGame> getDesignableGames() {
		Block223 block223 = Block223Application.getBlock223();
		Admin admin = (Admin) Block223Application.getCurrentUserRole();

		List<TOGame> result = new ArrayList<TOGame>();

		List<Game> games = block223.getGames();

		for (Game game : games) {
			Admin gameAdmin = game.getAdmin();

			if (gameAdmin.equals(admin)) {
				TOGame to = new TOGame(game.getName(), game.getLevels().size(), game.getNrBlocksPerLevel(),
						game.getBall().getMinBallSpeedX(), game.getBall().getMinBallSpeedY(),
						game.getBall().getBallSpeedIncreaseFactor(), game.getPaddle().getMaxPaddleLength(),
						game.getPaddle().getMinPaddleLength());

				result.add(to);
			}
		}
		return result;
	}

	public static TOGame getCurrentDesignableGame() {
		Game thisgame = Block223Application.getCurrentGame();
		TOGame to = new TOGame(thisgame.getName(), thisgame.getLevels().size(), thisgame.getNrBlocksPerLevel(),
				thisgame.getBall().getMinBallSpeedX(), thisgame.getBall().getMinBallSpeedY(),
				thisgame.getBall().getBallSpeedIncreaseFactor(), thisgame.getPaddle().getMaxPaddleLength(),
				thisgame.getPaddle().getMinPaddleLength());
		return to;

	}

	public static List<TOBlock> getBlocksOfCurrentDesignableGame() {
		Game thisgame = Block223Application.getCurrentGame();
		List<TOBlock> result = new ArrayList<TOBlock>();
		List<Block> blocks = thisgame.getBlocks();
		for (int i = 0; i < blocks.size(); i++) {
			TOBlock to = new TOBlock(blocks.get(i).getId(), blocks.get(i).getRed(), blocks.get(i).getGreen(),
					blocks.get(i).getBlue(), blocks.get(i).getPoints());
			result.add(to);
		}
		return result;
	}

	public static TOBlock getBlockOfCurrentDesignableGame(int id) throws InvalidInputException {
		Game thisgame = Block223Application.getCurrentGame();
		Block thisblock = thisgame.findBlock(id);

		TOBlock to = new TOBlock(thisblock.getId(), thisblock.getRed(), thisblock.getGreen(), thisblock.getBlue(),
				thisblock.getPoints());

		return to;
	}

	public List<TOGridCell> getBlocksAtLevelOfCurrentDesignableGame(int level) throws InvalidInputException {
		Game thisgame = Block223Application.getCurrentGame();
		List<TOGridCell> result = new ArrayList<TOGridCell>();
		Level thislevel = thisgame.getLevel(level);
		List<BlockAssignment> assignments = thislevel.getBlockAssignments();
		for (int i = 0; i < assignments.size(); i++) {
			TOGridCell to = new TOGridCell(assignments.get(i).getGridHorizontalPosition(),
					assignments.get(i).getGridVerticalPosition(), assignments.get(i).getBlock().getId(),
					assignments.get(i).getBlock().getRed(), assignments.get(i).getBlock().getGreen(),
					assignments.get(i).getBlock().getBlue(), assignments.get(i).getBlock().getPoints());
			result.add(to);
		}
		return result;

	}

	public static TOUserMode getUserMode() {
		UserRole thisrole = Block223Application.getCurrentUserRole();
		TOUserMode to = new TOUserMode(Mode.None);
		if (thisrole == null) {
			to = new TOUserMode(Mode.None);
		}
		if (thisrole instanceof Player) {
			to = new TOUserMode(Mode.Play);

		}
		if (thisrole instanceof Admin) {
			to = new TOUserMode(Mode.Design);
		}
		return to;
	}

}