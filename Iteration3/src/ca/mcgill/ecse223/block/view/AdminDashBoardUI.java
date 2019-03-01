package ca.mcgill.ecse223.block.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.util.HashMap;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOGame;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class AdminDashBoardUI {

	private static JFrame frame;
	private static JTextField textField;
	private static JComboBox<String> games;
//	private static HashMap<Integer, String> currentGames;
	private static JLabel errorMsg;
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame("Admin DashBoard");
		frame.setVisible(true);
		frame.setBounds(100, 100, 648, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAddAGame = new JButton("Add a Game");
		btnAddAGame.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnAddAGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addGameButtonActionPerformed(evt);
			}
		});
		JLabel lblCreateANew = new JLabel("Create a new Game ");
		lblCreateANew.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblOrUpdateExisting = new JLabel("Or Update Existing Game");
		lblOrUpdateExisting.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		games = new JComboBox<String>();
		try {
			refreshGames();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnUpdateGame = new JButton("Update Game");
		btnUpdateGame.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnUpdateGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateGameButtonActionPerformed(evt);
			}
		});
		JButton btnDeleteGame = new JButton("Delete Game");
		btnDeleteGame.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnDeleteGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					deleteGameButtonActionPerformed();
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logout();
			}
		});
		 errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(115)
					.addComponent(games, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(222, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogout)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCreateANew)
									.addContainerGap(436, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblName)
									.addGap(52)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnUpdateGame)
										.addComponent(btnAddAGame)
										.addComponent(btnDeleteGame))
									.addGap(39)))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblOrUpdateExisting)
								.addContainerGap()))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(errorMsg)
					.addGap(18)
					.addComponent(lblCreateANew)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddAGame)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblName)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(55)
					.addComponent(lblOrUpdateExisting)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(games, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateGame))
					.addGap(25)
					.addComponent(btnDeleteGame)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addGap(37))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected static void logout() {
		// TODO Auto-generated method stub
		Block223Controller.logout();
		frame.dispose();
		SignInUI.init();
	}

	private static void addGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		// call the controller
		try {
			
			 Block223Controller.createGame(textField.getText());
			 frame.dispose();
			GameSettingUI.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// add method here to move on to next screen
	}

	private static void deleteGameButtonActionPerformed() throws InvalidInputException {
		
		
		// call the controller
		try {
			 String name = games.getSelectedItem().toString(); 
			 Block223Controller.deleteGame(name);
			 refreshGames();
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		} 
		// add method here to move on to next screen
	}
	
	private static void updateGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		// call the controller
		try {
			frame.dispose();
			String name = games.getSelectedItem().toString();
			Block223Controller.selectGame(name);
			GameSettingUI.init();
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
		// add method here to move on to next screen
	}
	
	
	public static void refreshGames() throws InvalidInputException {
		
		
		
		games.removeAllItems();
	//	gameIndex = 0;
		for (TOGame game : Block223Controller.getDesignableGames()) {
			//currentGames.put(gameIndex, game.getName());
			games.addItem(game.getName());
			//gameIndex++;
		};
		games.setSelectedIndex(-1);
	}
}
