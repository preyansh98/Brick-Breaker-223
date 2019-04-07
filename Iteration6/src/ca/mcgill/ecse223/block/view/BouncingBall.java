package ca.mcgill.ecse223.block.view; 

import java.awt.*;
import javax.swing.*;
 
/**
 * Additional feature: An independent bouncing ball on our sign in page
 * @author Preyansh
 *
 */

public class BouncingBall extends JPanel implements Runnable{
Thread thread = null;

  int width, height;
  float radius = 10;  
  float diameter = radius * 2;
 
  float X = radius + 80;
  float Y = radius + 20;
 
  //speeds
  float speedX = 3;
  float speedY = 3;
  
  /**
   * Created to give thread functionalities. 
   */
  public void start() {
	  if(thread == null) {
		  thread = new Thread(this);
		  thread.start();
	  }}

  	/**
  	 * This method is never needed, but added in case. 
  	 */
	  public void stop() {
	    thread = null;
	  }
	  
	  public void run() {
	
	        while (thread != null) {
	        	
	          width = getWidth();
	          height = getHeight();
	 
	          X = X + speedX;
	          Y = Y + speedY;
	 
	          if (X - radius < 0) {
	            speedX = -speedX; 
	            X = radius; 
	          } else if (X + radius > width) {
	            speedX = -speedX;
	            X = width - radius;
	          }
	 
	          if (Y - radius < 0) {
	            speedY = -speedY;
	            Y = radius;
	          } else if (Y + radius > height) {
	            speedY = -speedY;
	            Y = height - radius;
	          }
	          
	          
	          repaint();
	 
	          try {
	            Thread.sleep(50);
	          } catch (InterruptedException ex) {
	          }
	 
	        }
	        thread = null;
	      }
	 
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.RED);
	    g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
	  }
	
	}