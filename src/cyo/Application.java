package cyo;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class Application extends JFrame {
    private final double RATE = 0.20; // Pixels/ms
    public Application() {

        initUI();
    }

    private void initUI() {

        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Platform Game");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new Application();
                ex.setVisible(true);                
            }
        });
    }}