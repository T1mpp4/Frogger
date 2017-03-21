package frogger;

import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author timi
 */
public class Frogger extends JFrame {

    public static void main(String[] args) throws IOException {
        //GameFrame Frame = new GameFrame();
        if(args.length > 0 && args[0].equals("p")) {
            Engine GameEngine = new Engine("p");
        } else {
            Engine GameEngine = new Engine("c");
        }
    }
    
    
}
