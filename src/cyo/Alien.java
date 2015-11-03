package cyo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Alien extends GameObject {
private Image stillImage;

	public Alien(Board inBoard, int startX, int startY) {
		board = inBoard;
		ImageIcon ii = new ImageIcon("images/Alien.png");
		stillImage = ii.getImage();
		x = startX;
		y = startY;
		myImage = stillImage;
	
	}
	public void update(int timeSenceLast) {
	
		if (board.locatePlayer().y == this.y) {
			System.out.println("Shooting missile");
		}
	
	}
}