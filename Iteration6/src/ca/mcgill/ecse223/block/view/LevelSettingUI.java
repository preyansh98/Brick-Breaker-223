package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOBlock;
import ca.mcgill.ecse223.block.controller.TOGridCell;

public class LevelSettingUI {

	private static JFrame frame;
	private static JTextField newXposTXT;
	private static JTextField newYposTXT;
	private static JTextField oldXmoveTXT;
	private static JTextField oldYmoveTXT;
	private static JTextField newXmoveTXT;
	private static JTextField newYmoveTXT;
	private static JTextField XdeleteTXT;
	private static JTextField YdeleteTXT;
	private static JComboBox<String> levels;
	private static JComboBox<String> blocks;
	private static JLabel errorMsg;
	private static HashMap<Integer, TOBlock> map;
	private static Rectangle2D[][] rectangles;
	private static Grid layeredPane;
	
	private static JLabel lblSelectBlockInfo;
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame("Level Settings");
		frame.setVisible(true);
		frame.setBounds(100, 100, 845, 714);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		levels = new JComboBox<String>();
		
		JLabel lblSelectLevel = new JLabel("Select Level:");
		lblSelectLevel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblSelectBlock = new JLabel("Select Block :");
		lblSelectBlock.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		blocks = new JComboBox<String>();
		
