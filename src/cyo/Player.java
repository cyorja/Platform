package cyo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Player {
	
	private double x;
	private double y;
    private Image stillImage;
    private Image[] leftImages;
    private Image[] rightImages;
    private Image currentImage;
    private Board board;
    private Buttons buttons;
    private final double RATE = 0.08; // Pixels/ms
    

    public Player(Board inBoard, int startX, int startY) {
    	board = inBoard;
    	buttons = board.getButtons();
    	x = startX;
    	y = startY;
    	loadImages();
    	currentImage = stillImage;
    }
    
    private void loadImages() {
    	stillImage = loadImage("star.png");
    	rightImages = new Image[3];
    	rightImages[0] = loadImage("starRt1.png");
    	rightImages[1] = loadImage("starRt2.png");
    	rightImages[2] = loadImage("starRt3.png");
    	leftImages = new Image[3];
    	leftImages[0] = loadImage("starLt1.png");
    	leftImages[1] = loadImage("starLt2.png");
    	leftImages[2] = loadImage("starLt3.png");
    	
    }
    
    private Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon("images/" + imageName);
        Image newImage = ii.getImage();
        return newImage;
    }
    
    public void update(int timeSinceLast) {
    	if (buttons.rightPressed()) {
    		currentImage = rightImages[0];
        	x += RATE * timeSinceLast;
        	if (x >= board.getWidth()) {
        		x = x - board.getWidth();
        	}
    	}
    	if (buttons.leftPressed()) {
    		currentImage = leftImages[0];
        	x -= RATE * timeSinceLast;
        	if (x < 0) {
        		x = x + board.getWidth();
        	}
    	}    	
    }
    
    public void draw(Graphics g) {

        g.drawImage(currentImage, (int)x, (int)y, board);
        Toolkit.getDefaultToolkit().sync();
    }
    
}
