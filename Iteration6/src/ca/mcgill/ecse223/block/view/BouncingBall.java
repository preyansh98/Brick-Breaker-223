package ca.mcgill.ecse223.block.view; 

import java.awt.*;
import javax.swing.*;
 
public class BouncingBall extends JPanel implements Runnable{
Thread thread = null;

  // Box height and width
  int width;
  int height;
 
  // Ball Size
  float radius = 10; 
  float diameter = radius * 2;
 
  float X = radius + 50;
  float Y = radius + 20;
 
  // Direction
  float dx = 1;
  float dy = 1;
 
  
  
  public void start() {
	  if(thread == null) {
		  thread = new Thread(this);
		  thread.start();
	  }}

	  public void stop() {
	    thread = null;
	  }
	  
	  public void run() {
	
	        while (thread != null) {
	        	
	          width = getWidth();
	          height = getHeight();
	 
	          X = X + dx;
	          Y = Y + dy;
	 
	          if (X - radius < 0) {
	            dx = -dx; 
	            X = radius; 
	          } else if (X + radius > width) {
	            dx = -dx;
	            X = width - radius;
	          }
	 
	          if (Y - radius < 0) {
	            dy = -dy;
	            Y = radius;
	          } else if (Y + radius > height) {
	            dy = -dy;
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