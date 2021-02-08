/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multishapes;

import TurtleGraphics.StandardPen;
import java.awt.Color;

/**
 *
 * @author EJ Braswell
 */
public class MultiShapes {

    /**
     * @param args the command line arguments
     */
    
    /*
    * 0 = east
    * 90 = north
    * 180 = west
    * 270 = south
    * positive = clockwise
    */
    public static void main(String[] args) 
    {
        int dis = 400;
        StandardPen pen = new StandardPen();
        BreezySwing.GBDialog.getWindows()[0].setBounds(100, 100, 1000, 1000);
        
        // square
        pen.home();
        pen.setColor(Color.BLACK);
        pen.up();
        pen.setDirection(0);
        pen.move(-200);
        pen.turn(-90);
        pen.move(200);
        pen.setDirection(0);
        pen.down();
        
        // box
        for(int i=0;i<4;i++){
        pen.move(dis);
        pen.turn(90);
        }
        pen.up();
        pen.setDirection(0);
        pen.home();
        
        // circle
        pen.setDirection(0);
        pen.move(199);
        pen.setDirection(90);
        pen.move(-6);
        pen.setColor(Color.BLACK);
        pen.down();
        for (int i = 0; i < 360; i++) {
            pen.move(1.6*7.8);
            pen.turn(3.6);
        }
        pen.up();
        pen.home();
        
        // octogon
        pen.setDirection(0);
        pen.move(150);
        pen.setDirection(90);
        pen.move(-60);
        pen.setColor(Color.BLACK);
        pen.down();
        for (int i = 0; i < 8; i++) {
            pen.move(125);
            pen.turn(45);
        }
        pen.home();
        
    }
    
}
