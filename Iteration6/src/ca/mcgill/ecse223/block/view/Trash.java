package ca.mcgill.ecse223.block.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Trash extends JPanel{
	
	public static BufferedImage img, img2; 
	private static JLabel label; 
	private static ImageIcon icon, icon2; 
	
	public Trash() {
		super();
		//System.out.println("creating trash");
		try {
			this.setSize(200,200);
			img = ImageIO.read(new File("pacman_open.jpg"));
			img2 = ImageIO.read(new File("pacman_closed.jpg"));
			 icon = new ImageIcon(img);
			 icon2 = new ImageIcon(img2); 
		        label = new JLabel(icon);
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
	
	public void closePacMouth() {
		label.setIcon(icon2);
	}
	public void openPacMouth() {
		label.setIcon(icon);
	}
	
}
