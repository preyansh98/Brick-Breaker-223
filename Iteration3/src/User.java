/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/


import java.io.Serializable;

// line 29 "Block223Persistence.ump"
public class User implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 35 "Block223Persistence.ump"
   public static  void reinitializeUniqueUsername(List<User> users){
    usersByUsername = new HashMap<String, User>();
    for (User user : users) {
      usersByUsername.put(user.getUsername(), user);
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 32 "Block223Persistence.ump"
  private static final long serialVersionUID = 8896099581655989380L ;

  
}