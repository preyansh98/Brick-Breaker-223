package ca.mcgill.ecse223.block.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ca.mcgill.ecse223.block.controller.Block223Controller;

import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Color;

public class NewBlockUI {

	private static JFrame frame;
	private static JLabel errorMsg;

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame("New Block");
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
		point.setMinimum(1);
		point.setMaximum(1000);
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
		
		JLabel label_8 = new JLabel("50");
		
		JLabel label_9 = new JLabel("50");
		
		JLabel label_10 = new JLabel("50");
		
		JLabel label_11 = new JLabel("50");
		
		Rvalue.addChangeListener((new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				change(Rvalue.getValue(),label_8);
			}
		}));
		Gvalue.addChangeListener((new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				change(Gvalue.getValue(),label_9);
			}
		}));
		Bvalue.addChangeListener((new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				change(Bvalue.getValue(),label_10);
			}
		}));
		point.addChangeListener((new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				change(point.getValue(),label_11);
			}
		}));
		
		 errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblG)
										.addComponent(lblPoints)
										.addComponent(lblB))
									.addGap(21)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addComponent(label_10))
											.addComponent(label_9))
										.addComponent(label_8)))
								.addComponent(btnCancel))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnAddBlock)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(point, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_4))))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(Bvalue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(Gvalue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(Rvalue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(lblPleaseEnterThe))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(errorMsg)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPleaseEnterThe)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_8))
								.addComponent(label_4)
								.addComponent(Rvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_1)
										.addComponent(label_9)
										.addComponent(lblB))
									.addGap(30)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblG)
										.addComponent(label_2)
										.addComponent(label_10)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_5)
										.addComponent(Gvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(Bvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_6))))
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblPoints)
									.addComponent(label_3)
									.addComponent(label_11))
								.addComponent(label_7)
								.addComponent(point, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCancel)
								.addComponent(btnAddBlock))
							.addGap(37))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private static void change(int value, JLabel label) {
		label.setText(value+"");
	}

	private static void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// clear error message
		frame.dispose();
		GameSettingUI.init();
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
			GameSettingUI.init();
			//constructor call for game settings
		}
		catch(Exception e) {
			errorMsg.setText(e.getMessage());
		}
	}

}
