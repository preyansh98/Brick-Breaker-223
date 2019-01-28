/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse223.block.model;
import java.util.*;

// line 4 "../../../../../Iteration1.ump"
public class Block223
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Block223 Associations
  private List<UserRole> userrole;
  private List<Ball> ball;
  private List<Level> level;
  private List<PlayArea> playArea;
  private List<Paddle> paddle;
  private List<Game> game;
  private List<User> user;
  private List<Grid> grid;
  private List<GridCell> gridCell;
  private List<HallOfFame> halfOfFame;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Block223()
  {
    userrole = new ArrayList<UserRole>();
    ball = new ArrayList<Ball>();
    level = new ArrayList<Level>();
    playArea = new ArrayList<PlayArea>();
    paddle = new ArrayList<Paddle>();
    game = new ArrayList<Game>();
    user = new ArrayList<User>();
    grid = new ArrayList<Grid>();
    gridCell = new ArrayList<GridCell>();
    halfOfFame = new ArrayList<HallOfFame>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public UserRole getUserrole(int index)
  {
    UserRole aUserrole = userrole.get(index);
    return aUserrole;
  }

  public List<UserRole> getUserrole()
  {
    List<UserRole> newUserrole = Collections.unmodifiableList(userrole);
    return newUserrole;
  }

  public int numberOfUserrole()
  {
    int number = userrole.size();
    return number;
  }

  public boolean hasUserrole()
  {
    boolean has = userrole.size() > 0;
    return has;
  }

  public int indexOfUserrole(UserRole aUserrole)
  {
    int index = userrole.indexOf(aUserrole);
    return index;
  }
  /* Code from template association_GetMany */
  public Ball getBall(int index)
  {
    Ball aBall = ball.get(index);
    return aBall;
  }

  public List<Ball> getBall()
  {
    List<Ball> newBall = Collections.unmodifiableList(ball);
    return newBall;
  }

  public int numberOfBall()
  {
    int number = ball.size();
    return number;
  }

  public boolean hasBall()
  {
    boolean has = ball.size() > 0;
    return has;
  }

  public int indexOfBall(Ball aBall)
  {
    int index = ball.indexOf(aBall);
    return index;
  }
  /* Code from template association_GetMany */
  public Level getLevel(int index)
  {
    Level aLevel = level.get(index);
    return aLevel;
  }

  public List<Level> getLevel()
  {
    List<Level> newLevel = Collections.unmodifiableList(level);
    return newLevel;
  }

  public int numberOfLevel()
  {
    int number = level.size();
    return number;
  }

  public boolean hasLevel()
  {
    boolean has = level.size() > 0;
    return has;
  }

  public int indexOfLevel(Level aLevel)
  {
    int index = level.indexOf(aLevel);
    return index;
  }
  /* Code from template association_GetMany */
  public PlayArea getPlayArea(int index)
  {
    PlayArea aPlayArea = playArea.get(index);
    return aPlayArea;
  }

  public List<PlayArea> getPlayArea()
  {
    List<PlayArea> newPlayArea = Collections.unmodifiableList(playArea);
    return newPlayArea;
  }

  public int numberOfPlayArea()
  {
    int number = playArea.size();
    return number;
  }

  public boolean hasPlayArea()
  {
    boolean has = playArea.size() > 0;
    return has;
  }

  public int indexOfPlayArea(PlayArea aPlayArea)
  {
    int index = playArea.indexOf(aPlayArea);
    return index;
  }
  /* Code from template association_GetMany */
  public Paddle getPaddle(int index)
  {
    Paddle aPaddle = paddle.get(index);
    return aPaddle;
  }

  public List<Paddle> getPaddle()
  {
    List<Paddle> newPaddle = Collections.unmodifiableList(paddle);
    return newPaddle;
  }

  public int numberOfPaddle()
  {
    int number = paddle.size();
    return number;
  }

  public boolean hasPaddle()
  {
    boolean has = paddle.size() > 0;
    return has;
  }

  public int indexOfPaddle(Paddle aPaddle)
  {
    int index = paddle.indexOf(aPaddle);
    return index;
  }
  /* Code from template association_GetMany */
  public Game getGame(int index)
  {
    Game aGame = game.get(index);
    return aGame;
  }

  public List<Game> getGame()
  {
    List<Game> newGame = Collections.unmodifiableList(game);
    return newGame;
  }

  public int numberOfGame()
  {
    int number = game.size();
    return number;
  }

  public boolean hasGame()
  {
    boolean has = game.size() > 0;
    return has;
  }

  public int indexOfGame(Game aGame)
  {
    int index = game.indexOf(aGame);
    return index;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = user.get(index);
    return aUser;
  }

  public List<User> getUser()
  {
    List<User> newUser = Collections.unmodifiableList(user);
    return newUser;
  }

  public int numberOfUser()
  {
    int number = user.size();
    return number;
  }

  public boolean hasUser()
  {
    boolean has = user.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = user.indexOf(aUser);
    return index;
  }
  /* Code from template association_GetMany */
  public Grid getGrid(int index)
  {
    Grid aGrid = grid.get(index);
    return aGrid;
  }

  public List<Grid> getGrid()
  {
    List<Grid> newGrid = Collections.unmodifiableList(grid);
    return newGrid;
  }

  public int numberOfGrid()
  {
    int number = grid.size();
    return number;
  }

  public boolean hasGrid()
  {
    boolean has = grid.size() > 0;
    return has;
  }

  public int indexOfGrid(Grid aGrid)
  {
    int index = grid.indexOf(aGrid);
    return index;
  }
  /* Code from template association_GetMany */
  public GridCell getGridCell(int index)
  {
    GridCell aGridCell = gridCell.get(index);
    return aGridCell;
  }

  public List<GridCell> getGridCell()
  {
    List<GridCell> newGridCell = Collections.unmodifiableList(gridCell);
    return newGridCell;
  }

  public int numberOfGridCell()
  {
    int number = gridCell.size();
    return number;
  }

  public boolean hasGridCell()
  {
    boolean has = gridCell.size() > 0;
    return has;
  }

  public int indexOfGridCell(GridCell aGridCell)
  {
    int index = gridCell.indexOf(aGridCell);
    return index;
  }
  /* Code from template association_GetMany */
  public HallOfFame getHalfOfFame(int index)
  {
    HallOfFame aHalfOfFame = halfOfFame.get(index);
    return aHalfOfFame;
  }

  public List<HallOfFame> getHalfOfFame()
  {
    List<HallOfFame> newHalfOfFame = Collections.unmodifiableList(halfOfFame);
    return newHalfOfFame;
  }

  public int numberOfHalfOfFame()
  {
    int number = halfOfFame.size();
    return number;
  }

  public boolean hasHalfOfFame()
  {
    boolean has = halfOfFame.size() > 0;
    return has;
  }

  public int indexOfHalfOfFame(HallOfFame aHalfOfFame)
  {
    int index = halfOfFame.indexOf(aHalfOfFame);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUserrole()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addUserrole(UserRole aUserrole)
  {
    boolean wasAdded = false;
    if (userrole.contains(aUserrole)) { return false; }
    Block223 existingBlock223 = aUserrole.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aUserrole.setBlock223(this);
    }
    else
    {
      userrole.add(aUserrole);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUserrole(UserRole aUserrole)
  {
    boolean wasRemoved = false;
    //Unable to remove aUserrole, as it must always have a block223
    if (!this.equals(aUserrole.getBlock223()))
    {
      userrole.remove(aUserrole);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserroleAt(UserRole aUserrole, int index)
  {  
    boolean wasAdded = false;
    if(addUserrole(aUserrole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserrole()) { index = numberOfUserrole() - 1; }
      userrole.remove(aUserrole);
      userrole.add(index, aUserrole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserroleAt(UserRole aUserrole, int index)
  {
    boolean wasAdded = false;
    if(userrole.contains(aUserrole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserrole()) { index = numberOfUserrole() - 1; }
      userrole.remove(aUserrole);
      userrole.add(index, aUserrole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserroleAt(aUserrole, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBall()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ball addBall(int aMinimumSpeed, double aSpeedFactor, PlayArea aPlayArea)
  {
    return new Ball(aMinimumSpeed, aSpeedFactor, this, aPlayArea);
  }

  public boolean addBall(Ball aBall)
  {
    boolean wasAdded = false;
    if (ball.contains(aBall)) { return false; }
    Block223 existingBlock223 = aBall.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aBall.setBlock223(this);
    }
    else
    {
      ball.add(aBall);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBall(Ball aBall)
  {
    boolean wasRemoved = false;
    //Unable to remove aBall, as it must always have a block223
    if (!this.equals(aBall.getBlock223()))
    {
      ball.remove(aBall);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBallAt(Ball aBall, int index)
  {  
    boolean wasAdded = false;
    if(addBall(aBall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBall()) { index = numberOfBall() - 1; }
      ball.remove(aBall);
      ball.add(index, aBall);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBallAt(Ball aBall, int index)
  {
    boolean wasAdded = false;
    if(ball.contains(aBall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBall()) { index = numberOfBall() - 1; }
      ball.remove(aBall);
      ball.add(index, aBall);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBallAt(aBall, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLevel()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Level addLevel(int aLevelnumber, boolean aIsRandom, PlayArea aPlayArea, Grid aGrid)
  {
    return new Level(aLevelnumber, aIsRandom, aPlayArea, aGrid, this);
  }

  public boolean addLevel(Level aLevel)
  {
    boolean wasAdded = false;
    if (level.contains(aLevel)) { return false; }
    Block223 existingBlock223 = aLevel.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aLevel.setBlock223(this);
    }
    else
    {
      level.add(aLevel);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLevel(Level aLevel)
  {
    boolean wasRemoved = false;
    //Unable to remove aLevel, as it must always have a block223
    if (!this.equals(aLevel.getBlock223()))
    {
      level.remove(aLevel);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLevelAt(Level aLevel, int index)
  {  
    boolean wasAdded = false;
    if(addLevel(aLevel))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLevel()) { index = numberOfLevel() - 1; }
      level.remove(aLevel);
      level.add(index, aLevel);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLevelAt(Level aLevel, int index)
  {
    boolean wasAdded = false;
    if(level.contains(aLevel))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLevel()) { index = numberOfLevel() - 1; }
      level.remove(aLevel);
      level.add(index, aLevel);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLevelAt(aLevel, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlayArea()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PlayArea addPlayArea(int aWidth, int aHeight, Ball aBall, Paddle aPaddle, Game aGame)
  {
    return new PlayArea(aWidth, aHeight, aBall, aPaddle, aGame, this);
  }

  public boolean addPlayArea(PlayArea aPlayArea)
  {
    boolean wasAdded = false;
    if (playArea.contains(aPlayArea)) { return false; }
    Block223 existingBlock223 = aPlayArea.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aPlayArea.setBlock223(this);
    }
    else
    {
      playArea.add(aPlayArea);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePlayArea(PlayArea aPlayArea)
  {
    boolean wasRemoved = false;
    //Unable to remove aPlayArea, as it must always have a block223
    if (!this.equals(aPlayArea.getBlock223()))
    {
      playArea.remove(aPlayArea);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPlayAreaAt(PlayArea aPlayArea, int index)
  {  
    boolean wasAdded = false;
    if(addPlayArea(aPlayArea))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayArea()) { index = numberOfPlayArea() - 1; }
      playArea.remove(aPlayArea);
      playArea.add(index, aPlayArea);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlayAreaAt(PlayArea aPlayArea, int index)
  {
    boolean wasAdded = false;
    if(playArea.contains(aPlayArea))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayArea()) { index = numberOfPlayArea() - 1; }
      playArea.remove(aPlayArea);
      playArea.add(index, aPlayArea);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlayAreaAt(aPlayArea, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPaddle()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Paddle addPaddle(int aMinimumLength, int aMaximumLength, PlayArea aPlayArea)
  {
    return new Paddle(aMinimumLength, aMaximumLength, this, aPlayArea);
  }

  public boolean addPaddle(Paddle aPaddle)
  {
    boolean wasAdded = false;
    if (paddle.contains(aPaddle)) { return false; }
    Block223 existingBlock223 = aPaddle.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aPaddle.setBlock223(this);
    }
    else
    {
      paddle.add(aPaddle);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePaddle(Paddle aPaddle)
  {
    boolean wasRemoved = false;
    //Unable to remove aPaddle, as it must always have a block223
    if (!this.equals(aPaddle.getBlock223()))
    {
      paddle.remove(aPaddle);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPaddleAt(Paddle aPaddle, int index)
  {  
    boolean wasAdded = false;
    if(addPaddle(aPaddle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPaddle()) { index = numberOfPaddle() - 1; }
      paddle.remove(aPaddle);
      paddle.add(index, aPaddle);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePaddleAt(Paddle aPaddle, int index)
  {
    boolean wasAdded = false;
    if(paddle.contains(aPaddle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPaddle()) { index = numberOfPaddle() - 1; }
      paddle.remove(aPaddle);
      paddle.add(index, aPaddle);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPaddleAt(aPaddle, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGame()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Game addGame(String aName, int aNumOfLevels, Admin aAdmin, PlayArea aPlayArea, HallOfFame aHallOfFame)
  {
    return new Game(aName, aNumOfLevels, aAdmin, this, aPlayArea, aHallOfFame);
  }

  public boolean addGame(Game aGame)
  {
    boolean wasAdded = false;
    if (game.contains(aGame)) { return false; }
    Block223 existingBlock223 = aGame.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aGame.setBlock223(this);
    }
    else
    {
      game.add(aGame);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGame(Game aGame)
  {
    boolean wasRemoved = false;
    //Unable to remove aGame, as it must always have a block223
    if (!this.equals(aGame.getBlock223()))
    {
      game.remove(aGame);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGameAt(Game aGame, int index)
  {  
    boolean wasAdded = false;
    if(addGame(aGame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGame()) { index = numberOfGame() - 1; }
      game.remove(aGame);
      game.add(index, aGame);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGameAt(Game aGame, int index)
  {
    boolean wasAdded = false;
    if(game.contains(aGame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGame()) { index = numberOfGame() - 1; }
      game.remove(aGame);
      game.add(index, aGame);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGameAt(aGame, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUser()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public User addUser(String aUsername, HallOfFame aHallOfFame, UserRole... allUserRoles)
  {
    return new User(aUsername, this, aHallOfFame, allUserRoles);
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (user.contains(aUser)) { return false; }
    Block223 existingBlock223 = aUser.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aUser.setBlock223(this);
    }
    else
    {
      user.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a block223
    if (!this.equals(aUser.getBlock223()))
    {
      user.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUser()) { index = numberOfUser() - 1; }
      user.remove(aUser);
      user.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(user.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUser()) { index = numberOfUser() - 1; }
      user.remove(aUser);
      user.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGrid()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Grid addGrid(Level aLevel, PlayArea aPlayArea)
  {
    return new Grid(this, aLevel, aPlayArea);
  }

  public boolean addGrid(Grid aGrid)
  {
    boolean wasAdded = false;
    if (grid.contains(aGrid)) { return false; }
    Block223 existingBlock223 = aGrid.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aGrid.setBlock223(this);
    }
    else
    {
      grid.add(aGrid);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGrid(Grid aGrid)
  {
    boolean wasRemoved = false;
    //Unable to remove aGrid, as it must always have a block223
    if (!this.equals(aGrid.getBlock223()))
    {
      grid.remove(aGrid);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGridAt(Grid aGrid, int index)
  {  
    boolean wasAdded = false;
    if(addGrid(aGrid))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGrid()) { index = numberOfGrid() - 1; }
      grid.remove(aGrid);
      grid.add(index, aGrid);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGridAt(Grid aGrid, int index)
  {
    boolean wasAdded = false;
    if(grid.contains(aGrid))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGrid()) { index = numberOfGrid() - 1; }
      grid.remove(aGrid);
      grid.add(index, aGrid);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGridAt(aGrid, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGridCell()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public GridCell addGridCell(boolean aIsEmpty, Grid aGrid)
  {
    return new GridCell(aIsEmpty, this, aGrid);
  }

  public boolean addGridCell(GridCell aGridCell)
  {
    boolean wasAdded = false;
    if (gridCell.contains(aGridCell)) { return false; }
    Block223 existingBlock223 = aGridCell.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aGridCell.setBlock223(this);
    }
    else
    {
      gridCell.add(aGridCell);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeGridCell(GridCell aGridCell)
  {
    boolean wasRemoved = false;
    //Unable to remove aGridCell, as it must always have a block223
    if (!this.equals(aGridCell.getBlock223()))
    {
      gridCell.remove(aGridCell);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGridCellAt(GridCell aGridCell, int index)
  {  
    boolean wasAdded = false;
    if(addGridCell(aGridCell))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGridCell()) { index = numberOfGridCell() - 1; }
      gridCell.remove(aGridCell);
      gridCell.add(index, aGridCell);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGridCellAt(GridCell aGridCell, int index)
  {
    boolean wasAdded = false;
    if(gridCell.contains(aGridCell))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGridCell()) { index = numberOfGridCell() - 1; }
      gridCell.remove(aGridCell);
      gridCell.add(index, aGridCell);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGridCellAt(aGridCell, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHalfOfFame()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public HallOfFame addHalfOfFame(Game aGame)
  {
    return new HallOfFame(aGame, this);
  }

  public boolean addHalfOfFame(HallOfFame aHalfOfFame)
  {
    boolean wasAdded = false;
    if (halfOfFame.contains(aHalfOfFame)) { return false; }
    Block223 existingBlock223 = aHalfOfFame.getBlock223();
    boolean isNewBlock223 = existingBlock223 != null && !this.equals(existingBlock223);
    if (isNewBlock223)
    {
      aHalfOfFame.setBlock223(this);
    }
    else
    {
      halfOfFame.add(aHalfOfFame);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHalfOfFame(HallOfFame aHalfOfFame)
  {
    boolean wasRemoved = false;
    //Unable to remove aHalfOfFame, as it must always have a block223
    if (!this.equals(aHalfOfFame.getBlock223()))
    {
      halfOfFame.remove(aHalfOfFame);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addHalfOfFameAt(HallOfFame aHalfOfFame, int index)
  {  
    boolean wasAdded = false;
    if(addHalfOfFame(aHalfOfFame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHalfOfFame()) { index = numberOfHalfOfFame() - 1; }
      halfOfFame.remove(aHalfOfFame);
      halfOfFame.add(index, aHalfOfFame);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHalfOfFameAt(HallOfFame aHalfOfFame, int index)
  {
    boolean wasAdded = false;
    if(halfOfFame.contains(aHalfOfFame))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHalfOfFame()) { index = numberOfHalfOfFame() - 1; }
      halfOfFame.remove(aHalfOfFame);
      halfOfFame.add(index, aHalfOfFame);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHalfOfFameAt(aHalfOfFame, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (userrole.size() > 0)
    {
      UserRole aUserrole = userrole.get(userrole.size() - 1);
      aUserrole.delete();
      userrole.remove(aUserrole);
    }
    
    while (ball.size() > 0)
    {
      Ball aBall = ball.get(ball.size() - 1);
      aBall.delete();
      ball.remove(aBall);
    }
    
    while (level.size() > 0)
    {
      Level aLevel = level.get(level.size() - 1);
      aLevel.delete();
      level.remove(aLevel);
    }
    
    while (playArea.size() > 0)
    {
      PlayArea aPlayArea = playArea.get(playArea.size() - 1);
      aPlayArea.delete();
      playArea.remove(aPlayArea);
    }
    
    while (paddle.size() > 0)
    {
      Paddle aPaddle = paddle.get(paddle.size() - 1);
      aPaddle.delete();
      paddle.remove(aPaddle);
    }
    
    while (game.size() > 0)
    {
      Game aGame = game.get(game.size() - 1);
      aGame.delete();
      game.remove(aGame);
    }
    
    while (user.size() > 0)
    {
      User aUser = user.get(user.size() - 1);
      aUser.delete();
      user.remove(aUser);
    }
    
    while (grid.size() > 0)
    {
      Grid aGrid = grid.get(grid.size() - 1);
      aGrid.delete();
      grid.remove(aGrid);
    }
    
    while (gridCell.size() > 0)
    {
      GridCell aGridCell = gridCell.get(gridCell.size() - 1);
      aGridCell.delete();
      gridCell.remove(aGridCell);
    }
    
    while (halfOfFame.size() > 0)
    {
      HallOfFame aHalfOfFame = halfOfFame.get(halfOfFame.size() - 1);
      aHalfOfFame.delete();
      halfOfFame.remove(aHalfOfFame);
    }
    
  }

}