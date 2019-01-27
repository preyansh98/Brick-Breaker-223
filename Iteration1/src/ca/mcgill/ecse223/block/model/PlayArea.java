/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 34 "../../../../../Untitled.ump"
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
  private Level level;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlayArea(int aWidth, int aHeight, Ball aBall, Paddle aPaddle, Game aGame, Level aLevel)
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
    if (aLevel == null || aLevel.getPlayArea() != null)
    {
      throw new RuntimeException("Unable to create PlayArea due to aLevel");
    }
    level = aLevel;
  }

  public PlayArea(int aWidth, int aHeight, int aMinimumSpeedForBall, double aSpeedFactorForBall, int aMinimumLengthForPaddle, int aMaximumLengthForPaddle, String aNameForGame, HallOfFame aHallOfFameForGame, int aLevelnumberForLevel, Grid aGridForLevel)
  {
    width = aWidth;
    height = aHeight;
    ball = new Ball(aMinimumSpeedForBall, aSpeedFactorForBall, this);
    paddle = new Paddle(aMinimumLengthForPaddle, aMaximumLengthForPaddle, this);
    grid = new ArrayList<Grid>();
    game = new Game(aNameForGame, this, aHallOfFameForGame);
    level = new Level(aLevelnumberForLevel, this, aGridForLevel);
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
  public Level getLevel()
  {
    return level;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGrid()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Grid addGrid(Level aLevel)
  {
    return new Grid(aLevel, this);
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
    Level existingLevel = level;
    level = null;
    if (existingLevel != null)
    {
      existingLevel.delete();
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
            "  " + "level = "+(getLevel()!=null?Integer.toHexString(System.identityHashCode(getLevel())):"null");
  }
}