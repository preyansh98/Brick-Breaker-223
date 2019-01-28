/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 51 "../../../../../Iteration1.ump"
public class PlayArea
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PlayArea Attributes
  private int width;
  private int height;

  //PlayArea Associations
  private Ball ball;
  private Paddle paddle;
  private List<Grid> grid;
  private Game game;
  private Block223 block223;
  private List<Level> levels;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlayArea(int aWidth, int aHeight, Ball aBall, Paddle aPaddle, Game aGame, Block223 aBlock223)
  {
    width = aWidth;
    height = aHeight;
    if (aBall == null || aBall.getPlayArea() != null)
    {
      throw new RuntimeException("Unable to create PlayArea due to aBall");
    }
    ball = aBall;
    if (aPaddle == null || aPaddle.getPlayArea() != null)
    {
      throw new RuntimeException("Unable to create PlayArea due to aPaddle");
    }
    paddle = aPaddle;
    grid = new ArrayList<Grid>();
    if (aGame == null || aGame.getPlayArea() != null)
    {
      throw new RuntimeException("Unable to create PlayArea due to aGame");
    }
    game = aGame;
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create playArea due to block223");
    }
    levels = new ArrayList<Level>();
  }

  public PlayArea(int aWidth, int aHeight, int aMinimumSpeedForBall, double aSpeedFactorForBall, Block223 aBlock223ForBall, int aMinimumLengthForPaddle, int aMaximumLengthForPaddle, Block223 aBlock223ForPaddle, String aNameForGame, int aNumOfLevelsForGame, Admin aAdminForGame, Block223 aBlock223ForGame, HallOfFame aHallOfFameForGame, Block223 aBlock223)
  {
    width = aWidth;
    height = aHeight;
    ball = new Ball(aMinimumSpeedForBall, aSpeedFactorForBall, aBlock223ForBall, this);
    paddle = new Paddle(aMinimumLengthForPaddle, aMaximumLengthForPaddle, aBlock223ForPaddle, this);
    grid = new ArrayList<Grid>();
    game = new Game(aNameForGame, aNumOfLevelsForGame, aAdminForGame, aBlock223ForGame, this, aHallOfFameForGame);
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create playArea due to block223");
    }
    levels = new ArrayList<Level>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWidth(int aWidth)
  {
    boolean wasSet = false;
    width = aWidth;
    wasSet = true;
    return wasSet;
  }

  public boolean setHeight(int aHeight)
  {
    boolean wasSet = false;
    height = aHeight;
    wasSet = true;
    return wasSet;
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }
  /* Code from template association_GetOne */
  public Ball getBall()
  {
    return ball;
  }
  /* Code from template association_GetOne */
  public Paddle getPaddle()
  {
    return paddle;
  }
  /* Code from template association_GetMany */
  public Grid getGrid(int index)
  {
    Grid aGrid = grid.get(index);
    return aGrid;
  }

  public List<Grid> getGrid()
  {
    List<Grid> newGrid = Collections.unmodifiableList(grid);
    return newGrid;
  }

  public int numberOfGrid()
  {
    int number = grid.size();
    return number;
  }

  public boolean hasGrid()
  {
    boolean has = grid.size() > 0;
    return has;
  }

  public int indexOfGrid(Grid aGrid)
  {
    int index = grid.indexOf(aGrid);
    return index;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_GetOne */
  public Block223 getBlock223()
  {
    return block223;
  }
  /* Code from template association_GetMany */
  public Level getLevel(int index)
  {
    Level aLevel = levels.get(index);
    return aLevel;
  }

  public List<Level> getLevels()
  {
    List<Level> newLevels = Collections.unmodifiableList(levels);
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

  public int indexOfLevel(Level aLevel)
  {
    int index = levels.indexOf(aLevel);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGrid()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Grid addGrid(Block223 aBlock223, Level aLevel)
  {
    return new Grid(aBlock223, aLevel, this);
  }

  public boolean addGrid(Grid aGrid)
  {
    boolean wasAdded = false;
    if (grid.contains(aGrid)) { return false; }
    PlayArea existingPlayArea = aGrid.getPlayArea();
    boolean isNewPlayArea = existingPlayArea != null && !this.equals(existingPlayArea);
    if (isNewPlayArea)
    {
      aGrid.setPlayArea(this);
    }
    else
    {
      grid.add(aGrid);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGrid(Grid aGrid)
  {
    boolean wasRemoved = false;
    //Unable to remove aGrid, as it must always have a playArea
    if (!this.equals(aGrid.getPlayArea()))
    {
      grid.remove(aGrid);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGridAt(Grid aGrid, int index)
  {  
    boolean wasAdded = false;
    if(addGrid(aGrid))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGrid()) { index = numberOfGrid() - 1; }
      grid.remove(aGrid);
      grid.add(index, aGrid);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGridAt(Grid aGrid, int index)
  {
    boolean wasAdded = false;
    if(grid.contains(aGrid))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGrid()) { index = numberOfGrid() - 1; }
      grid.remove(aGrid);
      grid.add(index, aGrid);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGridAt(aGrid, index);
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
      existingBlock223.removePlayArea(this);
    }
    block223.addPlayArea(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLevels()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Level addLevel(int aLevelnumber, boolean aIsRandom, Grid aGrid, Block223 aBlock223)
  {
    return new Level(aLevelnumber, aIsRandom, this, aGrid, aBlock223);
  }

  public boolean addLevel(Level aLevel)
  {
    boolean wasAdded = false;
    if (levels.contains(aLevel)) { return false; }
    PlayArea existingPlayArea = aLevel.getPlayArea();
    boolean isNewPlayArea = existingPlayArea != null && !this.equals(existingPlayArea);
    if (isNewPlayArea)
    {
      aLevel.setPlayArea(this);
    }
    else
    {
      levels.add(aLevel);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLevel(Level aLevel)
  {
    boolean wasRemoved = false;
    //Unable to remove aLevel, as it must always have a playArea
    if (!this.equals(aLevel.getPlayArea()))
    {
      levels.remove(aLevel);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLevelAt(Level aLevel, int index)
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

  public boolean addOrMoveLevelAt(Level aLevel, int index)
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

  public void delete()
  {
    Ball existingBall = ball;
    ball = null;
    if (existingBall != null)
    {
      existingBall.delete();
    }
    Paddle existingPaddle = paddle;
    paddle = null;
    if (existingPaddle != null)
    {
      existingPaddle.delete();
    }
    while (grid.size() > 0)
    {
      Grid aGrid = grid.get(grid.size() - 1);
      aGrid.delete();
      grid.remove(aGrid);
    }
    
    Game existingGame = game;
    game = null;
    if (existingGame != null)
    {
      existingGame.delete();
    }
    Block223 placeholderBlock223 = block223;
    this.block223 = null;
    if(placeholderBlock223 != null)
    {
      placeholderBlock223.removePlayArea(this);
    }
    for(int i=levels.size(); i > 0; i--)
    {
      Level aLevel = levels.get(i - 1);
      aLevel.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "width" + ":" + getWidth()+ "," +
            "height" + ":" + getHeight()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ball = "+(getBall()!=null?Integer.toHexString(System.identityHashCode(getBall())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "paddle = "+(getPaddle()!=null?Integer.toHexString(System.identityHashCode(getPaddle())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "block223 = "+(getBlock223()!=null?Integer.toHexString(System.identityHashCode(getBlock223())):"null");
  }
}