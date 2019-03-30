package ca.mcgill.ecse223.block.view;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOGame;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameSettingUI {

	private static JFrame frame;
	private static JTextField nameTXT;
	private static JTextField XSpeedTXT;
	private static JTextField YSpeedTXT;
	private static JTextField speedFactorTXT;
	private static JTextField minLengthTXT;
	private static JTextField maxLengthTXT;
	private static JLabel errorMsg;
	private static JTextField numLevelsTXT;
	private static JTextField numBlockTXT;

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame("Game Settings");
		frame.setVisible(true);
		frame.setBounds(100, 100, 782, 673);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblGameName = new JLabel("Game Name :");
		lblGameName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		nameTXT = new JTextField();
		nameTXT.setColumns(10);
		
		JLabel lblBallParameters = new JLabel("Ball Parameters: ");
		lblBallParameters.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblMinSpeed = new JLabel("Min. Speed in X: ");
		lblMinSpeed.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		XSpeedTXT = new JTextField();
		XSpeedTXT.setColumns(10);
		
		YSpeedTXT = new JTextField();
		YSpeedTXT.setColumns(10);
		
		JLabel lblMinSpeedIn = new JLabel("Min. Speed in Y:");
		lblMinSpeedIn.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblSpeedIncreaseFactor = new JLabel("Speed Increase Factor: ");
		lblSpeedIncreaseFactor.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		speedFactorTXT = new JTextField();
		speedFactorTXT.setColumns(10);
		
		JLabel lblPaddleLength = new JLabel("Paddle Length:");
		lblPaddleLength.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblMin = new JLabel("Min: ");
		lblMin.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		minLengthTXT = new JTextField();
		minLengthTXT.setColumns(10);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		maxLengthTXT = new JTextField();
		maxLengthTXT.setColumns(10);
		
		JButton btnAddNewBlock = new JButton("Add New Block");
		btnAddNewBlock.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnAddNewBlock.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addNewBlocks();
			}
		});
		JButton btnUpdateOldBlocks = new JButton("Update Old Blocks");
		btnUpdateOldBlocks.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnUpdateOldBlocks.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateOldBlocks();
			}
		});
		JButton btnLevelDesign = new JButton("Level Design");
		btnLevelDesign.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnLevelDesign.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				levelDesign();
			}
		});
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnGoBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBack();
			}
		});
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				save();
			}
		});
		errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		JLabel lblNumberOfLevels = new JLabel("Number of levels (1..99) :");
		lblNumberOfLevels.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		numLevelsTXT = new JTextField();
		numLevelsTXT.setColumns(10);
		
		JLabel lblNumberOfBlocks = new JLabel("Number of Blocks per Level:");
		lblNumberOfBlocks.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		numBlockTXT = new JTextField();
		numBlockTXT.setColumns(10);
		
		JButton btnUpdateGame = new JButton("Update Game");
		btnUpdateGame.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnUpdateGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateGame();
			}
		});
		refresh();
		
		JButton btnPublishGame = new JButton("Publish Game");
		btnPublishGame.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnPublishGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				publishGame();
			}
		});
		
		JButton btnTestGame = new JButton("Test Game");
		btnTestGame.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnTestGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testGame();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMin)
									.addGap(61)
									.addComponent(minLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
									.addComponent(lblMax)
									.addGap(68)
									.addComponent(maxLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(230))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnGoBack)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnAddNewBlock)
												.addComponent(btnLevelDesign))
											.addGap(101)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnPublishGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnUpdateOldBlocks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
									.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(btnTestGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnUpdateGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(btnSave))
									.addGap(67))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblBallParameters)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblGameName)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(nameTXT, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
											.addGap(318))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNumberOfLevels)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(numLevelsTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(lblNumberOfBlocks))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblMinSpeed)
													.addGap(31)
													.addComponent(XSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(116)
													.addComponent(lblMinSpeedIn)))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(YSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(numBlockTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
									.addGap(32))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblSpeedIncreaseFactor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(speedFactorTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblPaddleLength, Alignment.LEADING)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(errorMsg)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGameName)
						.addComponent(nameTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfLevels)
						.addComponent(numLevelsTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberOfBlocks)
						.addComponent(numBlockTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(lblBallParameters)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMinSpeed)
						.addComponent(XSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMinSpeedIn)
						.addComponent(YSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeedIncreaseFactor)
						.addComponent(speedFactorTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(lblPaddleLength)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMax)
						.addComponent(maxLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin)
						.addComponent(minLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNewBlock)
						.addComponent(btnUpdateOldBlocks)
						.addComponent(btnUpdateGame))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPublishGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnTestGame, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnLevelDesign, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGoBack)
						.addComponent(btnSave))
					.addGap(34))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	protected static void testGame() {
		frame.dispose();
		TestGameUI testing=new TestGameUI();
		
	}

	protected static void publishGame() {
		try {
			Block223Controller.publishGame();
			Block223Controller.saveGame();
			frame.dispose();
			AdminDashBoardUI.init();
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
	}

	protected static void updateGame() {
		int levels;
		int numBlocks;
		int xspeed;
		int yspeed;
		double speedFactor;
		int minLength;
		int maxLength;
		try {
		 levels=Integer.parseInt(numLevelsTXT.getText());
		 numBlocks=Integer.parseInt(numBlockTXT.getText());
		 xspeed=Integer.parseInt(XSpeedTXT.getText());
		 yspeed=Integer.parseInt(YSpeedTXT.getText());
		 speedFactor=Double.parseDouble(speedFactorTXT.getText());
		 minLength=Integer.parseInt(minLengthTXT.getText());
		 maxLength=Integer.parseInt(maxLengthTXT.getText());
		}catch(NumberFormatException e) {
			errorMsg.setText("Please enter number only in the fields other than name");
			return;
		}
		try {
			Block223Controller.updateGame(nameTXT.getText(),levels,numBlocks,xspeed,yspeed,
					speedFactor,maxLength,minLength);
		} catch (Exception e) {
			errorMsg.setText(e.getMessage());
			return;
		}
		errorMsg.setText("");
	}

	protected static void levelDesign() {
		frame.dispose();
		LevelSettingUI.init();
		
	}
	protected static void addNewBlocks() {
	
		frame.dispose();
		NewBlockUI.init();
	}


	protected static void updateOldBlocks() {
		
		frame.dispose();
		
		UpdateBlockUI.init();
	}
	private static void goBack() {
		frame.dispose();
		AdminDashBoardUI.init();
		
	}
	private static void refresh() {
		try {
			TOGame temp=Block223Controller.getCurrentDesignableGame();
			nameTXT.setText(temp.getName());
			 XSpeedTXT.setText(temp.getMinBallSpeedX()+"");
			YSpeedTXT.setText(temp.getMinBallSpeedY()+"");
			speedFactorTXT.setText(temp.getBallSpeedIncreaseFactor()+"");
			minLengthTXT.setText(temp.getMinPaddleLength()+"");
			 maxLengthTXT.setText(temp.getMaxPaddleLength()+"");
			 numLevelsTXT.setText(temp.getNrLevels()+"");
			 numBlockTXT.setText(temp.getNrBlocksPerLevel()+"");
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}		
	}
	private static void save() {
		try {
			Block223Controller.saveGame();
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
	}
}
