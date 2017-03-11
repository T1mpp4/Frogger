package frogger;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author timi
 */
public class Window extends JFrame {
    private double stepLen;
    
    public Window(double stepLen) {
        this.stepLen = stepLen;

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Frogger");
        this.setLayout(null);

        getContentPane().setBackground(Color.black);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - this.getSize().width)/2;
        int y = (dim.height - this.getSize().height)/2;

        this.setLocation(x, y);

        JLabel goal = new JLabel();
        goal.setText("|=========|");
        goal.setForeground(Color.WHITE);
        goal.setFont(new Font("Seif", Font.PLAIN, 20));
        add(goal);
        goal.setBounds(325, -10, 600, 50);

        setFocusable(true);
        requestFocusInWindow();

        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        int firstRoad = 5;
        int i = 0;
        int max = 10;
        
        Graphics2D g2 = (Graphics2D) g;

        super.paint(g);
        g2.setColor(Color.WHITE);
        g2.drawRect(5, 30, 75, 40);
        
        while(i < max) {
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));
            
            if(i % 2 == 0) {
                g.setColor(Color.WHITE);
                g.drawRect(3, firstRoad + 50 * i, 793, 50);
                //g.fillRect(3, firstRoad + 50 * i, 793, 50);
            } else {
                g2.setColor(Color.WHITE);
                g2.drawRect(3, firstRoad + 50 * i, 793, 50);
            }
            i++;
        }
        
        
        /*g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(3, firstRoad, 793, 50);
        
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(3, firstRoad + 50, 793, 50);
        
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(3, firstRoad + 100, 793, 50);*/
    }
}