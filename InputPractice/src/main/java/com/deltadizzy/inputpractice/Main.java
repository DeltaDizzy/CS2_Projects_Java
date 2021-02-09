/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltadizzy.inputpractice;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DeltaDizzy
 */
public class Main {
    
    static Random rng = new Random();
    static int distanceToEnd = 150;
    static int distanceToEnemy = 30;
    static int enemySpeed = 0;
    static int fuelMiles = 50;
    static Boolean playing = true;
    static Scanner scan = new Scanner(System.in);
    static String text = "";
    static int eventChance = 0;
    static String instructions = "\n\n\n\nWelcome to ESCAPE! You are a spy who has just stolen"
            + "top secret plans from The Enemy.\nThey have sent a band of agents"
            + " after you and you ened to make it to the other side of the Frozen"
            + " Desert to reach the Extraction Point and ESCAPE.\nAlong the way "
            + "there are various safehouses at which you can rest, resupply,"
            + " warm up, and refuel your vehicle.\nBe careful about any fellow travellers or settlements "
            + "you find, The Enemy has informers everywhere.";
    static String choices = "What will you do next?\nA. Wait here\nB. Drive Slowly\nC. Drive at maximum speed\nD. Status";
    public static void main(String[] args) {
        
        
        print(instructions);
        print("\nAre you ready to begin?\n[y/n]");
        text = scan.nextLine();
        if ("y".equals(text)) {
            playGame();
        }
        else {
            System.exit(0);
        }
        
    }
    
    private static void playGame() {
        /*
        * make choice
        * how far are they behind you
        * set enemy speed
        * make changes due to choice
        * roll events
        */
        while(playing == true) {
            print(String.format("Miles of Fuel Remaining: %d", fuelMiles));
            print(String.format("The Enemy Agents are %d miles behind you.", distanceToEnemy));
            print(String.format("You are %d miles from the extraction point.", distanceToEnd));
            if (distanceToEnd <= 0) {
                print("You reached the Extraction Point and escaped the Enemy with the secret plans! Good job, Agent.");
                System.exit(0);
            }
            
            if (distanceToEnemy<=0) {
                print("The enemy caught up with you! 'Say goodbye to those secret plans! (and your head ;) )'");
                System.exit(0);
            }
            
            if (fuelMiles <= 0) {
                print("You ran out of fuel! Here they come...");
                distanceToEnemy=0;
            }
            print(choices);
            text = scan.nextLine().toUpperCase();
            enemySpeed = randomWithBounds(0,15);
            // player choices
            switch(text) {
                case "A":
                    print("You decide to take a break.");
                    distanceToEnemy-=enemySpeed;
                    break;
                case "B":
                    distanceToEnd-=10;
                    distanceToEnemy-=(enemySpeed-10);
                    fuelMiles-=10;
                    break;
                case "C":
                    distanceToEnd-=20;
                    distanceToEnemy-=(enemySpeed-20);
                    fuelMiles-=20;
                    break;
                case "D":
                    print(String.format("Miles of Fuel Remaining: %d\n", fuelMiles));
                    print(String.format("The Enemy Agents are %d miles behind you.", distanceToEnemy));
                    print(String.format("You are %d miles from the extraction point.", distanceToEnd));
                    break;
                case "F":
                    fuelMiles+=20;
                default:
                    break;
            }
            
            
            
            // Events
            // safehouse = 15%
            // settlement - 10%
            eventChance = randomWithBounds(0,101);
            
            if (between(eventChance,69,91)) { // safehouse, 75-90
                print("You found a hidden safehouse! You refuel your snowmobile.");
                fuelMiles+=25;
                distanceToEnemy-=enemySpeed;
            } else if (between(eventChance,90,101)) { // settlement, 90-100
                print("You found a town! You can head into town and restock at the risk of being spotted by enemy informers or you can continue pushing on with what you have.");
                print("A. Go In\nB. Keep Moving");
                text = scan.nextLine().toUpperCase();
                switch(text) {
                    case "A":
                        eventChance=randomWithBounds(1,101);
                        if (between(eventChance, 74,101)) {
                            print("You got caught by an enemy spy! You can try to sneak out (A), hope the townspeople rescue you (B), or give up (C).");
                            text=scan.nextLine().toUpperCase();
                            switch(text) {
                                case "A":
                                    distanceToEnemy-=10;
                                    eventChance=randomWithBounds(1,101);
                                    if (between(eventChance, 0, 16)) {
                                        print("You escaped! But beware, the Agents are gaining fast.");
                                        distanceToEnemy-=15;
                                    } else {
                                        print("You failed to escape! You really should have studied more magic tricks.");
                                        distanceToEnemy=0;
                                    }
                                    break;
                                case "B":
                                    eventChance=randomWithBounds(1,101);
                                    if (between(eventChance, 16, 41)) {
                                        print("The townspeople helped you escape! They refuel your snowmobile and promise to delay the agents as much as possible while you get away.");
                                        fuelMiles+=35;
                                        distanceToEnemy+=20;
                                    } else {
                                        print("They never came to help!");
                                        distanceToEnemy=0;
                                    }
                                    break;
                                case "C":
                                    distanceToEnemy=0;
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            print("You made it out with extra fuel!");
                            fuelMiles+=30;
                        }
                        break;
                    case "B":
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    public static void print(String msg) {
        System.out.println(msg);
    }
    
    /**
     * 
     * @param lowerBound Inclusive minimum return value
     * @param upperBound Exclusive maximum return value;
     * @return 
     */
    public static int randomWithBounds(int lowerBound, int upperBound) {
        return rng.nextInt(upperBound-lowerBound)+lowerBound;
    }
    
    /**
     * 
     * @param value The field to check the value of
     * @param first The value that `value` must be greater than
     * @param second The value that `value` must be less than
     * @return Whether `value` is between `first` and `second` 
     */
    public static boolean between(int value, int first, int second) {
        return value > first && value < second;
    }
}
