package cyo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player extends GameObject {

	private final int JUMP_SECONDS = 100;
	private Image stillImage;
	private Image[] rt;
	private Image[] lt;
	private Buttons buttons;
	private final double RATE = 0.08; // Pixels/ms
	private int jumpTime = 0;
	private int counter = 0;
	private int imageIWant = 0;

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
			
			counter++;
			if (counter > 2) {
				counter = 0;
				imageIWant++;
			}
			if (imageIWant > rt.length - 1) {
				imageIWant = 0;
			}
			myImage = rt [imageIWant];
		}    

		//Move the player left if left is being pressed
		if (buttons.leftPressed()) {
			x -= RATE * timeSinceLast;
			if (x < 0) {
				x = x + board.getWidth();
			}

			counter++;
			if (counter > 2) {
				counter = 0;
				imageIWant++;
			}
			if (imageIWant > lt.length - 1) {
				imageIWant = 0;
			}
			myImage = lt [imageIWant];
		}    
		
		if (board.platformInArea(x, x + wt, y + ht, y + ht + 1) == null) {
			 if ((jumpTime == 0) || (jumpTime == JUMP_SECONDS)) {
			y += RATE * timeSinceLast;
		}
		} else {
			jumpTime = 0;
		}
		
		//Jump if space bar is being pressed
		if (jumpTime < JUMP_SECONDS) {
			if (buttons.upPressed()) {
				if (jumpTime == 0) {
					jumpTime++;
				}
			}
			if (jumpTime > 0) {
				y -= RATE * timeSinceLast;
				jumpTime++;
			}

		}
		
		if (buttons.leftPressed() == false && buttons.rightPressed() == false && buttons.upPressed() == false) {
			myImage = stillImage;
		}
		
	}

}
