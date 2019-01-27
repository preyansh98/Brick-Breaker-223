/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 28 "../../../../../Iteration1.ump"
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
    boolean didAddPlayArea = setPlayArea(aPlayArea);
    if (!didAddPlayArea)
    {
      throw new RuntimeException("Unable to create level due to playArea");
    }
    if (aGrid == null || aGrid.getLevel() != null)
    {
      throw new RuntimeException("Unable to create Level due to aGrid");
    }
    grid = aGrid;
  }

  public Level(int aLevelnumber, PlayArea aPlayArea, PlayArea aPlayAreaForGrid)
  {
    levelnumber = aLevelnumber;
    boolean didAddPlayArea = setPlayArea(aPlayArea);
    if (!didAddPlayArea)
    {
      throw new RuntimeException("Unable to create level due to playArea");
    }
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
  /* Code from template association_SetOneToMany */
  public boolean setPlayArea(PlayArea aPlayArea)
  {
    boolean wasSet = false;
    if (aPlayArea == null)
    {
      return wasSet;
    }

    PlayArea existingPlayArea = playArea;
    playArea = aPlayArea;
    if (existingPlayArea != null && !existingPlayArea.equals(aPlayArea))
    {
      existingPlayArea.removeLevel(this);
    }
    playArea.addLevel(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    PlayArea placeholderPlayArea = playArea;
    this.playArea = null;
    if(placeholderPlayArea != null)
    {
      placeholderPlayArea.removeLevel(this);
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