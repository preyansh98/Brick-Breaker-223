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
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;

import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOHallOfFameEntry;
public class TestGameUI implements Block223PlayModeInterface{

	private  JFrame frame;
	private  JLabel errorMsg;
	private JLayeredPane playArea;
	private JButton btnBack;
	private JLabel lblScore;
	private volatile String keyString = "";
	private JLabel lblLevel;
	private JLabel lblLives;
	public TestGameUI() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 432, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(106,108,110));
		 playArea = new PlayAreaUI();
		
		errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		errorMsg.setFont(new Font("Arial", Font.ITALIC, 15));
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		
		btnBack = new JButton("Go Back");
		btnBack.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		btnBack.addMouseListener(new java.awt.event.MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ( btnStart.isVisible()) actionGoBack();
				
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
		 lblScore = new JLabel("Score: 0");
		lblScore.setFont(new Font("Century Gothic", Font.BOLD, 17));
		lblScore.setEnabled(false);
		
		lblLevel = new JLabel("Level: 1");
		lblLevel.setEnabled(false);
		lblLevel.setFont(new Font("Century Gothic", Font.BOLD, 17));
		
		lblLives = new JLabel("Lives: 3");
		lblLives.setEnabled(false);
		lblLives.setFont(new Font("Century Gothic", Font.BOLD, 17));
		refresh();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addComponent(playArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblScore, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
							.addComponent(lblLives, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScore)
						.addComponent(lblLives))
					.addGap(18)
					.addComponent(playArea, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStart)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		
		btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnStart.setVisible(false);
				
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
								Block223Controller.startGame(TestGameUI.this);
								
							} catch (InvalidInputException e) {
								errorMsg.setText(e.getMessage());
							}
							btnStart.setVisible(true);
							
						
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
		lblLives.setText("Lives: "+ ((PlayAreaUI)playArea).getLives());
		lblLevel.setText("Level: "+ ((PlayAreaUI)playArea).getLevel());
	}
	@Override
	public synchronized String takeInputs() {
		String passString = keyString;
		keyString = "";
		return passString;
	}

	@Override
	public void endGame(int nrOfLives, TOHallOfFameEntry hof) {
		if(nrOfLives>0) {
			((PlayAreaUI) playArea).displayCongratulations();
		}else {
			((PlayAreaUI) playArea).displayGameOver();
		}
		
	}
	
	
}
