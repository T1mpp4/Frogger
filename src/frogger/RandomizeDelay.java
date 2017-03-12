/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.concurrent.Task;

/**
 *
 * @author timi
 */
public class RandomizeDelay extends TimerTask {
    static Timer timer = new Timer();
    
    public RandomizeDelay() {
        new RandomizeDelay().run();
    }
    
    @Override
    public void run() {
        int delay = Randomize(100, 3000);
        timer.schedule(new RandomizeDelay(), delay);
        System.out.println(new Date());
    }
    
    public int Randomize(int low, int high) {
        return (int) (Math.random() * (high - low)) + low;

    }
}
