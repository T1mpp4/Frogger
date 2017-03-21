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
public class Tux {
    private JPanel gCanvas;
    
    public int cX;
    public int cY;
    public boolean lumpeella;
    private int sizeX;
    private int sizeY;
    private int stepLen;
    
    public JLabel frog;
    
    public static int level;
    
    public int[] loc;
    
    public Tux(JPanel gCanvas, String col) {
        this.gCanvas = gCanvas;
        this.sizeX = 35;
        this.sizeY = 41;
        this.cX = 400;
        this.cY = 522;
        this.stepLen = 52;
        this.lumpeella = false;
        
        this.frog = new JLabel();
        this.frog.setForeground(Color.WHITE);
        this.frog.setFont(new Font("Seif", Font.PLAIN, 20));
        gCanvas.add(this.frog);
        this.frog.setBounds(this.cX, this.cY, this.sizeX, this.sizeY);
        
        if(col.equals("p")) {
            this.frog.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Tux_2.png")));
        } else {
            this.frog.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Tux_1.png")));  
        }
    }
    
    public void Up() {
        System.out.println(this.cY);
        this.cY -= this.stepLen;
        this.level += 1;
        this.frog.setBounds(this.cX, this.cY, this.sizeX, this.sizeY);
        this.gCanvas.repaint();
    }
    
    public void Left(double lummeSpeed) {
        this.cX -= lummeSpeed;
        this.frog.setBounds(this.cX, this.cY, this.sizeX, this.sizeY);
        this.gCanvas.repaint();
    }
    
    public int[] getPos() {
        int[] posxy = {this.cX, this.cY};
        return posxy;
    }
}