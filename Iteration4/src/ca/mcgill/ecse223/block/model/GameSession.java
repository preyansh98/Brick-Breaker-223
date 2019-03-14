/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 1 "../../../../../Block223Update.ump"
// line 3 "../../../../../StateMachine.ump"
public class GameSession
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final int MAX_NR_LIVES = 3;
  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GameSession Attributes
  private int numOfLives;
  private int currentLevel;
  private int score;
  private int paddlePosition;
  private int ballPositonX;
  private int ballPositionY;
  private int ballDirectionX;
  private int ballDirectionY;

  //Autounique Attributes
  private int id;

  //GameSession State Machines
  public enum GameStatus { Paused, Playing, Done }
  private GameStatus gameStatus;

  //GameSession Associations
  private Player player;
  private Game game;
  private List<SpecificLevel> levels;
  private List<SpecificBlockAssignment> assignments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GameSession(int aNumOfLives, int aCurrentLevel, int aScore, int aPaddlePosition, Game aGame)
  {
    numOfLives = aNumOfLives;
    currentLevel = aCurrentLevel;
    score = aScore;
    paddlePosition = aPaddlePosition;
    ballPositonX = 195;
    ballPositionY = 195;
    resetBallDirectionX();
    resetBallDirectionY();
    id = nextId++;
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create gameSession due to game");
    }
    levels = new ArrayList<SpecificLevel>();
    assignments = new ArrayList<SpecificBlockAssignment>();
    setGameStatus(GameStatus.Paused);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumOfLives(int aNumOfLives)
  {
    boolean wasSet = false;
    numOfLives = aNumOfLives;
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

  public boolean setScore(int aScore)
  {
    boolean wasSet = false;
    score = aScore;
    wasSet = true;
    return wasSet;
  }

  public boolean setPaddlePosition(int aPaddlePosition)
  {
    boolean wasSet = false;
    paddlePosition = aPaddlePosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setBallPositonX(int aBallPositonX)
  {
    boolean wasSet = false;
    ballPositonX = aBallPositonX;
    wasSet = true;
    return wasSet;
  }

  public boolean setBallPositionY(int aBallPositionY)
  {
    boolean wasSet = false;
    ballPositionY = aBallPositionY;
    wasSet = true;
    return wasSet;
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

  public int getNumOfLives()
  {
    return numOfLives;
  }

  public int getCurrentLevel()
  {
    return currentLevel;
  }

  public int getScore()
  {
    return score;
  }

  public int getPaddlePosition()
  {
    return paddlePosition;
  }

  public int getBallPositonX()
  {
    return ballPositonX;
  }

  public int getBallPositionY()
  {
    return ballPositionY;
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

  public boolean start()
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

  public boolean update()
  {
    boolean wasEventProcessed = false;
    
    GameStatus aGameStatus = gameStatus;
    switch (aGameStatus)
    {
      case Playing:
        if (ballHitsPaddleOrWall())
        {
          setGameStatus(GameStatus.Playing);
          wasEventProcessed = true;
          break;
        }
        if (gameIsDone())
        {
          setGameStatus(GameStatus.Done);
          wasEventProcessed = true;
          break;
        }
        if (ballHitsBlock())
        {
          setGameStatus(GameStatus.Playing);
          wasEventProcessed = true;
          break;
        }
        if (ballIsOutOfBound())
        {
          setGameStatus(GameStatus.Paused);
          wasEventProcessed = true;
          break;
        }
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
        // line 19 "../../../../../StateMachine.ump"
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
  public SpecificLevel getLevel(int index)
  {
    SpecificLevel aLevel = levels.get(index);
    return aLevel;
  }

  public List<SpecificLevel> getLevels()
  {
    List<SpecificLevel> newLevels = Collections.unmodifiableList(levels);
    return newLevels;
  }

  public int numberOfLevels()
  {
    int number = levels.size();
    return number;
  }

  public boolean hasLevels()
  {
    boolean has = levels.size() > 0;
    return has;
  }

  public int indexOfLevel(SpecificLevel aLevel)
  {
    int index = levels.indexOf(aLevel);
    return index;
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
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfLevelsValid()
  {
    boolean isValid = numberOfLevels() >= minimumNumberOfLevels() && numberOfLevels() <= maximumNumberOfLevels();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLevels()
  {
    return 1;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfLevels()
  {
    return 99;
  }
  /* Code from template association_AddMNToOnlyOne */
  public SpecificLevel addLevel()
  {
    if (numberOfLevels() >= maximumNumberOfLevels())
    {
      return null;
    }
    else
    {
      return new SpecificLevel(this);
    }
  }

  public boolean addLevel(SpecificLevel aLevel)
  {
    boolean wasAdded = false;
    if (levels.contains(aLevel)) { return false; }
    if (numberOfLevels() >= maximumNumberOfLevels())
    {
      return wasAdded;
    }

    GameSession existingGameSession = aLevel.getGameSession();
    boolean isNewGameSession = existingGameSession != null && !this.equals(existingGameSession);

    if (isNewGameSession && existingGameSession.numberOfLevels() <= minimumNumberOfLevels())
    {
      return wasAdded;
    }

    if (isNewGameSession)
    {
      aLevel.setGameSession(this);
    }
    else
    {
      levels.add(aLevel);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLevel(SpecificLevel aLevel)
  {
    boolean wasRemoved = false;
    //Unable to remove aLevel, as it must always have a gameSession
    if (this.equals(aLevel.getGameSession()))
    {
      return wasRemoved;
    }

    //gameSession already at minimum (1)
    if (numberOfLevels() <= minimumNumberOfLevels())
    {
      return wasRemoved;
    }
    levels.remove(aLevel);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLevelAt(SpecificLevel aLevel, int index)
  {  
    boolean wasAdded = false;
    if(addLevel(aLevel))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLevels()) { index = numberOfLevels() - 1; }
      levels.remove(aLevel);
      levels.add(index, aLevel);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLevelAt(SpecificLevel aLevel, int index)
  {
    boolean wasAdded = false;
    if(levels.contains(aLevel))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLevels()) { index = numberOfLevels() - 1; }
      levels.remove(aLevel);
      levels.add(index, aLevel);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLevelAt(aLevel, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssignments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public SpecificBlockAssignment addAssignment(int aPositionX, int aPositionY, Block aBlock, SpecificLevel aLevel)
  {
    return new SpecificBlockAssignment(aPositionX, aPositionY, aBlock, aLevel, this);
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
    while (levels.size() > 0)
    {
      SpecificLevel aLevel = levels.get(levels.size() - 1);
      aLevel.delete();
      levels.remove(aLevel);
    }
    
    while (assignments.size() > 0)
    {
      SpecificBlockAssignment aAssignment = assignments.get(assignments.size() - 1);
      aAssignment.delete();
      assignments.remove(aAssignment);
    }
    
  }

  // line 19 "../../../../../Block223Update.ump"
   private boolean ballHitsPaddleOrWall(){
    return false;
  }

  // line 20 "../../../../../Block223Update.ump"
   private boolean gameIsDone(){
    return false;
  }

  // line 21 "../../../../../Block223Update.ump"
   private boolean ballHitsBlock(){
    return false;
  }

  // line 22 "../../../../../Block223Update.ump"
   private boolean ballIsOutOfBound(){
    return false;
  }

  // line 23 "../../../../../Block223Update.ump"
   private boolean saveScoreAndDelete(){
    return false;
  }

  // line 24 "../../../../../Block223Update.ump"
   private boolean levelIsDone(){
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
            "ballDirectionY" + ":" + getBallDirectionY()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "player = "+(getPlayer()!=null?Integer.toHexString(System.identityHashCode(getPlayer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null");
  }
}