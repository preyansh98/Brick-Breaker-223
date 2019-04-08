package ca.mcgill.ecse223.block.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class SecondPlayerLoginUI {

	private static JFrame frame;
	private static JTextField txtLoginUser;
	private static JPasswordField txtLoginPass;
	private static JTextField txtRegisterUser;
	private static JPasswordField txtRegPlayPass;
	private static JTextField txtRegAdminPass;
	private static JLabel errorMsg;

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(106,108,110));
		JSeparator separator = new JSeparator();
		
		JButton btnGhost = new JButton("Ghost Mode");
		btnGhost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ghostMode();
			}
		});
		
		JLabel lblUsername = new JLabel("Username : ");
		
		txtLoginUser = new JTextField();
		txtLoginUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		
		txtLoginPass = new JPasswordField();
		txtLoginPass.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		JLabel lblUsername_1 = new JLabel("Username: ");
		
		txtRegisterUser = new JTextField();
		txtRegisterUser.setColumns(10);
		
		JLabel lblPlayerPassword = new JLabel("Player password:");
		
		JLabel lblAdminPassowrd = new JLabel("Admin Passowrd: ");
		
		txtRegPlayPass = new JPasswordField();
		txtRegPlayPass.setColumns(10);
		
		txtRegAdminPass = new JTextField();
		txtRegAdminPass.setColumns(10);
		
		JLabel lblDontWantTo = new JLabel("Don't want to login?");
		
		JLabel lblReturningUser = new JLabel("Returning user? ");
		
		JLabel lblNewUser = new JLabel("New User? ");
		
		JSeparator separator_1 = new JSeparator();
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		
		 errorMsg = new JLabel("");
		errorMsg.setFont(new Font("HYGothic-Extra", Font.PLAIN, 15));
		errorMsg.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewUser)
						.addComponent(lblReturningUser)
						.addComponent(lblPlayerPassword)
						.addComponent(lblAdminPassowrd)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername_1)
								.addComponent(lblPassword)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtLoginUser, Alignment.TRAILING)
								.addComponent(txtRegPlayPass)
								.addComponent(txtRegisterUser, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
								.addComponent(txtRegAdminPass)
								.addComponent(btnLogin, Alignment.TRAILING)
								.addComponent(txtLoginPass, Alignment.TRAILING)
								.addComponent(btnRegister, Alignment.TRAILING)
								.addComponent(btnGoBack)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDontWantTo)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnGhost, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
						.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(errorMsg)
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDontWantTo)
							.addGap(12))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGhost, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReturningUser)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtLoginUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPassword)
						.addComponent(txtLoginPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin)
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewUser)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername_1)
						.addComponent(txtRegisterUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlayerPassword)
						.addComponent(txtRegPlayPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdminPassowrd)
						.addComponent(txtRegAdminPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(btnRegister)
					.addGap(18)
					.addComponent(btnGoBack)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	private static void goBack() {
		frame.dispose();
		PlayerDashUI.init();
		
	}

	private static void register() {
		try {
			Block223Controller.registerSecondPlayer(txtRegisterUser.getText(), new String(txtRegPlayPass.getPassword()),txtRegAdminPass.getText());
			frame.dispose();
			OneVsOneModeUI test=new OneVsOneModeUI();
			test.initialize();
		}catch(InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
	}

	private static void login() {
		try {
			Block223Controller.loginSecondPlayer(txtLoginUser.getText(), new String(txtLoginPass.getPassword()));
			OneVsOneModeUI test = new OneVsOneModeUI();
			test.initialize();
		}catch(InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
	}

	private static void ghostMode() {
		OneVsOneModeUI test = new OneVsOneModeUI();
		test.initialize();
		
	}
}
