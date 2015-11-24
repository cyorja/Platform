package cyo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Alien extends GameObject {
	private Image stillImage;
	private int launchTime = 0;
	private int launchNeed = 20; 

	public Alien(Board inBoard, double startX, double startY) {
		board = inBoard;
		ImageIcon ii = new ImageIcon("images/Alien.png");
		stillImage = ii.getImage();
		x = startX;
		y = startY;
		myImage = stillImage;
		
	}
	public void update(int timeSenceLast) {


		if (board.locatePlayer().y == this.y) {
			if (launchTime == launchNeed) {
				launchTime = 0;
				if (board.locatePlayer().x < this.x) {
					Missile boom = new Missile(board, this.x, this.y, true);
					board.addGameObject(boom);
				} else {
					Missile boom = new Missile(board, this.x, this.y, false);
					board.addGameObject(boom);
				}
			} else {
				launchTime++;
			}
		}
	}
}