/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 20 "../../../../../Untitled.ump"
public class Ball
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final double Diameter = 10;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ball Attributes
  private int minimumSpeed;
  private double speedFactor;
  private double currentSpeed;

  //Ball Associations
  private PlayArea playArea;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ball(int aMinimumSpeed, double aSpeedFactor, PlayArea aPlayArea)
  {
    minimumSpeed = aMinimumSpeed;
    speedFactor = aSpeedFactor;
    currentSpeed = 0;
    if (aPlayArea == null || aPlayArea.getBall() != null)
    {
      throw new RuntimeException("Unable to create Ball due to aPlayArea");
    }
    playArea = aPlayArea;
  }

  public Ball(int aMinimumSpeed, double aSpeedFactor, int aWidthForPlayArea, int aHeightForPlayArea, Paddle aPaddleForPlayArea, Game aGameForPlayArea, Level aLevelForPlayArea)
  {
    minimumSpeed = aMinimumSpeed;
    speedFactor = aSpeedFactor;
    currentSpeed = 0;
    playArea = new PlayArea(aWidthForPlayArea, aHeightForPlayArea, this, aPaddleForPlayArea, aGameForPlayArea, aLevelForPlayArea);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMinimumSpeed(int aMinimumSpeed)
  {
    boolean wasSet = false;
    minimumSpeed = aMinimumSpeed;
    wasSet = true;
    return wasSet;
  }

  public boolean setSpeedFactor(double aSpeedFactor)
  {
    boolean wasSet = false;
    speedFactor = aSpeedFactor;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentSpeed(double aCurrentSpeed)
  {
    boolean wasSet = false;
    currentSpeed = aCurrentSpeed;
    wasSet = true;
    return wasSet;
  }

  public int getMinimumSpeed()
  {
    return minimumSpeed;
  }

  public double getSpeedFactor()
  {
    return speedFactor;
  }

  public double getCurrentSpeed()
  {
    return currentSpeed;
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
            "minimumSpeed" + ":" + getMinimumSpeed()+ "," +
            "speedFactor" + ":" + getSpeedFactor()+ "," +
            "currentSpeed" + ":" + getCurrentSpeed()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "playArea = "+(getPlayArea()!=null?Integer.toHexString(System.identityHashCode(getPlayArea())):"null");
  }
}