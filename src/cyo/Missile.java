package cyo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile extends GameObject {

	private final double RATE = 0.20; // Pixels/ms
	private String direction = "";

	public Missile(Board inBoard, double startX, double startY, boolean moveLeft) {
		board = inBoard;
		
		ImageIcon ii;

		if (moveLeft == false) {
			direction = "RIGHT";
		} else {
			direction = "LEFT";
		}

		if (direction == "RIGHT") {
			ii = new ImageIcon("images/missileRt.png");
		} else {
			ii = new ImageIcon("images/missleLt.png");
		}

		myImage = ii .getImage();
		x = startX;
		y = startY;
	}

	public void update(int timeSinceLast) {
		if (direction .equals("RIGHT")) {
			x += RATE * timeSinceLast;
		} else {
			x -= RATE * timeSinceLast;
		}

		if (this.x == 0 || this.x == board.getWidth()) {
			System.out.println("missle dead");
		}

	}

}
