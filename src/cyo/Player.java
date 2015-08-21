package cyo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player {

	private double x;
	private double y;
	private int ht = 40;
	private int wt = 40;
	private Image myImage;
	private Image stillImage;
	private Image[] rt;
	private Image[] lt;
	private Board board;
	private Buttons buttons;
	private final double RATE = 0.08; // Pixels/ms
	private int lastTime;

	public Player(Board inBoard, int startX, int startY) {
		board = inBoard;
		buttons = board.getButtons();
		x = startX;
		y = startY;
		ImageIcon ii = new ImageIcon("images/star.png");
		stillImage = ii.getImage();
		rt = new Image[3];
		int fileNum = 1;
		for(int r = 0;r < 3;r++) {
			ImageIcon iir = new ImageIcon("images/starRt" + fileNum + ".png");
			rt[r] = iir.getImage();	
			fileNum++;
		}
		lt = new Image[3];
		fileNum = 1;
		for(int l = 0;l < 3;l++) {
			ImageIcon iir = new ImageIcon("images/starLt" + fileNum + ".png");
			lt[l] = iir.getImage();	
			fileNum++;
		}
		myImage = stillImage;
	}


	/**
	 * Look at what's around us and what keys are being pressed and change
	 * our location and image accordingly.
	 * @param timeSinceLast time since we last updated the player
	 */
	public void update(int timeSinceLast) {
	
		// Move the player right if right is being pressed
		if (buttons.rightPressed()) {
			x += RATE * timeSinceLast;

			if (x >= board.getWidth()) {
				x = x - board.getWidth();	 
			}
			int imageIWant = lastTime + 1;
			if (imageIWant > 3) {
				imageIWant = 1;
			}
			myImage = rt [imageIWant - 1];
			lastTime = imageIWant;
		}
		
		//Move the player left if left is being pressed
		if (buttons.leftPressed()) {
			x -= RATE * timeSinceLast;
			if (x < 0) {
				x = x + board.getWidth();
			}
			int imageIWant = lastTime + 1;
			if (imageIWant > 3) {
				imageIWant = 1;
			}
			myImage = lt [imageIWant - 1];
			lastTime = imageIWant;
			
		}    	
		if (board.platformInArea(x, x + wt, y + ht, y + ht + 1) == null) {
			y += RATE * timeSinceLast;
		}
	}

	public void draw(Graphics g) {

		g.drawImage(myImage, (int)x, (int)y, board);
		Toolkit.getDefaultToolkit().sync();
	}

}
