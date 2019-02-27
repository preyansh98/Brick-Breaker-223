package ca.mcgill.ecse223.block.model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import ca.mcgill.ecse223.block.controller.Block223Controller;

import javax.swing.JSlider;
import javax.swing.JButton;

public class NewBlockUI {

	private static JFrame frame;


	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 535, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblR = new JLabel("R:");
		lblR.setFont(new Font("Arial Black", Font.BOLD, 15));
		
		JLabel lblB = new JLabel("G:");
		lblB.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblG = new JLabel("B:");
		lblG.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the parameters of the Block");
		lblPleaseEnterThe.setFont(new Font("Arial Black", Font.PLAIN, 15));
		
		JSlider Rvalue = new JSlider();
		Rvalue.setToolTipText("");
		Rvalue.setSnapToTicks(true);
		Rvalue.setPaintTicks(true);
		Rvalue.setPaintLabels(true);
		Rvalue.setMaximum(255);
		
		JSlider Gvalue = new JSlider();
		Gvalue.setMaximum(255);
		Gvalue.setPaintLabels(true);
		Gvalue.setPaintTicks(true);
		Gvalue.setSnapToTicks(true);
		
		JSlider Bvalue = new JSlider();
		Bvalue.setMaximum(255);
		Bvalue.setSnapToTicks(true);
		Bvalue.setPaintTicks(true);
		Bvalue.setPaintLabels(true);
		
		JSlider point = new JSlider();
		point.setMaximum(255);
		point.setSnapToTicks(true);
		point.setPaintTicks(true);
		point.setPaintLabels(true);
		
		JLabel label = new JLabel("0");
		
		JLabel label_1 = new JLabel("0");
		
		JLabel label_2 = new JLabel("0");
		
		JLabel label_3 = new JLabel("1");
		
		JLabel label_4 = new JLabel("255");
		
		JLabel label_5 = new JLabel("255");
		
		JLabel label_6 = new JLabel("255");
		
		JLabel label_7 = new JLabel("1000");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});
		JButton btnAddBlock = new JButton("Add Block");
		btnAddBlock.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnAddBlock.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt, Rvalue, Gvalue, Bvalue, point);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblB)
										.addComponent(lblG)
										.addComponent(lblPoints))
									.addGap(42)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
										.addComponent(label, GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(Bvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(Gvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(Rvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(label_4))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(point, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnAddBlock)
												.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnCancel)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(lblPleaseEnterThe)))
					.addGap(63))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(lblPleaseEnterThe)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(Rvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(label))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblB)
								.addComponent(label_1))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblG)
								.addComponent(label_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Gvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6)
								.addComponent(Bvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(point, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPoints)
							.addComponent(label_3))
						.addComponent(label_7))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel)
						.addComponent(btnAddBlock))
					.addGap(37))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private static void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// clear error message
		
	}
	
	/**
	 * Specification for saveButton event when listener activated
	 * @param evt
	 */
	
	private static void addButtonActionPerformed(java.awt.event.ActionEvent evt, JSlider R, JSlider G, JSlider B, JSlider point) {
	
		try {
			//close the main frame
			Block223Controller.addBlock(R.getValue(), G.getValue(), B.getValue(), point.getValue());
			frame.dispose(); 
			//constructor call for game settings
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
