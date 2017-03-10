package frogger;

import static frogger.Vehicle.Collision;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
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
    private double stepLen;
    private int sizeX;
    private int sizeY;
    private int winsq;
    private int deathsq;
    
    public Engine() {        
        this.sizeX = 20;
        this.sizeY = 20;
        
        this.cX = 400;
        this.cY = 500;
        
        this.stepLen = 50.5;
        
        this.deathsq = 0;
        this.winsq = 0;
        
        Window GameWindow = new Window(this.stepLen);
        
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
        
        driveCars(GameWindow, frog);
                
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
                    GameWindow.repaint();
                }
                if(checkWin()) {
                    System.out.println("WIN!!"); //win animation :D
                    winsq += 1;
                    wins.setText("Wins: " + winsq);
                    GameWindow.repaint();
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
    
    public void driveCars(JFrame GameWindow, JLabel frog) {
        int Delay = Randomize(100, 4000);
        
        JLabel car1 = new JLabel();
        car1.setText("|=====|-| |");
        
        JLabel car2 = new JLabel();
        car2.setText("<|=|>");
        
        Vehicle Truck = new Vehicle(GameWindow, car1, frog, 1);    
        Vehicle Car = new Vehicle(GameWindow, car2, frog, 3);
        
        System.out.println(Delay);
        
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Vehicle newCar  = new Vehicle(GameWindow, car1, frog, Randomize(1, 10));
                
                GameWindow.repaint();
            }
        }, 0, Delay);
        
    }
    
    public int Randomize(int low, int high) {
        return (int) (Math.random() * (high - low)) + low;

    }
}
