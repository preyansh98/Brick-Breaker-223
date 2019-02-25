package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

public class SignInPage {
	static String error_msg = null;
	static JFrame mainFrame = new JFrame("Sign-In");

	public static void main(String[] args) {

		// UI Elements1
		JTextArea welcomeText=new JTextArea("Welcome to Block223");
		JTextArea usernameText = new JTextArea("Username: ");
		JTextArea passwordText = new JTextArea("Password: ");
		JTextArea newUserText=new JTextArea("New User?");
		JButton signinButton = new JButton("Sign-In");
		JButton registerButton = new JButton("Register");
		JTextField usernameTextEntry = new JTextField();
		JTextField passwordTextEntry = new JTextField();
		JTextArea errorMsg = new JTextArea(error_msg);

		// frame related
		mainFrame.setVisible(true);
		mainFrame.setLayout(null);

		// Setting attributes of components
		mainFrame.setSize(400, 300); // this should be consistent across all features
		
		welcomeText.setEditable(false);
		usernameText.setEditable(false);
		passwordText.setEditable(false);
		newUserText.setEditable(false);
		
		welcomeText.setLocation(140, 30);
		welcomeText.setSize(welcomeText.getPreferredSize());
		welcomeText.setBackground(mainFrame.getBackground());
		
		usernameText.setLocation(30, 60);
		Dimension addGameDimension = usernameText.getPreferredSize();
		usernameText.setSize(addGameDimension);
		usernameText.setBackground(mainFrame.getBackground()); // added this so it doesnt stand out

		passwordText.setSize(passwordText.getPreferredSize());
		passwordText.setLocation(30, 110);
		passwordText.setBackground(mainFrame.getBackground());

		usernameTextEntry.setSize(200, 20);
		// setting location in a way that whenever the text moves, the text entry field
		// is always next to it
		usernameTextEntry.setLocation((int) (usernameText.getLocation().x + usernameText.getSize().getWidth() + 20),
				usernameText.getLocation().y);
		passwordTextEntry.setSize(200, 20);
		passwordTextEntry.setLocation((int) (usernameText.getLocation().x + usernameText.getSize().getWidth() + 20),
				passwordText.getLocation().y);

		signinButton.setSize(75, 26);
		signinButton.setLocation(150, 150);

		registerButton.setSize(95, 26);
		registerButton.setLocation(270, 200);
		
		newUserText.setLocation(200, 205);
		newUserText.setSize(newUserText.getPreferredSize());
		newUserText.setBackground(mainFrame.getBackground());
		
		errorMsg.setEditable(false);
		errorMsg.setSize(300, 20);
		errorMsg.setLocation(30, 20);
		errorMsg.setBackground(mainFrame.getBackground());

		// Adding all components to frame
		mainFrame.add(welcomeText);
		mainFrame.add(usernameText);
		mainFrame.add(passwordText);
		mainFrame.add(signinButton);
		mainFrame.add(registerButton);
		mainFrame.add(usernameTextEntry);
		mainFrame.add(passwordTextEntry);
		mainFrame.add(errorMsg);
		mainFrame.add(newUserText);
		// Design here:
		mainFrame.setBackground(Color.gray); // could probably do some rgb

		// Listener for buttons
		registerButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt);
			}
		});

		signinButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				signinButtonActionPerformed(evt,usernameTextEntry, passwordTextEntry,errorMsg);
			}
		});

	}

	protected static void signinButtonActionPerformed(ActionEvent evt, JTextField usernameTextEntry,
			JTextField passwordTextEntry, JTextArea errorMsg) {
		// TODO Auto-generated method stub
		try {
			Block223Controller.login(usernameTextEntry.getText(), passwordTextEntry.getText());
		}catch(InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
	}

	/**
	 * Specification for addGame event when listener activated
	 * 
	 * @param evt
	 */
	private static void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
		

	}


	void initializeThis() {
		mainFrame.setVisible(true);
		this.main(null);
	}

}
