/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author timi
 */
public class Tux extends JLabel {
    private JPanel gCanvas;
    
    public static int cX;
    public static int cY;
    private int sizeX;
    private int sizeY;
    private int stepLen;
    
    public JLabel frog;
    
    public int[] loc;
    
    public Tux(JPanel gCanvas) {
        this.gCanvas = gCanvas;
        this.sizeX = 35;
        this.sizeY = 41;
        this.cX = 400;
        this.cY = 522;
        this.stepLen = 52;
        
        this.frog = new JLabel();
        //frog.setText("@");
        this.frog.setForeground(Color.WHITE);
        this.frog.setFont(new Font("Seif", Font.PLAIN, 20));
        gCanvas.add(this.frog);
        this.frog.setBounds(this.cX, this.cY, this.sizeX, this.sizeY);
        
        //frog.setIcon(new ImageIcon("Images/Tux_1.png"));
        this.frog.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Tux_1.png")));  

        //gCanvas.repaint();
    }
    
    public void Up() {
        System.out.println(cY);
        this.cY -= this.stepLen;
        this.frog.setBounds(this.cX, this.cY, this.sizeX, this.sizeY);
        this.gCanvas.repaint();

        /*if(Vehicle.isDead()) {
            deathsq += 1;
            deaths.setText("Deaths: " + deathsq);
            killGame(gCanvas, this.frog);
        }*/
    }
}