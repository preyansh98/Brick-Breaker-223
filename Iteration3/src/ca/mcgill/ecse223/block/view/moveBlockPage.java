package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.*;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOBlock;
import ca.mcgill.ecse223.block.controller.TOGame;
import ca.mcgill.ecse223.block.model.Game;
import ca.mcgill.ecse223.block.model.Level;


public class moveBlockPage {
	
	static JTextField oldxentry = new JTextField();
	static JTextField oldyentry = new JTextField();
	
	static JTextField newxentry = new JTextField();
	static JTextField newyentry = new JTextField();
	
	static JFrame mainWindow = new JFrame("move block Settings");
	
	public static void main(String[] args) {
	
	//old x and y
		
	JTextArea oldInputx = new JTextArea("Input old X:");
	JTextArea oldInputy = new JTextArea("Input old Y:");
	
	oldxentry.setSize(50, 20);
	oldyentry.setSize(50, 20);
	
	oldInputx.setLocation(10, 70);
	Dimension oldInputxdimension = oldInputx.getPreferredSize();
	oldInputx.setSize(oldInputxdimension);
	oldInputx.setBackground(mainWindow.getBackground()); //added this so it doesnt stand out
	
	oldInputy.setLocation(10, 100);
	Dimension oldInputydimension = oldInputx.getPreferredSize();
	oldInputy.setSize(oldInputydimension);
	oldInputy.setBackground(mainWindow.getBackground()); //added this so it doesnt stand out
	
	oldxentry.setLocation((int) (oldInputx.getLocation().x + oldInputx.getSize().getWidth() + 20), 
			oldInputx.getLocation().y);
	oldyentry.setLocation((int) (oldInputy.getLocation().x + oldInputy.getSize().getWidth() + 20), 
			oldInputy.getLocation().y);
	
	//new x and y
	
	JTextArea newInputx = new JTextArea("Input new X:");
	JTextArea newInputy = new JTextArea("Input new Y:");
	
	newxentry.setSize(55, 20);
	newyentry.setSize(55, 20);
	
	newInputx.setLocation(5, 160);
	Dimension newInputxdimension = newInputx.getPreferredSize();
	newInputx.setSize(newInputxdimension);
	newInputx.setBackground(mainWindow.getBackground()); //added this so it doesnt stand out
	
	newInputy.setLocation(5, 190);
	Dimension newInputydimension = newInputx.getPreferredSize();
	newInputy.setSize(newInputydimension);
	newInputy.setBackground(mainWindow.getBackground()); //added this so it doesnt stand out
	
	 newxentry.setLocation((int) (newInputx.getLocation().x + newInputx.getSize().getWidth() + 20), 
			newInputx.getLocation().y);
	newyentry.setLocation((int) (newInputy.getLocation().x + newInputy.getSize().getWidth() + 20), 
			newInputy.getLocation().y);
	
	mainWindow.setVisible(true);
	mainWindow.setLayout(null);
	mainWindow.setSize(400, 400);
	mainWindow.add(oldxentry);
	mainWindow.add(oldyentry);
	mainWindow.add(oldInputx);
	mainWindow.add(oldInputy);
	mainWindow.add(newxentry);
	mainWindow.add(newyentry);
	mainWindow.add(newInputx);
	mainWindow.add(newInputy);
	
	
	
	}

}
