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
	
    /**
     * Determine if this game object touches another game object
     * @param other the other game object
     * @return true if it touches, false if it does not.
     */
    public boolean touches(GameObject other) {
    	return (x <= (other.x+other.wt)) && ((x+wt) >= other.x) && (y <= (other.y+other.ht)) && ((y+ht) >= other.y);
    }

    /**
     * Determine if this game object touches a given area
     * @param left the x-coordinate of the left side of the area
     * @param right the x-coordinate of the right side of the area
     * @param top the y-coordinate of the top of the area
     * @param bottom the y-coordinate of the bottom of the area
     * @return true if it touches, false if it does not.
     */
    public boolean touches(double left, double right, double top, double bottom) {
    	return (x <= right) && (x+wt >= left) && (y <= bottom) && (y+ht >= top);
    }
    
    /**
     * Process what happens when this object collides with another.
     * @param other the object this collided with
     */
    public void collide(GameObject other) {
    	// Meant to be overridden by derived classes
    }

}