/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author timi
 */
public class Lumme {
    private int level;
    private JLabel lumme;
    private JPanel gCanvas;
    
    private int lummeX;
    private int lummeY;
    
    public Lumme(JPanel window, JLabel frog, int level_given) {
        this.level = level_given;
        
        int cWidth = 148;
        int cHeight = 45;
        int vLevel = 512 - 51 * this.level;
        
        this.lumme = new JLabel();
        this.lumme.setIcon(new ImageIcon(getClass().getClassLoader().getResource("lumme2_1.png")));  
        
        this.lumme.setBounds(900, vLevel, cWidth, cHeight);
        
        window.add(this.lumme);
        
        this.lumme.setForeground(Color.WHITE);
        //car.setBackground(Color.RED);
        this.lumme.setOpaque(false);
        this.lumme.setFont(Engine.cFont);
        
        Move(window, 1, this.lumme, frog, cWidth, cHeight);
    }
    
    public void Move(JPanel window, int speed, JLabel object, JLabel frog, int vsizeX, int vsizeY) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lummeX = object.getX();
                lummeY = object.getY();
                
                lummeX -= 5;
                
                object.setBounds(lummeX, lummeY, vsizeX, vsizeY);
                
                window.repaint();
                
                /*if(Collision(object, frog)) {
                    System.out.println("COLLISION");
                    //isDead = true;
                }*/
            }
        };
        Timer timer = new Timer(88, actionListener );
        timer.start();
    }
}
