package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOCurrentBlock;
import ca.mcgill.ecse223.block.controller.TOCurrentlyPlayedGame;
import ca.mcgill.ecse223.block.controller.TOGridCell;

public class PlayAreaUI extends JLayeredPane {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Graphics2D g2d;
	private int score=0;
	public PlayAreaUI () {
		super();
		this.setSize(390,390);
		//repaint();
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
				game = Block223Controller.getCurrentPlayableGame();
			} catch (InvalidInputException e) {
				
			}catch(Exception e) {
				return;
			}
			if(game!=null) {
			List<TOCurrentBlock> blocks=game.getBlocks();
			score=game.getScore();
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
	


}
