package frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author timi
 */
public class Engine {
    public int cX;
    public int cY;
    private int oX;
    private int oY;
    private double stepLen;
    private int sizeX;
    private int sizeY;
    private int winsq;
    private int deathsq;
    private int carAmount;
    private boolean allowMove = true;
    
    public Engine() throws IOException {        
        this.sizeX = 35;
        this.sizeY = 41;
        
        this.cX = 400;
        this.cY = 522;
        
        this.oX = 400;
        this.oY = 522;
        
        this.stepLen = 52;
        
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
        //frog.setText("@");
        frog.setForeground(Color.WHITE);
        frog.setFont(new Font("Seif", Font.PLAIN, 20));
        gCanvas.add(frog);
        frog.setBounds(this.cX, this.cY, this.sizeX, this.sizeY);
        
        //frog.setIcon(new ImageIcon("Images/Tux_1.png"));
        frog.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Tux_1.png")));  
        
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
                        frog.setBounds(cX, cY, sizeX, sizeY);
                        gCanvas.repaint();
                        
                        if(Vehicle.isDead()) {
                            deathsq += 1;
                            deaths.setText("Deaths: " + deathsq);
                            killGame(gCanvas, frog);
                        }
                    }
                }
                if(checkWin()) {
                    System.out.println("WIN!!");
                    
                    winsq += 1;
                    wins.setText("Wins: " + winsq);
                    killGame(gCanvas, frog);
                    gCanvas.repaint();
                }
                
                if(e.getKeyCode() == KeyEvent.VK_F1) {
                    System.out.println("1");
                    killGame(gCanvas, frog);
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
    
    private void killGame(JPanel gCanvas, JLabel frog) {
        gCanvas.removeAll();
        
        this.cX = this.oX;
        this.cY = this.oY;
        
        frog.setText("@");
        frog.setForeground(Color.WHITE);
        frog.setFont(new Font("Seif", Font.PLAIN, 20));
        gCanvas.add(frog);
        frog.setBounds(this.oX, this.oY, this.sizeX, this.sizeY);
        
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
        
        Vehicle.reset();
        
        gCanvas.validate();
        
        JLabel goal = new JLabel();
        goal.setText("| G O A L |");
        goal.setForeground(Color.WHITE);
        goal.setFont(new Font("Seif", Font.PLAIN, 20));
        goal.setBounds(360, 2, 600, 50);
        gCanvas.add(goal);
    }
    
    public void driveCars(JPanel gCanvas, JLabel frog) {
        int d = 0;
                
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = 0;
                Vehicle[] vArray = new Vehicle[carAmount];
                JLabel[] cArray = new JLabel[carAmount];
                
                while(i < carAmount) {
                    int carLevel = Randomize(1, 10);
                    cArray[i] = new JLabel();
                    if(carLevel % 2 == 0) {
                        cArray[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("lumme2_1.png")));
                    } else {
                        cArray[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("croco.png")));
                    }
                    
                    vArray[i] = new Vehicle(gCanvas, cArray[i], frog, carLevel);
                    i++;
                }
                
                gCanvas.repaint();
            }
        }, 0, 4000);
    }
    
    public int Randomize(int low, int high) {
        return (int) (Math.random() * (high - low)) + low;
    }
}
