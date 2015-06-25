package cyo;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Buttons extends KeyAdapter {
	
	boolean left = false;
	boolean right = false;
	
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
	
    @Override
    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if (key == KeyEvent.VK_LEFT) {
    		left = false;
    	}
    	else if (key == KeyEvent.VK_RIGHT) {
    		right = false;
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
    }
    

}
