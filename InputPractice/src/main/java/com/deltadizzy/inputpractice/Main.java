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

    
    public enum Choices {
        DRINK,
        WARM_UP,
        WALK,
        RUN,
        STATUS,
        WAIT
    }
    static Random rng = new Random();
    static int distanceToEnd = 200;
    static int distanceToEnemy = 15;
    static int enemySpeed = 0;
    static int drinks = 6;
    static int fuelMiles = 25;
    static Boolean playing = true;
    static Scanner scan = new Scanner(System.in);
    static String text = "";
    static int eventChance = 0;
    static String instructions = "Welcome to ESCAPE! You are a spy who has just stolen"
            + "top secret plans from The Enemy.\nThey have sent a band of agents"
            + " after you and you ened to make it to the other side of the Frozen"
            + " Desert to reach the Extraction Point and ESCAPE.\nAlong the way "
            + "there are various safehouses at which you can rest, resupply,"
            + " warm up, and refuel your vehicle.\nBe careful about any fellow travellers or settlements "
            + "you find, The Enemy has informers everywhere.";
    static String choices = "What will you do next?\nA. Drink\nB. Wait here\nC. Drive Slowly\nD. Drive at maximum speed\nE. Status";
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
            print(choices);
            text = scan.nextLine().toUpperCase();
            enemySpeed = randomWithBounds(0,15);
            // player choices
            switch(text) {
                case "A":
                    drinks--;
                    break;
                case "B":
                    print("You decide to take a break.");
                    distanceToEnemy-=enemySpeed;
                    break;
                case "C":
                    distanceToEnd-=14;
                    distanceToEnemy-=(enemySpeed-14);
                    fuelMiles-=14;
                    break;
                case "D":
                    distanceToEnd-=20;
                    distanceToEnemy-=(enemySpeed-20);
                    fuelMiles-=20;
                    break;
                case "E":
                    print(String.format("Drinks Remaining: %d\n", drinks));
                    print(String.format("Miles of Fuel Remaining: %d\n", fuelMiles));
                    print(String.format("The Enemy Agents are %d miles behind you.", distanceToEnemy));
                    print(String.format("You are %d miles from the extraction point.", distanceToEnd));
                    break;
                default:
                    break;
            }
            
            if (distanceToEnd <= 0) {
                print("You reached the Extraction Point and escaped the Enemy with the secret plans! Good job, Agent.");
            }
            
            // Events
            // safehouse = 15%
            // settlement - 10%
            eventChance = randomWithBounds(0,101);
            
            if (between(eventChance,75,91)) { // safehouse, 75-90
                print("You found a hidden safehouse! You refill your water supplies and refuel your snowmobile.");
                drinks=6;
                fuelMiles=25;
                distanceToEnemy-=enemySpeed;
            } else if (between(eventChance,90,101)) { // settlement, 90-100
                print("You found a town! You can head into town and restock at the risk of being spotted by enemy informers or you can continue pushing on with what you have.");
                print("A. Go In\nB. Keep Moving");
                text = scan.nextLine().toUpperCase();
                switch(text) {
                    case "A":
                        eventChance=randomWithBounds(1,101);
                        if (between(eventChance, )) {
                            
                        }
                        break;
                    case "B":
                        break;
                    default:
                        break;
                }
            }
            
            
            print(String.format("The Enemy' agents are %d miles behind you.", distanceToEnemy));
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
    
    public static boolean between(int value, int first, int second) {
        return value > first && value < second;
    }
}
