package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import ca.mcgill.ecse223.block.controller.TOUserMode.Mode;

public class SignInUI {

	private static JFrame frame;
	private static JTextField usernameTXT;
	private static JPasswordField passwordTXT;


	/**
	 * Initialize the contents of the frame.
	 */
	public static void init() {
		frame = new JFrame("Sign in");
		frame.setVisible(true);
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		frame.setBounds(100, 100, 722, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcomeToBlock = new JLabel("Welcome to Block223!");
		lblWelcomeToBlock.setFont(new Font("Arial Black", Font.BOLD, 22));
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		usernameTXT = new JTextField();
		usernameTXT.setColumns(10);
		
		passwordTXT = new JPasswordField();
		passwordTXT.setColumns(10);
		
		JButton btnSignin = new JButton("Sign-In");
		btnSignin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewUser = new JLabel("New user?");
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerButtonActionPerformed();
			}
		});
		JLabel errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signinButtonActionPerformed(usernameTXT,
						passwordTXT,  errorMsg);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(365, Short.MAX_VALUE)
					.addComponent(lblNewUser)
					.addGap(77)
					.addComponent(btnRegister)
					.addGap(109))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(138)
							.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblUsername))
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblWelcomeToBlock)
								.addComponent(usernameTXT, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
								.addComponent(passwordTXT)))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(294)
							.addComponent(btnSignin)))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addComponent(lblWelcomeToBlock)
					.addGap(18)
					.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(usernameTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(btnSignin)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewUser)
						.addComponent(btnRegister))
					.addGap(71))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private static  void signinButtonActionPerformed(JTextField usernameTextEntry,
			JTextField passwordTextEntry, JLabel errorMsg) {
		try {
			Block223Controller.login(usernameTextEntry.getText(), passwordTextEntry.getText());
			if(Block223Controller.getUserMode().getMode()==Mode.Play) {
				delete();
				PlayerDashUI.init();
			}else if(Block223Controller.getUserMode().getMode()==Mode.Design){
				delete();
				AdminDashBoardUI.init();
			}
		}catch(InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
	}
	private static  void registerButtonActionPerformed() {
		delete();
		RegistrationUI.init();

	}
	private static  void delete() {
		frame.dispose();
	}
}
