/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 44 "../../../../../Iteration1.ump"
public class Level
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Level Attributes
  private int levelnumber;
  private boolean isRandom;

  //Level Associations
  private PlayArea playArea;
  private Grid grid;
  private Block223 block223;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Level(int aLevelnumber, boolean aIsRandom, PlayArea aPlayArea, Grid aGrid, Block223 aBlock223)
  {
    levelnumber = aLevelnumber;
    isRandom = aIsRandom;
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
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create level due to block223");
    }
  }

  public Level(int aLevelnumber, boolean aIsRandom, PlayArea aPlayArea, Block223 aBlock223ForGrid, PlayArea aPlayAreaForGrid, Block223 aBlock223)
  {
    levelnumber = aLevelnumber;
    isRandom = aIsRandom;
    boolean didAddPlayArea = setPlayArea(aPlayArea);
    if (!didAddPlayArea)
    {
      throw new RuntimeException("Unable to create level due to playArea");
    }
    grid = new Grid(aBlock223ForGrid, this, aPlayAreaForGrid);
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create level due to block223");
    }
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

  public boolean setIsRandom(boolean aIsRandom)
  {
    boolean wasSet = false;
    isRandom = aIsRandom;
    wasSet = true;
    return wasSet;
  }

  public int getLevelnumber()
  {
    return levelnumber;
  }

  public boolean getIsRandom()
  {
    return isRandom;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsRandom()
  {
    return isRandom;
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
  /* Code from template association_GetOne */
  public Block223 getBlock223()
  {
    return block223;
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
      existingBlock223.removeLevel(this);
    }
    block223.addLevel(this);
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
    Block223 placeholderBlock223 = block223;
    this.block223 = null;
    if(placeholderBlock223 != null)
    {
      placeholderBlock223.removeLevel(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "levelnumber" + ":" + getLevelnumber()+ "," +
            "isRandom" + ":" + getIsRandom()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "playArea = "+(getPlayArea()!=null?Integer.toHexString(System.identityHashCode(getPlayArea())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "grid = "+(getGrid()!=null?Integer.toHexString(System.identityHashCode(getGrid())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "block223 = "+(getBlock223()!=null?Integer.toHexString(System.identityHashCode(getBlock223())):"null");
  }
}