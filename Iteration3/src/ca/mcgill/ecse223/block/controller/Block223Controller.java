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
		
		Game game = null; 
		try {
//			if(game.getName() == null || game.getName().isEmpty()) {
//				throw new InvalidInputException("name can not be empty or null"); 
//			}
//			else {
			game = new Game(name, 1, admin, 1,1,1,10,10,block223);
			Block223Application.setCurrentGame(game); //this is temporary for testing. 
		}
		catch (RuntimeException e) {
		}
	}

	public static void setGameDetails(int nrLevels, int nrBlocksPerLevel, int minBallSpeedX, int minBallSpeedY,
			Double ballSpeedIncreaseFactor, int maxPaddleLength, int minPaddleLength) throws InvalidInputException 
	{
		//Osman Warsi
		//Variables
		String error = "";
		Admin admin = (Admin) Block223Application.getCurrentUserRole();
		Game game = Block223Application.getCurrentGame();
    
		//CHECKS
		if (game == null) 
    {
    	throw new InvalidInputException("A Game must be selected to define game settings");
    }
    
    if (! (Block223Application.getCurrentUserRole() instanceof Admin)) 
    {
		throw new InvalidInputException("Admin privileges are required to define game settings. ");
    }
	
    if (game.getAdmin()!=admin) 
    {
		throw new InvalidInputException("Only the admin who created the game can define its game features.");
    }

    if(nrLevels < 1 || nrLevels >99) 
    {
    	throw new InvalidInputException("The number of levels must be between 1 and 99.");
    }
    
   
    if (nrBlocksPerLevel <= 0) 
    {
    	throw new InvalidInputException("The number of blocks per level must be greater than zero.");
    }
    
    game.setNrBlocksPerLevel(nrBlocksPerLevel);

    //Ball Settings
    Ball ball = game.getBall();

    if (minBallSpeedX <= 0) 
    {
    	throw new InvalidInputException("The minimum speed of the ball must be greater than zero");
    }
    	ball.setMinBallSpeedX(minBallSpeedX);
    
    if (minBallSpeedY <= 0) 
    {
    	throw new InvalidInputException("The minimum speed of the ball must be greater than zero");
    }
    	ball.setMinBallSpeedY(minBallSpeedY);
    
    if(ballSpeedIncreaseFactor <= 0) 
    {
    	throw new InvalidInputException("The speed increase factor of the ball must be greater than zero");
    }
    	ball.setBallSpeedIncreaseFactor(ballSpeedIncreaseFactor);

    //Paddle Settings
    Paddle paddle = game.getPaddle();
    
    if(maxPaddleLength <=0 || maxPaddleLength >400) 
    {
    	throw new InvalidInputException("The maximum length of the paddle must be greater than zero or less than or equal to 400.");
    }
    	paddle.setMaxPaddleLength(maxPaddleLength);
    
    if (minPaddleLength <= 0) 
    {
    	throw new InvalidInputException("The minimum length of the paddle must be greater than zero.");
    }
    
    paddle.setMinPaddleLength(minPaddleLength);
    
    
    //ASK GUNTER ABOUT THIS STUFF
    //Level Settings
    List<Level> levels = game.getLevels();
    
    //level.size();
    //game.numberOfLevels();
    while (nrLevels > levels.size()) {
    	game.addLevel();
    
    	
    }
    while (nrLevels < levels.size()) {
    	Level level=levels.get(levels.size() - 1);
    	level.delete();
    	
    }
    
	}


	public static void deleteGame(String name) throws InvalidInputException {
		System.out.println("game not deleted "+ name+"hi");
		if(Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to delete a game"); 
		}
		System.out.println("game not deleted "+ name+"hi");
		if(!Block223Application.getCurrentUserRole().
				equals(Block223Application.getBlock223().findGame(name).getAdmin())) {
			throw new InvalidInputException("Only the admin who created the game can delete the game"); 
		}
		
		Game game = Block223Application.getBlock223().findGame(name);
		
		if (game != null) {
			//Block223 block223 = game.getBlock223();
			game.delete();
			System.out.println("game deleted "+ name);
			Block223Persistence.save(Block223Application.getBlock223());
		}else {
			System.out.println("game not found "+ name);
		}
	}

	public static void selectGame(String name) throws InvalidInputException {
	Game game = Block223Application.getBlock223().findGame(name); 
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
		
		//CHECKS
		if (Block223Application.getCurrentGame() == null) 
		{
			throw new InvalidInputException("A game must be selected to define game settings");
		}
		
		Game game =  Block223Application.getCurrentGame();
		String currentName = game.getName();
		
		if (! (Block223Application.getCurrentUserRole() instanceof Admin)) 
    {
		throw new InvalidInputException("Admin privileges are required to define game settings. ");
    }
		
		//Add a for loop and loop through each name of the game?
	
		if (!currentName.equals(name)) 
		{
			if(!game.setName(name)) 
			{
				
				throw new InvalidInputException("The name of the game must be unique");
			}
			
		}
		
		Block223Controller.setGameDetails(nrLevels, nrBlocksPerLevel, minBallSpeedX, minBallSpeedY, ballSpeedIncreaseFactor, maxPaddleLength, minPaddleLength);
		//END
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
		 if(Block223Application.getCurrentUserRole() instanceof Admin ==false) {
		    	throw new InvalidInputException("Admin privileges are required to update a block.");
		    }
		    
		    if(Block223Application.getCurrentGame()==null) {
				throw new InvalidInputException("A game must be selected to update a block.");
			}
		    
       if(Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
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
			if (thisblock.getRed() == red && thisblock.getBlue()==blue && thisblock.getGreen()==green) {
				throw new InvalidInputException("A block with the same color already exists for the game.");
			}
		}
		block.setRed(red);
		block.setGreen(green);
		block.setBlue(blue);
		block.setPoints(points);

	}

	// Modifier method to position block
	public static void positionBlock(int Id, int level, int gridHorizontalPosition, int gridVerticalPosition)
			throws InvalidInputException {

		Game game = Block223Application.getCurrentGame();
		
		  if(Block223Application.getCurrentUserRole() instanceof Admin ==false) {
		    	throw new InvalidInputException("Admin privileges are required to position a block.");
		    }
		    
		    if(Block223Application.getCurrentGame()==null) {
				throw new InvalidInputException("A game must be selected to position a block.");
			}
		    
          if(Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
          	throw new InvalidInputException("Only the admin who created the game can position a block.");
			}
         
          
          if(level <1 || level > game.getLevels().size()) {
  			throw new InvalidInputException("Level " + level + " does not exist for the game.");
  		}
        try {
		Level currentlevel = game.getLevel(level-1);
        }
        catch(IndexOutOfBoundsException e){
        	throw new IndexOutOfBoundsException(e.getMessage());
        	}
		
		Level currentlevel = game.getLevel(level-1);
		int nrBlocksPerLevel = game.maximumNumberOfLevels();
		if (currentlevel.getBlockAssignments().size() > nrBlocksPerLevel) {
			throw new InvalidInputException("The number of blocks has reached the maximum number ("+ nrBlocksPerLevel +") allowed for this game.");
			
		}
		List<BlockAssignment> assignments = currentlevel.getBlockAssignments();
		for (BlockAssignment thisassignment : assignments) {
			if (thisassignment.getGridHorizontalPosition() == gridHorizontalPosition && thisassignment.getGridVerticalPosition() == gridVerticalPosition) {
				throw new InvalidInputException("A  block  already  exists  at  location"  + gridHorizontalPosition+   "/"   +   gridVerticalPosition + ".");
			}
		}
		Block block = game.findBlock(Id);
		if (block == null) {
			throw new InvalidInputException("The block does not exist.");
		}
		int maxNumberOfHorizontalBlocks = 15;
		int maxNumberOfVerticalBlocks = 15;
		
		if (gridHorizontalPosition !=0 && gridHorizontalPosition > 0 && gridHorizontalPosition <= maxNumberOfHorizontalBlocks) {
			try {
		BlockAssignment blockassignment = new BlockAssignment(gridHorizontalPosition, gridVerticalPosition,
				currentlevel, block, game);
			}
		catch(RuntimeException e) {
        	throw new RuntimeException("The horizontal position must be between 1 and " + maxNumberOfHorizontalBlocks + ".");
        	}
}

	}
	
	public static void moveBlock(int level, int oldGridHorizontalPosition, int oldGridVerticalPosition,
				int newGridHorizontalPosition, int newGridVerticalPosition) throws InvalidInputException {
		
		    if(Block223Application.getCurrentUserRole() instanceof Admin ==false) {
		    	throw new InvalidInputException("Admin privileges are required to move a block.");
		    }
		    
		    if(Block223Application.getCurrentGame()==null) {
				throw new InvalidInputException("A game must be selected to move a block.");
			}
		    
            if(Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
            	throw new InvalidInputException("Only the admin who created the game can move a block.");
			}
			
			Game game = Block223Application.getCurrentGame();
			Level currentlevel = game.getLevel(level-1);
			BlockAssignment assignment;
			
			
			if(level <1 || level > game.maximumNumberOfLevels()) {
				throw new InvalidInputException("Level " + level + " does not exist for the game.");
			}
			
			if(newGridHorizontalPosition <= 0 || newGridHorizontalPosition>15) {
				throw new InvalidInputException("The horizontal position must be between 1 and " + 15 + ".");
			}
			if(newGridVerticalPosition <= 0 || newGridVerticalPosition>15) {
				throw new InvalidInputException("The vertical position must be between 1 and " + 15 + ".");
			}
			
			if(currentlevel.findBlockAssignment(oldGridHorizontalPosition, oldGridVerticalPosition)==null) {
				throw new InvalidInputException("A block does not exist at location" + oldGridHorizontalPosition + "/" + oldGridVerticalPosition + ".");
			}else {
				assignment= currentlevel.findBlockAssignment(oldGridHorizontalPosition, oldGridVerticalPosition);
				if(currentlevel.findBlockAssignment(newGridHorizontalPosition, newGridVerticalPosition)!=null) {
					throw new InvalidInputException("A block already exists at location" + newGridHorizontalPosition + "/" + newGridVerticalPosition + ".");
				}
				assignment.setGridHorizontalPosition(newGridHorizontalPosition);
				assignment.setGridVerticalPosition(newGridVerticalPosition);
			}
			
		
				
			
		}

		public static void removeBlock(int level, int gridHorizontalPosition, int gridVerticalPosition)
				throws InvalidInputException {
			
			 if(Block223Application.getCurrentUserRole() instanceof Admin ==false) {
			    	throw new InvalidInputException("Admin privileges are required to move a block.");
			    }
			    
			    if(Block223Application.getCurrentGame()==null) {
					throw new InvalidInputException("A game must be selected to move a block.");
				}
			    
			    if(Block223Application.getCurrentUserRole() != Block223Application.getCurrentGame().getAdmin()) {
	            	throw new InvalidInputException("Only the admin who created the game can move a block.");
				}
			
			Game game = Block223Application.getCurrentGame();
			Level currentlevel = game.getLevel(level);
			BlockAssignment assignment;
			
			assignment= currentlevel.findBlockAssignment(gridHorizontalPosition, gridVerticalPosition);
			
			if(assignment != null) {
				System.out.println("found");
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
			error="User not found.";
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
		if(Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information");
		}
		Block223 block223 = Block223Application.getBlock223();
		Admin admin = (Admin) Block223Application.getCurrentUserRole();

		List<TOGame> result = new ArrayList<TOGame>();

		List<Game> games = block223.getGames();

		for (Game game : games) {
			Admin gameAdmin = game.getAdmin();

			if (true) { // if gameAdmin.equals(admin), this is temporary for testing. 
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
		if(Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information");
		}
		if(Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to access its information"); 
		}
		if(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()) == false)
		{
			throw new InvalidInputException("Only the admin who created this game can access it's information"); 
		}
		Game thisgame = Block223Application.getCurrentGame();
		TOGame to = new TOGame(thisgame.getName(), thisgame.getLevels().size(), thisgame.getNrBlocksPerLevel(),
				thisgame.getBall().getMinBallSpeedX(), thisgame.getBall().getMinBallSpeedY(),
				thisgame.getBall().getBallSpeedIncreaseFactor(), thisgame.getPaddle().getMaxPaddleLength(),
				thisgame.getPaddle().getMinPaddleLength());
		return to;

	}

	public static List<TOBlock> getBlocksOfCurrentDesignableGame() throws InvalidInputException{
		if(Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information");
		}
		if(Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to access its information"); 
		}
		if(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()) == false)
		{
			throw new InvalidInputException("Only the admin who created this game can access it's information"); 
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
		if(Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information");
		}
		if(Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to access its information"); 
		}
		if(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()) == false)
		{
			throw new InvalidInputException("Only the admin who created this game can access it's information"); 
		}
		
		Game thisgame = Block223Application.getCurrentGame();
		Block thisblock = null; 
		try{
			thisblock = thisgame.findBlock(id); //should be findBlock not getBlock since ID not index
			if(thisblock == null) {
				throw new InvalidInputException("The block does not exist"); 
			}
		}
		catch(Exception e) {
			
		}

		TOBlock to = new TOBlock(thisblock.getId(), thisblock.getRed(), thisblock.getGreen(), thisblock.getBlue(),
				thisblock.getPoints());

		return to;
	}

	public static List<TOGridCell> getBlocksAtLevelOfCurrentDesignableGame(int level) throws InvalidInputException {
		if(Block223Application.getCurrentUserRole() instanceof Admin == false) {
			throw new InvalidInputException("Admin privileges are required to access game information");
		}
		if(Block223Application.getCurrentGame() == null) {
			throw new InvalidInputException("A game must be selected to access its information"); 
		}
		if(Block223Application.getCurrentUserRole().equals(Block223Application.getCurrentGame().getAdmin()) == false)
		{
			throw new InvalidInputException("Only the admin who created this game can access it's information"); 
		}
		
		Game thisgame = Block223Application.getCurrentGame();
		List<TOGridCell> result = new ArrayList<TOGridCell>();
		
		Level thislevel = null;
		try {
			thislevel = thisgame.getLevel(level);
		}
		catch(IndexOutOfBoundsException e) {
			throw new InvalidInputException("Level " + thislevel + " does not exist for the game.");
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
		}else if (thisrole instanceof Player) {
			to = new TOUserMode(Mode.Play);
		}else if (thisrole instanceof Admin) {
			to = new TOUserMode(Mode.Design);
		}
		return to;
	}
	
}
