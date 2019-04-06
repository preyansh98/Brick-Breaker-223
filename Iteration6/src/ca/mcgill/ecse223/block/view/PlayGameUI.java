package ca.mcgill.ecse223.block.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOHallOfFameEntry;

import javax.swing.JPanel;
import java.awt.Color;

public class PlayGameUI implements Block223PlayModeInterface{

	private JFrame frame;
	private JLayeredPane playArea;
	private volatile String keyString = "";
	private JLabel lblScore;
	private JLabel lblLives;
	private JLabel lblLevel;
	private JButton btnStartGame;
	private JLabel errorMsg;
	private JPanel hallOfFame ;
	/**
	 * Create the application.
	 */
	public PlayGameUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		frame.setBounds(100, 100, 716, 648);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		 playArea = new PlayAreaUI();
		
		 btnStartGame = new JButton("Start Game");
		 btnStartGame.setBackground(new Color(51, 153, 102));
		btnStartGame.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		 lblLevel = new JLabel("Level: ");
		lblLevel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		 lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		 lblLives = new JLabel("Lives: ");
		lblLives.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		 hallOfFame = new HallOfFame();
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnGoBack.addMouseListener(new java.awt.event.MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ( btnStartGame.isVisible()) goBack();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		JButton btnPrevious = new JButton("< Prev");
		btnPrevious.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnPrevious.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				((HallOfFame) hallOfFame).prevPage();
			}
		});
		JButton btnNext = new JButton(" Next >");
		btnNext.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				((HallOfFame) hallOfFame).nextPage();
			}
		});
		
		errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		refresh();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(errorMsg, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnStartGame)
							.addGap(119)
							.addComponent(btnGoBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblLives, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblScore, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblLevel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
						.addComponent(playArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNext))
						.addComponent(hallOfFame, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(errorMsg)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblScore)
					.addGap(18)
					.addComponent(lblLives)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(hallOfFame, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addComponent(playArea, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPrevious, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnGoBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnStartGame, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addGap(25))
		);
		frame.getContentPane().setLayout(groupLayout);
		btnStartGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnStartGame.setVisible(false);
			
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
								Block223Controller.startPlayGame(PlayGameUI.this);
								
							} catch (InvalidInputException e) {
								errorMsg.setText(e.getMessage());
							}
							btnStartGame.setVisible(true);
						
					}
				};
				Thread t2 = new Thread(r2);
				t2.start();
			}
		});
		
		frame.pack();
	}

	protected void goBack() {
		// TODO Auto-generated method stub
		if(btnStartGame.isVisible()) {
			Block223Controller.unselectGame();
			frame.dispose();
			PlayerDashUI.init();
			
		}
	}

	@Override
	public String takeInputs() {
		String passString = keyString;
		keyString = "";
		return passString;
	}

	@Override
	public void refresh() {
		playArea.repaint();
		lblScore.setText("Score: " +((PlayAreaUI)playArea).getScore());
		lblLives.setText("Lives: "+ ((PlayAreaUI)playArea).getLives());
		lblLevel.setText("Level: "+ ((PlayAreaUI)playArea).getLevel());
	}

	@Override
	public void endGame(int nrOfLives, TOHallOfFameEntry hof) {
		if(nrOfLives>0) {
			((PlayAreaUI) playArea).displayCongratulations();
		}else {
			((PlayAreaUI) playArea).displayGameOver();
		}
		((HallOfFame)hallOfFame).refresh();
	}
}
