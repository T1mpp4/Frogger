package frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author timi
 */
public class Engine {
    public int cX;
    public int cY;
    private int stepLen;
    private int sizeX;
    private int sizeY;
    private int winsq;
    private int deathsq;
    
    public Engine() {
        Window GameWindow = new Window();
        
        this.sizeX = 20;
        this.sizeY = 20;
        
        this.cX = 400;
        this.cY = 500;
        
        this.stepLen = 50;
        
        this.deathsq = 0;
        this.winsq = 0;
        
        JLabel deaths = new JLabel();
        deaths.setText("Deaths: " + this.deathsq);
        deaths.setForeground(Color.WHITE);
        deaths.setFont(new Font("Seif", Font.PLAIN, 12));
        GameWindow.add(deaths);
        deaths.setBounds(10, 10, 100, 12);
        
        JLabel wins = new JLabel();
        wins.setText("Wins: " + this.winsq);
        wins.setForeground(Color.WHITE);
        wins.setFont(new Font("Seif", Font.PLAIN, 12));
        GameWindow.add(wins);
        wins.setBounds(10, 27, 100, 12);
        
        
        JLabel frog = new JLabel();
        frog.setText("@");
        frog.setForeground(Color.WHITE);
        frog.setFont(new Font("Seif", Font.PLAIN, 20));
        GameWindow.add(frog);
        frog.setBounds(this.cX, this.cY, this.sizeX, this.sizeY);
        
        JLabel car1 = new JLabel();
        car1.setText("|=====|-| |");
        car1.setForeground(Color.WHITE);
        car1.setFont(new Font("Seif", Font.PLAIN, 20));
        
        Vehicle Truck = new Vehicle(GameWindow, car1, frog);
        
        GameWindow.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            
            }

            @Override
            public void keyReleased(KeyEvent e) {
            
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println(cY);
                    cY -= stepLen;
                    frog.setBounds(cX, cY, 20, 20);
                }
                if(checkWin()) {
                    System.out.println("WIN!!"); //win animation :D
                    winsq += 1;
                    wins.setText("Wins: " + winsq);
                }             
            }
        });
    }
    
    public boolean checkWin() {
        if(this.cY <= 30) {
            return true;
        } else {
            return false;
        }
    }
}
