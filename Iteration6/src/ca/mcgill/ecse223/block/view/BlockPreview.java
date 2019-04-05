package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;


public class BlockPreview extends JLayeredPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Rectangle2D rect = new Rectangle2D.Float(0, 0, 40, 40);
	Color color = new Color(50, 50, 50);

	public BlockPreview() {
		super();
		this.setSize(40, 40);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	public void update(int r, int g, int b) {
		color = new Color(r, g, b);
	}

	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setColor(color);

		g2d.fill(rect);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}

}
