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
import java.awt.SystemColor;
import javax.swing.JSeparator;

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
		lblGameName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		nameTXT = new JTextField();
		nameTXT.setColumns(10);
		
		JLabel lblBallParameters = new JLabel("Ball Parameters: ");
		lblBallParameters.setForeground(new Color(51, 102, 204));
		lblBallParameters.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblMinSpeed = new JLabel("Min. Speed in X: ");
		lblMinSpeed.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		XSpeedTXT = new JTextField();
		XSpeedTXT.setColumns(10);
		
		YSpeedTXT = new JTextField();
		YSpeedTXT.setColumns(10);
		
		JLabel lblMinSpeedIn = new JLabel("Min. Speed in Y:");
		lblMinSpeedIn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblSpeedIncreaseFactor = new JLabel("Speed Increase Factor: ");
		lblSpeedIncreaseFactor.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		speedFactorTXT = new JTextField();
		speedFactorTXT.setColumns(10);
		
		JLabel lblPaddleLength = new JLabel("Paddle Length:");
		lblPaddleLength.setForeground(new Color(51, 102, 204));
		lblPaddleLength.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblMin = new JLabel("Min: ");
		lblMin.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		minLengthTXT = new JTextField();
		minLengthTXT.setColumns(10);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		maxLengthTXT = new JTextField();
		maxLengthTXT.setColumns(10);
		
		JButton btnAddNewBlock = new JButton("Add New Block");
		btnAddNewBlock.setBackground(new Color(51, 0, 153));
		btnAddNewBlock.setForeground(new Color(51, 102, 204));
		btnAddNewBlock.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAddNewBlock.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addNewBlocks();
			}
		});
		JButton btnUpdateOldBlocks = new JButton("Update Old Blocks");
		btnUpdateOldBlocks.setBackground(new Color(51, 0, 204));
		btnUpdateOldBlocks.setForeground(new Color(51, 102, 204));
		btnUpdateOldBlocks.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnUpdateOldBlocks.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateOldBlocks();
			}
		});
		JButton btnLevelDesign = new JButton("Level Design");
		btnLevelDesign.setForeground(new Color(51, 102, 204));
		btnLevelDesign.setBackground(new Color(51, 0, 204));
		btnLevelDesign.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLevelDesign.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				levelDesign();
			}
		});
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setForeground(new Color(204, 0, 51));
		btnGoBack.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnGoBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goBack();
			}
		});
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(new Color(0, 153, 0));
		btnSave.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				save();
			}
		});
		errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		JLabel lblNumberOfLevels = new JLabel("Number of levels (1..99) :");
		lblNumberOfLevels.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		numLevelsTXT = new JTextField();
		numLevelsTXT.setColumns(10);
		
		JLabel lblNumberOfBlocks = new JLabel("Number of Blocks per Level:");
		lblNumberOfBlocks.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		numBlockTXT = new JTextField();
		numBlockTXT.setColumns(10);
		
		JButton btnUpdateGame = new JButton("Update Game");
		btnUpdateGame.setForeground(new Color(51, 102, 204));
		btnUpdateGame.setBackground(new Color(51, 0, 204));
		btnUpdateGame.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnUpdateGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateGame();
			}
		});
		refresh();
		
		JButton btnPublishGame = new JButton("Publish Game");
		btnPublishGame.setForeground(new Color(0, 153, 0));
		btnPublishGame.setBackground(new Color(51, 0, 204));
		btnPublishGame.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnPublishGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				publishGame();
			}
		});
		
		JButton btnTestGame = new JButton("Test Game");
		btnTestGame.setForeground(new Color(51, 102, 204));
		btnTestGame.setBackground(new Color(0, 0, 153));
		btnTestGame.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnTestGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testGame();
			}
		});
		
		JSeparator separator = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBallParameters)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblMinSpeed)
											.addGap(31)
											.addComponent(XSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(134)
											.addComponent(lblMinSpeedIn)
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(maxLengthTXT, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
												.addComponent(YSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNumberOfLevels)
												.addComponent(lblGameName))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(nameTXT, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(numLevelsTXT, 0, 0, Short.MAX_VALUE)
													.addGap(46)
													.addComponent(lblNumberOfBlocks)
													.addGap(18)
													.addComponent(numBlockTXT, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))))
									.addGap(100)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
									.addGap(42))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSpeedIncreaseFactor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(speedFactorTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblMin)
													.addGap(18)
													.addComponent(minLengthTXT, 0, 0, Short.MAX_VALUE))
												.addComponent(lblPaddleLength, Alignment.LEADING))
											.addPreferredGap(ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
											.addComponent(lblMax))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addGap(9)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnLevelDesign, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnAddNewBlock, Alignment.LEADING)
												.addComponent(btnGoBack, Alignment.LEADING))
											.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnPublishGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnUpdateOldBlocks, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
											.addGap(25)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(btnTestGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnUpdateGame, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
										.addComponent(btnSave))
									.addGap(30))))
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGameName)
						.addComponent(nameTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfLevels)
						.addComponent(numLevelsTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberOfBlocks)
						.addComponent(numBlockTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblBallParameters)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMinSpeed)
								.addComponent(XSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMinSpeedIn)
								.addComponent(YSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSpeedIncreaseFactor)
								.addComponent(speedFactorTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addComponent(lblPaddleLength)
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMin)
								.addComponent(minLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(maxLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMax))
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddNewBlock)
								.addComponent(btnUpdateGame)
								.addComponent(btnUpdateOldBlocks))
							.addGap(52)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLevelDesign)
								.addComponent(btnPublishGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTestGame, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(75)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGoBack)
								.addComponent(btnSave))
							.addGap(20))))
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
