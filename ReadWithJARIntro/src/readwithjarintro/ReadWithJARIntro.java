/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwithjarintro;

import TerminalIO.KeyboardReader;
import java.util.Random;


/**
 *
 * @author EJ Braswell
 */
public class ReadWithJARIntro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        KeyboardReader reader = new KeyboardReader();
        Random rnd = new Random();
        
        int startNum, endNum;
        double count = 0, total = 0;
        String nums = "";
        
        startNum = reader.readInt("Starting Number: ");
        endNum = rnd.nextInt(16)+5+startNum;
        
        for (int i = startNum; i <=endNum; i++) {
            count++;
            total+=i;
            nums+=i+", ";
        }
        
        nums+="\n";
        
        for (int i = endNum; i >= startNum; i-=2) {
            count++;
            total+=i;
            nums+=i+", ";
        }
        
        double aver = total/count;
        
        System.out.println(nums);
        System.out.println(aver);
    }
    
}
