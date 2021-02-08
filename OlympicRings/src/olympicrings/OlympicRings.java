/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olympicrings;

/**
 *
 * @author DeltaDizzy
 */
import TurtleGraphics.StandardPen;
import java.awt.Color;

public class OlympicRings {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) 
    {
        
        
        int dis = 200;
        StandardPen pen = new StandardPen();
        BreezySwing.GBDialog.getWindows()[0].setBounds(100, 100, 1000, 1000);
        // red ring
        pen.setDirection(90);
        pen.setWidth(5);
        pen.setColor(Color.RED);
        for (int i = 0; i < 150; i++) {
            pen.move(1.6);
            pen.turn(3.6);
        }
        
        // prep for next ring
        pen.up();
        pen.turn(90);
        pen.move(52);
        pen.turn(-90);
        pen.down();
        
        // black ring
        pen.setColor(Color.BLACK);
        for (int i = 0; i < 100; i++) {
            pen.move(1.6);
            pen.turn(3.6);
        }
        
        // prep for next ring
        pen.up();
        pen.turn(90);
        pen.move(52);
        pen.turn(-90);
        pen.down();
        
        // blue ring
        pen.setColor(Color.BLUE);
        for (int i = 0; i < 100; i++) {
            pen.move(1.6);
            pen.turn(3.6);
        }
        
        // prep for next ring
        pen.up();
        pen.turn(-90);
        pen.down();
        
        // green ring
        pen.setColor(Color.GREEN);
        for (int i = 0; i < 150; i++) {
            pen.move(1.6);
            pen.turn(3.6);
        }
        
        // prep for next ring
        pen.up();
        pen.move(-50);
        pen.down();
        
        // yellow ring
        pen.setColor(Color.YELLOW);
        for (int i = 0; i < 150; i++) {
            pen.move(1.6);
            pen.turn(3.6);
        }
        
        // prep for box
        pen.home();
        pen.setColor(Color.BLACK);
        pen.up();
        pen.setDirection(0);
        pen.move(-70);
        pen.turn(-90);
        pen.move(100);
        pen.setDirection(0);
        pen.down();
        
        // box
        for(int i=0;i<4;i++){
        pen.move(dis);
        pen.turn(90);
        }
        pen.up();
        pen.setDirection(0);
        
    }
    
}
