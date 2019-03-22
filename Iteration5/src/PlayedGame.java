/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/



// line 1 "Block223States.ump"
public class PlayedGame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PlayedGame State Machines
  public enum PlayStatus { Ready, Moving, Paused, GameOver }
  private PlayStatus playStatus;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlayedGame()
  {
    setPlayStatus(PlayStatus.Ready);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getPlayStatusFullName()
  {
    String answer = playStatus.toString();
    return answer;
  }

  public PlayStatus getPlayStatus()
  {
    return playStatus;
  }

  public boolean play()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Ready:
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      case Paused:
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean pause()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Moving:
        setPlayStatus(PlayStatus.Paused);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean move()
  {
    boolean wasEventProcessed = false;
    
    PlayStatus aPlayStatus = playStatus;
    switch (aPlayStatus)
    {
      case Moving:
        if (hitPaddle())
        {
        // line 12 "Block223States.ump"
          doHitPaddleOrWall();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        if (isOutOfBoundsAndLastLife())
        {
        // line 13 "Block223States.ump"
          doOutOfBounds();
          setPlayStatus(PlayStatus.GameOver);
          wasEventProcessed = true;
          break;
        }
        if (isOutOfBounds())
        {
        // line 14 "Block223States.ump"
          doOutOfBounds();
          setPlayStatus(PlayStatus.Paused);
          wasEventProcessed = true;
          break;
        }
        if (hitLastBlockAndLastLevel())
        {
        // line 15 "Block223States.ump"
          doHitBlock();
          setPlayStatus(PlayStatus.GameOver);
          wasEventProcessed = true;
          break;
        }
        if (hitLastBlock())
        {
        // line 16 "Block223States.ump"
          doHitBlockNextLevel();
          setPlayStatus(PlayStatus.Ready);
          wasEventProcessed = true;
          break;
        }
        if (hitBlock())
        {
        // line 17 "Block223States.ump"
          doHitBlock();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        if (hitWall())
        {
        // line 18 "Block223States.ump"
          doHitPaddleOrWall();
          setPlayStatus(PlayStatus.Moving);
          wasEventProcessed = true;
          break;
        }
        // line 19 "Block223States.ump"
        doHitNothingAndNotOutOfBounds();
        setPlayStatus(PlayStatus.Moving);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setPlayStatus(PlayStatus aPlayStatus)
  {
    playStatus = aPlayStatus;

    // entry actions and do activities
    switch(playStatus)
    {
      case Ready:
        // line 7 "Block223States.ump"
        doSetup();
        break;
      case GameOver:
        // line 25 "Block223States.ump"
        doGameOver();
        break;
    }
  }

  public void delete()
  {}


  /**
   * Guards
   */
  // line 32 "Block223States.ump"
   private boolean hitPaddle(){
    // TODO implement
    return false;
  }

  // line 37 "Block223States.ump"
   private boolean isOutOfBoundsAndLastLife(){
    // TODO implement
    return false;
  }

  // line 42 "Block223States.ump"
   private boolean isOutOfBounds(){
    // TODO implement
    return false;
  }

  // line 48 "Block223States.ump"
   private boolean hitLastBlockAndLastLevel(){
    Game game = this.getGame(); 
	int nrLevels = game.numberOfLevels(); 
	
	this.setBounce(null); 
	
	if(nrLevels == currentLevel) {
		int nrBlocks = numberOfBlocks(); 
		if(nrBlocks == 1) {
			PlayedBlockAssignment block = this.getBlock(0); 
			BouncePoint bp = calculateBouncePointBlock(block); 
			setBounce(bp); 
			return true; 
		}
	}
    return false;
  }

  // line 67 "Block223States.ump"
   private boolean hitLastBlock(){
    int nrBlocks = numberOfBlocks(); 
	setBounce(null); 
	
	if(nrBlocks == 1) {
		PlayedBlockAssignment block = this.getBlock(0); 
		BouncePoint bp = null; 
		
		try{
			bp = calculateBouncePointBlock(block);
		}
		catch(NullPointerException e) {
			return false; //no bounce point found. 
		}
		setBounce(bp); 
		return true; 
	}
    return false;
  }

  // line 88 "Block223States.ump"
   private boolean hitBlock(){
    int nrBlocks = numberOfBlocks();
	   setBounce(null); 
	   
	   for(int index = 0; index < nrBlocks - 1; index++) {
		   PlayedBlockAssignment block = getBlock(index); 
		   
		   BouncePoint bp = null; 
		   try {
			   bp = calculateBouncePointBlock(block); 
		   }
		   catch(NullPointerException e) {
			   //what happens if its null?
		   }
		   
		   bounce = getBounce(); 
		   boolean closer = isCloser(bp, bounce); 
		   
		   if(closer) setBounce(bp); 
		  
	   }
	   return (getBounce()!=null);
  }

  // line 112 "Block223States.ump"
   private boolean hitWall(){
    // TODO implement
    return false;
  }


  /**
   * Actions
   */
  // line 119 "Block223States.ump"
   private void doSetup(){
    // TODO implement
  }

  // line 123 "Block223States.ump"
   private void doHitPaddleOrWall(){
    // TODO implement
  }

  // line 127 "Block223States.ump"
   private void doOutOfBounds(){
    // TODO implement
  }

  // line 131 "Block223States.ump"
   private void doHitBlock(){
    int score = getScore(); 
	   bounce = getBounce(); 
	   PlayedBlockAssignment pblock = bounce.getHitBlock(); 
	   
	   Block block = pblock.getBlock(); 
	   int bscore = block.getPoints();
	   
	   this.setScore(score + bscore); 
	   pblock.delete();
	   bounceBall();
  }

  // line 144 "Block223States.ump"
   private void doHitBlockNextLevel(){
    doHitBlock(); 
	   int level = getCurrentLevel(); 
	   setCurrentLevel(level+1); 
	   
	   setCurrentPaddleLength(getGame().getPaddle().getMaxPaddleLength() -
			   (getGame().getPaddle().getMaxPaddleLength() - getGame().getPaddle().getMinPaddleLength())/
			   (getGame().numberOfLevels() - 1) * (getCurrentLevel() - 1));
	   
	   setWaitTime(INITIAL_WAIT_TIME * Math.pow(getGame().getBall().getBallSpeedIncreaseFactor(), 
			   (getCurrentLevel() - 1)));
  }

  // line 157 "Block223States.ump"
   private void doHitNothingAndNotOutOfBounds(){
    double x = getCurrentBallX();
    double y = getCurretBallY();
    double dx = getBallDirectionX();
    double dy = getBallDirectionY();
    setCurrentBallX(x + dx);
    setCurrentBallY(y + dy);
  }

  // line 166 "Block223States.ump"
   private void doGameOver(){
    // TODO implement
  }


  /**
   * Helper methods
   */
  // line 172 "Block223States.ump"
   private BouncePoint calculateBouncePointPaddle(){
    int x=(int)getCurrentPaddleX();
  	int y=(int)getCurrentPaddleY();
  	int length=(int)getCurrentPaddleLength();
  	int radius=Ball.BALL_DIAMETER/2;
  	int width=Paddle.PADDLE_WIDTH;
  	Rectangle2D A=new Rectangle2D.Float(x,y-radius,length,width );
  	Rectangle2D B=new Rectangle2D.Float(x-radius,y,length,width );
  	Rectangle2D C=new Rectangle2D.Float(x+length,y,length,width );
  	Rectangle2D F=new Rectangle2D.Float(x+length,y-radius,length,width);
  	Rectangle2D E=new Rectangle2D.Float(x-radius,y-radius,length,width);
  	
  	Line2D segment=new Line2D.Float((float)getCurrentBallX(),(float)getCurrentBallY(),
  			(float)(getCurrentBallX()+getBallDirectionX()),(float)(getCurrentBallY()+getBallDirectionY()));
  	
  	if(segment.intersects(A)){
  		
  	}else if(segment.intersects(B)){
  	
  	}else if(segment.intersects(C)){
  	
  	}else if(segment.intersects(F)){
  	
  	}else if(segment.intersects(E)){
  	
  	}
  	return null;
  }

  // line 201 "Block223States.ump"
   private BouncePoint calculateBouncePointWall(){
    return null;
  }

  // line 206 "Block223States.ump"
   private void bounceBall(){
    
  }

  // line 209 "Block223States.ump"
   private BouncePoint calculateBouncePointBlock(PlayedBlockAssignment block){
    return null;
  }

  // line 213 "Block223States.ump"
   private boolean isCloser(BouncePoint first, BouncePoint second){
    double ballPosX = getCurrentBallX(); 
	    double ballPosY = getCurrentBallY(); 
	    
	    if(first == null) {
	    	return false; 
	    }
	    
	    if(second == null) {
	    	return true; 
	    }
	    
	    //we will use euclidean distance to see which is closer 
	    double distToFirst = Math.sqrt(Math.pow((first.getX() - ballPosX),2) + 
	    							   Math.pow(first.getY() - ballPosY, 2));

	    double distToSecond = Math.sqrt(Math.pow((second.getX() - ballPosX),2) + 
				   Math.pow(second.getY() - ballPosY, 2));
	    
	    if(distToFirst <= distToSecond) {
	    	return true; 
	    }
	    return false;
  }

}