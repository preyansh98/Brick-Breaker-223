/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 73 "../../../../../Iteration1.ump"
public class Block
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Color { Blue, Yellow, Red, Grey, Black, Orange }

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final int SIDE = 20;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Block Attributes
  private Color color;
  private int points;

  //Block Associations
  private GridCell gridCell;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Block(Color aColor, int aPoints, GridCell aGridCell)
  {
    color = aColor;
    points = aPoints;
    boolean didAddGridCell = setGridCell(aGridCell);
    if (!didAddGridCell)
    {
      throw new RuntimeException("Unable to create block due to gridCell");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setColor(Color aColor)
  {
    boolean wasSet = false;
    color = aColor;
    wasSet = true;
    return wasSet;
  }

  public boolean setPoints(int aPoints)
  {
    boolean wasSet = false;
    points = aPoints;
    wasSet = true;
    return wasSet;
  }

  public Color getColor()
  {
    return color;
  }

  public int getPoints()
  {
    return points;
  }
  /* Code from template association_GetOne */
  public GridCell getGridCell()
  {
    return gridCell;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setGridCell(GridCell aNewGridCell)
  {
    boolean wasSet = false;
    if (aNewGridCell == null)
    {
      //Unable to setGridCell to null, as block must always be associated to a gridCell
      return wasSet;
    }
    
    Block existingBlock = aNewGridCell.getBlock();
    if (existingBlock != null && !equals(existingBlock))
    {
      //Unable to setGridCell, the current gridCell already has a block, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    GridCell anOldGridCell = gridCell;
    gridCell = aNewGridCell;
    gridCell.setBlock(this);

    if (anOldGridCell != null)
    {
      anOldGridCell.setBlock(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    GridCell existingGridCell = gridCell;
    gridCell = null;
    if (existingGridCell != null)
    {
      existingGridCell.setBlock(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "points" + ":" + getPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "color" + "=" + (getColor() != null ? !getColor().equals(this)  ? getColor().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "gridCell = "+(getGridCell()!=null?Integer.toHexString(System.identityHashCode(getGridCell())):"null");
  }
}