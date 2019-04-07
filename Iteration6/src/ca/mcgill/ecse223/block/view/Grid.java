package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ListModel;
import javax.swing.TransferHandler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.mcgill.ecse223.block.controller.TOBlock;
import ca.mcgill.ecse223.block.controller.TOGridCell;

@SuppressWarnings("serial")
public class Grid extends JLayeredPane implements Runnable {
	private static Rectangle2D[][] rectangles;
	private JList<String> list;
	private Rectangle2D floatRect;
	private Rectangle2D blockPreview;
	private int index;
	private TOBlock currentBlock;
	private boolean mouseClicked;
	private boolean previewDrag = false;
	private boolean gridObjectSelected=false;
	private TOGridCell draggedCell;
	private int movedX = 1;
	private int movedY = 1;
	Graphics2D g2d;

	public Grid() {
		super();
		
		repaint();

		list = new JList<String>(LevelSettingUI.getBlockList());

		list.setLocation(450, 10);
		list.setSize(300, 150);
		list.setBackground(this.getBackground());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setView(list);
		scrollPane.setSize(300, 150);
		scrollPane.setLocation(450, 10);
		scrollPane.setBackground(this.getBackground());

		this.add(scrollPane);
		//this.moveToFront(trash);
		JLabel blockPrev = new JLabel("Block to drag: ");
		blockPrev.setFont(new Font("Century Gothic", Font.BOLD, 15));
		blockPrev.setSize(130, 30);
		blockPrev.setLocation(450, 170);
		this.add(blockPrev);
		blockPreview = new Rectangle2D.Float(460 + (int) blockPrev.getSize().getWidth(), 170, 40, 40);
		
		JLabel pacmanText=new JLabel("Feed pacman to delete:");
		pacmanText.setFont(new Font("Century Gothic", Font.BOLD, 15));
		pacmanText.setSize(200, 30);
		pacmanText.setLocation(420, 300);
		this.add(pacmanText);
		Trash trash = new Trash();
		int trashX = 420+200;
		int trashY = 230;
		trash.setLocation(trashX, trashY);
		int maxTrashX = (int) (trashX + trash.getSize().getWidth());
		int maxTrashY = (int) (trashY + trash.getSize().getHeight());
		this.add(trash);

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				index = list.getSelectedIndex();
				currentBlock = LevelSettingUI.getBlock(index);
				repaint();

			}

		});
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						trash.openPacMouth();
						int x = e.getX();
						int y = e.getY();
						mouseClicked = true;
						previewDrag = false;
						if (blockPreview.contains(x, y)) {
							floatRect = new Rectangle2D.Float(x, y, 20, 20);
							previewDrag = true;
							repaint();
						} else {
							for (int row = 0; row < 15; row++) {
								for (int column = 0; column < 15; column++) {
									if (rectangles[row][column].contains(x, y)) {
										LevelSettingUI.displayBlockInfo(row + 1, column + 1);
										draggedCell=LevelSettingUI.getCell(column+1, row+1);
										floatRect = (Rectangle2D) rectangles[row][column].clone();
										gridObjectSelected=true;
										movedX = column + 1;
										movedY = row + 1;
										repaint();
										break;
									}
								}
							}
						}

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						int x = e.getX();
						int y = e.getY();
						int newX = (x - 10) / 25 + 1;
						int newY = (y - 10) / 22 + 1;
						if (mouseClicked) {
							if (x < 400 && y < 400) {
								if (previewDrag) {
									LevelSettingUI.positionBlock(currentBlock.getId(), newX, newY);
									previewDrag=false;
								} else if(gridObjectSelected) {
									
									LevelSettingUI.moveBlock(movedX, movedY, newX, newY);
									gridObjectSelected=false;
								}
							} else if (gridObjectSelected && x >= trashX && y >= trashY && x <= maxTrashX && y <= maxTrashY) {
								trash.closePacMouth(); 
								LevelSettingUI.deleteBlock(movedX, movedY);
								gridObjectSelected=false;
							}
						}

						for (int row = 0; row < 15; row++) {
							for (int column = 0; column < 15; column++) {
								if (rectangles[row][column].contains(x, y)) {
									LevelSettingUI.displayBlockInfo(row + 1, column + 1);
									break;
								}
							}
						}

						mouseClicked = false;
						repaint();
					}

				});
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(this);
		t2.start();

	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (mouseClicked) {

				if (floatRect != null) {
					double mouseX = MouseInfo.getPointerInfo().getLocation().getX() - LevelSettingUI.getOffsetX();
					double mouseY = MouseInfo.getPointerInfo().getLocation().getY() - LevelSettingUI.getOffsetY();
					// floatRect=new Rectangle2D.Double(mouseX-10, mouseY-10,20, 20);
					floatRect.setRect(mouseX - 10, mouseY - 10, 20, 20);

					repaint();
				}
			} else {
				floatRect = null;
			}
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	public void populatelist() {

	}

	private void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
		int y = 10;
		int x = 10;
		g2d = (Graphics2D) g.create();
		TOGridCell[][] temp = LevelSettingUI.getGrid();
		new Rectangle2D.Float(x, y, 20, 20);
		rectangles = new Rectangle2D[15][15];
		for (int row = 0; row < 15; row++) {
			for (int column = 0; column < 15; column++) {
				rectangles[row][column] = new Rectangle2D.Float(x, y, 20, 20);
				if (temp[row][column] == null) {
					g2d.setColor(Color.WHITE);
				} else {
					Color color = new Color(temp[row][column].getRed(), temp[row][column].getGreen(),
							temp[row][column].getBlue());
					g2d.setColor(color);
				}

				g2d.fill(rectangles[row][column]);
				g2d.setColor(Color.BLACK);
				g2d.draw(rectangles[row][column]);
				x += 25;

			}
			x = 10;
			y += 22;
		}
		if (currentBlock != null) {
			Color color = new Color(currentBlock.getRed(), currentBlock.getGreen(), currentBlock.getBlue());
			g2d.setColor(color);
			g2d.fill(blockPreview);

		}
		g2d.setColor(Color.BLACK);
		g2d.draw(blockPreview);
		if (previewDrag && floatRect != null && currentBlock != null) {
			Color color = new Color(currentBlock.getRed(), currentBlock.getGreen(), currentBlock.getBlue());

			g2d.setColor(color);

			g2d.fill(floatRect);
			g2d.setColor(Color.BLACK);
			g2d.draw(floatRect);

		} else if (!previewDrag && floatRect != null) {
			if(draggedCell!=null) {
				Color color = new Color(draggedCell.getRed(), draggedCell.getGreen(), draggedCell.getBlue());
				g2d.setColor(color);

				g2d.fill(floatRect);
			}
			g2d.setColor(Color.BLACK);
			g2d.draw(floatRect);
		}
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}

}
