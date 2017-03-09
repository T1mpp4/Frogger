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
    
    public Engine() {
        Window GameWindow = new Window();
        
        this.sizeX = 20;
        this.sizeY = 20;
        
        this.cX = 400;
        this.cY = 500;
        
        this.stepLen = 50;
        
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
        
        Vehicle Truck = new Vehicle(GameWindow, car1);
        
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
    
    public boolean intersects(JLabel test_a, JLabel test_b){
        Rectangle rectB = test_b.getBounds();

        Rectangle result = SwingUtilities.computeIntersection(test_a.getX(), test_a.getY(), test_a.getWidth(), test_a.getHeight(), rectB);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
}
