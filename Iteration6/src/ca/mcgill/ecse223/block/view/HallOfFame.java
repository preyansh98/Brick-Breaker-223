package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

public class HallOfFame extends JLayeredPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HallOfFame() {
		this.setSize(150, 500);
		this.repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	public void refresh() {
		
	}
	
}
