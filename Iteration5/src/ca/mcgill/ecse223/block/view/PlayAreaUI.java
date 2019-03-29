package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

public class PlayAreaUI extends JLayeredPane implements Block223PlayModeInterface{

	
	Graphics2D g2d;
	public PlayAreaUI () {
		super();
		this.setSize(390,390);
		repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
	public static void update() {
		
	}
	private void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
			int y=5;
			int x=10;
			g2d=(Graphics2D)g.create();
			TOCurrentlyPlayedGame game=null;
			try {
				game = Block223Controller.getCurrentPlayableGame();
			} catch (InvalidInputException e) {
				
			}
			List<TOCurrentBlock> blocks=game.getBlocks();
			for(TOCurrentBlock block:blocks) {
				Rectangle2D rect=new Rectangle2D.Double(block.getX(),block.getY(),20,20);
				Color color=new Color(block.getRed(),block.getGreen(), block.getBlue());
				g2d.setColor(color);
				g2d.fill(rect);
			}
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}
	
	
	
	@Override
	public String takeInputs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
