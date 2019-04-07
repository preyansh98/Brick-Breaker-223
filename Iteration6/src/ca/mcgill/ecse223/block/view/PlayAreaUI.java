package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOCurrentBlock;
import ca.mcgill.ecse223.block.controller.TOCurrentlyPlayedGame;

public class PlayAreaUI extends JLayeredPane {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Graphics2D g2d;
	private int score=0;
	private int lives=0;
	private int level=0;
	private boolean isSecondPlayer=false;
	public PlayAreaUI () {
		super();
		this.setSize(390,390);
		//repaint();
	}
	public PlayAreaUI(boolean second) {
		super();
		this.setSize(390,390);
		isSecondPlayer=second;
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
	
	private void doDrawing(Graphics g) {
			g2d=(Graphics2D)g.create();
			RenderingHints rh=new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setRenderingHints(rh);
			TOCurrentlyPlayedGame game=null;
			try {
				if (!isSecondPlayer) {
					game = Block223Controller.getCurrentPlayableGame();
				}else {
					game = Block223Controller.getSecondPlayableGame();
				}
			} catch (InvalidInputException e) {
				
			}catch(Exception e) {
				return;
			}
			if(game!=null) {
			List<TOCurrentBlock> blocks=game.getBlocks();
			score=game.getScore();
			lives=game.getLives();
			level=game.getCurrentLevel();
			for(TOCurrentBlock block:blocks) {
				Rectangle2D rect=new Rectangle2D.Double(block.getX(),block.getY(),20,20);
				Color color=new Color(block.getRed(),block.getGreen(), block.getBlue());
				g2d.setColor(color);
				g2d.fill(rect);
			}
			// Draw Paddle
				Rectangle2D paddle=new Rectangle2D.Double(game.getCurrentPaddleX(),355,game.getCurrentPaddleLength(),5);
				g2d.setColor(Color.gray);
				g2d.fill(paddle);
			// Draw Ball\
				g2d.setColor(Color.RED);
				g2d.fillOval(game.getCurrentBallX()-5,game.getCurrentBallY()-5,10,10);
			}
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}
	public int getScore() {
		return score;
	}
	public int getLives() {
		return lives;
	}
	public int getLevel() {
		return level;
	}
	public void displayGameOver() {
		JLabel gameOver=new JLabel("Game Over!");
		gameOver.setLocation(180,180);
		gameOver.setSize(300,300);
		for (int i=0; i<50;i++) {
			gameOver.setFont(new Font("Century Gothic", Font.BOLD, i));
			gameOver.setSize(10+i*6,10+i*6);
			gameOver.setLocation(180-(i*7)/2,180-(i*7)/2);
			gameOver.setForeground(Color.RED);
			this.add(gameOver);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i<49)this.remove(gameOver);
		}
	}
	public void displayCongratulations() {
		JLabel congrats=new JLabel("Congratulations!");
		congrats.setLocation(180,180);
		congrats.setSize(300,300);
		for (int i=0; i<35;i++) {
			congrats.setFont(new Font("Century Gothic", Font.BOLD, i));
			congrats.setSize(10+i*9,10+i*7);
			congrats.setLocation(180-(i*9)/2,180-(i*9)/2);
			congrats.setForeground(Color.RED);
			this.add(congrats);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i<34)this.remove(congrats);
		}
	}


}
