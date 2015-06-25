package cyo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel
        implements ActionListener {

    private final int WIDTH = 1200;
    private final int HEIGHT = 1000;
    
    private final int TIME_STEP = 25;

    private Player player;
    private Buttons buttons;
    private Timer timer;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDoubleBuffered(true);
        
        buttons = new Buttons(this);

        player = new Player(this, WIDTH/2, HEIGHT/2);
        
        timer = new Timer(TIME_STEP, this);
        timer.start();
    }
    
    public Buttons getButtons() {
    	return buttons;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        player.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	player.update(TIME_STEP);
        repaint();
    }
}