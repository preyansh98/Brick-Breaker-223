/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 36 "../../../../../Block223Update.ump"
public class SpecificLevel
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SpecificLevel Associations
  private GameSession gameSession;
  private List<SpecificBlockAssignment> specificBlockAssignments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SpecificLevel(GameSession aGameSession)
  {
    boolean didAddGameSession = setGameSession(aGameSession);
    if (!didAddGameSession)
    {
      throw new RuntimeException("Unable to create level due to gameSession");
    }
    specificBlockAssignments = new ArrayList<SpecificBlockAssignment>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public GameSession getGameSession()
  {
    return gameSession;
  }
  /* Code from template association_GetMany */
  public SpecificBlockAssignment getSpecificBlockAssignment(int index)
  {
    SpecificBlockAssignment aSpecificBlockAssignment = specificBlockAssignments.get(index);
    return aSpecificBlockAssignment;
  }

  public List<SpecificBlockAssignment> getSpecificBlockAssignments()
  {
    List<SpecificBlockAssignment> newSpecificBlockAssignments = Collections.unmodifiableList(specificBlockAssignments);
    return newSpecificBlockAssignments;
  }

  public int numberOfSpecificBlockAssignments()
  {
    int number = specificBlockAssignments.size();
    return number;
  }

  public boolean hasSpecificBlockAssignments()
  {
    boolean has = specificBlockAssignments.size() > 0;
    return has;
  }

  public int indexOfSpecificBlockAssignment(SpecificBlockAssignment aSpecificBlockAssignment)
  {
    int index = specificBlockAssignments.indexOf(aSpecificBlockAssignment);
    return index;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setGameSession(GameSession aGameSession)
  {
    boolean wasSet = false;
    //Must provide gameSession to level
    if (aGameSession == null)
    {
      return wasSet;
    }

    //gameSession already at maximum (99)
    if (aGameSession.numberOfLevels() >= GameSession.maximumNumberOfLevels())
    {
      return wasSet;
    }
    
    GameSession existingGameSession = gameSession;
    gameSession = aGameSession;
    if (existingGameSession != null && !existingGameSession.equals(aGameSession))
    {
      boolean didRemove = existingGameSession.removeLevel(this);
      if (!didRemove)
      {
        gameSession = existingGameSession;
        return wasSet;
      }
    }
    gameSession.addLevel(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSpecificBlockAssignments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public SpecificBlockAssignment addSpecificBlockAssignment(int aPositionX, int aPositionY, Block aBlock, GameSession aGameSession)
  {
    return new SpecificBlockAssignment(aPositionX, aPositionY, aBlock, this, aGameSession);
  }

  public boolean addSpecificBlockAssignment(SpecificBlockAssignment aSpecificBlockAssignment)
  {
    boolean wasAdded = false;
    if (specificBlockAssignments.contains(aSpecificBlockAssignment)) { return false; }
    SpecificLevel existingLevel = aSpecificBlockAssignment.getLevel();
    boolean isNewLevel = existingLevel != null && !this.equals(existingLevel);
    if (isNewLevel)
    {
      aSpecificBlockAssignment.setLevel(this);
    }
    else
    {
      specificBlockAssignments.add(aSpecificBlockAssignment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSpecificBlockAssignment(SpecificBlockAssignment aSpecificBlockAssignment)
  {
    boolean wasRemoved = false;
    //Unable to remove aSpecificBlockAssignment, as it must always have a level
    if (!this.equals(aSpecificBlockAssignment.getLevel()))
    {
      specificBlockAssignments.remove(aSpecificBlockAssignment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSpecificBlockAssignmentAt(SpecificBlockAssignment aSpecificBlockAssignment, int index)
  {  
    boolean wasAdded = false;
    if(addSpecificBlockAssignment(aSpecificBlockAssignment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecificBlockAssignments()) { index = numberOfSpecificBlockAssignments() - 1; }
      specificBlockAssignments.remove(aSpecificBlockAssignment);
      specificBlockAssignments.add(index, aSpecificBlockAssignment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSpecificBlockAssignmentAt(SpecificBlockAssignment aSpecificBlockAssignment, int index)
  {
    boolean wasAdded = false;
    if(specificBlockAssignments.contains(aSpecificBlockAssignment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecificBlockAssignments()) { index = numberOfSpecificBlockAssignments() - 1; }
      specificBlockAssignments.remove(aSpecificBlockAssignment);
      specificBlockAssignments.add(index, aSpecificBlockAssignment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSpecificBlockAssignmentAt(aSpecificBlockAssignment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    GameSession placeholderGameSession = gameSession;
    this.gameSession = null;
    if(placeholderGameSession != null)
    {
      placeholderGameSession.removeLevel(this);
    }
    for(int i=specificBlockAssignments.size(); i > 0; i--)
    {
      SpecificBlockAssignment aSpecificBlockAssignment = specificBlockAssignments.get(i - 1);
      aSpecificBlockAssignment.delete();
    }
  }

}