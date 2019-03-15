/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.io.Serializable;
import java.util.*;

// line 50 "../../../../../Block223Persistence.ump"
// line 30 "../../../../../Block223Update.ump"
// line 46 "../../../../../Block223 v2.ump"
public class Player extends UserRole implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Associations
  private List<GameSession> gameSessions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String aPassword, Block223 aBlock223)
  {
    super(aPassword, aBlock223);
    gameSessions = new ArrayList<GameSession>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public GameSession getGameSession(int index)
  {
    GameSession aGameSession = gameSessions.get(index);
    return aGameSession;
  }

  public List<GameSession> getGameSessions()
  {
    List<GameSession> newGameSessions = Collections.unmodifiableList(gameSessions);
    return newGameSessions;
  }

  public int numberOfGameSessions()
  {
    int number = gameSessions.size();
    return number;
  }

  public boolean hasGameSessions()
  {
    boolean has = gameSessions.size() > 0;
    return has;
  }

  public int indexOfGameSession(GameSession aGameSession)
  {
    int index = gameSessions.indexOf(aGameSession);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGameSessions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addGameSession(GameSession aGameSession)
  {
    boolean wasAdded = false;
    if (gameSessions.contains(aGameSession)) { return false; }
    Player existingPlayer = aGameSession.getPlayer();
    if (existingPlayer == null)
    {
      aGameSession.setPlayer(this);
    }
    else if (!this.equals(existingPlayer))
    {
      existingPlayer.removeGameSession(aGameSession);
      addGameSession(aGameSession);
    }
    else
    {
      gameSessions.add(aGameSession);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGameSession(GameSession aGameSession)
  {
    boolean wasRemoved = false;
    if (gameSessions.contains(aGameSession))
    {
      gameSessions.remove(aGameSession);
      aGameSession.setPlayer(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGameSessionAt(GameSession aGameSession, int index)
  {  
    boolean wasAdded = false;
    if(addGameSession(aGameSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGameSessions()) { index = numberOfGameSessions() - 1; }
      gameSessions.remove(aGameSession);
      gameSessions.add(index, aGameSession);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGameSessionAt(GameSession aGameSession, int index)
  {
    boolean wasAdded = false;
    if(gameSessions.contains(aGameSession))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGameSessions()) { index = numberOfGameSessions() - 1; }
      gameSessions.remove(aGameSession);
      gameSessions.add(index, aGameSession);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGameSessionAt(aGameSession, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !gameSessions.isEmpty() )
    {
      gameSessions.get(0).setPlayer(null);
    }
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 53 "../../../../../Block223Persistence.ump"
  private static final long serialVersionUID = -3900912597282882073L ;

  
}