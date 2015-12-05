package cyo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile extends GameObject {

	private final double RATE = 0.20; // Pixels/ms
	private String direction = "";
	private int explodeTime = 0;
	private final int explodeNeed = 20;

	public Missile(Board inBoard, double startX, double startY, boolean moveLeft) {
		board = inBoard;

		if (moveLeft == false) {
			direction = "RIGHT";
		} else {
			direction = "LEFT";
		}

		x = startX;
		y = startY;

		if (direction == "RIGHT") {
			ii = new ImageIcon("images/missileRt.png");
			this.x = startX + 41;
		} else {
			ii = new ImageIcon("images/missleLt.png");
			this.x = startX - 41;
		}

		myImage = ii .getImage();
	}

	ImageIcon ii;

	public void collide(GameObject other) {
		boolean passThrough = false;
		if (other instanceof Missile) {
			Missile om = (Missile)other;
			if (om.explodeTime > 0) {
				passThrough = true;
			}
		}
		if (passThrough == false) {
			ii = new ImageIcon("images/explode.gif");
			myImage = ii .getImage();
			explodeTime ++;
		}
	}

	public void update(int timeSinceLast) {
		if (direction .equals("RIGHT") && explodeTime == 0) {
			x += RATE * timeSinceLast;
		} else {
			if (explodeTime == 0) {
				x -= RATE * timeSinceLast;
			}
		}

		if (this.x == 0 || this.x == board.getWidth() || explodeTime == explodeNeed) {
			board.removeGameObject(this);
		}

		if (explodeTime > 0 && explodeTime != explodeNeed) {
			explodeTime++;
		}

	}

}
