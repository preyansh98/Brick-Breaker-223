/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 8 "../../../../../Iteration1.ump"
public class Admin extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Admin Attributes
  private String adminpassword;

  //Admin Associations
  private Game game;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Admin(String aAdminpassword, Game aGame)
  {
    super();
    adminpassword = aAdminpassword;
    boolean didAddGame = setGame(aGame);
    if (!didAddGame)
    {
      throw new RuntimeException("Unable to create admin due to game");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAdminpassword(String aAdminpassword)
  {
    boolean wasSet = false;
    adminpassword = aAdminpassword;
    wasSet = true;
    return wasSet;
  }

  public String getAdminpassword()
  {
    return adminpassword;
  }
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setGame(Game aNewGame)
  {
    boolean wasSet = false;
    if (aNewGame == null)
    {
      //Unable to setGame to null, as admin must always be associated to a game
      return wasSet;
    }
    
    Admin existingAdmin = aNewGame.getAdmin();
    if (existingAdmin != null && !equals(existingAdmin))
    {
      //Unable to setGame, the current game already has a admin, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Game anOldGame = game;
    game = aNewGame;
    game.setAdmin(this);

    if (anOldGame != null)
    {
      anOldGame.setAdmin(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Game existingGame = game;
    game = null;
    if (existingGame != null)
    {
      existingGame.setAdmin(null);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "adminpassword" + ":" + getAdminpassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "game = "+(getGame()!=null?Integer.toHexString(System.identityHashCode(getGame())):"null");
  }
}