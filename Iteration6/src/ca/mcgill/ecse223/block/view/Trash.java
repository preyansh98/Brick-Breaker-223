package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Trash extends JPanel{
	public Trash() {
		super();
		//System.out.println("creating trash");
		BufferedImage img;
		try {
			this.setSize(200,200);
			img = ImageIO.read(new File("pacman_resize.jpg"));
			 ImageIcon icon = new ImageIcon(img);
		        JLabel label = new JLabel(icon);
		       // JOptionPane.showMessageDialog(null, label);
		        label.setLocation(0,0);
		        this.add(label);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.repaint();
		
		
	}
	
}
