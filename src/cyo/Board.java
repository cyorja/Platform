package cyo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	private final int WIDTH = 1200;
	private final int HEIGHT = 800;

	private final int TIME_STEP = 25;

	private ArrayList<GameObject> avatars;
	private ArrayList <Platform> platforms;
	private Buttons buttons;
	private Timer timer;

	public Board() {

		initBoard();
	}

	private void initBoard() {

		buttons = new Buttons(this);

		avatars = new ArrayList<GameObject>();

		avatars.add(new Player(this, 600, 500));
		avatars.add(new Alien(this, 500, 700));

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDoubleBuffered(true);
		
		platforms = new ArrayList <Platform> ();
		
		platforms.add(new Platform (450, 540, 300, 20));
		platforms.add(new Platform (150, 740, 700, 20));
		platforms.add(new Platform (990, 645, 120, 20));

		timer = new Timer(TIME_STEP, this);
		timer.start();
	}

	public void addGameObject(GameObject newObj) {
		avatars.add(newObj);
	}

	public void removeGameObject(GameObject oldObj) {
		avatars.remove(oldObj);
	}

	public Buttons getButtons() {
		return buttons;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (GameObject a : avatars) {
			a.draw(g);
		}
		for (Platform p : platforms) {
			p.draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int up = 0; up < avatars.size(); up++) {
			avatars.get(up).update(TIME_STEP);
		}

		// Check every pair of objects to see if any overlap.
		for (int index1 = 0; index1 < avatars.size(); ++index1) {
			for (int index2 = index1 + 1; index2 < avatars.size(); ++index2) {
				if (avatars.get(index1).touches(avatars.get(index2))) {
					avatars.get(index1).collide(avatars.get(index2));
					avatars.get(index2).collide(avatars.get(index1));
				}
			}
		}

		repaint();
	}

	/**
	 * Determine if any platform on the board touch the given area
	 * 
	 * @param left
	 *            the x-coordinate of the left side of the area
	 * @param right
	 *            the x-coordinate of the right side of the area
	 * @param top
	 *            the y-coordinate of the top of the area
	 * @param bottom
	 *            the y-coordinate of the bottom of the area
	 * @return the first platform it finds that is in that area or null if no
	 *         platforms are in that area.
	 */
	public Platform platformInArea(double left, double right, double top,
			double bottom) {
		Platform found = null;

		// Loop through all the platforms and see if any are in the specified
		// area.
		// Stop after finding the first one.
		for (int ctr = 0; ctr < platforms.size(); ++ctr) {
			Platform next = platforms.get(ctr);
			if (next.touches(left, right, top, bottom)) {
				found = next;
				break;
			}
		}
		return found;
	}

	public Player locatePlayer() {
		return (Player) avatars.get(0);
	}

}
