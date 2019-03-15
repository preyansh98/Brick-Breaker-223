/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 33 "../../../../../Block223Update.ump"
public class SpecificBlockAssignment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SpecificBlockAssignment Attributes
  private int positionX;
  private int positionY;

  //SpecificBlockAssignment Associations
  private Block block;
  private GameSession gameSession;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SpecificBlockAssignment(int aPositionX, int aPositionY, Block aBlock, GameSession aGameSession)
  {
    positionX = aPositionX;
    positionY = aPositionY;
    if (!setBlock(aBlock))
    {
      throw new RuntimeException("Unable to create SpecificBlockAssignment due to aBlock");
    }
    boolean didAddGameSession = setGameSession(aGameSession);
    if (!didAddGameSession)
    {
      throw new RuntimeException("Unable to create assignment due to gameSession");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPositionX(int aPositionX)
  {
    boolean wasSet = false;
    positionX = aPositionX;
    wasSet = true;
    return wasSet;
  }

  public boolean setPositionY(int aPositionY)
  {
    boolean wasSet = false;
    positionY = aPositionY;
    wasSet = true;
    return wasSet;
  }

  public int getPositionX()
  {
    return positionX;
  }

  public int getPositionY()
  {
    return positionY;
  }
  /* Code from template association_GetOne */
  public Block getBlock()
  {
    return block;
  }
  /* Code from template association_GetOne */
  public GameSession getGameSession()
  {
    return gameSession;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setBlock(Block aNewBlock)
  {
    boolean wasSet = false;
    if (aNewBlock != null)
    {
      block = aNewBlock;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGameSession(GameSession aGameSession)
  {
    boolean wasSet = false;
    if (aGameSession == null)
    {
      return wasSet;
    }

    GameSession existingGameSession = gameSession;
    gameSession = aGameSession;
    if (existingGameSession != null && !existingGameSession.equals(aGameSession))
    {
      existingGameSession.removeAssignment(this);
    }
    gameSession.addAssignment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    block = null;
    GameSession placeholderGameSession = gameSession;
    this.gameSession = null;
    if(placeholderGameSession != null)
    {
      placeholderGameSession.removeAssignment(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "positionX" + ":" + getPositionX()+ "," +
            "positionY" + ":" + getPositionY()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "block = "+(getBlock()!=null?Integer.toHexString(System.identityHashCode(getBlock())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "gameSession = "+(getGameSession()!=null?Integer.toHexString(System.identityHashCode(getGameSession())):"null");
  }
}