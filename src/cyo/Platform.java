package cyo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

public class Platform {

	private double x;
	private double y;
	private int height;
	private int width;
    

    public Platform(int inX, int inY, int inWidth, int inHeight) {
    	x = inX;
    	y = inY;
    	height = inHeight;
    	width = inWidth;
    }
    
    
    public void draw(Graphics g) {
    	Graphics2D g2 = (Graphics2D)g;
    	Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
    	g2.fill(rect);
        Toolkit.getDefaultToolkit().sync();
    }
    

}
