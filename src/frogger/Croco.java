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
public class Croco {
    private int level;
    private JLabel croco;
    private JPanel gCanvas;
    
    private int crocoX;
    private int crocoY;
    
    public Croco(JPanel window, JLabel frog, int level_given) {
        this.level = level_given;
        
        int cWidth = 148;
        int cHeight = 45;
        int vLevel = 512 - 51 * this.level;
        
        this.croco = new JLabel();
        this.croco.setIcon(new ImageIcon(getClass().getClassLoader().getResource("croco.png")));  
        
        this.croco.setBounds(-100, vLevel, cWidth, cHeight);
        
        window.add(this.croco);
        
        this.croco.setForeground(Color.WHITE);
        //car.setBackground(Color.RED);
        this.croco.setOpaque(false);
        this.croco.setFont(Engine.cFont);
        
        Move(window, 1, this.croco, frog, cWidth, cHeight);
    }    
    
    public void Move(JPanel window, int speed, JLabel object, JLabel frog, int vsizeX, int vsizeY) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                crocoX = object.getX();
                crocoY = object.getY();
                
                crocoX += 5;
                
                object.setBounds(crocoX, crocoY, vsizeX, vsizeY);
                
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
