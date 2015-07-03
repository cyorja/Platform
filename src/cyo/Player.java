package cyo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player {
	
	private double x;
	private double y;
    private Image myImage;
    private Board board;
    private Buttons buttons;
    private final double RATE = 0.08; // Pixels/ms
    

    public Player(Board inBoard, int startX, int startY) {
    	board = inBoard;
    	buttons = board.getButtons();
    	x = startX;
    	y = startY;
        ImageIcon ii = new ImageIcon("images/star.png");
        myImage = ii.getImage();
    }
    
    public void update(int timeSinceLast) {
    	if (buttons.rightPressed()) {
        	x += RATE * timeSinceLast;
        	if (x >= board.getWidth()) {
        		x = x - board.getWidth();
        	}
    	}
    	if (buttons.leftPressed()) {
        	x -= RATE * timeSinceLast;
        	if (x < 0) {
        		x = x + board.getWidth();
        	}
    	}    	
    }
    
    public void draw(Graphics g) {

        g.drawImage(myImage, (int)x, (int)y, board);
        Toolkit.getDefaultToolkit().sync();
    }
    
}
