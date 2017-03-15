/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author timi
 */
public class Vehicle {
    private Font cFont = new Font("Seif", Font.PLAIN, 20);
    private static int deathc;
    private static boolean isDead;
    
    public Vehicle(JPanel window, JLabel car, JLabel frog, int level) {
        
        int cWidth = 50;
        int cHeight = 35;
        int vLevel = 512 - 50 * level;
        
        if(level % 2 == 0) {
            car.setBounds(-100, vLevel, cWidth, cHeight);
        } else {
            car.setBounds(900, vLevel, cWidth, cHeight);
        }
        window.add(car);
        
        
        car.setForeground(Color.WHITE);
        //car.setBackground(Color.RED);
        car.setOpaque(false);
        car.setFont(cFont);
        
        if(level % 2 == 0) {
            Move(window, 50, car, frog, cWidth, cHeight, 1);
        } else {
            Move(window, 50, car, frog, cWidth, cHeight, 0);
        }
    }
    
    public static void Move(JPanel window, int speed, JLabel object, JLabel frog, int vsizeX, int vsizeY, int direction) {
        
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int vX = object.getX();
                int vY = object.getY();
                
                if(direction == 1) {
                    vX += 10;
                } else {
                    vX -= 10;
                }
                
                object.setBounds(vX, vY, vsizeX, vsizeY);
                
                window.repaint();
                
                if(Collision(object, frog)) {
                    System.out.println("COLLISION");
                    isDead = true;
                }
            }
        };
        Timer timer = new Timer(175, actionListener );
        timer.start();
    }
    
    public static boolean Collision(JLabel test_a, JLabel test_b){
        Rectangle rectB = test_b.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(test_a.getX(), test_a.getY(), test_a.getWidth(), test_a.getHeight(), rectB);
        
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public static boolean isDead() {
        return isDead;
    }
    
    public static void reset() {
        isDead = false;
    }
}
