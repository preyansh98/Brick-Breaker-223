/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 63 "../../../../../Iteration1.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String username;

  //User Associations
  private List<UserRole> userRoles;
  private HallOfFame hallOfFame;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aUsername, HallOfFame aHallOfFame, UserRole... allUserRoles)
  {
    username = aUsername;
    userRoles = new ArrayList<UserRole>();
    boolean didAddUserRoles = setUserRoles(allUserRoles);
    if (!didAddUserRoles)
    {
      throw new RuntimeException("Unable to create User, must have 2 userRoles");
    }
    boolean didAddHallOfFame = setHallOfFame(aHallOfFame);
    if (!didAddHallOfFame)
    {
      throw new RuntimeException("Unable to create user due to hallOfFame");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }
  /* Code from template association_GetMany */
  public UserRole getUserRole(int index)
  {
    UserRole aUserRole = userRoles.get(index);
    return aUserRole;
  }

  public List<UserRole> getUserRoles()
  {
    List<UserRole> newUserRoles = Collections.unmodifiableList(userRoles);
    return newUserRoles;
  }

  public int numberOfUserRoles()
  {
    int number = userRoles.size();
    return number;
  }

  public boolean hasUserRoles()
  {
    boolean has = userRoles.size() > 0;
    return has;
  }

  public int indexOfUserRole(UserRole aUserRole)
  {
    int index = userRoles.indexOf(aUserRole);
    return index;
  }
  /* Code from template association_GetOne */
  public HallOfFame getHallOfFame()
  {
    return hallOfFame;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfUserRolesValid()
  {
    boolean isValid = numberOfUserRoles() >= minimumNumberOfUserRoles() && numberOfUserRoles() <= maximumNumberOfUserRoles();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfUserRoles()
  {
    return 2;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUserRoles()
  {
    return 2;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfUserRoles()
  {
    return 2;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addUserRole(UserRole aUserRole)
  {
    boolean wasAdded = false;
    if (userRoles.contains(aUserRole)) { return false; }
    if (numberOfUserRoles() >= maximumNumberOfUserRoles())
    {
      return wasAdded;
    }

    userRoles.add(aUserRole);
    if (aUserRole.indexOfUser(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUserRole.addUser(this);
      if (!wasAdded)
      {
        userRoles.remove(aUserRole);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMNToMany */
  public boolean removeUserRole(UserRole aUserRole)
  {
    boolean wasRemoved = false;
    if (!userRoles.contains(aUserRole))
    {
      return wasRemoved;
    }

    if (numberOfUserRoles() <= minimumNumberOfUserRoles())
    {
      return wasRemoved;
    }

    int oldIndex = userRoles.indexOf(aUserRole);
    userRoles.remove(oldIndex);
    if (aUserRole.indexOfUser(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUserRole.removeUser(this);
      if (!wasRemoved)
      {
        userRoles.add(oldIndex,aUserRole);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToMany */
  public boolean setUserRoles(UserRole... newUserRoles)
  {
    boolean wasSet = false;
    ArrayList<UserRole> verifiedUserRoles = new ArrayList<UserRole>();
    for (UserRole aUserRole : newUserRoles)
    {
      if (verifiedUserRoles.contains(aUserRole))
      {
        continue;
      }
      verifiedUserRoles.add(aUserRole);
    }

    if (verifiedUserRoles.size() != newUserRoles.length || verifiedUserRoles.size() < minimumNumberOfUserRoles() || verifiedUserRoles.size() > maximumNumberOfUserRoles())
    {
      return wasSet;
    }

    ArrayList<UserRole> oldUserRoles = new ArrayList<UserRole>(userRoles);
    userRoles.clear();
    for (UserRole aNewUserRole : verifiedUserRoles)
    {
      userRoles.add(aNewUserRole);
      if (oldUserRoles.contains(aNewUserRole))
      {
        oldUserRoles.remove(aNewUserRole);
      }
      else
      {
        aNewUserRole.addUser(this);
      }
    }

    for (UserRole anOldUserRole : oldUserRoles)
    {
      anOldUserRole.removeUser(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setHallOfFame(HallOfFame aHallOfFame)
  {
    boolean wasSet = false;
    if (aHallOfFame == null)
    {
      return wasSet;
    }

    HallOfFame existingHallOfFame = hallOfFame;
    hallOfFame = aHallOfFame;
    if (existingHallOfFame != null && !existingHallOfFame.equals(aHallOfFame))
    {
      existingHallOfFame.removeUser(this);
    }
    hallOfFame.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<UserRole> copyOfUserRoles = new ArrayList<UserRole>(userRoles);
    userRoles.clear();
    for(UserRole aUserRole : copyOfUserRoles)
    {
      aUserRole.removeUser(this);
    }
    HallOfFame placeholderHallOfFame = hallOfFame;
    this.hallOfFame = null;
    if(placeholderHallOfFame != null)
    {
      placeholderHallOfFame.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hallOfFame = "+(getHallOfFame()!=null?Integer.toHexString(System.identityHashCode(getHallOfFame())):"null");
  }
}