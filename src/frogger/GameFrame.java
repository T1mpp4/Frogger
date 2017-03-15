/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
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
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Tux.png")));
        
        this.pack();

        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
}
