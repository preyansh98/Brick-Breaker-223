/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 92 "../../../../../Iteration1.ump"
public class GridCell
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GridCell Attributes
  private boolean isEmpty;

  //GridCell Associations
  private Block223 block223;
  private Block block;
  private Grid grid;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GridCell(boolean aIsEmpty, Block223 aBlock223, Grid aGrid)
  {
    isEmpty = aIsEmpty;
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create gridCell due to block223");
    }
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
  public Block223 getBlock223()
  {
    return block223;
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
      existingBlock223.removeGridCell(this);
    }
    block223.addGridCell(this);
    wasSet = true;
    return wasSet;
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
    Block223 placeholderBlock223 = block223;
    this.block223 = null;
    if(placeholderBlock223 != null)
    {
      placeholderBlock223.removeGridCell(this);
    }
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
            "  " + "block223 = "+(getBlock223()!=null?Integer.toHexString(System.identityHashCode(getBlock223())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "block = "+(getBlock()!=null?Integer.toHexString(System.identityHashCode(getBlock())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "grid = "+(getGrid()!=null?Integer.toHexString(System.identityHashCode(getGrid())):"null");
  }
}