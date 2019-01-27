/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 50 "../../../../../Untitled.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
  private String name;

  //Game Associations
  private Admin admin;
  private PlayArea playArea;
  private HallOfFame hallOfFame;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(String aName, PlayArea aPlayArea, HallOfFame aHallOfFame)
  {
    name = aName;
    if (aPlayArea == null || aPlayArea.getGame() != null)
    {
      throw new RuntimeException("Unable to create Game due to aPlayArea");
    }
    playArea = aPlayArea;
    if (aHallOfFame == null || aHallOfFame.getGame() != null)
    {
      throw new RuntimeException("Unable to create Game due to aHallOfFame");
    }
    hallOfFame = aHallOfFame;
  }

  public Game(String aName, int aWidthForPlayArea, int aHeightForPlayArea, Ball aBallForPlayArea, Paddle aPaddleForPlayArea, Level aLevelForPlayArea)
  {
    name = aName;
    playArea = new PlayArea(aWidthForPlayArea, aHeightForPlayArea, aBallForPlayArea, aPaddleForPlayArea, this, aLevelForPlayArea);
    hallOfFame = new HallOfFame(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public Admin getAdmin()
  {
    return admin;
  }

  public boolean hasAdmin()
  {
    boolean has = admin != null;
    return has;
  }
  /* Code from template association_GetOne */
  public PlayArea getPlayArea()
  {
    return playArea;
  }
  /* Code from template association_GetOne */
  public HallOfFame getHallOfFame()
  {
    return hallOfFame;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setAdmin(Admin aNewAdmin)
  {
    boolean wasSet = false;
    if (admin != null && !admin.equals(aNewAdmin) && equals(admin.getGame()))
    {
      //Unable to setAdmin, as existing admin would become an orphan
      return wasSet;
    }

    admin = aNewAdmin;
    Game anOldGame = aNewAdmin != null ? aNewAdmin.getGame() : null;

    if (!this.equals(anOldGame))
    {
      if (anOldGame != null)
      {
        anOldGame.admin = null;
      }
      if (admin != null)
      {
        admin.setGame(this);
      }
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Admin existingAdmin = admin;
    admin = null;
    if (existingAdmin != null)
    {
      existingAdmin.delete();
    }
    PlayArea existingPlayArea = playArea;
    playArea = null;
    if (existingPlayArea != null)
    {
      existingPlayArea.delete();
    }
    HallOfFame existingHallOfFame = hallOfFame;
    hallOfFame = null;
    if (existingHallOfFame != null)
    {
      existingHallOfFame.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "admin = "+(getAdmin()!=null?Integer.toHexString(System.identityHashCode(getAdmin())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "playArea = "+(getPlayArea()!=null?Integer.toHexString(System.identityHashCode(getPlayArea())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "hallOfFame = "+(getHallOfFame()!=null?Integer.toHexString(System.identityHashCode(getHallOfFame())):"null");
  }
}