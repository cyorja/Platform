package cyo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile extends GameObject {

	private final double RATE = 0.20; // Pixels/ms

	public Missile(Board inBoard, double startX, double startY, boolean moveLeft) {
		board = inBoard;
		ImageIcon ii = new ImageIcon("images/missile.png");
		myImage = ii.getImage();
		x = startX;
		y = startY;
	}	

		public void update(int timeSinceLast) {
			x -= RATE * timeSinceLast;
		}

	}
