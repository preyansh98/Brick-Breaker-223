package ca.mcgill.ecse223.block.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ca.mcgill.ecse223.block.application.Block223Application;
import ca.mcgill.ecse223.block.controller.TOUserMode.Mode;
import ca.mcgill.ecse223.block.model.Admin;
import ca.mcgill.ecse223.block.model.Ball;
import ca.mcgill.ecse223.block.model.Block;
import ca.mcgill.ecse223.block.model.Block223;
import ca.mcgill.ecse223.block.model.BlockAssignment;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.HallOfFameEntry;
import ca.mcgill.ecse223.block.model.Level;
import ca.mcgill.ecse223.block.model.Paddle;
import ca.mcgill.ecse223.block.model.PlayedBlockAssignment;
import ca.mcgill.ecse223.block.model.PlayedGame;
import ca.mcgill.ecse223.block.model.Player;
import ca.mcgill.ecse223.block.model.User;
import ca.mcgill.ecse223.block.model.UserRole;
import ca.mcgill.ecse223.block.model.PlayedGame.PlayStatus;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;
import ca.mcgill.ecse223.block.view.Block223PlayModeInterface;
import ca.mcgill.ecse223.block.view.PlayedModeClass;


public class Block223Controller {

	// ****************************
	// Modifier methods
	// ****************************
	public static void createGame(String name) throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to create a game.");
		}

		Block223 block223 = Block223Application.getBlock223();

		Admin admin = (Admin) Block223Application.getCurrentUserRole();
		Game game = null;

		if (Block223Application.getBlock223().findGame(name) != null) {
			// a duplicate game exists
			throw new InvalidInputException("The name of a game must be unique.");
		}

		try {
			game = new Game(name, 1, admin, 1, 1, 1, 10, 10, block223);
		} catch (RuntimeException e) {
			throw new InvalidInputException("The name of a game must be specified.");
		}

	}

	public static void setGameDetails(int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {
		// Osman Warsi
		// Variables
		String error = "";

		Game game = Block223Application.getCurrentGame();

		// CHECKS
		if (game == null) {
			throw new InvalidInputException("A game must be selected to define game settings.");
		}

		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to define game settings.");
		}
		Admin admin = (Admin) Block223Application.getCurrentUserRole();
		if (game.getAdmin() != admin) {
			throw new InvalidInputException("Only the admin who created the game can define its game settings.");
		}

		if (nrLevels < 1 || nrLevels > 99) {
			throw new InvalidInputException("The number of levels must be between 1 and 99.");
		}

		if (nrBlocksPerLevel <= 0) {
			throw new InvalidInputException("The number of blocks per level must be greater than zero.");
		}
		for(Level level:game.getLevels()) {
			if(level.getBlockAssignments().size()>nrBlocksPerLevel) {
				throw new InvalidInputException("The maximum number of blocks per level cannot be less than the number of existing blocks in a level.");
			}
			


		}
	

		// Ball Settings
		Ball ball = game.getBall();
		if (minBallSpeedX == 0 && minBallSpeedY==0) {
			throw new InvalidInputException("The minimum speed of the ball must be greater than zero.");
		}
		if (minBallSpeedX < 0) {
			throw new InvalidInputException("The minimum speed of the ball must be greater than zero.");
		}
		

		if (minBallSpeedY < 0) {
			throw new InvalidInputException("The minimum speed of the ball must be greater than zero.");
		}
		

		if (ballSpeedIncreaseFactor <= 0) {
			throw new InvalidInputException("The speed increase factor of the ball must be greater than zero.");
		}
		if (maxPaddleLength <= 0 || maxPaddleLength > 390) {
			throw new InvalidInputException(
					"The maximum length of the paddle must be greater than zero and less than or equal to 390.");
		}
		

		if (minPaddleLength <= 0) {
			throw new InvalidInputException("The minimum length of the paddle must be greater than zero.");
		}
		game.setNrBlocksPerLevel(nrBlocksPerLevel);
		
		ball.setBallSpeedIncreaseFactor(ballSpeedIncreaseFactor);
		
		ball.setMinBallSpeedX(minBallSpeedX);
		ball.setMinBallSpeedY(minBallSpeedY);
		
		// Paddle Settings
		Paddle paddle = game.getPaddle();

		paddle.setMaxPaddleLength(maxPaddleLength);
		paddle.setMinPaddleLength(minPaddleLength);

		// Level Settings
		List<Level> levels = game.getLevels();

		// level.size();
		// game.numberOfLevels();
		while (nrLevels > levels.size()) {
			game.addLevel();
		}

		while (nrLevels < levels.size()) {
			Level level = levels.get(levels.size() - 1);
			level.delete();

		}
	}

	public static void deleteGame(String name) throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to delete a game.");
		}
		if (Block223Application.getBlock223().findGame(name) == null) {
			return;
		}
		if (!Block223Application.getCurrentUserRole()
				.equals(Block223Application.getBlock223().findGame(name).getAdmin())) {
			throw new InvalidInputException("Only the admin who created the game can delete the game.");
		}
		if (Block223Application.getBlock223().findGame(name).getPublished() == true) {
			throw new InvalidInputException("A published game cannot be deleted.");
		}

		Game game = Block223Application.getBlock223().findGame(name);

		if (game != null) {
			game.delete();
			Block223Persistence.save(Block223Application.getBlock223());
		}
	}

	public static void selectGame(String name) throws InvalidInputException {
		Game game = Block223Application.getBlock223().findGame(name);

		if (game == null) {
			throw new InvalidInputException("A game with name " + name + " does not exist.");
		}

		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to select a game.");
		}
		if (Block223Application.getCurrentUserRole().equals(game.getAdmin()) == false) {
			throw new InvalidInputException("Only the admin who created the game can select the game.");
		}
		if (Block223Application.getBlock223().findGame(name).getPublished() == true) {
			throw new InvalidInputException("A published game cannot be changed.");
		}
		Block223Application.setCurrentGame(game);

	}

	public static void updateGame(String name, int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException {

		// CHECKS
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to define game settings.");
		}
		if (!(Block223Application.getCurrentUserRole() instanceof Admin)) {
			throw new InvalidInputException("Admin privileges are required to define game settings.");
		}
		Game game = Block223Application.getCurrentGame();
		String currentName = game.getName();
		Admin admin = (Admin) Block223Application.getCurrentUserRole();

		if (!(admin.equals(game.getAdmin()))) {
			throw new InvalidInputException("Only the admin who created the game can define its game settings.");
		}

		// Admin check

		// Name Check
		if (name == null || name.length() == 0) {
			throw new InvalidInputException("The name of a game must be specified.");
		}
		if (!currentName.equals(name)) {
			Boolean result = Block223Application.getBlock223().findGame(name) != null;
			if (result) {
				throw new InvalidInputException("The name of a game must be unique.");
			} else {
				game.setName(name);
			}
		}

		setGameDetails(nrLevels, nrBlocksPerLevel, minBallSpeedX, minBallSpeedY, ballSpeedIncreaseFactor,
				maxPaddleLength, minPaddleLength);
		// END
	}

	public static void deleteBlock(int id) throws InvalidInputException {
		if ((Block223Application.getCurrentUserRole()) instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to delete a block.");
		}
		Game game = Block223Application.getCurrentGame();

		if (game == null) {
			throw new InvalidInputException("A game must be selected to delete a block.");
		}

		if ((game.getAdmin().equals(Block223Application.getCurrentUserRole()) == false)) {
			throw new InvalidInputException("Only the admin who created the game can delete a block.");
		}
		Block foundBlock = game.findBlock(id);
		if (foundBlock != null) {
			foundBlock.delete();

		}
	}

	public static void addBlock(int red, int green, int blue, int points) throws InvalidInputException {
		// first check
		if ((Block223Application.getCurrentUserRole()) instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to add a block.");
		}

		Game game = Block223Application.getCurrentGame();
		// second check
		if (game == null) {
			throw new InvalidInputException("A game must be selected to add a block.");
		}
		// third check
		if ((game.getAdmin() != Block223Application.getCurrentUserRole())) {
			throw new InvalidInputException("Only the admin who created the game can add a block.");
		}
		// fourth check
		for (Block block : game.getBlocks()) {
			if (red == block.getRed() && green == block.getGreen() && blue == block.getBlue()) {
				throw new InvalidInputException("A block with the same color already exists for the game.");
			}
		}
		try {
			Block block = new Block(red, green, blue, points, game);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	public static void updateBlock(int id, int red, int green, int blue, int points) throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to update a block.");
		}

		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to update a block.");
		}

		if (Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
			throw new InvalidInputException("Only the admin who created the game can update a block.");
		}

		Game game = Block223Application.getCurrentGame();
		Block block = game.findBlock(id);

		if (block == null) {
			throw new InvalidInputException("The block does not exist.");
		}

		if (red < 0 || red > 255) {
			throw new InvalidInputException("Red must be between 0 and 255.");
		}
		if (green < 0 || green > 255) {
			throw new InvalidInputException("Green must be between 0 and 255.");
		}
		if (blue < 0 || blue > 255) {
			throw new InvalidInputException("Blue must be between 0 and 255.");
		}
		if (points < 1 || points > 1000) {
			throw new InvalidInputException("Points must be between 1 and 1000.");
		}
		List<Block> listofblocks = game.getBlocks();
		for (Block thisblock : listofblocks) {
			if (thisblock.getRed() == red && thisblock.getBlue() == blue && thisblock.getGreen() == green) {
				throw new InvalidInputException("A block with the same color already exists for the game.");
			}
		}
		try {
			block.setRed(red);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		try {
			block.setGreen(green);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		try {
			block.setBlue(blue);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		try {
			block.setPoints(points);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

	public static void positionBlock(int id, int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {
		Game game = Block223Application.getCurrentGame();

		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to position a block.");
		}

		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to position a block.");
		}

		if (Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
			throw new InvalidInputException("Only the admin who created the game can position a block.");
		}

		if (level < 1 || level > game.getLevels().size()) {
			throw new InvalidInputException("Level " + level + " does not exist for the game.");
		}
		try {
			Level currentlevel = game.getLevel(level - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException(e.getMessage());
		}

		Level currentlevel = game.getLevel(level - 1);
		int nrBlocksPerLevel = game.getNrBlocksPerLevel();
		if (currentlevel.getBlockAssignments().size() >= nrBlocksPerLevel) {
			throw new InvalidInputException("The number of blocks has reached the maximum number (" + nrBlocksPerLevel
					+ ") allowed for this game.");

		}
		List<BlockAssignment> assignments = currentlevel.getBlockAssignments();
		for (BlockAssignment thisassignment : assignments) {
			if (thisassignment.getGridHorizontalPosition() == gridHorizontalPosition
					&& thisassignment.getGridVerticalPosition() == gridVerticalPosition) {
				throw new InvalidInputException("A block already exists at location " + gridHorizontalPosition + "/"
						+ gridVerticalPosition + ".");
			}
		}
		Block block = game.findBlock(id);
		if (block == null) {
			throw new InvalidInputException("The block does not exist.");
		}
		int maxNumberOfHorizontalBlocks = 15;
		int maxNumberOfVerticalBlocks = 15;

		if (gridHorizontalPosition > 0 && gridVerticalPosition > 0
				&& gridHorizontalPosition <= maxNumberOfHorizontalBlocks
				&& gridVerticalPosition <= maxNumberOfVerticalBlocks) {
			try {
				BlockAssignment blockassignment = new BlockAssignment(gridHorizontalPosition, gridVerticalPosition,
						currentlevel, block, game);
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
		}
	}

	public static void moveBlock(int level, int oldGridHorizontalPosition, int oldGridVerticalPosition,
			int newGridHorizontalPosition, int newGridVerticalPosition) throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to move a block.");
		}

		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to move a block.");
		}

		if (Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
			throw new InvalidInputException("Only the admin who created the game can move a block.");
		}

		Game game = Block223Application.getCurrentGame();
		Level currentlevel;
		BlockAssignment assignment;

		if (level < 1 || level > game.getLevels().size()) {
			throw new InvalidInputException("Level " + level + " does not exist for the game.");
		}
		try {
			currentlevel = game.getLevel(level - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException(e.getMessage());
		}

		if (newGridHorizontalPosition <= 0 || newGridHorizontalPosition > 15) {
			try {
				assignment = currentlevel.findBlockAssignment(newGridHorizontalPosition, newGridVerticalPosition);
			} catch (RuntimeException e) {
				throw new InvalidInputException("The horizontal position must be between 1 and " + 15 + ".");
			}
		}

		if (newGridVerticalPosition <= 0 || newGridVerticalPosition > 15) {
			try {
				assignment = currentlevel.findBlockAssignment(newGridHorizontalPosition, newGridVerticalPosition);
			} catch (RuntimeException e) {
				throw new InvalidInputException("The vertical position must be between 1 and " + 15 + ".");
			}
		}

		if (currentlevel.findBlockAssignment(oldGridHorizontalPosition, oldGridVerticalPosition) == null) {
			throw new InvalidInputException("A block does not exist at location " + oldGridHorizontalPosition + "/"
					+ oldGridVerticalPosition + ".");
		} else {
			assignment = currentlevel.findBlockAssignment(oldGridHorizontalPosition, oldGridVerticalPosition);
			if (currentlevel.findBlockAssignment(newGridHorizontalPosition, newGridVerticalPosition) != null) {
				throw new InvalidInputException("A block already exists at location " + newGridHorizontalPosition + "/"
						+ newGridVerticalPosition + ".");
			}
			try {
				assignment.setGridHorizontalPosition(newGridHorizontalPosition);
				assignment.setGridVerticalPosition(newGridVerticalPosition);
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
		}

	}

	public static void removeBlock(int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to remove a block.");
		}

		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to remove a block.");
		}

		if (Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
			throw new InvalidInputException("Only the admin who created the game can remove a block.");
		}

		Game game = Block223Application.getCurrentGame();
		Level currentlevel = game.getLevel(level - 1);
		BlockAssignment assignment;

		assignment = currentlevel.findBlockAssignment(gridHorizontalPosition, gridVerticalPosition);

		if (assignment != null) {
			assignment.delete();
		}

	}

	public static void saveGame() throws InvalidInputException {
		UserRole role = Block223Application.getCurrentUserRole();
		Game currentGame = Block223Application.getCurrentGame();
		String error = "";
		if (!(role instanceof Admin)) {
			error = "Admin privileges are required to save a game.";
		} else if (currentGame == null) {
			error = "A game must be selected to save it.";
		} else if (!(currentGame.getAdmin() == role)) {
			error = "Only the admin who created the game can save it.";
		}
		if (error.equals("")) {
			try {
				Block223 block223 = Block223Application.getBlock223();
				Block223Persistence.save(block223);
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
		} else {
			throw new InvalidInputException(error);
		}
	}

	public static void register(String username, String playerPassword, String adminPassword)
			throws InvalidInputException {
		UserRole role = Block223Application.getCurrentUserRole();
		String error = "";
		if (role != null) {
			error = "Cannot register a new user while a user is logged in.";
		} else if (playerPassword == null || playerPassword.length() == 0) {
			error = "The player password needs to be specified.";
		} else if (playerPassword.equals(adminPassword)) {
			error = "The passwords have to be different.";
		}
		if (error.equals("")) {
			Player player = null;
			Admin admin = null;
			try {
				Block223 block223 = Block223Application.getBlock223();
				player = new Player(playerPassword, block223);
				User user = new User(username, block223, player);
				if (adminPassword != null && !adminPassword.equals("")) {
					admin = new Admin(adminPassword, block223);
					user.addRole(admin);
				}
				Block223Persistence.save(block223);
			} catch (RuntimeException e) {
				if (player != null)
					player.delete();
				if (admin != null)
					admin.delete();
				if (e.getMessage().equals("The username must be specified.")) {
					throw new InvalidInputException("The username must be specified.");
				} else if (e.getMessage().equals("The password must be specified.")) {
					throw new InvalidInputException("The player password must be specified.");
				} else if (e.getMessage().equals("Cannot create due to duplicate username")) {
					throw new InvalidInputException("The username has already been taken.");
				} else {
					throw new InvalidInputException(e.getMessage());
				}

			}
		} else {
			throw new InvalidInputException(error);
		}
	}

	public static void login(String username, String password) throws InvalidInputException {
		UserRole currentRole = Block223Application.getCurrentUserRole();
		Block223Application.resetBlock223();
		String error = "";
		User user = User.getWithUsername(username);
		if (currentRole != null) {
			error = "Cannot login a user while a user is already logged in.";
		} else if (user == null) {
			error = "The username and password do not match.";
		} else {
			List<UserRole> roles = user.getRoles();
			for (UserRole role : roles) {
				if (role.getPassword().equals(password)) {
					Block223Application.setCurrentUserRole(role);
					return;
					
				}
			}
			error = "The username and password do not match.";
		}
		if (!error.equals("")) {
			throw new InvalidInputException(error);
		}
	}

	public static void logout() {
		Block223Application.setCurrentUserRole(null);
	}

	// play mode

	public static void selectPlayableGame(String name, int id) throws InvalidInputException {
		if(!(Block223Application.getCurrentUserRole() instanceof Player)) {
			throw new InvalidInputException("Player privileges are required to play a game.");
		}
		Block223 block223=Block223Application.getBlock223();
		Game game=block223.findGame(name);
		PlayedGame pgame=null;
		if(game!=null) {
			Player player=(Player)Block223Application.getCurrentUserRole();
			String username=User.findUsername(player);
			pgame= new PlayedGame(username, game, block223);
			pgame.setPlayer(player);
		}else {
			 pgame=block223.findPlayableGame(id);
			 if(pgame==null) {
				 throw new InvalidInputException("The game does not exist.");
			 }
			 if(pgame.getPlayer()!=(Player)Block223Application.getCurrentUserRole()) {
				 throw new InvalidInputException("Only the player that started a game can continue the game.");
			 }
		}
		Block223Application.setCurrentPlayableGame(pgame);

	}
	public static void startGame(Block223PlayModeInterface ui) throws InvalidInputException {
		startPlayGame(ui);
		PlayedGame game=Block223Application.getCurrentPlayableGame();
		if(game!=null && game.getPlayStatus()==PlayStatus.GameOver) {
			unselectGame();
		}
	}
	public static void startPlayGame(Block223PlayModeInterface ui) throws InvalidInputException {
		if (Block223Application.getCurrentUserRole()==null) {
			throw new InvalidInputException("Player privileges are required to play a game.");
		}
		PlayedGame game=Block223Application.getCurrentPlayableGame();
		if(game==null) {
			throw new InvalidInputException("A game must be selected to play it.");
		}
		if((Block223Application.getCurrentUserRole() instanceof Admin)
				&& game.getPlayer()!=null) {
			throw new InvalidInputException("Player privileges are required to play a game.");
		}
		if((Block223Application.getCurrentUserRole() instanceof Admin)
				&& game.getGame().getAdmin()!=Block223Application.getCurrentUserRole()) {
			throw new InvalidInputException("Only the admin of a game can test the game.");
		}
		if((Block223Application.getCurrentUserRole() instanceof Player)
				&& game.getPlayer()==null) {
			throw new InvalidInputException("Admin privileges are required to test a game.");
		}
		Game initialGame=game.getGame();
		game.play();
		boolean gameHasPlayer=game.getPlayer()!=null;
		String userInputs=ui.takeInputs();
		while(game.getPlayStatus()==PlayStatus.Moving) {
			userInputs=ui.takeInputs();
			updatePaddlePosition(userInputs);
			game.move();
			if(userInputs.contains(" ")) {
				game.pause();
			}
			try {
				TimeUnit.MILLISECONDS.sleep((long) game.getWaitTime());
			} catch (InterruptedException e) {
				
			}
			if(game.getPlayStatus()!=PlayStatus.GameOver) {
				ui.refresh();
			}
			
		}
		
		if(game.getPlayStatus()==PlayStatus.GameOver) {
			Block223Application.setCurrentGame(initialGame);
			ui.endGame(game.getLives(),null );
		}
		if(gameHasPlayer){
			game.setBounce(null);
			Block223 block223=Block223Application.getBlock223();
			Block223Persistence.save(block223);
			System.out.println("saved");
			
		}
	}
	public static void unselectGame() {
		Block223Application.setCurrentPlayableGame(null);
		Block223Application.setCurrentGame(null);
	}

	private static void updatePaddlePosition(String userInputs) {
		PlayedGame game=Block223Application.getCurrentPlayableGame();
		for(int i=0; i<userInputs.length();i++) {
			if(userInputs.charAt(i)=='l') {
				if(game.getCurrentPaddleX()>=Math.abs(PlayedGame.PADDLE_MOVE_LEFT)) {
					game.setCurrentPaddleX(game.getCurrentPaddleX()+PlayedGame.PADDLE_MOVE_LEFT);
				}
			}else if(userInputs.charAt(i)=='r') {
				if(game.getCurrentPaddleX()<=Game.PLAY_AREA_SIDE-PlayedGame.PADDLE_MOVE_RIGHT-game.getCurrentPaddleLength()) {
					game.setCurrentPaddleX(game.getCurrentPaddleX()+PlayedGame.PADDLE_MOVE_RIGHT);
				}
			}else if(userInputs.charAt(i)==' ') {
				break;
			}
		}
	}

	public static void testGame(Block223PlayModeInterface ui) throws InvalidInputException {
		selectTestGame();
		startGame(ui);

	}
	public static void selectTestGame() throws InvalidInputException{
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to test a game.");
		}
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to test it.");
		}

		if (Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
			throw new InvalidInputException("Only the admin who created the game can test it.");
		}
		
		if (Block223Application.getCurrentGame().getBlocks().size() < 1) {
			throw new InvalidInputException("At least one block must be defined for a game to be tested.");
		}
		if (Block223Application.getCurrentGame().getLevels().size() < 1) {
			throw new InvalidInputException("The game needs to have at least one level.");
		}
		
		Game game = Block223Application.getCurrentGame();
		Admin admin = (Admin) Block223Application.getCurrentUserRole();
		String username = User.findUsername(admin);
		Block223 block223 = Block223Application.getBlock223();
		PlayedGame pgame = new PlayedGame(username, game, block223);
		pgame.setPlayer(null);
		Block223Application.setCurrentPlayableGame(pgame);
	}

	public static void publishGame() throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to publish a game.");
		}
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to publish it.");
		}
		if (Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
			throw new InvalidInputException("Only the admin who created the game can publish it.");
		}
		if (Block223Application.getCurrentGame().getBlocks().size() < 1) {
			throw new InvalidInputException("At least one block must be defined for a game to be published.");
		}
		Game game = Block223Application.getCurrentGame();
		game.setPublished(true);

	}

	// ****************************
	// Query methods
	// ****************************
	public static List<TOGame> getDesignableGames() throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}

		Block223 block223 = Block223Application.getBlock223();
		Admin admin = (Admin) Block223Application.getCurrentUserRole();

		List<TOGame> result = new ArrayList<TOGame>();

		List<Game> games = block223.getGames();

		for (Game game : games) {
			Admin gameAdmin = game.getAdmin();

			if (gameAdmin.equals(admin) && !(game.getPublished())) {
				TOGame to = new TOGame(game.getName(), game.getLevels().size(), game.getNrBlocksPerLevel(),
						game.getBall().getMinBallSpeedX(), game.getBall().getMinBallSpeedY(),
						game.getBall().getBallSpeedIncreaseFactor(), game.getPaddle().getMaxPaddleLength(),
						game.getPaddle().getMinPaddleLength());

				result.add(to);
			}
		}
		return result;
	}

	public static TOGame getCurrentDesignableGame() throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to access its information.");
		}
		if (Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()) == false) {
			throw new InvalidInputException("Only the admin who created the game can access its information.");
		}
		Game thisgame = Block223Application.getCurrentGame();
		TOGame to = new TOGame(thisgame.getName(), thisgame.getLevels().size(), thisgame.getNrBlocksPerLevel(),
				thisgame.getBall().getMinBallSpeedX(), thisgame.getBall().getMinBallSpeedY(),
				thisgame.getBall().getBallSpeedIncreaseFactor(), thisgame.getPaddle().getMaxPaddleLength(),
				thisgame.getPaddle().getMinPaddleLength());
		return to;

	}

	public static List<TOBlock> getBlocksOfCurrentDesignableGame() throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to access its information.");
		}
		if (Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()) == false) {
			throw new InvalidInputException("Only the admin who created the game can access its information.");
		}
		Game thisgame = Block223Application.getCurrentGame();
		List<TOBlock> result = new ArrayList<TOBlock>();
		if (thisgame != null) {
			List<Block> blocks = thisgame.getBlocks();
			if (blocks != null) {
				for (int i = 0; i < blocks.size(); i++) {
					TOBlock to = new TOBlock(blocks.get(i).getId(), blocks.get(i).getRed(), blocks.get(i).getGreen(),
							blocks.get(i).getBlue(), blocks.get(i).getPoints());
					result.add(to);
				}

			}
		}
		return result;
	}

	public static TOBlock getBlockOfCurrentDesignableGame(int id) throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to access its information.");
		}
		if (Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()) == false) {
			throw new InvalidInputException("Only the admin who created the game can access its information.");
		}

		Game thisgame = Block223Application.getCurrentGame();
		Block thisblock = null;

		thisblock = thisgame.findBlock(id); // should be findBlock not getBlock since ID not index
		if (thisblock == null) {
			throw new InvalidInputException("The block does not exist.");
		}

		TOBlock to = new TOBlock(thisblock.getId(), thisblock.getRed(), thisblock.getGreen(), thisblock.getBlue(),
				thisblock.getPoints());

		return to;
	}

	public static List<TOGridCell> getBlocksAtLevelOfCurrentDesignableGame(int level) throws InvalidInputException {
		if (Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information.");
		}
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to access its information.");
		}
		if (Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()) == false) {
			throw new InvalidInputException("Only the admin who created the game can access its information.");
		}

		Game thisgame = Block223Application.getCurrentGame();
		List<TOGridCell> result = new ArrayList<TOGridCell>();

		Level thislevel = null;
		try {
			thislevel = thisgame.getLevel(level - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new InvalidInputException("Level " + level + " does not exist for the game.");
		}
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
		} else if (thisrole instanceof Player) {
			to = new TOUserMode(Mode.Play);
		} else if (thisrole instanceof Admin) {
			to = new TOUserMode(Mode.Design);
		}
		return to;
	}

	// play mode

	public static List<TOPlayableGame> getPlayableGames() throws InvalidInputException {

		Block223 block223 = Block223Application.getBlock223();
		
		//Check
		if (!(Block223Application.getCurrentUserRole() instanceof Player)) {
			throw new InvalidInputException("Player privileges are required to play a game.");
		}
		
		Player player = (Player) Block223Application.getCurrentUserRole(); // checks

		List<TOPlayableGame> result = new ArrayList<TOPlayableGame>();

		List<Game> games = block223.getGames();

		for (Game game : games) {
			boolean published = game.isPublished();

			if (published) {
				TOPlayableGame to = new TOPlayableGame(game.getName(), -1, 0);
				result.add(to);
			}
		}

		List<PlayedGame> playedGames = player.getPlayedGames();

		for (PlayedGame playedGame : playedGames) {
			TOPlayableGame to = new TOPlayableGame(playedGame.getGame().getName(), playedGame.getId(),
					playedGame.getCurrentLevel());
			result.add(to);
		}

		return result;
	}

	public static TOCurrentlyPlayedGame getCurrentPlayableGame() throws InvalidInputException {
		if(Block223Application.getCurrentUserRole()==null) {
			throw new InvalidInputException("Player privileges are required to play a game.");
		}
		if(Block223Application.getCurrentPlayableGame()==null) {
			throw new InvalidInputException("A game must be selected to play it.");
		}
		if((Block223Application.getCurrentUserRole() instanceof Admin)
				&& Block223Application.getCurrentPlayableGame().getPlayer()!=null){
			throw new InvalidInputException("Player privileges are required to play a game.");
			
		}
		if((Block223Application.getCurrentUserRole() instanceof Admin)
				&& Block223Application.getCurrentPlayableGame().getGame().getAdmin()!=Block223Application.getCurrentUserRole()){
			throw new InvalidInputException("Only the admin of a game can test the game.");
			
		}
		if((Block223Application.getCurrentUserRole() instanceof Player)
				&& Block223Application.getCurrentPlayableGame().getPlayer()==null){
			throw new InvalidInputException("Admin privileges are required to test a game.");
			
		}
		PlayedGame pgame = Block223Application.getCurrentPlayableGame();

		boolean paused = (pgame.getPlayStatus() == PlayStatus.Ready || pgame.getPlayStatus() == PlayStatus.Paused);
		
		TOCurrentlyPlayedGame result = new TOCurrentlyPlayedGame(pgame.getGame().getName(), paused, pgame.getScore(),
				pgame.getLives(), pgame.getCurrentLevel(), pgame.getPlayername(), (int) Math.round(pgame.getCurrentBallX()),
				(int)Math.round( pgame.getCurrentBallY()), (int) Math.round(pgame.getCurrentPaddleLength()), (int) Math.round(pgame.getCurrentPaddleX()));

		List<PlayedBlockAssignment> blocks = pgame.getBlocks();

		for (PlayedBlockAssignment pblock : blocks) {
			TOCurrentBlock to = new TOCurrentBlock(pblock.getBlock().getRed(), pblock.getBlock().getGreen(),
					pblock.getBlock().getBlue(), pblock.getBlock().getPoints(), pblock.getX(), pblock.getY(), result);
			result.addBlock(to);
		}

		return result;
	}

	public static TOHallOfFame getHallOfFame(int start, int end) throws InvalidInputException {
		
		if(!(Block223Application.getCurrentUserRole() instanceof Player)) {
			throw new InvalidInputException("Player privileges are required to access a game's hall of fame.");
		}
		if(Block223Application.getCurrentPlayableGame()==null) {
			throw new InvalidInputException("A game must be selected to view its hall of fame.");
		}
		PlayedGame pgame = Block223Application.getCurrentPlayableGame();
		Game game = pgame.getGame();
		if (game==null) {
			game=Block223Application.getCurrentGame();
		}
		TOHallOfFame result = new TOHallOfFame(game.getName());
		if (start < 1)
			start = 1;
		if (end > game.numberOfHallOfFameEntries())
			end = game.numberOfHallOfFameEntries();
		start = game.numberOfHallOfFameEntries()-start;
		end = game.numberOfHallOfFameEntries()-end;

		for (int i = start; i >=end; i--) {
			//String username = pgame.getPlayername();
			TOHallOfFameEntry to = new TOHallOfFameEntry(i + 1, game.getHallOfFameEntry(i).getPlayername(), game.getHallOfFameEntry(i).getScore(),
					result);
		}

		return result;
	}

	public static TOHallOfFame getHallOfFameWithMostRecentEntry(int numberOfEntries) throws InvalidInputException {
		if(!(Block223Application.getCurrentUserRole() instanceof Player)) {
			throw new InvalidInputException("Player privileges are required to access a game's hall of fame.");
		}
		if(Block223Application.getCurrentPlayableGame()==null) {
			throw new InvalidInputException("A game must be selected to view its hall of fame.");
		}
		PlayedGame pgame = Block223Application.getCurrentPlayableGame();
		Game game = pgame.getGame();

		TOHallOfFame result = new TOHallOfFame(game.getName());
		HallOfFameEntry mostRecent = game.getMostRecentEntry();
		int index = game.indexOfHallOfFameEntry(mostRecent);

		int start = index - numberOfEntries / 2;

		if (start < 1)
			start = 1;
		int end = start + numberOfEntries - 1;
		if (end > game.numberOfHallOfFameEntries())
			end = game.numberOfHallOfFameEntries();
		start = game.numberOfHallOfFameEntries()-start;
		end = game.numberOfHallOfFameEntries()-end;

		for (int i = start; i >=end; i--) {
			//String username = pgame.getPlayername();
			TOHallOfFameEntry to = new TOHallOfFameEntry(i + 1, game.getHallOfFameEntry(i).getPlayername(), game.getHallOfFameEntry(i).getScore(),
					result);
		}

		return result;
	}
	
	
	// 1 vs 1 related methods
	
	
	
	private static void updateBothPaddlePosition(String userInputs) {
		PlayedGame game=Block223Application.getCurrentPlayableGame();
		PlayedGame game2=Block223Application.getSecondPlayableGame();
		int coef=2;
		for(int i=0; i<userInputs.length();i++) {
			if(userInputs.charAt(i)=='l') {
				if(game.getCurrentPaddleX()>=Math.abs(PlayedGame.PADDLE_MOVE_LEFT/coef)) {
					if(game.getPlayStatus()==PlayStatus.Moving)game.setCurrentPaddleX(game.getCurrentPaddleX()+PlayedGame.PADDLE_MOVE_LEFT/coef);
				}
			}else if(userInputs.charAt(i)=='r') {
				if(game.getCurrentPaddleX()<=Game.PLAY_AREA_SIDE-PlayedGame.PADDLE_MOVE_RIGHT/coef-game.getCurrentPaddleLength()) {
					if(game.getPlayStatus()==PlayStatus.Moving)game.setCurrentPaddleX(game.getCurrentPaddleX()+PlayedGame.PADDLE_MOVE_RIGHT/coef);
				}
			}else if (userInputs.charAt(i)=='a') {
				if(game2.getCurrentPaddleX()>=Math.abs(PlayedGame.PADDLE_MOVE_LEFT/coef)) {
					if(game2.getPlayStatus()==PlayStatus.Moving)game2.setCurrentPaddleX(game2.getCurrentPaddleX()+PlayedGame.PADDLE_MOVE_LEFT/coef);
				}
			}else if (userInputs.charAt(i)=='d') {
				if(game2.getCurrentPaddleX()<=Game.PLAY_AREA_SIDE-PlayedGame.PADDLE_MOVE_RIGHT/coef-game2.getCurrentPaddleLength()) {
					if(game2.getPlayStatus()==PlayStatus.Moving)game2.setCurrentPaddleX(game2.getCurrentPaddleX()+PlayedGame.PADDLE_MOVE_RIGHT/coef);
				}
			}else if(userInputs.charAt(i)==' ') {
				break;
			}
		}
	}
	
	
	
	public static TOCurrentlyPlayedGame getSecondPlayableGame() throws InvalidInputException {
		PlayedGame pgame = Block223Application.getSecondPlayableGame();

		boolean paused = (pgame.getPlayStatus() == PlayStatus.Ready || pgame.getPlayStatus() == PlayStatus.Paused);
		
		TOCurrentlyPlayedGame result = new TOCurrentlyPlayedGame(pgame.getGame().getName(), paused, pgame.getScore(),
				pgame.getLives(), pgame.getCurrentLevel(), pgame.getPlayername(), (int) Math.round(pgame.getCurrentBallX()),
				(int)Math.round( pgame.getCurrentBallY()), (int) Math.round(pgame.getCurrentPaddleLength()), (int) Math.round(pgame.getCurrentPaddleX()));

		List<PlayedBlockAssignment> blocks = pgame.getBlocks();

		for (PlayedBlockAssignment pblock : blocks) {
			TOCurrentBlock to = new TOCurrentBlock(pblock.getBlock().getRed(), pblock.getBlock().getGreen(),
					pblock.getBlock().getBlue(), pblock.getBlock().getPoints(), pblock.getX(), pblock.getY(), result);
			result.addBlock(to);
		}

		return result;
	}
	
	public static void selectBothPlayableGame(String name) throws InvalidInputException {
		if(!(Block223Application.getCurrentUserRole() instanceof Player)) {
			throw new InvalidInputException("Player privileges are required to play a game.");
		}
		Block223 block223=Block223Application.getBlock223();
		Game game=block223.findGame(name);
		PlayedGame pgame=null;
		PlayedGame pgame2=null;
		if(game!=null) {
			Block223Application.setCurrentGame(game);
			Player player=(Player)Block223Application.getCurrentUserRole();
			String username=User.findUsername(player);
			pgame= new PlayedGame(username, game, block223);
			pgame.setPlayer(player);
			Block223Application.setCurrentPlayableGame(pgame);
			
			Player player2=(Player)Block223Application.getSecondPlayer();
			String username2=User.findUsername(player);
			pgame2= new PlayedGame(username2, game, block223);
			pgame2.setPlayer(player2);
			Block223Application.setSecondPlayableGame(pgame2);
			
			pgame.setGravityMode(true);
			pgame2.setGravityMode(true);
		}else {
			throw new InvalidInputException("Game does not exist");
		}
	}
	
	public static void startBothGames(Block223PlayModeInterface ui) throws InvalidInputException {
		PlayedGame game=Block223Application.getCurrentPlayableGame();
		PlayedGame game2=Block223Application.getSecondPlayableGame();
		game.play();
		game2.play();
		String userInputs=ui.takeInputs();
		boolean fresh1=true;
		boolean fresh2=true;
		boolean gameHasPlayer=game.getPlayer()!=null;
		while(game.getPlayStatus()!=PlayStatus.GameOver || game2.getPlayStatus()!=PlayStatus.GameOver) {
			userInputs=ui.takeInputs();
			if(game.getPlayStatus()!=PlayStatus.Moving &&(userInputs.contains("l") || userInputs.contains("r"))){
				game.play();
			}
			if(game2.getPlayStatus()!=PlayStatus.Moving &&(userInputs.contains("a") || userInputs.contains("d"))){
				game2.play();
			}
			updateBothPaddlePosition(userInputs);
			game.move();
			game2.move();
			if(userInputs.contains(" ")) {
				game.pause();
				game2.pause();
				break;
			}
			try {
				TimeUnit.MILLISECONDS.sleep((long) game.getWaitTime());
			} catch (InterruptedException e) {
				
			}
			ui.refresh();
			if (game.getPlayStatus()==PlayStatus.GameOver && fresh1) {
				fresh1=false;
				if(game.getLives()>0) {
					ui.endGame(1,null);
				}else {
					ui.endGame(0,null);
				}
			}
			if (game2.getPlayStatus()==PlayStatus.GameOver && fresh2) {
				fresh1=false;
				if(game2.getLives()>0) {
					ui.endGame(3,null);
				}else {
					ui.endGame(2,null);
				}
			}
			
		}
		if(gameHasPlayer){
			game.setBounce(null);
			game2.setBounce(null);
			Block223 block223=Block223Application.getBlock223();
			Block223Persistence.save(block223);
		}
	}
	public static void unselectBothGames() {
		Block223Application.setCurrentGame(null);
		Block223Application.setCurrentPlayableGame(null);
		Block223Application.setSecondPlayableGame(null);
	}
	
	public  static void registerSecondPlayer(String username, String playerPassword, String adminPassword) throws InvalidInputException{
		String error = "";
		 if (playerPassword == null || playerPassword.length() == 0) {
			error = "The player password needs to be specified.";
		} else if (playerPassword.equals(adminPassword)) {
			error = "The passwords have to be different.";
		}
		if (error.equals("")) {
			Player player = null;
			Admin admin = null;
			try {
				Block223 block223 = Block223Application.getBlock223();
				player = new Player(playerPassword, block223);
				User user = new User(username, block223, player);
				if (adminPassword != null && !adminPassword.equals("")) {
					admin = new Admin(adminPassword, block223);
					user.addRole(admin);
				}
				Block223Persistence.save(block223);
				Block223Application.setSecondPlayer(player);
			} catch (RuntimeException e) {
				if (player != null)
					player.delete();
				if (admin != null)
					admin.delete();
				if (e.getMessage().equals("The username must be specified.")) {
					throw new InvalidInputException("The username must be specified.");
				} else if (e.getMessage().equals("The password must be specified.")) {
					throw new InvalidInputException("The player password must be specified.");
				} else if (e.getMessage().equals("Cannot create due to duplicate username")) {
					throw new InvalidInputException("The username has already been taken.");
				} else {
					throw new InvalidInputException(e.getMessage());
				}

			}
		} else {
			throw new InvalidInputException(error);
		}
	}
	
	public  static void loginSecondPlayer(String username, String password) throws InvalidInputException{
		//UserRole currentRole = Block223Application.getCurrentUserRole();
		//Block223Application.resetBlock223();
		String error = "";
		User user = User.getWithUsername(username);
		if (user == null) {
			error = "The username and password do not match.";
		} else {
			List<UserRole> roles = user.getRoles();
			for (UserRole role : roles) {
				if (role.getPassword().equals(password)) {
					if (role instanceof Admin) {
						throw new InvalidInputException("Please enter your player password.");
					}
					Block223Application.setSecondPlayer((Player)role);
					return;
					
				}
			}
			error = "The username and password do not match.";
		}
		if (!error.equals("")) {
			throw new InvalidInputException(error);
		}
	}
	
	

}