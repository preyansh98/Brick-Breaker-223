package ca.mcgill.ecse223.block.view;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOGame;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AdminDashBoardUI {

	private static JFrame frame;
	private static JTextField gamenameField;
	private static JComboBox<String> games;
//	private static HashMap<Integer, String> currentGames;
	private static JLabel errorMsg;
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame("Admin DashBoard");
		frame.setVisible(true);
		frame.setBounds(100, 100, 919, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(106,108,110));
		JButton btnAddAGame = new JButton("Add a Game");
		btnAddAGame.setBackground(new Color(51, 204, 153));
		btnAddAGame.setForeground(new Color(51, 153, 0));
		btnAddAGame.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnAddAGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addGameButtonActionPerformed(evt);
			}
		});
		
		JComboBox randomBox = new JComboBox();
		
		JLabel suggestednames = new JLabel("Suggested Game Names:");
		frame.getContentPane().add(suggestednames);
		suggestednames.setFont(new Font("Century Gothic", Font.BOLD, 16));
		String gamenames[] = {"3D Waffle",
				"Hightower",
				"Papa Smurf", 
				"57 Pixels", 
				"Hog Butcher", 
				"Pepper Legs", 
				"101",
				"Houston", 
				"Pinball Wizard", 
				"Accidental Genius", 
				"Hyper", 
				"Pluto", 
				"Alpha", 
				"Jester", 
				"Pogue", 
				"Airport Flier", 
				"Jigsaw", 
				"Prometheus", 
				"Bearded Angler", 
				"Joker's Grin", 
				"Psycho Thinker", 
				"Beetle King", 
				"Judge",
				"Pusher", 
				"Bitmap", 
				"Junkyard Dog", 
				"Riff Raff",  
				"Blister", 
				"K-9",  
				"Roadblock", 
				"Bowie", 
				"Keystone", 
				"Rooster", 
				"Bowler", 
				"Kickstart", 
				"Sandbox", 
				"Breadmaker", 
				"Kill Switch", 
				"Scrapper", 
				"Broomspun", 
				"Kingfisher", 
				"Screwtape", 
				"Buckshot", 
				"Kitchen", 
				"ChocolateBlocks", 
				"Bugger" ,
				"Knuckles" , 
				"Shadow Chaser",
				"Cabbie" ,
				"LadyBird" , 
				"Sherwood Gladiator",
				"Candy Butcher" ,
				"Liquid Science" , 
				"Shooter" ,
				"CapitalG", 
				"Little Cobra" , 
				"Sidewalk Enforcer", 
				"Captain Peroxide", 
				"Little General",
				"HelloMarwan", 
				"Celtic Charger", 
				"Lord Nikon",
				"Sky Bully", 
				"Cereal Killer", 
				"Lord Pistachio", 
				"SlowMoves",
				"Chicago Blackout", 
				"Mad Irishman",
				"Snake Eyes",
				"Chocolate Thunder", 
				"Mad Jack",
				"Snow Hound", 
				"Chuckles",
				"Mad Rascal", 
				"Sofa King", 
				"Commando", 
				"Manimal", 
				"Speedwell" , 
				"Cool Whip" , 
				"Marbles" , 
				"Spider Fuji" , 
				"Cosmo" , 
				"Married Man" , 
				"Springheel Jack" , 
				"Crash Override" , 
				"Marshmallow" , 
				"Squatch" , 
				"Crash Test" , 
				"Mental" , 
				"Stacker of Wheat" , 
				"Crazy Eights" , 
				"Mercury Reborn" , 
				"Sugar Man" , 
				"Criss Cross" , 
				"Midas" , 
				"Jockey" , 
				"Cross Thread" , 
				"Midnight Rambler" , 
				"Swampmasher" , 
				"Cujo" , 
				"Midnight Rider" , 
				"Swerve" , 
				"Dancing Madman" , 
				"Mindless Bobcat" , 
				"Tacklebox" , 
				"Dangle" , 
				"Mr. 44" , 
				"Take Away" , 
				"Dark Horse" , 
				"Mr. Fabulous" , 
				"Tan Stallion" , 
				"Day Hawk" , 
				"Mr. Gadget" , 
				"The China Wall" , 
				"Desert Haze" , 
				"Mr. Lucky" , 
				"The Dude" , 
				"Digger" , 
				"Mr. Peppermint" , 
				"The Flying Mouse" , 
				"Disco Thunder" , 
				"Mr. Spy" , 
				"The Happy Jock" , 
				"Disco Potato" , 
				"Mr. Thanksgiving" , 
				"The Howling Swede" , 
				"Dr. Cocktail" , 
				"Mr. Wholesome" , 
				"Thrasher" , 
				"Dredd" , 
				"Mud Pie Man" , 
				"Toe" , 
				"Dropkick" , 
				"Mule Skinner" , 
				"Toolmaker" , 
				"Drop Stone" , 
				"Murmur" , 
				"Tough Nut" , 
				"Drugstore Cowboy" , 
				"Nacho" , 
				"Trip" , 
				"Easy Sweep" , 
				"Natural Mess" , 
				"Troubadour" , 
				"Electric Player" , 
				"Necromancer" , 
				"Turnip King" , 
				"Esquire" , 
				"Neophyte Believer" , 
				"Twitch" , 
				"Fast Draw" , 
				"Nessie" , 
				"Vagabond Warrior" , 
				"Flakes" , 
				"New Cycle" , 
				"Voluntary" , 
				"Flint" , 
				"Nickname Master" , 
				"Vortex" , 
				"Freak" , 
				"Nightmare King" , 
				"Washer" , 
				"Gas Man" , 
				"Night Train" , 
				"Waylay Dave" , 
				"Glyph" , 
				"Old Man Winter" , 
				"Wheels" , 
				"Grave Digger" , 
				"Old Orange Eyes" , 
				"Wooden Man" , 
				"Guillotine" , 
				"Old Regret" , 
				"Woo Woo" , 
				"Gunhawk" , 
				"Onion King" , 
				"Yellow Menace" , 
				"High Kingdom Warrior" , 
				"Osprey" , 
				"Zero Charisma" , 
				"Highlander Monk" , 
				"Overrun" , 
				"Zesty Dragon" ,
				"Zod"};
		
		
		
		JLabel lblCreateANew = new JLabel("Create a new Game ");
		lblCreateANew.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		gamenameField = new JTextField();
		gamenameField.setColumns(10);
		
		
		JLabel lblOrUpdateExisting = new JLabel("Or Update Existing Game");
		lblOrUpdateExisting.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		games = new JComboBox<String>();
		games.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		try {
			refreshGames();
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		JButton btnUpdateGame = new JButton("Update Game");
		btnUpdateGame.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnUpdateGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateGameButtonActionPerformed(evt);
			}
		});
		JButton btnDeleteGame = new JButton("Delete Game");
		btnDeleteGame.setForeground(new Color(204, 0, 0));
		btnDeleteGame.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnDeleteGame.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					deleteGameButtonActionPerformed();
				} catch (InvalidInputException e) {
					e.printStackTrace();
				}
			}
		});
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logout();
			}
		});
		 errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		JLabel lblBlock = new JLabel("BLOCK");
		lblBlock.setForeground(new Color(51, 102, 255));
		lblBlock.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		JLabel label = new JLabel("223");
		label.setForeground(new Color(153, 0, 0));
		label.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		JLabel lblSelectARandom = new JLabel("Random Game Name");
		lblSelectARandom.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogout)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblCreateANew, Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(gamenameField, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
										.addGap(31)
										.addComponent(btnAddAGame))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(50)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(games, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnUpdateGame)
												.addGap(18)
												.addComponent(btnDeleteGame)))))
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(lblOrUpdateExisting))
					.addGap(367))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(220)
									.addComponent(lblBlock))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(120)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)))
					.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(randomBox, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectARandom))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBlock, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(label))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(errorMsg)
					.addGap(67)
					.addComponent(lblCreateANew)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(gamenameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddAGame))
					.addGap(61)
					.addComponent(lblOrUpdateExisting)
					.addGap(45)
					.addComponent(games, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdateGame)
						.addComponent(btnDeleteGame))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addGap(37))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblSelectARandom)
					.addGap(18)
					.addComponent(randomBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(434, Short.MAX_VALUE))
		);
		
		
		for (int i=0 ; i<=20 ; i++) {
		randomBox.addItem(gamenames[new Random().nextInt(gamenames.length)]);
		}
		randomBox.setSelectedIndex(-1);
		frame.getContentPane().setLayout(groupLayout);
		
		randomBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            gamenameField.setText(String.valueOf(randomBox.getSelectedItem()));  
            }
        });
		
	
	}
	

	protected static void logout() {
		Block223Controller.logout();
		frame.dispose();
		SignInUI.init();
	}

	private static void addGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		// call the controller
		try {
			
			 Block223Controller.createGame(gamenameField.getText());
			 Block223Controller.selectGame(gamenameField.getText());
			 frame.dispose();
			GameSettingUI.init();
		} catch (Exception e) {
			String error = e.getMessage(); 
			errorMsg.setText(error);
		}
		
		// add method here to move on to next screen
	}

	private static void deleteGameButtonActionPerformed() throws InvalidInputException {
		
		if(games.getSelectedIndex() < 0) {
			errorMsg.setText("A game must be selected to delete it.");
			return;
		}
		try {
			 String name = games.getSelectedItem().toString(); 
			 Block223Controller.deleteGame(name);
			 refreshGames();
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		} 
		// add method here to move on to next screen
	}
	
	private static void updateGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		// call the controller
		errorMsg.setText("");
		if(games.getSelectedIndex() < 0) {
			errorMsg.setText("A game must be selected to update it.");
			return;
		}
		try {
			String name = games.getSelectedItem().toString();
			Block223Controller.selectGame(name);
			frame.dispose();
			GameSettingUI.init();
		} catch (InvalidInputException e) {
			errorMsg.setText(e.getMessage());
		}
		
		// add method here to move on to next screen
	}
	
	
	public static void refreshGames() throws InvalidInputException {
		
		
		
		games.removeAllItems();
	//	gameIndex = 0;
		for (TOGame game : Block223Controller.getDesignableGames()) {
			//currentGames.put(gameIndex, game.getName());
			games.addItem(game.getName());
			//gameIndex++;
		};
		games.setSelectedIndex(-1);
	}
}