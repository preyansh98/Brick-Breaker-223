package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOHallOfFame;
import ca.mcgill.ecse223.block.controller.TOHallOfFameEntry;

public class HallOfFame extends JPanel {
	private static final long serialVersionUID = 1L;
	private int HOFpage = 0;
	
	private JLabel[] userScores=new JLabel[10]; 
	private JLabel name;
	public HallOfFame() {
		this.setSize(150, 500);
		this.repaint();
		
		try {
			
			TOHallOfFame to=Block223Controller.getHallOfFame(0+HOFpage*10, 9+HOFpage*10);
			name=new JLabel("Hall of Fame: "+ to.getGamename());
			
			name.setLocation(10, 10);
			name.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
			this.add(name);
			refresh();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	
	public void refresh() {
		for (int i=0; i<10;i++) {
			if(userScores[i]!=null) {
				this.remove(userScores[i]);
			}
		}
		try {
			TOHallOfFame to=Block223Controller.getHallOfFame(0+HOFpage*10, 9+HOFpage*10);
			int i=0;
			for (TOHallOfFameEntry entry: to.getEntries()) {
				userScores[i]=new JLabel((HOFpage*10+i)+". "+entry.getPlayername()+ " : "+ entry.getScore());
				userScores[i].setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
				userScores[i].setLocation(100+i*20,10);
				this.add(userScores[i]);
				i++;
			}
		} catch (InvalidInputException e) {
			
		}
	}

	public void nextPage() {
		HOFpage++;
		refresh();
	}

	public void prevPage() {
		if (HOFpage > 0) {
			HOFpage--;
		}
		refresh();
	}
}
