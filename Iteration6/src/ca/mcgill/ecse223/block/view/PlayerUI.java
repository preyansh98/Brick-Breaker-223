package ca.mcgill.ecse223.block.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;

public class PlayerUI {

	private static JFrame frame;


	/**
	 * Initialize the contents of the frame.
	 */
	public  static void init() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 745, 623);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPlayerModeIs = new JLabel("Player Mode is not available at the moment!");
		lblPlayerModeIs.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerButtonActionPerformed(evt);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addComponent(lblPlayerModeIs)
					.addGap(48))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(567, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(221)
					.addComponent(lblPlayerModeIs)
					.addPreferredGap(ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(51))
		);
		frame.getContentPane().setLayout(groupLayout);
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
