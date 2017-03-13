package frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private int carAmount;
    private boolean allowMove = true;
    
    public Engine() {        
        this.sizeX = 20;
        this.sizeY = 20;
        
        this.cX = 400;
        this.cY = 522;
        
        this.stepLen = 50;
        
        this.deathsq = 0;
        this.winsq = 0;
        
        this.carAmount = 4;
        
        //Window GameWindow = new Window(this.stepLen);
        GameFrame gFrame = new GameFrame();
        GameCanvas gCanvas = new GameCanvas();
        
        gFrame.add(gCanvas);
        gFrame.pack();
        
        JLabel deaths = new JLabel();
        deaths.setText("Deaths: " + this.deathsq);
        deaths.setForeground(Color.WHITE);
        deaths.setFont(new Font("Seif", Font.PLAIN, 12));
        gCanvas.add(deaths);
        deaths.setBounds(10, 10, 100, 12);
        
        JLabel wins = new JLabel();
        wins.setText("Wins: " + this.winsq);
        wins.setForeground(Color.WHITE);
        wins.setFont(new Font("Seif", Font.PLAIN, 12));
        gCanvas.add(wins);
        wins.setBounds(10, 27, 100, 12);
        
        JLabel frog = new JLabel();
        frog.setText("@");
        frog.setForeground(Color.WHITE);
        frog.setFont(new Font("Seif", Font.PLAIN, 20));
        gCanvas.add(frog);
        frog.setBounds(this.cX, this.cY, this.sizeX, this.sizeY);
        
        driveCars(gCanvas, frog);
                
        gFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if(allowMove == true) {
                        System.out.println(cY);
                        cY -= stepLen;
                        frog.setBounds(cX, cY, 20, 20);
                        gCanvas.repaint();
                    }
                }
                if(checkWin()) {
                    System.out.println("WIN!!"); //win animation :D
                    winsq += 1;
                    wins.setText("Wins: " + winsq);
                    gCanvas.repaint();
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
    
    public void driveCars(JPanel gCanvas, JLabel frog) {
        int d = 0;
        
        /*JLabel car1 = new JLabel();
        car1.setText("|=====|-| |");
        
        JLabel car2 = new JLabel();
        car2.setText("<|=|>");
        
        Vehicle Truck = new Vehicle(gCanvas, car1, frog, 1);    
        Vehicle Car = new Vehicle(gCanvas, car2, frog, 3);*/
                
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = 0;
                Vehicle[] vArray = new Vehicle[carAmount];
                JLabel[] cArray = new JLabel[carAmount];
                
                while(i < carAmount) {
                    cArray[i] = new JLabel();
                    cArray[i].setText("C A R");
                    vArray[i] = new Vehicle(gCanvas, cArray[i], frog, Randomize(1, 10));
                    i++;
                }
                
                //int d = Randomize(150, 3000);
                gCanvas.repaint();
            }
        }, 0, 4000);
    }
    
    public int Randomize(int low, int high) {
        return (int) (Math.random() * (high - low)) + low;
    }
}
