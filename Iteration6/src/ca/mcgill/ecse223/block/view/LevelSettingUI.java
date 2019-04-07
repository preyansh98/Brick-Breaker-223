package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
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
	private static JComboBox<String> levels;
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
		frame.setBounds(100, 100, 871, 718);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(106,108,110));
		levels = new JComboBox<String>();
		
		JLabel lblSelectLevel = new JLabel("Select Level:");
		lblSelectLevel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		layeredPane = new Grid();
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setForeground(new Color(255, 51, 0));
		btnGoBack.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				goBackButtonActionPerformed();
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
		
		 errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		lblSelectBlockInfo = new JLabel("Selected Block info:");
		lblSelectBlockInfo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		JLabel lblInstructions = new JLabel("Choose a block to be positon, drag it and drop where wanted. To delete a block, feed it to pacman");
		lblInstructions.setFont(new Font("Century Gothic", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectLevel)
								.addComponent(btnGoBack))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(levels, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblSelectBlockInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(618)
									.addComponent(btnSave))))
						.addComponent(lblInstructions))
					.addContainerGap())
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
						.addComponent(lblSelectBlockInfo))
					.addGap(18)
					.addComponent(lblInstructions)
					.addGap(18)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnGoBack))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		layeredPane.setLayout(null);
		layeredPane.setSize(390, 390);
		frame.getContentPane().setLayout(groupLayout);
		refresh();
	
	}
	public static double getOffsetX() {
		return frame.getLocation().getX()+layeredPane.getLocation().getX()+9;
	}
	public static double getOffsetY() {
		return frame.getLocation().getY()+layeredPane.getLocation().getY()+38;
	}
	
	private static void saveButtonActionPerformed() {
		try {
			Block223Controller.saveGame();
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
	}
	private static void refresh() {
		refreshLevels();
	}
	private static void goBackButtonActionPerformed() {
		// TODO Auto-generated method stub
		frame.dispose();
		GameSettingUI.init();
	}

	
	public static String[] getBlockList(){
		map = new HashMap<Integer, TOBlock>();
		int blockid = 0;
		
		try {
			String[] rgb=new String[ Block223Controller.getBlocksOfCurrentDesignableGame().size()];
			for (TOBlock block : Block223Controller.getBlocksOfCurrentDesignableGame()) {
				
				map.put(blockid, block);
				String RGBPoints = (blockid+1) +") R: " + block.getRed() + " , G: " + block.getGreen() + " , B: " + block.getBlue()
						+ " , P: " + block.getPoints();
				rgb[blockid]=RGBPoints;
				blockid++;
			}
			return rgb;
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		return null;
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
	public static TOGridCell getCell(int x, int y) {
		
		if(levels!=null && levels.getSelectedIndex()!=-1) {
			try {
				List<TOGridCell> cells=Block223Controller.getBlocksAtLevelOfCurrentDesignableGame(levels.getSelectedIndex()+1);
				
				for(TOGridCell cell: cells) {
					if(cell.getGridHorizontalPosition()==x && cell.getGridVerticalPosition()==y) {
						return cell;
					}
				}
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
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
	public static void positionBlock(int id, int x, int y ) {
		errorMsg.setText("");
		int level=levels.getSelectedIndex()+1;
		try {
		Block223Controller.positionBlock(id, level, x, y);
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
	}
	public static void moveBlock(int oldX, int oldY, int newX , int newY) {
		errorMsg.setText("");
		int level=levels.getSelectedIndex()+1;
		try {
		Block223Controller.moveBlock(level, oldX, oldY, newX, newY);
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
	}
	public static void deleteBlock(int x, int y) {
		errorMsg.setText("");
		int level=levels.getSelectedIndex()+1;
		try {
			Block223Controller.removeBlock(level, x, y);
		}catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
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
	
	public static TOBlock getBlock(int index) {
		return map.get(index);
	}
}