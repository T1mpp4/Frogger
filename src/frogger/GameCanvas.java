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
    public static JLabel wins;
    public static JLabel deaths;
    
    public GameCanvas() {
        this.setBackground(Color.black);
        this.setLayout(null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    public void paintComponent(Graphics g) {

        int firstRoad = 3;
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
                Color waterColor = new Color(64, 164, 223, 100);
                g.setColor(waterColor);
                g.fillRect(3, firstRoad + 50 * i, 793, 50);
            } else {
                Color groundColor = new Color(113,148,68, 100);
                g2.setColor(groundColor);
                g2.fillRect(3, firstRoad + 50 * i, 793, 50);
            }
            i++;
        }
    }
    
    public void createGUI(JPanel gCanvas) {
        this.deaths = new JLabel();
        this.deaths.setText("Deaths: " + Engine.deathsq);
        this.deaths.setForeground(Color.WHITE);
        this.deaths.setFont(new Font("Seif", Font.PLAIN, 12));
        gCanvas.add(this.deaths);
        this.deaths.setBounds(10, 10, 100, 12);
        
        this.wins = new JLabel();
        this.wins.setText("Wins: " + Engine.winsq);
        this.wins.setForeground(Color.WHITE);
        this.wins.setFont(new Font("Seif", Font.PLAIN, 12));
        gCanvas.add(this.wins);
        this.wins.setBounds(10, 27, 100, 12);
        
        JLabel goal = new JLabel();
        goal.setText("| G O A L |");
        goal.setForeground(Color.WHITE);
        goal.setFont(new Font("Seif", Font.PLAIN, 20));
        goal.setBounds(360, 2, 600, 50);
        gCanvas.add(goal);
        
        gCanvas.validate();
        gCanvas.repaint();
    }
}
