package cyo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Alien extends GameObject {
	private Image stillImage;

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
			System.out.print("Shooting missile ");

			if (board.locatePlayer().x < this.x) {
				Missile boom = new Missile(board, this.x, this.y, true);
				board.addGameObject(boom);
			} else {
				Missile boom = new Missile(board, this.x, this.y, false);
				board.addGameObject(boom);
			}
		}
	}
}