package frogger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author timi
 */
public class Window extends JFrame {
    
    public Window() {
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
}
