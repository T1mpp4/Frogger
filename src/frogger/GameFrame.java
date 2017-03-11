/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author timi
 */
public class GameFrame extends JFrame{
    private double stepLen;
    
    public GameFrame() {
        this.stepLen = 50;

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Frogger");
        // Well, there's your problem...
        //this.setLayout(null);
        // Don't do this here...
        this.setVisible(true);

        this.getContentPane().setBackground(Color.black);

        // Simpler way to achieve this
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //int x = (dim.width - this.getSize().width) / 2;
        //int y = (dim.height - this.getSize().height) / 2;

        //GameCanvas gcanvas = new GameCanvas();
        //this.add(gcanvas);
        this.pack();

        //this.setLocation(x, y);

        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
}
