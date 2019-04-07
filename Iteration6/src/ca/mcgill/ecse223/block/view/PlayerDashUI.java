package ca.mcgill.ecse223.block.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOPlayableGame;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PlayerDashUI {

	private static JFrame frame;
	private static JComboBox<String> newGameBox;
	private static JComboBox<String> oldGameBox;
	private static int[] ids;
	private static PlayGameUI playArea;
	private static JLabel errorMsg;
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		playArea=null;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(106,108,110));
		frame.setBounds(100, 100, 749, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JLabel lblWelcome = new JLabel("Player Dashboard");
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setFont(new Font("Century Gothic", Font.BOLD, 22));
		
		JLabel lblStartANew = new JLabel("Start a new game: ");
		lblStartANew.setForeground(new Color(255, 255, 255));
		lblStartANew.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		 newGameBox = new JComboBox<String>();
		newGameBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startGame();
			}
		});
		JLabel lblFinishAPrevious = new JLabel("Finish a previous game:");
		lblFinishAPrevious.setForeground(new Color(255, 255, 255));
		lblFinishAPrevious.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		 oldGameBox = new JComboBox<String>();
		oldGameBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				continueGame();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoutButtonActionPerformed(evt);
			}
		});
		
		 errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		errorMsg.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		
		JButton btn2PlayerGame = new JButton("1 VS1 ");
		btn2PlayerGame.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btn2PlayerGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				start2Games();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(errorMsg, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStartANew)
								.addComponent(lblFinishAPrevious)
								.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(oldGameBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(newGameBox, 0, 247, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnFinish, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
								.addComponent(btn2PlayerGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(269, Short.MAX_VALUE)
					.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(265))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartANew)
						.addComponent(newGameBox, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStart))
					.addGap(18)
					.addComponent(btn2PlayerGame)
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFinishAPrevious)
						.addComponent(oldGameBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFinish))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addGap(69))
		);
		frame.getContentPane().setLayout(groupLayout);
		setUpCombos();
	}
	
	protected static void start2Games() {
		if(newGameBox.getSelectedIndex()!=-1) {
			try {
				Block223Controller.selectBothPlayableGame( newGameBox.getSelectedItem().toString());
				frame.dispose();
				SecondPlayerLoginUI.init();
			} catch (InvalidInputException e) {
				errorMsg.setText(e.getMessage());
			}
		}
	}

	public static void continueGame() {
		if(oldGameBox.getSelectedIndex()!=-1) {
			try {
				Block223Controller.selectPlayableGame( null, ids[oldGameBox.getSelectedIndex()]);
				frame.dispose();
				playArea=new PlayGameUI();
			} catch (InvalidInputException e) {
				errorMsg.setText(e.getMessage());
				System.out.println(e.getMessage());
			}
		}
	}

	public static void startGame() {
		
		if(newGameBox.getSelectedIndex()!=-1) {
			try {
				Block223Controller.selectPlayableGame( newGameBox.getSelectedItem().toString(), -1);
				frame.dispose();
				playArea=new PlayGameUI();
			} catch (InvalidInputException e) {
				errorMsg.setText(e.getMessage());
			}
		}
		
	}

	private static void logoutButtonActionPerformed(ActionEvent evt) {
		Block223Controller.logout();
		delete();
		SignInUI.init();
		
	}
	private static void delete() {
		frame.dispose();
	}
	private static void setUpCombos() {
		try {
			List<TOPlayableGame> playables=Block223Controller.getPlayableGames();
			int i=0;
			for(TOPlayableGame game:playables) {
				if(game.getNumber()!=-1) {
					i++;
				}
			}
			ids=new int[i];
			i=0;
			for(TOPlayableGame game:playables) {
				if(game.getNumber()==-1) {
					newGameBox.addItem(game.getName());
				}else{
					ids[i]=game.getNumber();
					oldGameBox.addItem(game.getName()+"  "+ game.getCurrentLevel());
					i++;
				}
			}
			newGameBox.setSelectedIndex(-1);
			oldGameBox.setSelectedIndex(-1);
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
	}
}
