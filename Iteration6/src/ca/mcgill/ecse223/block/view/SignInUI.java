package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import java.awt.Panel;
import javax.swing.JPanel;

public class SignInUI {

	private static JFrame frame;
	private static JTextField usernameTXT;
	private static JPasswordField passwordTXT;
	private static JLabel errorMsg; 

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame("Sign in");
		frame.setVisible(true);
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		frame.setBounds(100, 100, 722, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		JLabel lblWelcomeToBlock = new JLabel("WELCOME to Block223!");
		lblWelcomeToBlock.setFont(new Font("Arial Black", Font.BOLD, 22));
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		usernameTXT = new JTextField();
		usernameTXT.setColumns(10);
		
		passwordTXT = new JPasswordField();
		passwordTXT.setColumns(10);
		passwordTXT.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					signinButtonActionPerformed(usernameTXT,
							passwordTXT, errorMsg);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
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
		errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signinButtonActionPerformed(usernameTXT,
						passwordTXT,  errorMsg);
			}
		});
		
		BlockPreview blockPreview = new BlockPreview();
		blockPreview.color = Color.PINK; 
		
		BlockPreview blockPreview_1 = new BlockPreview();
		blockPreview_1.color = Color.BLACK; 
		
		BlockPreview blockPreview_2 = new BlockPreview();
		blockPreview_2.color = Color.BLUE; 
		
		BlockPreview blockPreview_3 = new BlockPreview();
		blockPreview_3.color = Color.CYAN; 
		
		BlockPreview blockPreview_4 = new BlockPreview();
		blockPreview_4.color = Color.GREEN; 
		
		BlockPreview blockPreview_5 = new BlockPreview();
		blockPreview_5.color = Color.MAGENTA; 
		
		BlockPreview blockPreview_6 = new BlockPreview();
		blockPreview_6.color = Color.ORANGE; 
		
		BlockPreview blockPreview_7 = new BlockPreview();
		blockPreview_7.color = Color.RED; 
		
		BlockPreview blockPreview_8 = new BlockPreview();
		blockPreview_8.color = Color.WHITE; 
		
		BlockPreview blockPreview_9 = new BlockPreview();
		blockPreview_9.color = Color.YELLOW; 
		
		BlockPreview blockPreview_10 = new BlockPreview();
		blockPreview_10.color = new Color(230,230,250);
		
		JPanel bouncingPanel = new BouncingBall();
		((BouncingBall) bouncingPanel).start(); 
		 
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(371, Short.MAX_VALUE)
					.addComponent(lblNewUser)
					.addGap(77)
					.addComponent(btnRegister)
					.addGap(109))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(bouncingPanel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSignin))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(72, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPassword)
									.addComponent(lblUsername))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(blockPreview_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(27)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(48)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(usernameTXT, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
											.addComponent(passwordTXT)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(110)
										.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(212)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblWelcomeToBlock)
									.addGap(23)))))
					.addGap(52)
					.addComponent(blockPreview_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(88))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(blockPreview, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(blockPreview_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(115)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(blockPreview_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
							.addComponent(blockPreview_7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(blockPreview_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(126)
							.addComponent(blockPreview_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
							.addComponent(blockPreview_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(blockPreview_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(blockPreview_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(blockPreview, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(blockPreview_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(19)
											.addComponent(lblWelcomeToBlock)
											.addGap(71)
											.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
										.addComponent(blockPreview_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(blockPreview_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
								.addComponent(blockPreview_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername)
								.addComponent(usernameTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(passwordTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(blockPreview_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(blockPreview_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(blockPreview_7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(blockPreview_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(blockPreview_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(blockPreview_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(btnSignin)
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewUser)
								.addComponent(btnRegister))
							.addGap(77))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bouncingPanel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(157))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private static  void signinButtonActionPerformed(JTextField usernameTextEntry,
			JPasswordField passwordTextEntry, JLabel errorMsg) {
		try {
			Block223Controller.login(usernameTextEntry.getText(), new String(passwordTextEntry.getPassword()));
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
