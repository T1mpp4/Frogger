/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author timi
 */
public class Vehicle {
    public Vehicle(JFrame window, JLabel car, JLabel frog, int level) {
        int vLevel = 450 - 50 * level;
        car.setBounds(20, vLevel, 200, 100);
        window.add(car);
        
        car.setForeground(Color.WHITE);
        car.setFont(new Font("Seif", Font.PLAIN, 20));
        
        Move(window, 50, car, frog, 140, 100);
        
    }
    
    public static void Move(JFrame window, int speed, JLabel object, JLabel frog, int vsizeX, int vsizeY) {
        
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int vX = object.getX();
                int vY = object.getY();
                
                vX += 10;
                
                object.setBounds(vX, vY, vsizeX, vsizeY);
                
                window.repaint();
                
                if(Collision(object, frog)) {
                    System.out.println("COLLISION");
                }
            }
        };
        Timer timer = new Timer(175, actionListener );
        timer.start();

        
        /*Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                int vX = object.getX();
                int vY = object.getY();
                
                vX += 10;
                
                object.setBounds(vX, vY, vsizeX, vsizeY);
                
                window.repaint();
                
                if(Collision(object, frog)) {
                    System.out.println("COLLISION");
                }
            }
        }, 0, 175);*/
    }
    
    public static boolean Collision(JLabel test_a, JLabel test_b){
        Rectangle rectB = test_b.getBounds();

        Rectangle result = SwingUtilities.computeIntersection(test_a.getX(), test_a.getY(), test_a.getWidth(), test_a.getHeight(), rectB);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
}
