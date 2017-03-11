/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author timi
 */
public class GameCanvas extends JPanel {
    public GameCanvas() {
        // Pointless
        //setDoubleBuffered(true);
        JLabel goal = new JLabel();
        goal.setText("|=========|");
        goal.setForeground(Color.WHITE);
        goal.setFont(new Font("Seif", Font.PLAIN, 20));
        this.add(goal);
        
        this.setBackground(Color.black);
        
        this.setLayout(null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    public void paintComponent(Graphics g) {

        int firstRoad = 5;
        int i = 0;
        int max = 10;

        Graphics2D g2 = (Graphics2D) g;

        super.paintComponent(g2);
        g2.setColor(Color.WHITE);
        g2.drawRect(5, 5, 75, 40);

        while (i < max) {
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));

            if (i % 2 == 0) {
                g.setColor(Color.WHITE);
                g.drawRect(3, firstRoad + 50 * i, 793, 50);
                //g.fillRect(3, firstRoad + 50 * i, 793, 50);
            } else {
                g2.setColor(Color.WHITE);
                g2.drawRect(3, firstRoad + 50 * i, 793, 50);
            }
            i++;
        }
    }
}
