package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

public class RegistrationUI {

	private static JFrame frame;
	private static JTextField usernameTXT;
	private static JPasswordField playerTXT;
	private static JPasswordField adminTXT;
	private static JButton btnCancel;
	private static JLabel errorMsg;
	private static JLabel lblBlock;


	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame("Sign Up");
		frame.getContentPane().setBackground(new Color(102, 102, 102));
		frame.setVisible(true);
		frame.setBounds(100, 100, 742, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblPlayerPassword = new JLabel("Player password:");
		lblPlayerPassword.setForeground(new Color(255, 255, 255));
		lblPlayerPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblAdminPassword = new JLabel("Admin password: ");
		lblAdminPassword.setForeground(new Color(255, 255, 255));
		lblAdminPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		usernameTXT = new JTextField();
		usernameTXT.setColumns(10);
		
		playerTXT = new JPasswordField();
		playerTXT.setColumns(10);
		
		adminTXT = new JPasswordField();
		adminTXT.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(0, 153, 0));
		btnRegister.setFont(new Font("Century Gothic", Font.BOLD, 19));
		btnRegister.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt, usernameTXT, playerTXT,adminTXT,errorMsg);
			}
		});
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				returnButtonActionPerformed(evt);
			}
		});
		errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		lblBlock = new JLabel("BLOCK223");
		lblBlock.setForeground(new Color(255, 204, 204));
		lblBlock.setFont(new Font("Century Gothic", Font.BOLD, 38));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
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
							.addGap(42)
							.addComponent(btnCancel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(190)
							.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(162, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(279, Short.MAX_VALUE)
					.addComponent(lblBlock)
					.addGap(259))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(344, Short.MAX_VALUE)
					.addComponent(btnRegister)
					.addGap(277))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblBlock)
					.addGap(33)
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
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
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
