package cyo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player {
	
	private double x;
	private double y;
	private Image myImage;
    private Image stillImage;
    private Image[] rt;
    private Image[] lt;
    private Board board;
    private Buttons buttons;
    private final double RATE = 0.08; // Pixels/ms
    private int lastTime;

    public Player(Board inBoard, int startX, int startY) {
    	board = inBoard;
    	buttons = board.getButtons();
    	x = startX;
    	y = startY;
        ImageIcon ii = new ImageIcon("images/star.png");
        stillImage = ii.getImage();
        rt = new Image[3];
        int fileNum = 1;
        for(int r = 0;r < 3;r++) {
	        ImageIcon iir = new ImageIcon("images/starRt" + fileNum + ".png");
	        rt[r] = iir.getImage();	
	        fileNum++;
        }
        lt = new Image[3];
        fileNum = 1;
        for(int l = 0;l < 3;l++) {
	        ImageIcon iir = new ImageIcon("images/starLt" + fileNum + ".png");
	        lt[l] = iir.getImage();	
	        fileNum++;
        }
        myImage = stillImage;
    }
   
    
    public void update(int timeSinceLast) {
    	if (buttons.rightPressed()) {
        	x += RATE * timeSinceLast;
        	
        	if (x >= board.getWidth()) {
        		x = x - board.getWidth();	 
        	}
        	int imageIWant = lastTime + 1;
        	if (imageIWant > 3) {
        		imageIWant = 1;
        	}
        	myImage = rt [imageIWant - 1];
        	lastTime = imageIWant;
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
