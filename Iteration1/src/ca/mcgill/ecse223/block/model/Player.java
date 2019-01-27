/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 14 "../../../../../Untitled.ump"
public class Player extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private String playerpassword;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String aPlayerpassword)
  {
    super();
    playerpassword = aPlayerpassword;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPlayerpassword(String aPlayerpassword)
  {
    boolean wasSet = false;
    playerpassword = aPlayerpassword;
    wasSet = true;
    return wasSet;
  }

  public String getPlayerpassword()
  {
    return playerpassword;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "playerpassword" + ":" + getPlayerpassword()+ "]";
  }
}