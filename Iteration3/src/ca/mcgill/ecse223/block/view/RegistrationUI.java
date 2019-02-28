package ca.mcgill.ecse223.block.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

import java.awt.Color;

public class RegistrationUI {

	private static JFrame frame;
	private static JTextField usernameTXT;
	private static JTextField playerTXT;
	private static JTextField adminTXT;
	private static JButton btnCancel;
	private static JLabel errorMsg;


	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 742, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblPlayerPassword = new JLabel("Player password:");
		lblPlayerPassword.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblAdminPassword = new JLabel("Admin password: ");
		lblAdminPassword.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		usernameTXT = new JTextField();
		usernameTXT.setColumns(10);
		
		playerTXT = new JTextField();
		playerTXT.setColumns(10);
		
		adminTXT = new JTextField();
		adminTXT.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		btnRegister.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt, usernameTXT, playerTXT,adminTXT,errorMsg);
			}
		});
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				returnButtonActionPerformed(evt);
			}
		});
		errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPlayerPassword)
								.addComponent(lblAdminPassword)
								.addComponent(lblUsername))
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(adminTXT)
								.addComponent(playerTXT)
								.addComponent(usernameTXT, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(285)
							.addComponent(btnRegister))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(btnCancel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(190)
							.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(errorMsg)
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(usernameTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlayerPassword)
						.addComponent(playerTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdminPassword)
						.addComponent(adminTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(btnRegister)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addGap(55))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private static void returnButtonActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		delete();
		SignInUI.init();
		
	}

	private static void registerButtonActionPerformed(java.awt.event.ActionEvent evt, JTextField usernameTextEntry,
			JTextField playerPasswordTextEntry,JTextField adminPasswordTextEntry, JLabel errorMsg2) {
		

		// call the controller
		try {
			Block223Controller.register(usernameTextEntry.getText(), playerPasswordTextEntry.getText(), adminPasswordTextEntry.getText());
			delete();
			SignInUI.init();
		} catch (InvalidInputException e) {
		
			errorMsg2.setText(e.getMessage());
		
		}

		// add method here to move on to next screen

	}
	private static void delete() {
		frame.dispose();
	}
}
