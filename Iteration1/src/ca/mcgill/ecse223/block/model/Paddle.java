/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 43 "../../../../../Untitled.ump"
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
  private PlayArea playArea;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Paddle(int aMinimumLength, int aMaximumLength, PlayArea aPlayArea)
  {
    minimumLength = aMinimumLength;
    maximumLength = aMaximumLength;
    if (aPlayArea == null || aPlayArea.getPaddle() != null)
    {
      throw new RuntimeException("Unable to create Paddle due to aPlayArea");
    }
    playArea = aPlayArea;
  }

  public Paddle(int aMinimumLength, int aMaximumLength, int aWidthForPlayArea, int aHeightForPlayArea, Ball aBallForPlayArea, Game aGameForPlayArea, Level aLevelForPlayArea)
  {
    minimumLength = aMinimumLength;
    maximumLength = aMaximumLength;
    playArea = new PlayArea(aWidthForPlayArea, aHeightForPlayArea, aBallForPlayArea, this, aGameForPlayArea, aLevelForPlayArea);
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
  public PlayArea getPlayArea()
  {
    return playArea;
  }

  public void delete()
  {
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
            "  " + "playArea = "+(getPlayArea()!=null?Integer.toHexString(System.identityHashCode(getPlayArea())):"null");
  }
}