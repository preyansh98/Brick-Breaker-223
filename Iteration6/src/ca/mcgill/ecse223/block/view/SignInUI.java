package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
		frame.getContentPane().setBackground(new Color(106,108,110));
		
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setForeground(Color.white);
		lblUsername.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(Color.white);
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
		lblNewUser.setForeground(Color.WHITE);
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
		
		BlockPreview blockPreview_4 = new BlockPreview();
		blockPreview_4.color = new Color (255,105,180);
		
		BlockPreview blockPreview_5 = new BlockPreview();
		blockPreview_5.color = new Color (252,201,208);
		
		BlockPreview blockPreview_8 = new BlockPreview();
		blockPreview_8.color = new Color (252, 199, 227); 
		
		BlockPreview blockPreview_9 = new BlockPreview();
		blockPreview_9.color = new Color (254,238,246); 
		
		BlockPreview blockPreview_10 = new BlockPreview();
		blockPreview_10.color = new Color(230,230,250);
		
		JPanel bouncingPanel = new BouncingBall();
		((BouncingBall) bouncingPanel).start(); 
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("block223.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon icon = null; 
		if(img != null) {icon = new ImageIcon(img);}
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(icon);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(blockPreview_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(blockPreview_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(blockPreview, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(41))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(bouncingPanel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewUser)
										.addGap(18)
										.addComponent(btnRegister))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnSignin)
										.addGap(79))))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(157)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPassword)
										.addGap(65)
										.addComponent(passwordTXT, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblUsername)
										.addGap(62)
										.addComponent(usernameTXT, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(205)
							.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
							.addGap(212)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(blockPreview_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(blockPreview_10, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(blockPreview_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(blockPreview_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(blockPreview_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(blockPreview_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(blockPreview, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(14)
									.addComponent(blockPreview_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(blockPreview_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(usernameTXT, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTXT, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(bouncingPanel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(btnSignin)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewUser)
								.addComponent(btnRegister))
							.addGap(53))))
		);
		
		BlockPreview blockPreview_3 = new BlockPreview();
		blockPreview_3.setBounds(0, 0, 40, 40);
		blockPreview_10.add(blockPreview_3);
		blockPreview_3.color = new Color (219,112,147);
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
