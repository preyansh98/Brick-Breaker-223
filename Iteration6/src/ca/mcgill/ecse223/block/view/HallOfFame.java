package ca.mcgill.ecse223.block.view;

import java.awt.BorderLayout;
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
		super(new BorderLayout());
		this.setSize(179, 500);
		this.repaint();
		
		try {
			
			TOHallOfFame to=Block223Controller.getHallOfFame(0+HOFpage*10, 9+HOFpage*10);
			name=new JLabel("Hall of Fame: "+ to.getGamename());
			name.setSize(169,50);
			name.setLocation(10, 10);
			name.setFont(new Font("Century Gothic", Font.BOLD, 16));
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
				userScores[i].setFont(new Font("Century Gothic", Font.BOLD, 16));
				userScores[i].setSize(140,30);
				userScores[i].setLocation(10,60+i*20);
				this.add(userScores[i]);
				i++;
				System.out.println(" "+ i);
			}
			
			while(i<10) {
				userScores[i]=new JLabel((HOFpage*10+i)+".TBD");
				userScores[i].setFont(new Font("Century Gothic", Font.BOLD, 16));
				userScores[i].setSize(140,40);
				userScores[i].setLocation(10,60+i*20);
				this.add(userScores[i]);
				i++;
			}
			JLabel dummy=new JLabel("");
			dummy.setSize(140,40);
			dummy.setLocation(10, 300);
			this.add(dummy);
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
