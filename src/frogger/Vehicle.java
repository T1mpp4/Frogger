/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Rectangle;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Timer;
import javax.swing.SwingUtilities;

/**
 *
 * @author timi
 */
public class Vehicle {
    public Vehicle(JFrame window, JLabel car, JLabel frog) {
        car.setBounds(20, 400, 200, 100);
        window.add(car);
        
        Move(50, car, frog, 140, 100);
    }
    
    public static void Move(int speed, JLabel object, JLabel frog, int vsizeX, int vsizeY) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                int vX = object.getX();
                int vY = object.getY();
                
                vX += 10;
                
                object.setBounds(vX, vY, vsizeX, vsizeY);
                
                if(Collision(object, frog)) {
                    System.out.println("COLLISION");
                }
            }
        }, 0, 175);
    }
    
    public static boolean Collision(JLabel test_a, JLabel test_b){
        Rectangle rectB = test_b.getBounds();

        Rectangle result = SwingUtilities.computeIntersection(test_a.getX(), test_a.getY(), test_a.getWidth(), test_a.getHeight(), rectB);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
}
