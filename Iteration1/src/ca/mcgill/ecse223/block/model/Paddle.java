/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 60 "../../../../../Iteration1.ump"
public class Paddle
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final int WIDTH = 5;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Paddle Attributes
  private int minimumLength;
  private int maximumLength;

  //Paddle Associations
  private Block223 block223;
  private PlayArea playArea;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Paddle(int aMinimumLength, int aMaximumLength, Block223 aBlock223, PlayArea aPlayArea)
  {
    minimumLength = aMinimumLength;
    maximumLength = aMaximumLength;
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create paddle due to block223");
    }
    if (aPlayArea == null || aPlayArea.getPaddle() != null)
    {
      throw new RuntimeException("Unable to create Paddle due to aPlayArea");
    }
    playArea = aPlayArea;
  }

  public Paddle(int aMinimumLength, int aMaximumLength, Block223 aBlock223, int aWidthForPlayArea, int aHeightForPlayArea, Ball aBallForPlayArea, Game aGameForPlayArea, Block223 aBlock223ForPlayArea)
  {
    minimumLength = aMinimumLength;
    maximumLength = aMaximumLength;
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create paddle due to block223");
    }
    playArea = new PlayArea(aWidthForPlayArea, aHeightForPlayArea, aBallForPlayArea, this, aGameForPlayArea, aBlock223ForPlayArea);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMinimumLength(int aMinimumLength)
  {
    boolean wasSet = false;
    minimumLength = aMinimumLength;
    wasSet = true;
    return wasSet;
  }

  public boolean setMaximumLength(int aMaximumLength)
  {
    boolean wasSet = false;
    maximumLength = aMaximumLength;
    wasSet = true;
    return wasSet;
  }

  public int getMinimumLength()
  {
    return minimumLength;
  }

  public int getMaximumLength()
  {
    return maximumLength;
  }
  /* Code from template association_GetOne */
  public Block223 getBlock223()
  {
    return block223;
  }
  /* Code from template association_GetOne */
  public PlayArea getPlayArea()
  {
    return playArea;
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
      existingBlock223.removePaddle(this);
    }
    block223.addPaddle(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Block223 placeholderBlock223 = block223;
    this.block223 = null;
    if(placeholderBlock223 != null)
    {
      placeholderBlock223.removePaddle(this);
    }
    PlayArea existingPlayArea = playArea;
    playArea = null;
    if (existingPlayArea != null)
    {
      existingPlayArea.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "minimumLength" + ":" + getMinimumLength()+ "," +
            "maximumLength" + ":" + getMaximumLength()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "block223 = "+(getBlock223()!=null?Integer.toHexString(System.identityHashCode(getBlock223())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "playArea = "+(getPlayArea()!=null?Integer.toHexString(System.identityHashCode(getPlayArea())):"null");
  }
}