/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author timi
 */
public class Road extends JComponent {
    public Road(Graphics g) {
        int height = 200;
        int width = 120;
        g.setColor(Color.red);
        g.drawRect(10,10,height,width);
        g.setColor(Color.gray);
        g.fillRect(11,11,height,width); 
        g.setColor(Color.red);
        g.drawOval(250,20, height,width);
        g.setColor(Color.magenta);
        g.fillOval(249,19,height,width);
    }
}
