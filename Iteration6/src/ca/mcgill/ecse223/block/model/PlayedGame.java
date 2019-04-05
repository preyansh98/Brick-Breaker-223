/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import ca.mcgill.ecse223.block.model.BouncePoint.BounceDirection;
import java.io.Serializable;
import java.util.*;

// line 18 "../../../../../Block223PlayMode.ump"
// line 109 "../../../../../Block223Persistence.ump"
// line 1 "../../../../../Block223States.ump"
public class PlayedGame implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------


  /**
   * at design time, the initial wait time may be adjusted as seen fit
   */
  public static final int INITIAL_WAIT_TIME = 30;
  private static int nextId = 1;
  public static final int NR_LIVES = 3;

  /**
   * the PlayedBall and PlayedPaddle are not in a separate class to avoid the bug in Umple that occurred for the second constructor of Game
   * no direct link to Ball, because the ball can be found by navigating to PlayedGame, Game, and then Ball
   */
  public static final int BALL_INITIAL_X = Game.PLAY_AREA_SIDE / 2;
  public static final int BALL_INITIAL_Y = Game.PLAY_AREA_SIDE / 2;

  /**
   * no direct link to Paddle, because the paddle can be found by navigating to PlayedGame, Game, and then Paddle
   * pixels moved when right arrow key is pressed
   */
  public static final int PADDLE_MOVE_RIGHT = 5;

  /**
   * pixels moved when left arrow key is pressed
   */
  public static final int PADDLE_MOVE_LEFT = -5;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PlayedGame Attributes
  private int score;
  private int lives;
  private int currentLevel;
  private double waitTime;
  private String playername;
  private double ballDirectionX;
  private double ballDirectionY;
  private double currentBallX;
  private double currentBallY;
  private double currentPaddleLength;
  private double currentPaddleX;
  private double currentPaddleY;
  private boolean gravityMode;
  private int counter;

  //Autounique Attributes
  private int id;

  //PlayedGame State Machines
  public enum PlayStatus { Ready, Moving, Paused, GameOver }
  private PlayStatus playStatus;

  //PlayedGame Associations
  private Player player;
  private Game game;
  private List<PlayedBlockAssignment> blocks;
  private BouncePoint bounce;
  private Block223 block223;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlayedGame(String aPlayername, Game aGame, Block223 aBlock223)
  {
    // line 59 "../../../../../Block223PlayMode.ump"
    boolean didAddGameResult = setGame(aGame);
          if (!didAddGameResult)
          {
             throw new RuntimeException("Unable to create playedGame due to game");
          }
    // END OF UMPLE BEFORE INJECTION
    score = 0;
    lives = NR_LIVES;
    currentLevel = 1;
    waitTime = INITIAL_WAIT_TIME;
    playername = aPlayername;
    resetBallDirectionX();
    resetBallDirectionY();
    resetCurrentBallX();
    resetCurrentBallY();
    currentPaddleLength = getGame().getPaddle().getMaxPaddleLength();
    resetCurrentPaddleX();
    currentPaddleY = Game.PLAY_AREA_SIDE - Paddle.VERTICAL_DISTANCE - Paddle.PADDLE_WIDTH;
    gravityMode = false;
    counter = 0;
    id = nextId++;
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create playedGame due to game");
    }
    blocks = new ArrayList<PlayedBlockAssignment>();
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create playedGame due to block223");
    }
    setPlayStatus(PlayStatus.Ready);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setScore(int aScore)
  {
    boolean wasSet = false;
    score = aScore;
    wasSet = true;
    return wasSet;
  }

  public boolean setLives(int aLives)
  {
    boolean wasSet = false;
    lives = aLives;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentLevel(int aCurrentLevel)
  {
    boolean wasSet = false;
    currentLevel = aCurrentLevel;
    wasSet = true;
    return wasSet;
  }

  public boolean setWaitTime(double aWaitTime)
  {
    boolean wasSet = false;
    waitTime = aWaitTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setPlayername(String aPlayername)
  {
    boolean wasSet = false;
    playername = aPlayername;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setBallDirectionX(double aBallDirectionX)
  {
    boolean wasSet = false;
    ballDirectionX = aBallDirectionX;
    wasSet = true;
    return wasSet;
  }

  public boolean resetBallDirectionX()
  {
    boolean wasReset = false;
    ballDirectionX = getDefaultBallDirectionX();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setBallDirectionY(double aBallDirectionY)
  {
    boolean wasSet = false;
    ballDirectionY = aBallDirectionY;
    wasSet = true;
    return wasSet;
  }

  public boolean resetBallDirectionY()
  {
    boolean wasReset = false;
    ballDirectionY = getDefaultBallDirectionY();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setCurrentBallX(double aCurrentBallX)
  {
    boolean wasSet = false;
    currentBallX = aCurrentBallX;
    wasSet = true;
    return wasSet;
  }

  public boolean resetCurrentBallX()
  {
    boolean wasReset = false;
    currentBallX = getDefaultCurrentBallX();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setCurrentBallY(double aCurrentBallY)
  {
    boolean wasSet = false;
    currentBallY = aCurrentBallY;
    wasSet = true;
    return wasSet;
  }

  public boolean resetCurrentBallY()
  {
    boolean wasReset = false;
    currentBallY = getDefaultCurrentBallY();
    wasReset = true;
    return wasReset;
  }

  public boolean setCurrentPaddleLength(double aCurrentPaddleLength)
  {
    boolean wasSet = false;
    currentPaddleLength = aCurrentPaddleLength;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setCurrentPaddleX(double aCurrentPaddleX)
  {
    boolean wasSet = false;
    currentPaddleX = aCurrentPaddleX;
    wasSet = true;
    return wasSet;
  }

  public boolean resetCurrentPaddleX()
  {
    boolean wasReset = false;
    currentPaddleX = getDefaultCurrentPaddleX();
    wasReset = true;
    return wasReset;
  }

  public boolean setGravityMode(boolean aGravityMode)
  {
    boolean wasSet = false;
    gravityMode = aGravityMode;
    wasSet = true;
    return wasSet;
  }

  public boolean setCounter(int aCounter)
  {
    boolean wasSet = false;
    counter = aCounter;
    wasSet = true;
    return wasSet;
  }

  public int getScore()
  {
    return score;
  }

  public int getLives()
  {
    return lives;
  }

  public int getCurrentLevel()
  {
    return currentLevel;
  }

  public double getWaitTime()
  {
    return waitTime;
  }

  /**
   * added here so that it only needs to be determined once
   */
  public String getPlayername()
  {
    return playername;
  }

  /**
   * 0/0 is the top left corner of the play area, i.e., a directionX/Y of 0/1 moves the ball down in a straight line
   */
  public double getBallDirectionX()
  {
    return ballDirectionX;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultBallDirectionX()
  {
    return getGame().getBall().getMinBallSpeedX();
  }

  public double getBallDirectionY()
  {
    return ballDirectionY;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultBallDirectionY()
  {
    return getGame().getBall().getMinBallSpeedY();
  }

  /**
   * the position of the ball is at the center of the ball
   */
  public double getCurrentBallX()
  {
    return currentBallX;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultCurrentBallX()
  {
    return BALL_INITIAL_X;
  }

  public double getCurrentBallY()
  {
    return currentBallY;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultCurrentBallY()
  {
    return BALL_INITIAL_Y;
  }

  public double getCurrentPaddleLength()
  {
    return currentPaddleLength;
  }

  /**
   * the position of the paddle is at its top right corner
   */
  public double getCurrentPaddleX()
  {
    return currentPaddleX;
  }
  /* Code from template attribute_GetDefaulted */
  public double getDefaultCurrentPaddleX()
  {
    return (Game.PLAY_AREA_SIDE - currentPaddleLength) / 2;
  }

  public double getCurrentPaddleY()
  {
    return currentPaddleY;
  }

  public boolean getGravityMode()
  {
    return gravityMode;
  }

  public int getCounter()
  {
    return counter;
  }

  public int getId()
  {
    return id;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isGravityMode()
  {
    return gravityMode;
  }

  public String getPlayStatusFullName()
  {
    String answer = playStatus.toString();
    return answer;
  }

  public PlayStatus getPlayStatus()
  {
    return playStatus;
  }

  public boolean play()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Ready:
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      case Paused:
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean pause()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Moving:
        setPlayStatus(PlayStatus.Paused);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean move()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Moving:
        if (blockOutOfBoundAndLastLife())
        {
        // line 13 "../../../../../Block223States.ump"
          doBlockOutOfBound();
          setPlayStatus(PlayStatus.GameOver);
          wasEventProcessed = true;
          break;
        }
        if (blockOutOfBound())
        {
        // line 14 "../../../../../Block223States.ump"
          doBlockOutOfBound();
          setPlayStatus(PlayStatus.Paused);
          wasEventProcessed = true;
          break;
        }
        if (hitPaddle())
        {
        // line 15 "../../../../../Block223States.ump"
          doHitPaddleOrWall();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        if (isOutOfBoundsAndLastLife())
        {
        // line 16 "../../../../../Block223States.ump"
          doOutOfBounds();
          setPlayStatus(PlayStatus.GameOver);
          wasEventProcessed = true;
          break;
        }
        if (isOutOfBounds())
        {
        // line 17 "../../../../../Block223States.ump"
          doOutOfBounds();
          setPlayStatus(PlayStatus.Paused);
          wasEventProcessed = true;
          break;
        }
        if (hitLastBlockAndLastLevel())
        {
        // line 18 "../../../../../Block223States.ump"
          doHitBlock();
          setPlayStatus(PlayStatus.GameOver);
          wasEventProcessed = true;
          break;
        }
        if (hitLastBlock())
        {
        // line 19 "../../../../../Block223States.ump"
          doHitBlockNextLevel();
          setPlayStatus(PlayStatus.Ready);
          wasEventProcessed = true;
          break;
        }
        if (hitBlock())
        {
        // line 20 "../../../../../Block223States.ump"
          doHitBlock();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        if (hitWall())
        {
        // line 21 "../../../../../Block223States.ump"
          doHitPaddleOrWall();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        // line 22 "../../../../../Block223States.ump"
        doHitNothingAndNotOutOfBounds();
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setPlayStatus(PlayStatus aPlayStatus)
  {
    playStatus = aPlayStatus;

    // entry actions and do activities
    switch(playStatus)
    {
      case Ready:
        // line 7 "../../../../../Block223States.ump"
        doSetup();
        break;
      case Moving:
        // line 11 "../../../../../Block223States.ump"
        moveBlocks();
        break;
      case GameOver:
        // line 28 "../../../../../Block223States.ump"
        doGameOver();
        break;
    }
  }
  /* Code from template association_GetOne */
  public Player getPlayer()
  {
    return player;
  }

  public boolean hasPlayer()
  {
    boolean has = player != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_GetMany */
  public PlayedBlockAssignment getBlock(int index)
  {
    PlayedBlockAssignment aBlock = blocks.get(index);
    return aBlock;
  }

  public List<PlayedBlockAssignment> getBlocks()
  {
    List<PlayedBlockAssignment> newBlocks = Collections.unmodifiableList(blocks);
    return newBlocks;
  }

  public int numberOfBlocks()
  {
    int number = blocks.size();
    return number;
  }

  public boolean hasBlocks()
  {
    boolean has = blocks.size() > 0;
    return has;
  }

  public int indexOfBlock(PlayedBlockAssignment aBlock)
  {
    int index = blocks.indexOf(aBlock);
    return index;
  }
  /* Code from template association_GetOne */
  public BouncePoint getBounce()
  {
    return bounce;
  }

  public boolean hasBounce()
  {
    boolean has = bounce != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Block223 getBlock223()
  {
    return block223;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setPlayer(Player aPlayer)
  {
    boolean wasSet = false;
    Player existingPlayer = player;
    player = aPlayer;
    if (existingPlayer != null && !existingPlayer.equals(aPlayer))
    {
      existingPlayer.removePlayedGame(this);
    }
    if (aPlayer != null)
    {
      aPlayer.addPlayedGame(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGame(Game aGame)
  {
    boolean wasSet = false;
    if (aGame == null)
    {
      return wasSet;
    }

    Game existingGame = game;
    game = aGame;
    if (existingGame != null && !existingGame.equals(aGame))
    {
      existingGame.removePlayedGame(this);
    }
    game.addPlayedGame(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBlocks()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PlayedBlockAssignment addBlock(int aX, int aY, Block aBlock)
  {
    return new PlayedBlockAssignment(aX, aY, aBlock, this);
  }

  public boolean addBlock(PlayedBlockAssignment aBlock)
  {
    boolean wasAdded = false;
    if (blocks.contains(aBlock)) { return false; }
    PlayedGame existingPlayedGame = aBlock.getPlayedGame();
    boolean isNewPlayedGame = existingPlayedGame != null && !this.equals(existingPlayedGame);
    if (isNewPlayedGame)
    {
      aBlock.setPlayedGame(this);
    }
    else
    {
      blocks.add(aBlock);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBlock(PlayedBlockAssignment aBlock)
  {
    boolean wasRemoved = false;
    //Unable to remove aBlock, as it must always have a playedGame
    if (!this.equals(aBlock.getPlayedGame()))
    {
      blocks.remove(aBlock);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBlockAt(PlayedBlockAssignment aBlock, int index)
  {  
    boolean wasAdded = false;
    if(addBlock(aBlock))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBlocks()) { index = numberOfBlocks() - 1; }
      blocks.remove(aBlock);
      blocks.add(index, aBlock);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBlockAt(PlayedBlockAssignment aBlock, int index)
  {
    boolean wasAdded = false;
    if(blocks.contains(aBlock))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBlocks()) { index = numberOfBlocks() - 1; }
      blocks.remove(aBlock);
      blocks.add(index, aBlock);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBlockAt(aBlock, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setBounce(BouncePoint aNewBounce)
  {
    boolean wasSet = false;
    bounce = aNewBounce;
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBlock223(Block223 aBlock223)
  {
    boolean wasSet = false;
    if (aBlock223 == null)
    {
      return wasSet;
    }

    Block223 existingBlock223 = block223;
    block223 = aBlock223;
    if (existingBlock223 != null && !existingBlock223.equals(aBlock223))
    {
      existingBlock223.removePlayedGame(this);
    }
    block223.addPlayedGame(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (player != null)
    {
      Player placeholderPlayer = player;
      this.player = null;
      placeholderPlayer.removePlayedGame(this);
    }
    Game placeholderGame = game;
    this.game = null;
    if(placeholderGame != null)
    {
      placeholderGame.removePlayedGame(this);
    }
    while (blocks.size() > 0)
    {
      PlayedBlockAssignment aBlock = blocks.get(blocks.size() - 1);
      aBlock.delete();
      blocks.remove(aBlock);
    }
    
    bounce = null;
    Block223 placeholderBlock223 = block223;
    this.block223 = null;
    if(placeholderBlock223 != null)
    {
      placeholderBlock223.removePlayedGame(this);
    }
  }

  // line 114 "../../../../../Block223Persistence.ump"
   public static  void reinitializeAutouniqueID(List<PlayedGame> games){
    nextId=0;
  	for(PlayedGame game: games){
  		
  			if(game.getId()>nextId){
  				nextId=game.getId();
  			}
  		}
  		nextId++;
  }


  /**
   * Guards
   */
  // line 34 "../../../../../Block223States.ump"
   private boolean blockOutOfBoundAndLastLife(){
    if(!gravityMode)return false;
  	if(this.getLives() ==1){
  		 for( PlayedBlockAssignment block : getBlocks()) {
		  	if (block.getY()>340){
		  		return true;
		  	}
		  } 
	  }
  	return false;
  }

  // line 45 "../../../../../Block223States.ump"
   private boolean blockOutOfBound(){
    if(!gravityMode)return false;
  	for( PlayedBlockAssignment block : getBlocks()) {
		  	if (block.getY()>340){
		  		return true;
		  	}   
	 }
		return false;
  }

  // line 55 "../../../../../Block223States.ump"
   private boolean hitPaddle(){
    BouncePoint bp=calculateBouncePointPaddle();
    setBounce(bp);
    return bp!=null;
  }

  // line 61 "../../../../../Block223States.ump"
   private boolean isOutOfBoundsAndLastLife(){
    boolean outOfBounds = false;
     if (this.getLives() ==1) {
    	outOfBounds = isBallOutOfBounds();
    }
    return outOfBounds;
  }

  // line 69 "../../../../../Block223States.ump"
   private boolean isOutOfBounds(){
    Boolean outOfBounds = isBallOutOfBounds();
    
    return outOfBounds;
  }

  // line 74 "../../../../../Block223States.ump"
   private boolean isBallOutOfBounds(){
    boolean outofbounds= false;
	   if (this.getCurrentBallY() + this.getBallDirectionY() > 360) {
		   outofbounds=true;
	   }
	   return outofbounds;
  }

  // line 83 "../../../../../Block223States.ump"
   private boolean hitLastBlockAndLastLevel(){
    Game game = this.getGame(); 
	int nrLevels = game.numberOfLevels(); 
	
	this.setBounce(null); 
	
	if(nrLevels == currentLevel) {
		int nrBlocks = numberOfBlocks(); 
		if(nrBlocks == 1) {
			PlayedBlockAssignment block = this.getBlock(0); 
			BouncePoint bp = calculateBouncePointBlock(block); 
			setBounce(bp); 
			return (bp!=null); 
		}
	}
    return false;
  }

  // line 101 "../../../../../Block223States.ump"
   private boolean hitLastBlock(){
    int nrBlocks = numberOfBlocks(); 
	setBounce(null); 
	
	if(nrBlocks == 1) {
		PlayedBlockAssignment block = this.getBlock(0); 
		BouncePoint bp = calculateBouncePointBlock(block);
		setBounce(bp); 
		return (bp!=null); 
	}
    return false;
  }

  // line 115 "../../../../../Block223States.ump"
   private boolean hitBlock(){
    int nrBlocks = numberOfBlocks();
	   setBounce(null); 
	   
	   for( PlayedBlockAssignment block : getBlocks()) {
		   BouncePoint bp = calculateBouncePointBlock(block); 		   
		   bounce = getBounce(); 
		   boolean closer = isCloser(bp, bounce); 
		   if(closer) {
		   bp.setHitBlock(block);
		   setBounce(bp);
		   } 
	   }
	   return (getBounce()!=null);
  }

  // line 131 "../../../../../Block223States.ump"
   private boolean hitWall(){
    BouncePoint bp=calculateBouncePointWall();
    setBounce(bp);
    return bp!=null;
  }


  /**
   * Actions
   */
  // line 140 "../../../../../Block223States.ump"
   private void moveBlocks(){
    if (gravityMode){
 		
 			counter++;
 		if(counter%5==0){
 		int lowestY=0;
 		for (PlayedBlockAssignment blockassi:getBlocks()){
		   		if(lowestY<blockassi.getY()){
		   			lowestY=blockassi.getY();
		   		}
		  }
		  for (PlayedBlockAssignment blockassi:getBlocks()){
		   		if(lowestY==blockassi.getY()){
		   			blockassi.setY(blockassi.getY()+1);
		   		}
		  }
		   
		}
 	}
  }

  // line 162 "../../../../../Block223States.ump"
   private void doSetup(){
    resetCurrentBallX(); 
	   resetCurrentBallY(); 
	   resetBallDirectionX(); 
	   resetBallDirectionY(); 
	   resetCurrentPaddleX(); 
	   
	   Game game = getGame(); 
	   
	   Level level = game.getLevel(currentLevel - 1); 
	   List<BlockAssignment> assignments = level.getBlockAssignments(); 
	   
	   for(BlockAssignment a : assignments) {
		   PlayedBlockAssignment pblock = new PlayedBlockAssignment(
				   game.WALL_PADDING + (Block.SIZE + game.COLUMNS_PADDING)* (a.getGridHorizontalPosition() - 1),
				   game.WALL_PADDING +(Block.SIZE + game.ROW_PADDING)*(a.getGridVerticalPosition() - 1), 
						   a.getBlock(), this); 
	   }
	   
	   while(numberOfBlocks() < game.getNrBlocksPerLevel()) {
		   //pick x and y randomly: 
		   //first pick a grid position randomly 
		   //if its already taken, try next position starting from the randomly 
		   Random rand=new Random();
		   int x = game.WALL_PADDING + (Block.SIZE + game.COLUMNS_PADDING)*rand.nextInt(15); 
		   int y =  game.WALL_PADDING +(Block.SIZE + game.ROW_PADDING)*rand.nextInt(15); 
		   boolean found=false;
		   for (PlayedBlockAssignment blockassi:getBlocks()){
		   		if(blockassi.getX()==x && blockassi.getY()==y){
		   			found=true;
		   			break;
		   		}
		   }
		   if(!found){
		   	PlayedBlockAssignment pblock = new PlayedBlockAssignment(x, y, game.getRandomBlock(), this);
		   } 
	   }
  }

  // line 203 "../../../../../Block223States.ump"
   private void doHitPaddleOrWall(){
    bounceBall();
  }

  // line 207 "../../../../../Block223States.ump"
   private void doOutOfBounds(){
    this.setLives(lives-1);
    this.resetCurrentBallX();
    this.resetCurrentBallY();
    this.resetBallDirectionX();
    this.resetBallDirectionY();
    this.resetCurrentPaddleX();
  }

  // line 215 "../../../../../Block223States.ump"
   private void doBlockOutOfBound(){
    this.setLives(lives-1);
    this.resetCurrentBallX();
    this.resetCurrentBallY();
    this.resetBallDirectionX();
    this.resetBallDirectionY();
    this.resetCurrentPaddleX();
	int lowestY=0;
 	for (PlayedBlockAssignment blockassi:getBlocks()){
		  	if(lowestY<blockassi.getY()){
		   		lowestY=blockassi.getY();
		  	}
	}
	 for (PlayedBlockAssignment blockassi:getBlocks()){
	  		if(lowestY==blockassi.getY()){
		  		blockassi.setY(blockassi.getY()-counter/5);
		   	}
	}
  }

  // line 236 "../../../../../Block223States.ump"
   private void doHitBlock(){
    int score = getScore(); 
	   bounce = getBounce(); 
	   PlayedBlockAssignment pblock = bounce.getHitBlock(); 
	   
	   Block block = pblock.getBlock(); 
	   int bscore = block.getPoints();
	   
	   this.setScore(score + bscore); 
	   pblock.delete();
	   bounceBall();
  }

  // line 249 "../../../../../Block223States.ump"
   private void doHitBlockNextLevel(){
    doHitBlock(); 
	   int level = getCurrentLevel(); 
	   setCurrentLevel(level+1); 
	   
	   setCurrentPaddleLength(getGame().getPaddle().getMaxPaddleLength() -
			   (getGame().getPaddle().getMaxPaddleLength() - getGame().getPaddle().getMinPaddleLength())/
			   (getGame().numberOfLevels() - 1) * (getCurrentLevel() - 1));
	   
	   setWaitTime(INITIAL_WAIT_TIME * Math.pow(getGame().getBall().getBallSpeedIncreaseFactor(), 
			   (getCurrentLevel() - 1)));
  }

  // line 262 "../../../../../Block223States.ump"
   private void doHitNothingAndNotOutOfBounds(){
    double x = getCurrentBallX();
	  double y = getCurrentBallY();
	  double dx = getBallDirectionX();
	  double dy = getBallDirectionY();
	  setCurrentBallX(x + dx);
	  setCurrentBallY(y + dy);
  }

  // line 270 "../../../../../Block223States.ump"
   private void doGameOver(){
    Block223 block223 = this.getBlock223();
	   Player p = this.getPlayer();
	   
	   if (p != null) {
		   Game game = this.getGame();
		   HallOfFameEntry hof = new HallOfFameEntry(this.score, this.getPlayername(), p, game, block223);
		   game.setMostRecentEntry(hof);
	   }
	   this.delete();
  }


  /**
   * Helper methods
   */
  // line 284 "../../../../../Block223States.ump"
   private BouncePoint calculateBouncePointPaddle(){
    double x=getCurrentPaddleX();
  	double y=getCurrentPaddleY();
  	double length=getCurrentPaddleLength();
  	int radius=Ball.BALL_DIAMETER/2;
  	int width=Paddle.PADDLE_WIDTH;
  	Rectangle2D rectA=new Rectangle2D.Double(x,y-radius,length,width );
  	Rectangle2D rectB=new Rectangle2D.Double(x-radius,y,radius,width );
  	Rectangle2D rectC=new Rectangle2D.Double(x+length,y,radius,width );
  	Rectangle2D rectF=new Rectangle2D.Double(x+length,y-radius,radius,radius);
  	Rectangle2D rectE=new Rectangle2D.Double(x-radius,y-radius,radius,radius);
   	double currentX=getCurrentBallX();
    double currentY=getCurrentBallY();
   	double dX=getBallDirectionX();
    double dY=getBallDirectionY();
  	Line2D segment=new Line2D.Double(currentX,currentY,currentX+dX,currentY+dY);
  	
  	if(segment.intersects(rectA)){
  		if(dX==0){
  			return new BouncePoint(currentX,y-radius,BounceDirection.FLIP_Y);
  		}else{
  			double a=dY/dX;
  			double b=currentY-a*currentX;
  			double bounceY=y-radius;
  			double bounceX=(bounceY-b)/a;
  			if((currentX+dX)==bounceX && (currentY+dY)==bounceY){
	  				return null;
	  			}
  			return new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_Y);
  		}
  	}else if(segment.intersects(rectB)){
  		if(dX!=0){
  			double a=dY/dX;
  			double b=currentY-a*currentX;
  			double bounceX=x-radius;
  			double bounceY=a*bounceX+b;
  			if((currentX+dX)==bounceX && (currentY+dY)==bounceY){
	  				return null;
	  			}
  			return new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_X);
  		}
  	}else if(segment.intersects(rectC)){
  		if(dX!=0){
  			double a=dY/dX;
  			double b=currentY-a*currentX;
  			double bounceX=x+length+radius;
  			double bounceY=a*bounceX+b;
  			if((currentX+dX)==bounceX && (currentY+dY)==bounceY){
	  				return null;
	  			}
  			return new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_X);
  		}
  	}else if(segment.intersects(rectE) && !(dX<0 &&dY<0)){
  			double a;
  			if(dX!=0){
  				a=dY/dX;
  			}else {
  				a=0;
  			}
  			double b=currentY-a*currentX;
  			double A=1+Math.pow(a,2);
  			double B=2*a*(b-y)-2*x;
  			double C=Math.pow(x,2)+Math.pow(b-y,2)-Math.pow(radius,2);
  			double delta=Math.sqrt(Math.pow(B,2)-4*A*C);
  			double X1=(-B-delta)/(2*A);
  			double X2=(-B+delta)/(2*A);
  			double X=0;
  			if(Math.abs(currentX-X1)< Math.abs(currentX-X2)) {
  				X=X1;
  			}else {
  				X=X2;
  			}
  			double Y=a*X+b;
  			if((currentX+dX)==X && (currentY+dY)==Y){
	  				return null;
	  			}
  			if(Double.isNaN(X) || Double.isNaN(Y)){
				  				return null;
				  			}
  			if (dX<0){
  				return new BouncePoint(X,Y, BounceDirection.FLIP_Y);
  			}else{
  				return new BouncePoint(X,Y, BounceDirection.FLIP_X);
  			}
  		
  	}else if(segment.intersects(rectF) && !(dX>0 &&dY<0)){
  			double a;
  			if(dX!=0){
  				a=dY/dX;
  			}else {
  				a=0;
  			}
  			double b=currentY-a*currentX;
  			double A=1+Math.pow(a,2);
  			double B=2*a*(b-y)-2*(x+length);
  			double C=Math.pow((x+length),2)+Math.pow(b-y,2)-Math.pow(radius,2);
  			double delta=Math.sqrt(Math.pow(B,2)-4*A*C);
  			double X1=(-B-delta)/(2*A);
  			double X2=(-B+delta)/(2*A);
  			double X=0;
  			if(Math.abs(currentX-X1)< Math.abs(currentX-X2)) {
  				X=X1;
  			}else {
  				X=X2;
  			}
  			double Y=a*X+b;
  			if((currentX+dX)==X && (currentY+dY)==Y){
	  				return null;
	  			}
  			if(Double.isNaN(X) || Double.isNaN(Y)){
				  				return null;
				  			}
  			if (dX<0){
  				return new BouncePoint(X,Y, BounceDirection.FLIP_X);
  			}else{
  				return new BouncePoint(X,Y, BounceDirection.FLIP_Y);
  			}
  		
  	}
  	return null;
  }

  // line 406 "../../../../../Block223States.ump"
   private BouncePoint calculateBouncePointWall(){
    double currentX=getCurrentBallX();
   double currentY=getCurrentBallY();
   double dX=getBallDirectionX();
   double dY=getBallDirectionY();
   
   if(currentY+dY<=5){
   		if(currentX+dX<=5){
   			return  new BouncePoint(5.0,5.0, BounceDirection.FLIP_BOTH);
   		}else if(currentX+dX>=385){
   			return  new BouncePoint(385.0,5.0, BounceDirection.FLIP_BOTH);
   		}else{
   			if(dX!=0){
   				double a=dY/dX;
  				double b=currentY-a*currentX;
  				double bounceY=5.0f;
  				double bounceX=(bounceY-b)/a;
  				return new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_Y);
  			}else{
  				return new BouncePoint(currentX, 5.0, BounceDirection.FLIP_Y);
  			}
   		}
    }
    
    if(currentX+dX<=5){
    	if(dX!=0){
   				double a=dY/dX;
  				double b=currentY-a*currentX;
  				double bounceX=5.0f;
  				double bounceY=a*bounceX+b;
  				
  				return new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_X);
  		}
    }
    if(currentX+dX>=385){
    	if(dX!=0){
   				double a=dY/dX;
  				double b=currentY-a*currentX;
  				double bounceX=385.0f;
  				double bounceY=a*bounceX+b;
  				
  				return new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_X);
  		}
    }
  	return null;
  }

  // line 453 "../../../../../Block223States.ump"
   private void bounceBall(){
    BouncePoint bp=getBounce();
  	double currentX=getCurrentBallX();
  	double currentY=getCurrentBallY();
  	double incomingX=bp.getX()-currentX;
  	double incomingY=bp.getY()-currentY;
  	double remainingX=getBallDirectionX()-incomingX;
  	double remainingY=getBallDirectionY()-incomingY;
  	if(remainingX==0 && remainingY==0){
  		setCurrentBallX(bp.getX());
  		setCurrentBallY(bp.getY());
  	}else{
  		double newDirX,newDirY,newX,newY;
  		if(bp.getDirection()==BounceDirection.FLIP_X){
  			 newDirX=-getBallDirectionX();
  			 newDirY=getBallDirectionY()+sign(getBallDirectionY())*0.1*Math.abs(newDirX);
  			 if(getBallDirectionX()!=0){
  			 newX=bp.getX()+remainingX*newDirX/getBallDirectionX();
  			 }else {
  			 newX=bp.getX()+remainingY*newDirX/getBallDirectionY();
  			 }
  			 if(getBallDirectionY()!=0){
  				 newY=bp.getY()+remainingY*newDirY/getBallDirectionY();
  			 }else{
  			 	newY=bp.getY()+remainingX*newDirY/getBallDirectionX();
  			 }
  		}else if (bp.getDirection()==BounceDirection.FLIP_Y){
  			 newDirY=-getBallDirectionY();
  			 newDirX=getBallDirectionX()+sign(getBallDirectionX())*0.1*Math.abs(newDirY);
  			if(getBallDirectionX()!=0){
  			 newX=bp.getX()+remainingX*newDirX/getBallDirectionX();
  			 }else {
  			 newX=bp.getX()+remainingY*newDirX/getBallDirectionY();
  			 }
  			 if(getBallDirectionY()!=0){
  				 newY=bp.getY()+remainingY*newDirY/getBallDirectionY();
  			 }else{
  			 	newY=bp.getY()+remainingX*newDirY/getBallDirectionX();
  			 }
  		}else{
  			 newDirX=-getBallDirectionX();
  			 newDirY=-getBallDirectionY();
  			if(getBallDirectionX()!=0){
  			 newX=bp.getX()+remainingX*newDirX/getBallDirectionX();
  			 }else {
  			 newX=bp.getX()+remainingY*newDirX/getBallDirectionY();
  			 }
  			 if(getBallDirectionY()!=0){
  				 newY=bp.getY()+remainingY*newDirY/getBallDirectionY();
  			 }else{
  			 	newY=bp.getY()+remainingX*newDirY/getBallDirectionX();
  			 }
  		}
  			setCurrentBallX(newX);
  			setCurrentBallY(newY);
  			setBallDirectionX(newDirX);
  			setBallDirectionY(newDirY);
  	}
  	setBounce(null);
  }

  // line 513 "../../../../../Block223States.ump"
   private int sign(double val){
    if(val>=0){
			return 1;
		}  
		return -1;
  }

  // line 521 "../../../../../Block223States.ump"
   private BouncePoint calculateBouncePointBlock(PlayedBlockAssignment block){
    int x=block.getX();
	  	int y=block.getY();
	  	int length=block.getBlock().SIZE;
	  	int radius=Ball.BALL_DIAMETER/2;
	  	int width=block.getBlock().SIZE;

	  	Rectangle2D rectA=new Rectangle2D.Double(x,y-radius,length,radius );
	  	Rectangle2D rectB=new Rectangle2D.Double(x-radius,y,radius,length );
	  	Rectangle2D rectC=new Rectangle2D.Double(x+length,y,radius,length );
	  	Rectangle2D rectF=new Rectangle2D.Double(x+length,y-radius,radius,radius);  	
	  	Rectangle2D rectE=new Rectangle2D.Double(x-radius,y-radius,radius,radius);
	  	
	  	Rectangle2D rectG=new Rectangle2D.Double(x-radius,y+length,radius,radius);
	  	Rectangle2D rectD=new Rectangle2D.Double(x,y+length,length,radius);
	  	Rectangle2D rectH=new Rectangle2D.Double(x+length,y+length,radius,radius);
	  	
	   	double currentX=getCurrentBallX();
	    double currentY=getCurrentBallY();
	   	double dX=getBallDirectionX();
	    double dY=getBallDirectionY();
	  	Line2D segment=new Line2D.Double(currentX,currentY,currentX+dX,currentY+dY);
	  	if(segment.intersects(rectA)){
	  		if(dX==0){
	  			BouncePoint bp= new BouncePoint(currentX,y-radius,BounceDirection.FLIP_Y);
	  			bp.setHitBlock(block);
	  			return bp;
	  		}else{
	  			double a=dY/dX;
	  			double b=currentY-a*currentX;
	  			double bounceY=y-radius;
	  			double bounceX=(bounceY-b)/a;
	  			if((currentX+dX)==bounceX && (currentY+dY)==bounceY){
	  				return null;
	  			}
	  			BouncePoint bp= new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_Y);
	  			bp.setHitBlock(block);
	  			return bp;
	  		}
	  	}
		 if(segment.intersects(rectB)){
	  		if(dX!=0){
	  			double a=dY/dX;
	  			double b=currentY-a*currentX;
	  			double bounceX=x-radius;
	  			double bounceY=a*bounceX+b;
	  			if((currentX+dX)==bounceX && (currentY+dY)==bounceY){
	  				return null;
	  			}
	  			BouncePoint bp= new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_X);
	  			bp.setHitBlock(block);
	  			return bp;
	  		}
	  	}
		 if(segment.intersects(rectC)){
	  		if(dX!=0){
	  			double a=dY/dX;
	  			double b=currentY-a*currentX;
	  			double bounceX=x+radius+length;
	  			double bounceY=a*bounceX+b;
	  			if((currentX+dX)==bounceX && (currentY+dY)==bounceY){
	  				return null;
	  			}
	  			BouncePoint bp= new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_X);
	  			bp.setHitBlock(block);
	  			return bp;
	  		}
	  	}	
	  	 if(segment.intersects(rectE) && !(dX<0 &&dY<0)){
	  		double a;
  			if(dX!=0){
  				a=dY/dX;
  			}else {
  				a=0;
  			}
	  			
	  			double b=currentY-a*currentX;
	  			double A=1+Math.pow(a,2);
	  			double B=2*a*(b-y)-2*x;
	  			double C=Math.pow(x,2)+Math.pow(b-y,2)-Math.pow(radius,2);
	  			double delta=Math.sqrt(Math.pow(B,2)-4*A*C);
	  			double X1=(-B-delta)/(2*A);
  			double X2=(-B+delta)/(2*A);
  			double X=0;
  			if(Math.abs(currentX-X1)< Math.abs(currentX-X2)) {
  				X=X1;
  			}else {
  				X=X2;
  			}
	  			double Y=a*X+b;
	  			if((currentX+dX)==X && (currentY+dY)==Y){
	  				return null;
	  			}
	  			if(Double.isNaN(X) || Double.isNaN(Y)){
				  				return null;
				  			}
	  			if (dX<0){
	  				BouncePoint bp= new BouncePoint(X,Y, BounceDirection.FLIP_Y);
	  				bp.setHitBlock(block);
	  				return bp;
	  			}else{
	  				BouncePoint bp= new BouncePoint(X,Y, BounceDirection.FLIP_X);
	  				bp.setHitBlock(block);
	  				return bp;
	  			}
	  		
	  	}
	  		 if(segment.intersects(rectF) && !(dX>0 &&dY<0)){
	  		double a;
  			if(dX!=0){
  				a=dY/dX;
  			}else {
  				a=0;
  			}
	  			
	  			double b=currentY-a*currentX;
	  			double A=1+Math.pow(a,2);
	  			double B=2*a*(b-y)-2*(x+length);
	  			double C=Math.pow((x+length),2)+Math.pow(b-y,2)-Math.pow(radius,2);
	  			double delta=Math.sqrt(Math.pow(B,2)-4*A*C);
	  			double X1=(-B-delta)/(2*A);
  			double X2=(-B+delta)/(2*A);
  			double X=0;
  			if(Math.abs(currentX-X1)< Math.abs(currentX-X2)) {
  				X=X1;
  			}else {
  				X=X2;
  			}
	  			double Y=a*X+b;
	  			if((currentX+dX)==X && (currentY+dY)==Y){
	  				return null;
	  			}
	  			if(Double.isNaN(X) || Double.isNaN(Y)){
				  				return null;
				  			}
	  			if (dX<0){
	  				BouncePoint bp= new BouncePoint(X,Y, BounceDirection.FLIP_X);
	  				bp.setHitBlock(block);
	  				return bp;
	  			}else{
	  				BouncePoint bp= new BouncePoint(X,Y, BounceDirection.FLIP_Y);
	  				bp.setHitBlock(block);
	  					return bp;
	  			}
	  		}
	  		 if(segment.intersects(rectG)&& !(dX<0 &&dY>0)){
		  			double a;
  					if(dX!=0){
  						a=dY/dX;
  					}else {
  						a=0;
  					}
		  			double b=currentY-a*currentX;
		  			double A=1+Math.pow(a,2);
		  			double B=2*a*(b-y-length)-2*(x);
		  			double C=Math.pow((x),2)+Math.pow(b-y-length,2)-Math.pow(radius,2);
		  			double delta=Math.sqrt(Math.pow(B,2)-4*A*C);
		  			double X1=(-B-delta)/(2*A);
  			double X2=(-B+delta)/(2*A);
  			double X=0;
  			if(Math.abs(currentX-X1)< Math.abs(currentX-X2)) {
  				X=X1;
  			}else {
  				X=X2;
  			}
		  			double Y=a*X+b;
		  			if((currentX+dX)==X && (currentY+dY)==Y){
	  				return null;
	  			}
		  			if(Double.isNaN(X) || Double.isNaN(Y)){
				  				return null;
				  			}
		  			if (dX<0){
		  				BouncePoint bp= new BouncePoint(X,Y, BounceDirection.FLIP_Y);
		  				bp.setHitBlock(block);
	  					return bp;
		  			}else{
		  				BouncePoint bp= new BouncePoint(X,Y, BounceDirection.FLIP_X);
		  				bp.setHitBlock(block);
	  					return bp;
		  			}
		  		
	  		}
		  		 if(segment.intersects(rectD)){
			  		if(dX!=0){
			  			double a=dY/dX;
			  			double b=currentY-a*currentX;
			  			double bounceY=y+length+radius;
			  			double bounceX=(bounceY-b)/a;
			  			if((currentX+dX)==bounceX && (currentY+dY)==bounceY){
	  				return null;
	  			}
			  			BouncePoint bp= new BouncePoint(bounceX,bounceY,BounceDirection.FLIP_Y);
			  			bp.setHitBlock(block);
	  					return bp;
			  		}else{
			  			BouncePoint bp= new BouncePoint(currentX,y+length+radius,BounceDirection.FLIP_Y);
	  					bp.setHitBlock(block);
	  					return bp;
			  		}
		  		}
			  	 if(segment.intersects(rectH)&& !(dX>0 &&dY>0)){
				  			double a;
  							if(dX!=0){
  								a=dY/dX;
  							}else {
  								a=0;
  							}
				  			double b=currentY-a*currentX;
				  			double A=1+Math.pow(a,2);
				  			double B=2*a*(b-y-length)-2*(x+length);
				  			double C=Math.pow((x+length),2)+Math.pow(b-y-length,2)-Math.pow(radius,2);
				  			double delta=Math.sqrt(Math.pow(B,2)-4*A*C);
				  			double X1=(-B-delta)/(2*A);
  							double X2=(-B+delta)/(2*A);
  							double X=0;
  							if(Math.abs(currentX-X1)< Math.abs(currentX-X2)) {
  								X=X1;
  							}else {
  								X=X2;
  								}
				  			double Y=a*X+b;
				  			if((currentX+dX)==X && (currentY+dY)==Y){
	  							return null;
	  						}
				  			if(Double.isNaN(X) || Double.isNaN(Y)){
				  				return null;
				  			}
				  			if (dX<0){
				  				BouncePoint bp= new BouncePoint(X,Y, BounceDirection.FLIP_X);
				  				bp.setHitBlock(block);
	  							return bp;
				  			}else{
				  				BouncePoint bp= new BouncePoint(X,Y, BounceDirection.FLIP_Y);
				  				bp.setHitBlock(block);
	  							return bp;
				  			}
				  		
	  	}
	  	return null;
  }

  // line 764 "../../../../../Block223States.ump"
   private boolean isCloser(BouncePoint first, BouncePoint second){
    double ballPosX = getCurrentBallX(); 
	    double ballPosY = getCurrentBallY(); 
	    
	    if(first == null) {
	    	return false; 
	    }
	    
	    if(second == null) {
	    	return true; 
	    }
	    
	    //we will use euclidean distance to see which is closer 
	    double distToFirst = Math.sqrt(Math.pow((first.getX() - ballPosX),2) + 
	    							   Math.pow(first.getY() - ballPosY, 2));

	    double distToSecond = Math.sqrt(Math.pow((second.getX() - ballPosX),2) + 
				   Math.pow(second.getY() - ballPosY, 2));
	    
	    if(distToFirst <= distToSecond) {
	    	return true; 
	    }
	    return false;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "score" + ":" + getScore()+ "," +
            "lives" + ":" + getLives()+ "," +
            "currentLevel" + ":" + getCurrentLevel()+ "," +
            "waitTime" + ":" + getWaitTime()+ "," +
            "playername" + ":" + getPlayername()+ "," +
            "ballDirectionX" + ":" + getBallDirectionX()+ "," +
            "ballDirectionY" + ":" + getBallDirectionY()+ "," +
            "currentBallX" + ":" + getCurrentBallX()+ "," +
            "currentBallY" + ":" + getCurrentBallY()+ "," +
            "currentPaddleLength" + ":" + getCurrentPaddleLength()+ "," +
            "currentPaddleX" + ":" + getCurrentPaddleX()+ "," +
            "currentPaddleY" + ":" + getCurrentPaddleY()+ "," +
            "gravityMode" + ":" + getGravityMode()+ "," +
            "counter" + ":" + getCounter()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bounce = "+(getBounce()!=null?Integer.toHexString(System.identityHashCode(getBounce())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "block223 = "+(getBlock223()!=null?Integer.toHexString(System.identityHashCode(getBlock223())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 112 "../../../../../Block223Persistence.ump"
  private static final long serialVersionUID = 8597675110221231714L ;

  
}