/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;

// line 30 "../../../../../Iteration1.ump"
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

  public Player(Block223 aBlock223, User aUser, String aPlayerpassword)
  {
    super(aBlock223, aUser);
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