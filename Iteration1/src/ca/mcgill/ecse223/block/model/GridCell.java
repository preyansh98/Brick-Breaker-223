/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 74 "../../../../../Iteration1.ump"
public class GridCell
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GridCell Attributes
  private boolean isEmpty;

  //GridCell Associations
  private Block block;
  private Grid grid;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GridCell(boolean aIsEmpty, Grid aGrid)
  {
    isEmpty = aIsEmpty;
    boolean didAddGrid = setGrid(aGrid);
    if (!didAddGrid)
    {
      throw new RuntimeException("Unable to create cell due to grid");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsEmpty(boolean aIsEmpty)
  {
    boolean wasSet = false;
    isEmpty = aIsEmpty;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsEmpty()
  {
    return isEmpty;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsEmpty()
  {
    return isEmpty;
  }
  /* Code from template association_GetOne */
  public Block getBlock()
  {
    return block;
  }

  public boolean hasBlock()
  {
    boolean has = block != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Grid getGrid()
  {
    return grid;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setBlock(Block aNewBlock)
  {
    boolean wasSet = false;
    if (block != null && !block.equals(aNewBlock) && equals(block.getGridCell()))
    {
      //Unable to setBlock, as existing block would become an orphan
      return wasSet;
    }

    block = aNewBlock;
    GridCell anOldGridCell = aNewBlock != null ? aNewBlock.getGridCell() : null;

    if (!this.equals(anOldGridCell))
    {
      if (anOldGridCell != null)
      {
        anOldGridCell.block = null;
      }
      if (block != null)
      {
        block.setGridCell(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGrid(Grid aGrid)
  {
    boolean wasSet = false;
    if (aGrid == null)
    {
      return wasSet;
    }

    Grid existingGrid = grid;
    grid = aGrid;
    if (existingGrid != null && !existingGrid.equals(aGrid))
    {
      existingGrid.removeCell(this);
    }
    grid.addCell(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Block existingBlock = block;
    block = null;
    if (existingBlock != null)
    {
      existingBlock.delete();
    }
    Grid placeholderGrid = grid;
    this.grid = null;
    if(placeholderGrid != null)
    {
      placeholderGrid.removeCell(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "isEmpty" + ":" + getIsEmpty()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "block = "+(getBlock()!=null?Integer.toHexString(System.identityHashCode(getBlock())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "grid = "+(getGrid()!=null?Integer.toHexString(System.identityHashCode(getGrid())):"null");
  }
}