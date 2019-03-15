/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 6 "../../../../../Block223Update.ump"
// line 2 "../../../../../StateMachine.ump"
public class GameSession
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum BallIncidence { Downward, Upward, Left, Right, None }

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final int MAX_NR_LIVES = 3;
  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GameSession Attributes
  private BallIncidence hitIncidence;
  private int numOfLives;
  private int currentLevel;
  private int score;
  private int paddlePosition;
  private int ballPositonX;
  private int ballPositionY;
  private int ballDirectionX;
  private int ballDirectionY;
  private int currentPaddleSize;

  //Autounique Attributes
  private int id;

  //GameSession State Machines
  public enum GameStatus { Idle, Playing, Paused, Done }
  private GameStatus gameStatus;

  //GameSession Associations
  private Player player;
  private Game game;
  private List<SpecificBlockAssignment> assignments;
  private Block223 block223;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GameSession(Game aGame, Block223 aBlock223)
  {
    resetNumOfLives();
    resetCurrentLevel();
    resetScore();
    resetPaddlePosition();
    resetBallPositonX();
    resetBallPositionY();
    resetBallDirectionX();
    resetBallDirectionY();
    currentPaddleSize = game.getPaddle().getMinPaddleLength()+
		(currentLevel-1)*(game.getPaddle().getMaxPaddleLength()-game.getPaddle().getMinPaddleLength())/(game.getLevels().size()-1);
    id = nextId++;
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create gameSession due to game");
    }
    assignments = new ArrayList<SpecificBlockAssignment>();
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create gameSession due to block223");
    }
    setGameStatus(GameStatus.Idle);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHitIncidence(BallIncidence aHitIncidence)
  {
    boolean wasSet = false;
    hitIncidence = aHitIncidence;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setNumOfLives(int aNumOfLives)
  {
    boolean wasSet = false;
    numOfLives = aNumOfLives;
    wasSet = true;
    return wasSet;
  }

  public boolean resetNumOfLives()
  {
    boolean wasReset = false;
    numOfLives = getDefaultNumOfLives();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setCurrentLevel(int aCurrentLevel)
  {
    boolean wasSet = false;
    currentLevel = aCurrentLevel;
    wasSet = true;
    return wasSet;
  }

  public boolean resetCurrentLevel()
  {
    boolean wasReset = false;
    currentLevel = getDefaultCurrentLevel();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setScore(int aScore)
  {
    boolean wasSet = false;
    score = aScore;
    wasSet = true;
    return wasSet;
  }

  public boolean resetScore()
  {
    boolean wasReset = false;
    score = getDefaultScore();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setPaddlePosition(int aPaddlePosition)
  {
    boolean wasSet = false;
    paddlePosition = aPaddlePosition;
    wasSet = true;
    return wasSet;
  }

  public boolean resetPaddlePosition()
  {
    boolean wasReset = false;
    paddlePosition = getDefaultPaddlePosition();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setBallPositonX(int aBallPositonX)
  {
    boolean wasSet = false;
    ballPositonX = aBallPositonX;
    wasSet = true;
    return wasSet;
  }

  public boolean resetBallPositonX()
  {
    boolean wasReset = false;
    ballPositonX = getDefaultBallPositonX();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setBallPositionY(int aBallPositionY)
  {
    boolean wasSet = false;
    ballPositionY = aBallPositionY;
    wasSet = true;
    return wasSet;
  }

  public boolean resetBallPositionY()
  {
    boolean wasReset = false;
    ballPositionY = getDefaultBallPositionY();
    wasReset = true;
    return wasReset;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setBallDirectionX(int aBallDirectionX)
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
  public boolean setBallDirectionY(int aBallDirectionY)
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

  public boolean setCurrentPaddleSize(int aCurrentPaddleSize)
  {
    boolean wasSet = false;
    currentPaddleSize = aCurrentPaddleSize;
    wasSet = true;
    return wasSet;
  }

  public BallIncidence getHitIncidence()
  {
    return hitIncidence;
  }

  public int getNumOfLives()
  {
    return numOfLives;
  }
  /* Code from template attribute_GetDefaulted */
  public int getDefaultNumOfLives()
  {
    return 3;
  }

  public int getCurrentLevel()
  {
    return currentLevel;
  }
  /* Code from template attribute_GetDefaulted */
  public int getDefaultCurrentLevel()
  {
    return 1;
  }

  public int getScore()
  {
    return score;
  }
  /* Code from template attribute_GetDefaulted */
  public int getDefaultScore()
  {
    return 0;
  }

  public int getPaddlePosition()
  {
    return paddlePosition;
  }
  /* Code from template attribute_GetDefaulted */
  public int getDefaultPaddlePosition()
  {
    return 195-getCurrentPaddleSize()/2;
  }

  public int getBallPositonX()
  {
    return ballPositonX;
  }
  /* Code from template attribute_GetDefaulted */
  public int getDefaultBallPositonX()
  {
    return 195;
  }

  public int getBallPositionY()
  {
    return ballPositionY;
  }
  /* Code from template attribute_GetDefaulted */
  public int getDefaultBallPositionY()
  {
    return 195;
  }

  public int getBallDirectionX()
  {
    return ballDirectionX;
  }
  /* Code from template attribute_GetDefaulted */
  public int getDefaultBallDirectionX()
  {
    return game.getBall().getMinBallSpeedX();
  }

  public int getBallDirectionY()
  {
    return ballDirectionY;
  }
  /* Code from template attribute_GetDefaulted */
  public int getDefaultBallDirectionY()
  {
    return game.getBall().getMinBallSpeedY();
  }

  public int getCurrentPaddleSize()
  {
    return currentPaddleSize;
  }

  public int getId()
  {
    return id;
  }

  public String getGameStatusFullName()
  {
    String answer = gameStatus.toString();
    return answer;
  }

  public GameStatus getGameStatus()
  {
    return gameStatus;
  }

  public boolean pause()
  {
    boolean wasEventProcessed = false;
    
    GameStatus aGameStatus = gameStatus;
    switch (aGameStatus)
    {
      case Playing:
        setGameStatus(GameStatus.Paused);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean resume()
  {
    boolean wasEventProcessed = false;
    
    GameStatus aGameStatus = gameStatus;
    switch (aGameStatus)
    {
      case Paused:
        setGameStatus(GameStatus.Playing);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setGameStatus(GameStatus aGameStatus)
  {
    gameStatus = aGameStatus;

    // entry actions and do activities
    switch(gameStatus)
    {
      case Done:
        // line 47 "../../../../../StateMachine.ump"
        saveScoreAndDelete();
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
  public SpecificBlockAssignment getAssignment(int index)
  {
    SpecificBlockAssignment aAssignment = assignments.get(index);
    return aAssignment;
  }

  public List<SpecificBlockAssignment> getAssignments()
  {
    List<SpecificBlockAssignment> newAssignments = Collections.unmodifiableList(assignments);
    return newAssignments;
  }

  public int numberOfAssignments()
  {
    int number = assignments.size();
    return number;
  }

  public boolean hasAssignments()
  {
    boolean has = assignments.size() > 0;
    return has;
  }

  public int indexOfAssignment(SpecificBlockAssignment aAssignment)
  {
    int index = assignments.indexOf(aAssignment);
    return index;
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
      existingPlayer.removeGameSession(this);
    }
    if (aPlayer != null)
    {
      aPlayer.addGameSession(this);
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
      existingGame.removeGameSession(this);
    }
    game.addGameSession(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssignments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public SpecificBlockAssignment addAssignment(int aPositionX, int aPositionY, Block aBlock)
  {
    return new SpecificBlockAssignment(aPositionX, aPositionY, aBlock, this);
  }

  public boolean addAssignment(SpecificBlockAssignment aAssignment)
  {
    boolean wasAdded = false;
    if (assignments.contains(aAssignment)) { return false; }
    GameSession existingGameSession = aAssignment.getGameSession();
    boolean isNewGameSession = existingGameSession != null && !this.equals(existingGameSession);
    if (isNewGameSession)
    {
      aAssignment.setGameSession(this);
    }
    else
    {
      assignments.add(aAssignment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssignment(SpecificBlockAssignment aAssignment)
  {
    boolean wasRemoved = false;
    //Unable to remove aAssignment, as it must always have a gameSession
    if (!this.equals(aAssignment.getGameSession()))
    {
      assignments.remove(aAssignment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssignmentAt(SpecificBlockAssignment aAssignment, int index)
  {  
    boolean wasAdded = false;
    if(addAssignment(aAssignment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignments()) { index = numberOfAssignments() - 1; }
      assignments.remove(aAssignment);
      assignments.add(index, aAssignment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssignmentAt(SpecificBlockAssignment aAssignment, int index)
  {
    boolean wasAdded = false;
    if(assignments.contains(aAssignment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignments()) { index = numberOfAssignments() - 1; }
      assignments.remove(aAssignment);
      assignments.add(index, aAssignment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssignmentAt(aAssignment, index);
    }
    return wasAdded;
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
      existingBlock223.removeGameSession(this);
    }
    block223.addGameSession(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (player != null)
    {
      Player placeholderPlayer = player;
      this.player = null;
      placeholderPlayer.removeGameSession(this);
    }
    Game placeholderGame = game;
    this.game = null;
    if(placeholderGame != null)
    {
      placeholderGame.removeGameSession(this);
    }
    while (assignments.size() > 0)
    {
      SpecificBlockAssignment aAssignment = assignments.get(assignments.size() - 1);
      aAssignment.delete();
      assignments.remove(aAssignment);
    }
    
    Block223 placeholderBlock223 = block223;
    this.block223 = null;
    if(placeholderBlock223 != null)
    {
      placeholderBlock223.removeGameSession(this);
    }
  }

  // line 28 "../../../../../Block223Update.ump"
   public void movePaddle(int offset){
    
  }

  // line 52 "../../../../../StateMachine.ump"
   private boolean hasEnoughBlocks(){
    return false;
  }

  // line 53 "../../../../../StateMachine.ump"
   private void doDuplicateBlocks(){
    
  }

  // line 54 "../../../../../StateMachine.ump"
   private void doFillRandomBlocks(){
    
  }

  // line 55 "../../../../../StateMachine.ump"
   private boolean isballHitPaddle(){
    return false;
  }

  // line 56 "../../../../../StateMachine.ump"
   private boolean isballHitWall(){
    return false;
  }

  // line 57 "../../../../../StateMachine.ump"
   private boolean ballHitsBlock(){
    return false;
  }

  // line 58 "../../../../../StateMachine.ump"
   private boolean ballIsOutOfBound(){
    return false;
  }

  // line 59 "../../../../../StateMachine.ump"
   private boolean saveScoreAndDelete(){
    return false;
  }

  // line 60 "../../../../../StateMachine.ump"
   private void doJumpToNextLevel(){
    
  }

  // line 61 "../../../../../StateMachine.ump"
   private boolean isLastBlock(){
    return false;
  }

  // line 63 "../../../../../StateMachine.ump"
   private boolean gameIsAlmostDone(){
    return false;
  }

  // line 65 "../../../../../StateMachine.ump"
   private boolean almostDead(){
    return false;
  }

  // line 66 "../../../../../StateMachine.ump"
   private void doMoveBall(){
    
  }

  // line 68 "../../../../../StateMachine.ump"
   private boolean checkLineIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
    return false;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "numOfLives" + ":" + getNumOfLives()+ "," +
            "currentLevel" + ":" + getCurrentLevel()+ "," +
            "score" + ":" + getScore()+ "," +
            "paddlePosition" + ":" + getPaddlePosition()+ "," +
            "ballPositonX" + ":" + getBallPositonX()+ "," +
            "ballPositionY" + ":" + getBallPositionY()+ "," +
            "ballDirectionX" + ":" + getBallDirectionX()+ "," +
            "ballDirectionY" + ":" + getBallDirectionY()+ "," +
            "currentPaddleSize" + ":" + getCurrentPaddleSize()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hitIncidence" + "=" + (getHitIncidence() != null ? !getHitIncidence().equals(this)  ? getHitIncidence().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "block223 = "+(getBlock223()!=null?Integer.toHexString(System.identityHashCode(getBlock223())):"null");
  }
}