		layeredPane = new Grid();
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setForeground(new Color(255, 51, 0));
		btnGoBack.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goBackButtonActionPerformed();
			}
		});
		JLabel lblPositionANew = new JLabel("Position a new Block:");
		lblPositionANew.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblXPosition = new JLabel("X position: ");
		lblXPosition.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		JLabel lblYPosition = new JLabel("Y position: ");
		lblYPosition.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		newXposTXT = new JTextField();
		newXposTXT.setColumns(10);
		
		newYposTXT = new JTextField();
		newYposTXT.setColumns(10);
		
		JLabel lblMoveAnExisting = new JLabel("Move an existing Block:");
		lblMoveAnExisting.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JButton btnPosition = new JButton("Position");
		btnPosition.setBackground(new Color(0, 0, 255));
		btnPosition.setForeground(new Color(0, 0, 0));
		btnPosition.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				positionButtonActionPerformed();
			}
		});
		JLabel lblXPosition_1 = new JLabel("Old X:");
		lblXPosition_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		oldXmoveTXT = new JTextField();
		oldXmoveTXT.setColumns(10);
		
		JLabel lblOldY = new JLabel("Old Y:");
		lblOldY.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		oldYmoveTXT = new JTextField();
		oldYmoveTXT.setColumns(10);
		
		JLabel lblNewX = new JLabel("New X:");
		lblNewX.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		JLabel lblNewY = new JLabel("New Y:");
		lblNewY.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		newXmoveTXT = new JTextField();
		newXmoveTXT.setColumns(10);
		
		newYmoveTXT = new JTextField();
		newYmoveTXT.setColumns(10);
		
		JButton btnMove = new JButton("Move");
		btnMove.setBackground(new Color(0, 102, 255));
		btnMove.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveButtonActionPerformed();
			}
		});
		JLabel lblDeleteABlock = new JLabel("Delete a Block:");
		lblDeleteABlock.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblX = new JLabel("Current X:");
		lblX.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		JLabel lblCurrentY = new JLabel("Current Y:");
		lblCurrentY.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		XdeleteTXT = new JTextField();
		XdeleteTXT.setColumns(10);
		
		YdeleteTXT = new JTextField();
		YdeleteTXT.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(0, 102, 255));
		btnDelete.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteButtonActionPerformed();
			}
		});
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(new Color(0, 153, 0));
		btnSave.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveButtonActionPerformed();
			}
		});
		JLabel lblEnterValuesBetween = new JLabel("Enter values between 0 and 15 for all the positions:");
		lblEnterValuesBetween.setForeground(new Color(51, 102, 255));
		lblEnterValuesBetween.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		
		 errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		lblSelectBlockInfo = new JLabel("Select Block info:");
		lblSelectBlockInfo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSelectLevel)
									.addGap(18)
									.addComponent(levels, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addComponent(lblSelectBlock, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(blocks, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
									.addGap(85)))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDeleteABlock)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblXPosition)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(newXposTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblMoveAnExisting)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblYPosition)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(newYposTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(btnGoBack)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblCurrentY)
													.addGap(18)
													.addComponent(YdeleteTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblPositionANew)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblXPosition_1)
														.addComponent(lblOldY)
														.addComponent(lblNewX)
														.addComponent(lblNewY))
													.addGap(33)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(newYmoveTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(newXmoveTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(oldYmoveTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(oldXmoveTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnMove, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
													.addComponent(btnPosition, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
									.addGap(92))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblX)
									.addGap(18)
									.addComponent(XdeleteTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSelectBlockInfo, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
								.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSave))
							.addGap(111))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterValuesBetween)
					.addContainerGap(533, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(errorMsg)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectLevel)
						.addComponent(levels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectBlock)
						.addComponent(blocks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblEnterValuesBetween)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPositionANew)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblXPosition)
										.addComponent(newXposTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblYPosition)
										.addComponent(newYposTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblMoveAnExisting))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(41)
									.addComponent(btnPosition)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblXPosition_1)
								.addComponent(oldXmoveTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOldY)
								.addComponent(oldYmoveTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewX)
								.addComponent(newXmoveTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewY)
								.addComponent(newYmoveTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMove))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblDeleteABlock)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblX)
										.addComponent(XdeleteTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCurrentY)
										.addComponent(YdeleteTXT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(71)
									.addComponent(btnDelete))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSelectBlockInfo)
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGoBack)
						.addComponent(btnSave))
					.addGap(51))
		);
		layeredPane.setLayout(null);
		layeredPane.setSize(390, 390);
		frame.getContentPane().setLayout(groupLayout);
		refresh();
	}
	
	protected static void deleteButtonActionPerformed() {
		// TODO Auto-generated method stub
		if(blocks.getSelectedIndex()==-1) {
			errorMsg.setText("Please select the block to position");
			return;
		}else if (levels.getSelectedIndex()==-1){
		errorMsg.setText("Please select a level");
			return;
		}else {
			int x;
			int y;
			try {
			x=Integer.parseInt(XdeleteTXT.getText());
			y=Integer.parseInt(YdeleteTXT.getText());
			}catch (Exception e) {
				errorMsg.setText("Enter integer between 1 and 15 in the x and y position");
				return;
			}
			if(x<1 || x>15 || y<1 || y>15) {
				errorMsg.setText("Enter integer between 1 and 15 in the x and y position");
				return;
			}
			try {
				Block223Controller.removeBlock(levels.getSelectedIndex()+1, x, y);
				layeredPane.repaint();
			} catch (InvalidInputException e) {
				errorMsg.setText(e.getMessage());
			}
		}
	}

	protected static void moveButtonActionPerformed() {
		// TODO Auto-generated method stub
		errorMsg.setText("");
		if(blocks.getSelectedIndex()==-1) {
			errorMsg.setText("Please select the block to position");
			return;
		}else if (levels.getSelectedIndex()==-1){
		errorMsg.setText("Please select a level");
			return;
		}else {
			int oldX;
			int oldY;
			int newX;
			int newY;
			try {
			oldX=Integer.parseInt(oldXmoveTXT.getText());
			oldY=Integer.parseInt(oldYmoveTXT.getText());
			newX=Integer.parseInt(newXmoveTXT.getText());
			newY=Integer.parseInt(newYmoveTXT.getText());
			}catch (Exception e) {
				errorMsg.setText("Enter integer between 1 and 15 in the x and y position");
				return;
			}
			if(oldX<1 || oldX>15 || oldY<1 || oldY>15 || newX<1 || newX>15 || newY<1 || newY>15) {
				errorMsg.setText("Enter integer between 1 and 15 in the x and y position");
				return;
			}
			try {
				Block223Controller.moveBlock(levels.getSelectedIndex()+1, oldX, oldY, newX, newY);
				layeredPane.repaint();
			} catch (InvalidInputException e) {
				errorMsg.setText(e.getMessage());
			}
		}
	}

	protected static void positionButtonActionPerformed() {
		// TODO Auto-generated method stub
		if(blocks.getSelectedIndex()==-1) {
			errorMsg.setText("Please select the block to position");
			return;
		}else if (levels.getSelectedIndex()==-1){
		errorMsg.setText("Please select a level");
			return;
		}else {
			TOBlock block=map.get(blocks.getSelectedIndex());
			int x;
			int y;
			try {
			x=Integer.parseInt(newXposTXT.getText());
			y=Integer.parseInt(newYposTXT.getText());
			}catch (Exception e) {
				errorMsg.setText("Enter integer between 1 and 15 in the x and y position");
				return;
			}
			if(x<1 || x>15 || y<1 || y>15) {
				errorMsg.setText("Enter integer between 1 and 15 in the x and y position");
				return;
			}
			try {
				Block223Controller.positionBlock(block.getId(), levels.getSelectedIndex()+1, x, y);
				
				layeredPane.repaint();
			} catch (InvalidInputException e) {
				errorMsg.setText(e.getMessage());
			}
		}
	}

	private static void saveButtonActionPerformed() {
		try {
			Block223Controller.saveGame();
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
	}
	private static void refresh() {
		resfreshBlocks();
		refreshLevels();
	}
	private static void goBackButtonActionPerformed() {
		// TODO Auto-generated method stub
		frame.dispose();
		GameSettingUI.init();
	}

	private static void resfreshBlocks() {
		blocks.removeAllItems();
		map = new HashMap<Integer, TOBlock>();
		int blockid = 0;
		errorMsg.setText("");
		try {
			for (TOBlock block : Block223Controller.getBlocksOfCurrentDesignableGame()) {
				map.put(blockid, block);
				String RGBPoints = (blockid+1) +") R: " + block.getRed() + " , G: " + block.getGreen() + " , B: " + block.getBlue()
						+ " , P: " + block.getPoints();
				blocks.addItem(RGBPoints);
				blockid++;
			}
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		blocks.setSelectedItem(-1);
	}
	private static void refreshLevels() {
		levels.removeAllItems();
		try {
			int numofLevels=Block223Controller.getCurrentDesignableGame().getNrLevels();
			for(int i=1;i<=numofLevels;i++) {
				levels.addItem("Level "+ i);
			}
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			errorMsg.setText(e.getMessage());
		}
		levels.setSelectedItem(-1);
	}
	
	public static TOGridCell [][] getGrid(){
		TOGridCell [][] to=new TOGridCell [15][15];
		if(levels!=null && levels.getSelectedIndex()!=-1) {
			try {
				List<TOGridCell> cells=Block223Controller.getBlocksAtLevelOfCurrentDesignableGame(levels.getSelectedIndex()+1);
				
				for(TOGridCell cell: cells) {
					to[cell.getGridVerticalPosition()-1][cell.getGridHorizontalPosition()-1]=cell;
				}
				return to;
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return to;
	}
	
	public static void displayBlockInfo(int x, int y) {
		List<TOGridCell> cells;
		try {
			cells = Block223Controller.getBlocksAtLevelOfCurrentDesignableGame(levels.getSelectedIndex()+1);
			for(TOGridCell cell: cells) {
				if(cell.getGridHorizontalPosition()==y && cell.getGridVerticalPosition()==x) {
					lblSelectBlockInfo.setText("Select Block info: R: "+ cell.getRed()+  " , G: " + cell.getGreen() + " , B: " + cell.getBlue()
						+ " , P: " + cell.getPoints());
					return;
				}
			}
			
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
		lblSelectBlockInfo.setText("Select Block info: empty slot");
	}
}