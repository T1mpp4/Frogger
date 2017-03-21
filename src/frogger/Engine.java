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
    public static int winsq;
    public static int deathsq;
    private int carAmount;
    private boolean allowMove = true;
    public static Font cFont = new Font("Seif", Font.PLAIN, 20);
    public static Tux frog;
    
    public Pos frogPos;
    
    public GameCanvas gCanvas;
    
    //public JLabel frog;
    
    public Engine() throws IOException {
        this.oX = 400;
        this.oY = 522;
        
        this.stepLen = 52;
        
        this.deathsq = 0;
        this.winsq = 0;
        
        this.carAmount = 4;
        
        //Window GameWindow = new Window(this.stepLen);
        GameFrame gFrame = new GameFrame();
        this.gCanvas = new GameCanvas();
        
        gFrame.add(gCanvas);
        gFrame.pack();
        
        gCanvas.createGUI(gCanvas);
        
        this.frog = new Tux(gCanvas);
        
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
                        frog.Up();
                        gCanvas.repaint();
                        frogPos.setPosition(cY, cX);
                    }
                }
                if(checkWin(frog)) {
                    System.out.println("WIN!!");
                    
                    winsq += 1;
                    GameCanvas.wins.setText("Wins: " + winsq);
                    killGame();
                    gCanvas.repaint();
                }
                
                if(e.getKeyCode() == KeyEvent.VK_F1) {
                    System.out.println("1");
                    killGame();
                }
            }
        });
        
        int crocoLevel = 1;
        Croco croc = new Croco(gCanvas, frog, crocoLevel);
        //gCanvas.add(croc);
    }
    
    public boolean checkWin(Tux frog) {
        if(frog.cY <= 30) {
            return true;
        } else {
            return false;
        }
    }
    
    public void killGame() {
        gCanvas.removeAll();
        frog = null;
        
        frog.cX = this.oX;
        frog.cY = this.oY;
        Tux.level = 0;
        
        this.frog = new Tux(gCanvas);
        
        //gameCanvas.createGUI(gCanvas);
        this.gCanvas.repaint();
    }
    
    public void driveCars(JPanel gCanvas, Tux frog) {
        int d = 0;
                
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = 0;
                Croco[] cArray = new Croco[carAmount];
                Lumme[] lArray = new Lumme[carAmount];
                
                while(i < carAmount) {
                    int Level = Randomize(1, 10);
                    
                    if(Level % 2 != 0) {
                        cArray[i] = new Croco(gCanvas, frog, Level);
                    } else {
                        lArray[i] = new Lumme(gCanvas, frog, Level);
                    }
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
