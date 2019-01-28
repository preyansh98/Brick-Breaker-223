/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 36 "../../../../../Iteration1.ump"
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
  private Block223 block223;
  private PlayArea playArea;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ball(int aMinimumSpeed, double aSpeedFactor, Block223 aBlock223, PlayArea aPlayArea)
  {
    minimumSpeed = aMinimumSpeed;
    speedFactor = aSpeedFactor;
    currentSpeed = 0;
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create ball due to block223");
    }
    if (aPlayArea == null || aPlayArea.getBall() != null)
    {
      throw new RuntimeException("Unable to create Ball due to aPlayArea");
    }
    playArea = aPlayArea;
  }

  public Ball(int aMinimumSpeed, double aSpeedFactor, Block223 aBlock223, int aWidthForPlayArea, int aHeightForPlayArea, Paddle aPaddleForPlayArea, Game aGameForPlayArea, Block223 aBlock223ForPlayArea)
  {
    minimumSpeed = aMinimumSpeed;
    speedFactor = aSpeedFactor;
    currentSpeed = 0;
    boolean didAddBlock223 = setBlock223(aBlock223);
    if (!didAddBlock223)
    {
      throw new RuntimeException("Unable to create ball due to block223");
    }
    playArea = new PlayArea(aWidthForPlayArea, aHeightForPlayArea, this, aPaddleForPlayArea, aGameForPlayArea, aBlock223ForPlayArea);
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
      existingBlock223.removeBall(this);
    }
    block223.addBall(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Block223 placeholderBlock223 = block223;
    this.block223 = null;
    if(placeholderBlock223 != null)
    {
      placeholderBlock223.removeBall(this);
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
            "minimumSpeed" + ":" + getMinimumSpeed()+ "," +
            "speedFactor" + ":" + getSpeedFactor()+ "," +
            "currentSpeed" + ":" + getCurrentSpeed()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "block223 = "+(getBlock223()!=null?Integer.toHexString(System.identityHashCode(getBlock223())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "playArea = "+(getPlayArea()!=null?Integer.toHexString(System.identityHashCode(getPlayArea())):"null");
  }
}