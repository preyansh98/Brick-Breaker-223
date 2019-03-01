package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

import ca.mcgill.ecse223.block.controller.TOGridCell;

@SuppressWarnings("serial")
public class Grid extends JLayeredPane{
	private static Rectangle2D[][] rectangles;
	Graphics2D g2d;
	public Grid () {
		super();
		this.setSize(390,390);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				for(int row=0; row<15;row++) {
					for(int column=0;column<15;column++) {
					if (rectangles[row][column].contains(x, y)) {
						LevelSettingUI.displayBlockInfo( column+1,  row+1);
						break;
					}
				}
				}
				repaint();
			}
		});

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
			TOGridCell[][] temp=LevelSettingUI.getGrid();
			new Rectangle2D.Float(x,y,20,20);
			rectangles=new Rectangle2D[15][15];
			for(int row=0; row<15;row++) {
				for(int column=0;column<15;column++) {
					rectangles[row][column]=new Rectangle2D.Float(x,y,20,20);
					if(temp[row][column]==null) {
						g2d.setColor(Color.WHITE);
					}else {
						Color color=new Color(temp[row][column].getRed(),temp[row][column].getGreen(), temp[row][column].getBlue());
						g2d.setColor(color);
					}
					
					g2d.fill(rectangles[row][column]);
					g2d.setColor(Color.BLACK);
					g2d.draw(rectangles[row][column]);
					x+=25;
					
				}
				x=10;
				y+=22;
			}
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}
	
}
