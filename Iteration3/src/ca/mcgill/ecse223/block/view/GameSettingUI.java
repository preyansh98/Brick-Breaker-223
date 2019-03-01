package ca.mcgill.ecse223.block.view;

import java.awt.EventQueue;

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
		frame.setBounds(100, 100, 795, 647);
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
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMin)
									.addGap(75)
									.addComponent(minLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(99)
									.addComponent(lblMax)
									.addGap(68)
									.addComponent(maxLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblPaddleLength)
								.addComponent(lblBallParameters)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMinSpeed)
										.addComponent(lblGameName))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(XSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(74)
											.addComponent(lblMinSpeedIn)
											.addGap(44)
											.addComponent(YSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(nameTXT, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSpeedIncreaseFactor)
									.addGap(47)
									.addComponent(speedFactorTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnGoBack)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnLevelDesign))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(btnAddNewBlock)
											.addGap(101)
											.addComponent(btnUpdateOldBlocks)))
									.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnUpdateGame)
										.addComponent(btnSave))
									.addGap(48))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNumberOfLevels)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(numLevelsTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNumberOfBlocks)
									.addGap(18)
									.addComponent(numBlockTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGameName)
						.addComponent(nameTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfLevels)
						.addComponent(numLevelsTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberOfBlocks)
						.addComponent(numBlockTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(lblBallParameters)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMinSpeed)
						.addComponent(XSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMinSpeedIn)
						.addComponent(YSpeedTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSpeedIncreaseFactor)
						.addComponent(speedFactorTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addComponent(lblPaddleLength)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMin)
						.addComponent(minLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMax)
						.addComponent(maxLengthTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddNewBlock)
						.addComponent(btnUpdateOldBlocks)
						.addComponent(btnUpdateGame))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGoBack)
						.addComponent(btnLevelDesign)
						.addComponent(btnSave))
					.addGap(34))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	protected static void updateGame() {
		// TODO Auto-generated method stub
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
					speedFactor,minLength,maxLength);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			errorMsg.setText(e.getMessage());
			return;
		}
		errorMsg.setText("");
	}

	protected static void levelDesign() {
		// TODO Auto-generated method stub
		frame.dispose();
		LevelSettingUI.init();
		
	}
	protected static void addNewBlocks() {
		// TODO Auto-generated method stub
		frame.dispose();
		NewBlockUI.init();
	}


	protected static void updateOldBlocks() {
		// TODO Auto-generated method stub
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
