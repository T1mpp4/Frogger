/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author timi
 */
public class Pos {
    private static int x;
    private static int level;
    
    public Pos() {
        
    }
    
    public static void setPosition(int gotX, int gotL) {
        x = gotX;
        level = gotL;
    }
    
    public static int[] getPosition() {
        int[] positionxy = {x, level};
        return positionxy;
    }
    
    public static boolean Collision(JLabel test_a, JLabel test_b){
        Rectangle rectB = test_b.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(test_a.getX(), test_a.getY(), test_a.getWidth(), test_a.getHeight(), rectB);
        
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
}
