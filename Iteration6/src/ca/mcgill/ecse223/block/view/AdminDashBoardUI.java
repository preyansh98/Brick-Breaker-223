package ca.mcgill.ecse223.block.view;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
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
		btnAddAGame.setBackground(new Color(51, 204, 153));
		btnAddAGame.setForeground(new Color(51, 153, 0));
		btnAddAGame.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnAddAGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addGameButtonActionPerformed(evt);
			}
		});
		JLabel lblCreateANew = new JLabel("Create a new Game ");
		lblCreateANew.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblOrUpdateExisting = new JLabel("Or Update Existing Game");
		lblOrUpdateExisting.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		games = new JComboBox<String>();
		games.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		try {
			refreshGames();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		JButton btnUpdateGame = new JButton("Update Game");
		btnUpdateGame.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnUpdateGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateGameButtonActionPerformed(evt);
			}
		});
		JButton btnDeleteGame = new JButton("Delete Game");
		btnDeleteGame.setForeground(new Color(204, 0, 0));
		btnDeleteGame.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnDeleteGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					deleteGameButtonActionPerformed();
				} catch (InvalidInputException e) {
					e.printStackTrace();
				}
			}
		});
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logout();
			}
		});
		 errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		JLabel lblBlock = new JLabel("BLOCK");
		lblBlock.setForeground(new Color(51, 102, 255));
		lblBlock.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		JLabel label = new JLabel("223");
		label.setForeground(new Color(153, 0, 0));
		label.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
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
									.addContainerGap(444, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblName)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(50)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(games, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(btnUpdateGame)
													.addGap(18)
													.addComponent(btnDeleteGame)))))
									.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
									.addComponent(btnAddAGame)
									.addGap(55)))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblOrUpdateExisting)
								.addContainerGap()))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(189, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(220)
					.addComponent(lblBlock)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBlock, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(errorMsg)
					.addGap(18)
					.addComponent(lblCreateANew)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddAGame))
					.addGap(61)
					.addComponent(lblOrUpdateExisting)
					.addGap(45)
					.addComponent(games, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdateGame)
						.addComponent(btnDeleteGame))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addGap(37))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected static void logout() {
		Block223Controller.logout();
		frame.dispose();
		SignInUI.init();
	}

	private static void addGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		// call the controller
		try {
			
			 Block223Controller.createGame(textField.getText());
			 Block223Controller.selectGame(textField.getText());
			 frame.dispose();
			GameSettingUI.init();
		} catch (Exception e) {
			String error = e.getMessage(); 
			errorMsg.setText(error);
		}
		
		// add method here to move on to next screen
	}

	private static void deleteGameButtonActionPerformed() throws InvalidInputException {
		
		if(games.getSelectedIndex() < 0) {
			errorMsg.setText("A game must be selected to delete it.");
			return;
		}
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
		errorMsg.setText("");
		if(games.getSelectedIndex() < 0) {
			errorMsg.setText("A game must be selected to update it.");
			return;
		}
		try {
			String name = games.getSelectedItem().toString();
			Block223Controller.selectGame(name);
			frame.dispose();
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