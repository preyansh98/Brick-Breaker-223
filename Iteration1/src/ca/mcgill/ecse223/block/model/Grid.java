/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 68 "../../../../../Untitled.ump"
public class Grid
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Grid Associations
  private List<GridCell> cell;
  private Level level;
  private PlayArea playArea;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Grid(Level aLevel, PlayArea aPlayArea)
  {
    cell = new ArrayList<GridCell>();
    if (aLevel == null || aLevel.getGrid() != null)
    {
      throw new RuntimeException("Unable to create Grid due to aLevel");
    }
    level = aLevel;
    boolean didAddPlayArea = setPlayArea(aPlayArea);
    if (!didAddPlayArea)
    {
      throw new RuntimeException("Unable to create grid due to playArea");
    }
  }

  public Grid(int aLevelnumberForLevel, PlayArea aPlayAreaForLevel, PlayArea aPlayArea)
  {
    cell = new ArrayList<GridCell>();
    level = new Level(aLevelnumberForLevel, aPlayAreaForLevel, this);
    boolean didAddPlayArea = setPlayArea(aPlayArea);
    if (!didAddPlayArea)
    {
      throw new RuntimeException("Unable to create grid due to playArea");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public GridCell getCell(int index)
  {
    GridCell aCell = cell.get(index);
    return aCell;
  }

  public List<GridCell> getCell()
  {
    List<GridCell> newCell = Collections.unmodifiableList(cell);
    return newCell;
  }

  public int numberOfCell()
  {
    int number = cell.size();
    return number;
  }

  public boolean hasCell()
  {
    boolean has = cell.size() > 0;
    return has;
  }

  public int indexOfCell(GridCell aCell)
  {
    int index = cell.indexOf(aCell);
    return index;
  }
  /* Code from template association_GetOne */
  public Level getLevel()
  {
    return level;
  }
  /* Code from template association_GetOne */
  public PlayArea getPlayArea()
  {
    return playArea;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCell()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public GridCell addCell(boolean aIsEmpty)
  {
    return new GridCell(aIsEmpty, this);
  }

  public boolean addCell(GridCell aCell)
  {
    boolean wasAdded = false;
    if (cell.contains(aCell)) { return false; }
    Grid existingGrid = aCell.getGrid();
    boolean isNewGrid = existingGrid != null && !this.equals(existingGrid);
    if (isNewGrid)
    {
      aCell.setGrid(this);
    }
    else
    {
      cell.add(aCell);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCell(GridCell aCell)
  {
    boolean wasRemoved = false;
    //Unable to remove aCell, as it must always have a grid
    if (!this.equals(aCell.getGrid()))
    {
      cell.remove(aCell);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCellAt(GridCell aCell, int index)
  {  
    boolean wasAdded = false;
    if(addCell(aCell))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCell()) { index = numberOfCell() - 1; }
      cell.remove(aCell);
      cell.add(index, aCell);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCellAt(GridCell aCell, int index)
  {
    boolean wasAdded = false;
    if(cell.contains(aCell))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCell()) { index = numberOfCell() - 1; }
      cell.remove(aCell);
      cell.add(index, aCell);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCellAt(aCell, index);
    }
    return wasAdded;
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
      existingPlayArea.removeGrid(this);
    }
    playArea.addGrid(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while (cell.size() > 0)
    {
      GridCell aCell = cell.get(cell.size() - 1);
      aCell.delete();
      cell.remove(aCell);
    }
    
    Level existingLevel = level;
    level = null;
    if (existingLevel != null)
    {
      existingLevel.delete();
    }
    PlayArea placeholderPlayArea = playArea;
    this.playArea = null;
    if(placeholderPlayArea != null)
    {
      placeholderPlayArea.removeGrid(this);
    }
  }

}