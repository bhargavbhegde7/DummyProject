package com.learn.java.mouse;
/*
 * Create By @author bhegde
 * Create On @date 8/8/2022
 *
 */

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

public class KeepAlive {
    public static void mouseWiggle() throws AWTException {
        Robot hal = new Robot();
        Random random = new Random();
        while(true){
            hal.delay(1000 * 60);
            int x = random.nextInt() % 640;
            int y = random.nextInt() % 480;
            hal.mouseMove(x,y);
        }
    }
}
