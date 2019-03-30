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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerDashUI {

	private static JFrame frame;
	private static JComboBox<String> newGameBox;
	private static JComboBox<String> oldGameBox;
	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JLabel lblWelcome = new JLabel("Welcome back!");
		lblWelcome.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblStartANew = new JLabel("Start a new game: ");
		lblStartANew.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		 newGameBox = new JComboBox<String>();
		newGameBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startGame();
			}
		});
		JLabel lblFinishAPrevious = new JLabel("Finish a previous game:");
		lblFinishAPrevious.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		 oldGameBox = new JComboBox<String>();
		oldGameBox.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnFinish = new JButton("Finish it!!!!!!!");
		btnFinish.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				continueGame();
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt);
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(214)
							.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStartANew)
								.addComponent(lblFinishAPrevious)
								.addComponent(btnLogout))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(oldGameBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(newGameBox, 0, 247, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnFinish)
								.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartANew)
						.addComponent(newGameBox, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStart))
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFinishAPrevious)
						.addComponent(oldGameBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFinish))
					.addGap(90)
					.addComponent(btnLogout)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	protected static void continueGame() {
		// TODO Auto-generated method stub
		
	}

	protected static void startGame() {
		frame.dispose();
		PlayGameUI test=new PlayGameUI();
		
	}

	private static void registerButtonActionPerformed(ActionEvent evt) {
		Block223Controller.logout();
		delete();
		SignInUI.init();
		
	}
	private static void delete() {
		frame.dispose();
	}
}
