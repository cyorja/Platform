package cyo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class GameObject {

	protected double x;
	protected double y;
	protected Board board;
	protected Image myImage;
	protected int ht = 40;
	protected int wt = 40;
	
	public abstract void update(int time_step);
	
	public void draw(Graphics g) {

		g.drawImage(myImage, (int)x, (int)y, board);
		Toolkit.getDefaultToolkit().sync();
	}

}