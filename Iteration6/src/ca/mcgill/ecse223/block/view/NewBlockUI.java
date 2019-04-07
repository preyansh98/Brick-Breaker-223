package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import javax.swing.JLayeredPane;

public class NewBlockUI {

	private static JFrame frame;
	private static JLabel errorMsg;
	private static JLayeredPane blockPreview;
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void init() {
		frame = new JFrame("New Block");
		frame.setVisible(true);
		frame.setBounds(100, 100, 504, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(106,108,110));
		JLabel lblR = new JLabel("R:");
		lblR.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblB = new JLabel("G:");
		lblB.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblG = new JLabel("B:");
		lblG.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblPoints = new JLabel("Points:");
		lblPoints.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the parameters of the Block");
		lblPleaseEnterThe.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
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
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_1 = new JLabel("0");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_2 = new JLabel("0");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_3 = new JLabel("1");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_4 = new JLabel("255");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_5 = new JLabel("255");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_6 = new JLabel("255");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_7 = new JLabel("1000");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		Rvalue.setBackground(new Color(106,108,110));
		Gvalue.setBackground(new Color(106,108,110));
		Bvalue.setBackground(new Color(106,108,110));
		point.setBackground(new Color(106,108,110));
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(0, 0, 0));
		btnCancel.setForeground(new Color(204, 0, 0));
		btnCancel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});
		JButton btnAddBlock = new JButton("Add Block");
		btnAddBlock.setBackground(new Color(0, 0, 0));
		btnAddBlock.setForeground(new Color(51, 102, 0));
		btnAddBlock.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnAddBlock.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt, Rvalue, Gvalue, Bvalue, point);
			}
		});
		
		JLabel label_8 = new JLabel("50");
		label_8.setForeground(new Color(255, 51, 0));
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_9 = new JLabel("50");
		label_9.setForeground(new Color(0, 153, 0));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_10 = new JLabel("50");
		label_10.setForeground(new Color(0, 102, 255));
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JTextField pointTxt = new JTextField("50");
		pointTxt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pointTxt.setBackground(frame.getBackground());
		pointTxt.addActionListener((new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int value=0;
				try {
					value=Integer.parseInt(pointTxt.getText());
					if (value>=1 && value<=1000) {
						point.setValue(value);
					}else {
						errorMsg.setText("Please enter a value between 1 and 1000 only for the points.");
					}
				}catch(Exception e) {
					errorMsg.setText("Please enter integers only for points.");
				}
				
			}
			
		}));
		Rvalue.addChangeListener((new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				change(Rvalue.getValue(),label_8);
				((BlockPreview)blockPreview).update(Rvalue.getValue(),Gvalue.getValue(),Bvalue.getValue());
			}
		}));
		Gvalue.addChangeListener((new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				change(Gvalue.getValue(),label_9);
				((BlockPreview)blockPreview).update(Rvalue.getValue(),Gvalue.getValue(),Bvalue.getValue());
			}
		}));
		Bvalue.addChangeListener((new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				change(Bvalue.getValue(),label_10);
				((BlockPreview)blockPreview).update(Rvalue.getValue(),Gvalue.getValue(),Bvalue.getValue());
			}
		}));
		point.addChangeListener((new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				change(point.getValue(),pointTxt);
			}
		}));
		
		 errorMsg = new JLabel("");
		errorMsg.setForeground(Color.RED);
		
		JLabel lblPreview = new JLabel("Preview: ");
		lblPreview.setFont(new Font("Century Gothic", Font.BOLD, 16));
		
		 blockPreview = new BlockPreview();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPoints)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(lblB)
													.addComponent(lblG)))
											.addGap(21)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addComponent(pointTxt, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.RELATED))
														.addComponent(label_10))
													.addComponent(label_9))
												.addComponent(label_8)))
										.addComponent(btnCancel))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(26)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
														.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(label))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addComponent(point, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
																.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
																.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
																.addComponent(label_4)))
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
															.addComponent(Bvalue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addComponent(Gvalue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
															.addComponent(Rvalue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))))
												.addComponent(blockPreview, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnAddBlock)
											.addGap(37))))
								.addComponent(lblPreview)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(lblPleaseEnterThe))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(errorMsg, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)))
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
									.addComponent(pointTxt))
								.addComponent(label_7)
								.addComponent(point, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPreview)
							.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancel)
								.addComponent(btnAddBlock))
							.addGap(37))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(blockPreview, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private static void change(int value, JLabel label) {
		label.setText(value+"");
	}
	private static void change(int value, JTextField label) {
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
