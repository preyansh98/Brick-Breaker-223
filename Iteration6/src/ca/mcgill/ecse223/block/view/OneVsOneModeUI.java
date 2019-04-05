package ca.mcgill.ecse223.block.view;

import java.awt.EventQueue;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
	private	JPanel Timer;
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
	private volatile String keyString = "";

	private UserEntryListener bp;
	/**
	 * Create the application.
	 */
	public OneVsOneModeUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1312, 741);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		 player2Area = new PlayAreaUI(true);
		
		 HOF = new HallOfFame();
		
		 Timer = new JPanel();
		
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLives2)
								.addComponent(lblLevel2)
								.addComponent(lblScore2)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(player2Area, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
										.addComponent(Timer, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLives1, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
								.addComponent(lblLevel1, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblScore1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(player1Area, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(147)
							.addComponent(lblPlayer2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
							.addComponent(lblPlayer1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(191)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(HOF, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPlayer2)
								.addComponent(lblPlayer1))
							.addGap(240)
							.addComponent(Timer, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(HOF, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
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
										.addComponent(player2Area, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))))
							.addGap(72)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(3))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	protected void doStartGame() {
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
		// TODO Auto-generated method stub
		
	}
}
