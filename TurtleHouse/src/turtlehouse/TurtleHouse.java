/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlehouse;

import TurtleGraphics.StandardPen;
import java.awt.Color;

/**
 *
 * @author DeltaDizzy
 */
public class TurtleHouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StandardPen pen = new StandardPen();
        BreezySwing.GBDialog.getWindows()[0].setBounds(1100,100,800,800);
        int dis = 100;
        
        // square
        pen.setColor(Color.RED);
        for (int d = 100; d>0; d--) {
            for (int i = 0; i < 3; i++) {
                pen.move(d);
                pen.turn(90);
            }
            pen.move(d-1);
            pen.turn(90);
        }
        
        // move to door start
        pen.up();
        pen.setDirection(90);
        pen.move(0);
        pen.setDirection(0);
        pen.move(40);
        pen.down();
        // door pt 1
        pen.setColor(Color.BLUE);
        for (int d = 30; d > 0; d--) {
            for (int i = 0; i < 3; i++) {
                pen.move(d);
                pen.turn(90);
            }
            pen.move(d-1);
            pen.turn(90);
            
        }
        
        // door pt 2
        for (int d = 30; d > 0; d--) {
            for (int i = 0; i < 3; i++) {
                pen.move(d);
                pen.turn(90);
            }
            pen.move(d-1);
            pen.turn(90);
            
        }
        
        // move to roof
        pen.up();
        pen.setDirection(90);
        pen.move(40);
        pen.setDirection(0);
        pen.move(60);
        pen.down();
        
        // roof
        pen.setColor(Color.PINK);
        pen.turn(180);
        for (int d = 100; d > 0; d--) {
            for (int i = 0; i < 2; i++) {
                pen.move(d);
                pen.turn(-120);
            }
            //pen.move(d-1);
            //pen.turn(60);
            
        }
        
        // move to left window
        pen.up();
        pen.setDirection(90);
        pen.move(-100);
        pen.setDirection(0);
        pen.move(-45);
        pen.down();
        
        // left window
        pen.setColor(Color.CYAN);
        for (int d = 30; d>0; d--) {
            for (int i = 0; i < 3; i++) {
                pen.move(d);
                pen.turn(90);
            }
            pen.move(d-1);
            pen.turn(90);
        }
        
        // move to right window
        pen.up();
        pen.setDirection(90);
        pen.move(-27);
        pen.setDirection(0);
        pen.move(68);
        pen.down();
        
        // right window
        pen.setColor(Color.CYAN);
        for (int d = 25; d>0; d--) {
            for (int i = 0; i < 3; i++) {
                pen.move(d);
                pen.turn(90);
            }
            pen.move(d-1);
            pen.turn(90);
        }
        
        // move to ground
        pen.up();
        pen.setDirection(90);
        pen.move(-27);
        pen.setDirection(0);
        pen.move(68);
        pen.down();
        
        // ground
        pen.setColor(Color.GREEN);
        for (int d = 25; d>0; d--) {
            for (int i = 0; i < 3; i++) {
                pen.move(d);
                pen.turn(90);
            }
            pen.move(d-1);
            pen.turn(90);
        }
    }
    
}
