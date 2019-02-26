package ca.mcgill.ecse223.block.controller;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse223.block.application.*;
import ca.mcgill.ecse223.block.controller.TOUserMode.Mode;
import ca.mcgill.ecse223.block.model.*;
import ca.mcgill.ecse223.block.persistence.Block223Persistence;

public class Block223Controller {

	// ****************************
	// Modifier methods
	// ****************************
	public static void createGame(String name) throws InvalidInputException {
		if(Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to create a game"); 
		}
		
		Block223 block223 = Block223Application.getBlock223();

		Admin admin = (Admin) Block223Application.getCurrentUserRole();

		Game game = new Game(name, 1, admin, 1, 1, 1, 10, 10, block223);
	}

	public static void setGameDetails(int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException 
	{
																// To do: Add Checksss
		
		String error = "";
		Admin admin = (Admin) Block223Application.getCurrentUserRole();
			if (admin == null) 
		{
				throw new InvalidInputException("Admin previleges are required to define game settings");
		} 	else if (!admin.hasGames()) 
		{ //NOT SURE
			throw new InvalidInputException("Only the admin who created the game can define its game settings");
		}  
		
		
		if (nrLevels < 1 || nrLevels >99 ) {
			throw new InvalidInputException("The number of levels must be between 1 and 99");
		}
		
		
    Game game = Block223Application.getCurrentGame();
    if (game == null) 
    {
    	throw new InvalidInputException("A Game must be selected to define game settings");
    }
    
    if(nrLevels < 1 || nrLevels >99) {
    	throw new InvalidInputException("The number of levels must be between 1 and 99.");
    }
    
   
    //setting number of blocks
    if (nrBlocksPerLevel <= 0) {
    	throw new InvalidInputException("The number of blocks per level must be greater than zero.");
    }
    game.setNrBlocksPerLevel(nrBlocksPerLevel);
//get ball
    Ball ball = game.getBall();
    //change ball settings
    if (minBallSpeedX <= 0) {
    	throw new InvalidInputException("The minimum speed of the ball must be greater than zero");
    }
    ball.setMinBallSpeedX(minBallSpeedX);
    
    if (minBallSpeedY <= 0) {
    	throw new InvalidInputException("The minimum speed of the ball must be greater than zero");
    	
    }
    ball.setMinBallSpeedY(minBallSpeedY);
    
    if(ballSpeedIncreaseFactor <= 0) {
    	throw new InvalidInputException("The speed increase factor of the ball must be greater than zero");
    }
    ball.setBallSpeedIncreaseFactor(ballSpeedIncreaseFactor);
//get paddle
    Paddle paddle = game.getPaddle();
    //change paddle settings
    if(maxPaddleLength <=0 || maxPaddleLength >400) {
    	throw new InvalidInputException("The maximum length of the paddle must be greater than zero or less than or equal to 400.");
    }
    paddle.setMaxPaddleLength(maxPaddleLength);
    if (minPaddleLength <= 0) {
    	throw new InvalidInputException("The minimum length of the paddle must be greater than zero.");
    }
    paddle.setMinPaddleLength(minPaddleLength);
    //get levels
    List<Level> level = game.getLevels();
    
    //level.size();
    //game.numberOfLevels();
    while (game.numberOfLevels() > level.size()) {
    	game.addLevel();
    level.size(); //MIGHT BE WRONG	
    	
    }
    while (game.numberOfLevels() < level.size()) {
    	level.get(level.size() - 1);
    	level.remove(level.size());
    	level.size(); //MIGHT BE WRONG
    	//NOT SURE ABOUT 'size = size() ' method
    }
    
		}


	public static void deleteGame(String name) throws InvalidInputException {
		Game game = Game.getWithName(name);
		if (game != null) {
			game.delete();
		}
	}

	public static void selectGame(String name) throws InvalidInputException {
	Game game = Game.getWithName(name);
	//Use findGame due to bug in Umple
	
	
	//Block223Application.getCurrentUserRole()
	
	
	if (game == null) {
		throw new InvalidInputException("A game with name "+name+" does not exist");
	}
	Block223Application.setCurrentGame(game);
	}

	public static void updateGame(String name, int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException 
	{
		
		
							//Checks
		if (Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to define game settings");
			
		}
		
		Game game =  Block223Application.getCurrentGame();
		String currentName = game.getName();
		
		if(!game.setName(name)) {
			//NOT SURE
			throw new InvalidInputException("The name of the game must be unique");
		}
		
		if (currentName != name) {
			game.setName(name);
		}
		Block223Controller.setGameDetails(nrLevels, nrBlocksPerLevel, minBallSpeedX, minBallSpeedY, ballSpeedIncreaseFactor, maxPaddleLength, minPaddleLength);
		
	}

	public static void addBlock(int red, int green, int blue, int points) throws InvalidInputException {
		if((Block223Application.getCurrentUserRole()) instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to add a block");
		}
		Game game = Block223Application.getCurrentGame();
		if(game == null) {
			throw new InvalidInputException("A game must be selected to add a block");
		}
		if((game.getAdmin().equals(Block223Application.getCurrentUserRole()) == false)) {
			throw new InvalidInputException("Only the admin who created the game can add a block");
		}
		try {
			Block block = new Block(red, green, blue, points,game);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		
	}

	public static void deleteBlock(int id) throws InvalidInputException {
		if((Block223Application.getCurrentUserRole()) instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to delete a block");
		}
		Game game = Block223Application.getCurrentGame();
		
		if(game == null) {
			throw new InvalidInputException("A game must be selected to delete a block");
		}
		
		if((game.getAdmin().equals(Block223Application.getCurrentUserRole()) == false)) {
			throw new InvalidInputException("Only the admin who created the game can delete a block");
		}
		Block foundBlock = game.findBlock(id);
		if(foundBlock != null) {
			foundBlock.delete();
			
		}	
	}
	
	
	public static void updateBlock(int id, int red, int green, int blue, int points) throws InvalidInputException {
		Game game = Block223Application.getCurrentGame();
		Block block = game.getBlock(id);

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
		Block block = game.getBlock(Id);

		BlockAssignment blockassignment = new BlockAssignment(gridHorizontalPosition, gridVerticalPosition,
				currentlevel, block, game);

	}

	public static void moveBlock(int level, int oldGridHorizontalPosition, int oldGridVerticalPosition,
				int newGridHorizontalPosition, int newGridVerticalPosition) throws InvalidInputException {
			
			Game game = Block223Application.getCurrentGame();
			Level currentlevel = game.getLevel(level);
			BlockAssignment assignment;
			List<BlockAssignment> assignments = currentlevel.getBlockAssignments();
			
			if(level <1 || level > game.maximumNumberOfLevels()) {
				throw new InvalidInputException("Level " + level + " does not exist for the game.");
			}
			
			if(findBlockAssignment(oldGridHorizontalPosition, oldGridVerticalPosition)==null) {
				throw new InvalidInputException("A block does not exist at location" + oldGridHorizontalPosition + "/" + oldGridVerticalPosition + ".");
			}else {
				assignment= findBlockAssignment(oldGridHorizontalPosition, oldGridVerticalPosition);
			}
			
			for(BlockAssignment assign: assignments) {
				
				int h= assign.getGridHorizontalPosition();
				int v= assign.getGridVerticalPosition();
				
				if(h==newGridHorizontalPosition && v==newGridVerticalPosition) {
					throw new InvalidInputException("A block already exists at location" + newGridHorizontalPosition + "/" + newGridVerticalPosition + ".");
				}
			}
			
		}

		public static void removeBlock(int level, int gridHorizontalPosition, int gridVerticalPosition)
				throws InvalidInputException {
			
			Game game = Block223Application.getCurrentGame();
			Level currentlevel = game.getLevel(level);
			BlockAssignment assignment;
			List<BlockAssignment> assignments = currentlevel.getBlockAssignments();
			
			assignment= findBlockAssignment(gridHorizontalPosition, gridVerticalPosition);
			
			if(assignment != null) {
				
				for(BlockAssignment assign: assignments) {
					
					int h= assign.getGridHorizontalPosition();
					int v= assign.getGridVerticalPosition();
					
					if(h==gridHorizontalPosition && v==gridVerticalPosition) {
						 assign.delete();
					}
				}
				
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
		} else if (playerPassword.equals(adminPassword)) {
			error = "The passwords have to be different.";
		}
		if (error.equals("")) {
			Player player=null;
			Admin admin=null;
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
				if(player!=null)player.delete();
				if(admin!=null)admin.delete();
				throw new InvalidInputException(e.getMessage());
			}
		} else {
			throw new InvalidInputException(error);
		}
	}

	public static void login(String username, String password) throws InvalidInputException {
		UserRole currentRole = Block223Application.getCurrentUserRole();
		Block223Application.resetBlock223();
		String error="";
		User user=User.getWithUsername(username);
		if(currentRole!=null) {
			error="Cannot login a user while a user is already logged in.";
		}else if(user==null) {
			error="The username and password do not match.";
		}else {
			List<UserRole> roles=user.getRoles();
			for(UserRole role:roles) {
				if(role.getPassword().equals(password)) {
					Block223Application.setCurrentUserRole(role);
					return;
				}
			}
			error="The username and password do not match.";
		}
		if(!error.equals("")) {
			throw new InvalidInputException(error);
		}
	}

	public static void logout() {
		Block223Application.setCurrentUserRole(null);
	}

	// ****************************
	// Query methods
	// ****************************
	public static List<TOGame> getDesignableGames() throws InvalidInputException {
		Block223 block223 = Block223Application.getBlock223();
		Admin admin = (Admin) Block223Application.getCurrentUserRole();//TODO: add checks

		List<TOGame> result = new ArrayList<TOGame>();

		List<Game> games = block223.getGames();

		for (Game game : games) {
			Admin gameAdmin = game.getAdmin();

			if (true) {
				TOGame to = new TOGame(game.getName(), game.getLevels().size(), game.getNrBlocksPerLevel(),
						game.getBall().getMinBallSpeedX(), game.getBall().getMinBallSpeedY(),
						game.getBall().getBallSpeedIncreaseFactor(), game.getPaddle().getMaxPaddleLength(),
						game.getPaddle().getMinPaddleLength());

				result.add(to);
			}
		}
		return result;
	}

	public static TOGame getCurrentDesignableGame() throws InvalidInputException{
		Game thisgame = Block223Application.getCurrentGame();
		TOGame to = new TOGame(thisgame.getName(), thisgame.getLevels().size(), thisgame.getNrBlocksPerLevel(),
				thisgame.getBall().getMinBallSpeedX(), thisgame.getBall().getMinBallSpeedY(),
				thisgame.getBall().getBallSpeedIncreaseFactor(), thisgame.getPaddle().getMaxPaddleLength(),
				thisgame.getPaddle().getMinPaddleLength());
		return to;

	}

	public static List<TOBlock> getBlocksOfCurrentDesignableGame() throws InvalidInputException{
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
		Game thisgame = Block223Application.getCurrentGame();
		Block thisblock = thisgame.getBlock(id);

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
		}else if (thisrole instanceof Player) {
			to = new TOUserMode(Mode.Play);
		}else if (thisrole instanceof Admin) {
			to = new TOUserMode(Mode.Design);
		}
		return to;
	}
	public static BlockAssignment findBlockAssignment(int gridHorizontalPosition, int gridVerticalPosition){
			
			Game thisgame = Block223Application.getCurrentGame();
			List<BlockAssignment> assignments = thisgame.getBlockAssignments();
			
			
			for(BlockAssignment assignment: assignments) {
				
				int h= assignment.getGridHorizontalPosition();
				int v= assignment.getGridVerticalPosition();
				
				if(h==gridHorizontalPosition && v==gridVerticalPosition) {
					return assignment;
				}else {
					return null;
				}
			}
			
			return null;
		}

}
