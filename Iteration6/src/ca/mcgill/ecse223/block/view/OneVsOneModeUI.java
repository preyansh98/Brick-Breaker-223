package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOHallOfFameEntry;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class OneVsOneModeUI implements Block223PlayModeInterface{

	private JFrame frame;
	private JLayeredPane player2Area ;
	private JPanel HOF;
	private JLabel lblPlayer2;
	private JLabel lblLives2;
	private JLabel lblLevel2;
	private JLabel lblScore2;
	private JLabel lblPlayer1;	
	private JLabel lblLives1 ;
	private JLabel lblLevel1 ;
	private JLabel lblScore1 ;
	private JButton btnStart ;
	private JLayeredPane player1Area;
	private JTextArea textArea;
	private UserEntryListener bp;
	private boolean endgame=false;

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("unused") //suppressing since it is called from other UI
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1224, 741);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(106,108,110));
		 player2Area = new PlayAreaUI(true);
		
		 HOF = new HallOfFame();
		
		 lblPlayer2 = new JLabel("Player 2");
		
		 lblLives2 = new JLabel("Lives: ");
		
		 lblLevel2 = new JLabel("Level: ");
		
		 lblScore2 = new JLabel("Score:");
		
		 lblPlayer1 = new JLabel("Player 1");
		
		 lblLives1 = new JLabel("Lives: ");
		
		 lblLevel1 = new JLabel("Level: ");
		
		 lblScore1 = new JLabel("Score:");
		
		 btnStart = new JButton("Start");
		btnStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doStartGame();
				
			}
		});
		player1Area = new PlayAreaUI();
		
		 textArea = new JTextArea();
		 textArea.setEditable(false);
		 textArea.setBackground(frame.getBackground());
		 refresh();
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new java.awt.event.MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ( btnStart.isVisible()) goBack();
				
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
		JButton btnPrev = new JButton("< Prev.");
		btnPrev.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				((HallOfFame) HOF).prevPage();
			}
		});
		JButton btnNext = new JButton("next >");
		btnNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				((HallOfFame) HOF).nextPage();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLives2)
										.addComponent(lblLevel2)
										.addComponent(lblScore2)
										.addComponent(player2Area, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(13)
											.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(39))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(406)
									.addComponent(btnGoBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLives1, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
								.addComponent(lblLevel1, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblScore1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(player1Area, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(147)
							.addComponent(lblPlayer2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
							.addComponent(lblPlayer1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(191)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPrev)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNext))
						.addComponent(HOF, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
					.addGap(47))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblPlayer2)
									.addComponent(lblPlayer1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(75)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblLives2)
										.addComponent(lblLives1))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblLevel2)
										.addComponent(lblLevel1))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblScore2)
										.addComponent(lblScore1))
									.addGap(35)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(player1Area, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(player2Area, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
										.addComponent(HOF, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnPrev)
										.addComponent(btnNext))))
							.addGap(65))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(217)
							.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void goBack() {
		if(btnStart.isVisible()) {
			Block223Controller.unselectGame();
			frame.dispose();
			PlayerDashUI.init();	
		}
	}

	protected void doStartGame() {
		if (endgame)return ;
		btnStart.setVisible(false);
		bp = new UserEntryListener();
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				// in the actual game, add keyListener to the game window
				textArea.addKeyListener(bp);
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		// to be on the safe side use join to start executing thread t1 before executing
		// the next thread
		try {
			t1.join();
		} catch (InterruptedException e1) {
		}
	
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				
					try {
						Block223Controller.startBothGames(OneVsOneModeUI.this);
						btnStart.setVisible(true);
					} catch (InvalidInputException e) {
						btnStart.setText(e.getMessage());
					}
					
				
			}
		};
		Thread t2 = new Thread(r2);
		t2.start();
		
	}
	
	@Override
	public String takeInputs() {
		if (bp == null) {
			return "";
		}
		return bp.takeInputs();
	}

	@Override
	public void refresh() {
		player1Area.repaint();
		lblScore1.setText("Score: " +((PlayAreaUI)player1Area).getScore());
		lblLives1.setText("Lives: "+ ((PlayAreaUI)player1Area).getLives());
		lblLevel1.setText("Level: "+ ((PlayAreaUI)player1Area).getLevel());
		
		player2Area.repaint();
		lblScore2.setText("Score: " +((PlayAreaUI)player2Area).getScore());
		lblLives2.setText("Lives: "+ ((PlayAreaUI)player2Area).getLives());
		lblLevel2.setText("Level: "+ ((PlayAreaUI)player2Area).getLevel());
	}

	@Override
	public void endGame(int nrOfLives, TOHallOfFameEntry hof) {
		endgame=true;
		lblScore1.setText("Score: " +Block223Controller.getScoreAndLivePlayer(1)[0]);
		lblLives1.setText("Lives: "+ Block223Controller.getScoreAndLivePlayer(1)[1]);
		lblScore2.setText("Score: " +Block223Controller.getScoreAndLivePlayer(2)[0]);
		lblLives2.setText("Lives: "+ Block223Controller.getScoreAndLivePlayer(2)[1]);
		if(nrOfLives==0) {
			((PlayAreaUI) player1Area).displayGameOver();
			((PlayAreaUI) player2Area).displayCongratulations();
		}else if (nrOfLives==1) {
			((PlayAreaUI) player1Area).displayCongratulations();
			((PlayAreaUI) player2Area).displayGameOver();
		}else if (nrOfLives==2) {
			((PlayAreaUI) player1Area).displayCongratulations();
			((PlayAreaUI) player2Area).displayGameOver();
		}else if (nrOfLives==3) {
			((PlayAreaUI) player2Area).displayCongratulations();
			((PlayAreaUI) player1Area).displayGameOver();
		}
		
		((HallOfFame) HOF).refresh();
		
	}
}
