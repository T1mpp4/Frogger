/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        /*URL url;
        try {
            url = new URL("com/timi/resources/Tux.png");
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image img = kit.createImage(url);
            this.setIconImage(img);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        this.pack();

        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
}
