/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 28 "../../../../../Untitled.ump"
public class Level
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Level Attributes
  private int levelnumber;

  //Level Associations
  private PlayArea playArea;
  private Grid grid;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Level(int aLevelnumber, PlayArea aPlayArea, Grid aGrid)
  {
    levelnumber = aLevelnumber;
    if (aPlayArea == null || aPlayArea.getLevel() != null)
    {
      throw new RuntimeException("Unable to create Level due to aPlayArea");
    }
    playArea = aPlayArea;
    if (aGrid == null || aGrid.getLevel() != null)
    {
      throw new RuntimeException("Unable to create Level due to aGrid");
    }
    grid = aGrid;
  }

  public Level(int aLevelnumber, int aWidthForPlayArea, int aHeightForPlayArea, Ball aBallForPlayArea, Paddle aPaddleForPlayArea, Game aGameForPlayArea, PlayArea aPlayAreaForGrid)
  {
    levelnumber = aLevelnumber;
    playArea = new PlayArea(aWidthForPlayArea, aHeightForPlayArea, aBallForPlayArea, aPaddleForPlayArea, aGameForPlayArea, this);
    grid = new Grid(this, aPlayAreaForGrid);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLevelnumber(int aLevelnumber)
  {
    boolean wasSet = false;
    levelnumber = aLevelnumber;
    wasSet = true;
    return wasSet;
  }

  public int getLevelnumber()
  {
    return levelnumber;
  }
  /* Code from template association_GetOne */
  public PlayArea getPlayArea()
  {
    return playArea;
  }
  /* Code from template association_GetOne */
  public Grid getGrid()
  {
    return grid;
  }

  public void delete()
  {
    PlayArea existingPlayArea = playArea;
    playArea = null;
    if (existingPlayArea != null)
    {
      existingPlayArea.delete();
    }
    Grid existingGrid = grid;
    grid = null;
    if (existingGrid != null)
    {
      existingGrid.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "levelnumber" + ":" + getLevelnumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "playArea = "+(getPlayArea()!=null?Integer.toHexString(System.identityHashCode(getPlayArea())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "grid = "+(getGrid()!=null?Integer.toHexString(System.identityHashCode(getGrid())):"null");
  }
}