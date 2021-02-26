/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author 312679
 */
public class RandomGen {
    static Random rng = new Random();
    static ArrayList<Integer> al = new ArrayList();
    static int mode=0;
    static int modeFreq=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            al.add(randomWithBounds(0, 251));
        }
        Collections.sort(al);   
        mode = mode(al.stream().mapToInt(i -> i).toArray());
        ystem.out.println(String.format("The mode of the dataset is:\n" + "%d\n" + "\n" + "It occurred %d times.", mode, modeFreq));
    }
    
    /**
     * Calculates the mode of the data set contained in the input array using a HashMap
     * @param array A sorted list of random integers
     * @return The mode of the data contained in the input array
     */
    public static int mode(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq=0, temp=0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) != null) {
                // if map contains i, get the number of times it occurs. push into map
                int count = map.get(array[i]);
                count++;
                map.put(array[i], count);
                
                if (count > maxFreq) { // if this has the highest freq so far
                    maxFreq = count;
                    temp = array[i];
                }
            } else {
                // if map does not contain i yet
                map.put(array[i], 1);
            }
        }
        modeFreq = maxFreq;
        return temp;
    }
  
    /**
     * Utility function for generating random numbers with noninclusive upper and lower bounds
     * @param lowerBound The smallest possible output number will be one more than this argument.
     * @param upperBound The largest possible output number will be one less than this argument.
     * @return A pseudo-RNG integer larger than lowerBound but smaller than upperBound.
     */
    public static int randomWithBounds(int lowerBound, int upperBound) {
        return lowerBound + rng.nextInt(upperBound-lowerBound);
    }
    
}
