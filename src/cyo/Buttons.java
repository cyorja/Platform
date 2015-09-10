package cyo;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Buttons extends KeyAdapter {
	
	boolean left = false;
	boolean right = false;
	boolean up = false;
	
	public Buttons(Component panel) {
        panel.addKeyListener(this);
        panel.setFocusable(true);
        
	}
	
	public boolean leftPressed() {
		return left;
	}
	
	public boolean rightPressed() {
		return right;
	}
	
	public boolean upPressed() {
		return up;
	}
	
	
    @Override
    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if (key == KeyEvent.VK_LEFT) {
    		left = false;
    	}
    	else if (key == KeyEvent.VK_RIGHT) {
    		right = false;
    	}
    	
    	 else if (key == KeyEvent.VK_UP) {
    		up = false;
    	 }
    	
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if (key == KeyEvent.VK_LEFT) {
    		left = true;
    	}
    	else if (key == KeyEvent.VK_RIGHT) {
    		right = true;
    	}
    	
    	else if (key == KeyEvent.VK_UP) {
    		up = true;
    	}
    	
    }

}
