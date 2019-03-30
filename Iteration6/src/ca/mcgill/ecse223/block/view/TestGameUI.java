package ca.mcgill.ecse223.block.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;

import ca.mcgill.ecse223.block.controller.InvalidInputException;
public class TestGameUI implements Block223PlayModeInterface{

	private  JFrame frame;
	private  JLabel errorMsg;
	private JLayeredPane playArea;
	private JButton btnBack;
	private JLabel lblScore;
	private volatile String keyString = "";
	public TestGameUI() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		 playArea = new PlayAreaUI();
		
		errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		errorMsg.setFont(new Font("Arial", Font.ITALIC, 15));
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		btnBack = new JButton("Go Back");
		btnBack.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
					actionGoBack();
				}
		});
		 lblScore = new JLabel("Score: 0");
		lblScore.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblScore.setEnabled(false);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(playArea, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addComponent(lblScore, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(lblScore)
					.addGap(18)
					.addComponent(playArea, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStart)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnStart.setVisible(false);
				// initiating a thread to start listening to keyboard inputs
			//	keyListen = new Listeners();
			
				/*Runnable r1 = new Runnable() {
					@Override
					public void run() {
						// in the actual game, add keyListener to the game window
						frame.addKeyListener(keyListen);
					}
				};
				Thread t1 = new Thread(r1);
				t1.start();
				// to be on the safe side use join to start executing thread t1 before executing
				// the next thread
				try {
					t1.join();
				} catch (InterruptedException e1) {
				}*/

				// initiating a thread to start the game loop
				KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
					  @Override
					  public synchronized boolean dispatchKeyEvent(final KeyEvent e) {
						  
						  int location = e.getKeyCode();
							
							if (location == KeyEvent.VK_LEFT) {
								keyString += "l";
							} else if (location == KeyEvent.VK_RIGHT) {
								keyString += "r";
							} else if (location == KeyEvent.VK_SPACE) {
								keyString += " ";
							} else {
								// ignore all other keys
							}
					    // Pass the KeyEvent to the next KeyEventDispatcher in the chain
					    return false;
					  }
					};
				KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
			
				Runnable r2 = new Runnable() {
					@Override
					public void run() {
						
							try {
								Block223Controller.testGame(TestGameUI.this);
								btnStart.setVisible(true);
							} catch (InvalidInputException e) {
								errorMsg.setText(e.getMessage());
							}
							
						
					}
				};
				Thread t2 = new Thread(r2);
				t2.start();
			}
		});
		
		
		
	
		frame.pack();
	}

	protected void actionGoBack() {
		frame.dispose();
		GameSettingUI.init();
	}

	
	

	@Override
	public void refresh() {
		playArea.repaint();
		lblScore.setText("Score: " +((PlayAreaUI)playArea).getScore());
	}
	@Override
	public synchronized String takeInputs() {
		String passString = keyString;
		keyString = "";
		return passString;
	}
	
	
}
