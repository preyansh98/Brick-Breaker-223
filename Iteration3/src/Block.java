/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/


import java.io.Serializable;

// line 68 "Block223Persistence.ump"
public class Block implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Block()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 73 "Block223Persistence.ump"
   public static  void reinitializeAutouniqueID(List<Game> games){
    nextId=0;
  	for(Game game: games){
  		for(Block block: game.getBlocks()){
  			if(block.getId()>nextId){
  				nextId=block.getId();
  			}
  		}
  	}
  	nextId++;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 71 "Block223Persistence.ump"
  private static final long serialVersionUID = -7403802774454234836L ;

  
}