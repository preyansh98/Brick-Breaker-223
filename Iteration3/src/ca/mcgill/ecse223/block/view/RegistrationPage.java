package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

public class RegistrationPage {
	static String error_msg = null;
	static JFrame mainFrame = new JFrame("Registration");

	public static void main(String[] args) {

		// UI Elements1
		
		JTextArea usernameText = new JTextArea("Username: ");
		JTextArea playerPasswordText = new JTextArea("Player password:");
		JTextArea adminPasswordText = new JTextArea("Admin password:");
		JButton registerButton = new JButton("Register");
		JTextField usernameTextEntry = new JTextField();
		JTextField playerPasswordTextEntry = new JTextField();
		JTextField adminPasswordTextEntry = new JTextField();
		JTextArea errorMsg = new JTextArea(error_msg);
		JButton returnButton = new JButton("Return");
		// frame related
		mainFrame.setVisible(true);
		mainFrame.setLayout(null);
		mainFrame.setSize(400, 300);
		

	
		usernameText.setEditable(false);
		playerPasswordText.setEditable(false);
		adminPasswordText.setEditable(false);

		// Username text
		usernameText.setLocation(30, 60);
		Dimension addGameDimension = usernameText.getPreferredSize();
		usernameText.setSize(addGameDimension);
		usernameText.setBackground(mainFrame.getBackground());
		// Player Password text
		playerPasswordText.setSize(playerPasswordText.getPreferredSize());
		playerPasswordText.setLocation(30, usernameText.getLocation().y+40);
		playerPasswordText.setBackground(mainFrame.getBackground());
	
		// Admin Password Text
		adminPasswordText.setSize(adminPasswordText.getPreferredSize());
		adminPasswordText.setLocation(30, playerPasswordText.getLocation().y+40);
		adminPasswordText.setBackground(mainFrame.getBackground());

		// Text field positioning
		usernameTextEntry.setSize(200, 20);
		// setting location in a way that whenever the text moves, the text entry field
		// is always next to it
		usernameTextEntry.setLocation((int) (usernameText.getLocation().x + usernameText.getSize().getWidth() + 40),
				usernameText.getLocation().y);

		playerPasswordTextEntry.setSize(200, 20);
		playerPasswordTextEntry.setLocation(
				(int) (usernameTextEntry.getLocation().x ),
				playerPasswordText.getLocation().y);

		adminPasswordTextEntry.setSize(200, 20);
		adminPasswordTextEntry.setLocation(
				(int) (usernameTextEntry.getLocation().x),playerPasswordText.getLocation().y + 40);

		registerButton.setSize(95, 25);
		registerButton.setLocation(150, adminPasswordTextEntry.getLocation().y+40);
		
		returnButton.setSize(95,25);
		returnButton.setLocation(20, 200);
		
		
		errorMsg.setEditable(false);
		errorMsg.setSize(300, 20);
		errorMsg.setLocation(30, 20);
		errorMsg.setBackground(mainFrame.getBackground());

		// Adding all components to frame
	
		mainFrame.add(usernameText);
		mainFrame.add(playerPasswordText);
		mainFrame.add(registerButton);
		mainFrame.add(usernameTextEntry);
		mainFrame.add(playerPasswordTextEntry);
		mainFrame.add(errorMsg);
		mainFrame.add(returnButton);
		mainFrame.add(adminPasswordTextEntry);
		mainFrame.add(adminPasswordText);
		
		mainFrame.setBackground(Color.gray);
		// Listener for buttons
		registerButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt, usernameTextEntry, playerPasswordTextEntry,adminPasswordTextEntry,errorMsg);
			}
		});
		
		returnButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				returnButtonActionPerformed(evt);
			}
		});

	}

	protected static void returnButtonActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	private static void registerButtonActionPerformed(java.awt.event.ActionEvent evt, JTextField usernameTextEntry,
			JTextField playerPasswordTextEntry,JTextField adminPasswordTextEntry, JTextArea errorMsg) {
		// clear error message
		error_msg = null;

		// call the controller
		try {
			System.out.println("run");
			Block223Controller.register(usernameTextEntry.getText(), playerPasswordTextEntry.getText(), adminPasswordTextEntry.getText());
		} catch (InvalidInputException e) {
			error_msg = e.getMessage();
			errorMsg.setText(error_msg);
			System.out.println(error_msg);
		}

		// add method here to move on to next screen

	}

}
