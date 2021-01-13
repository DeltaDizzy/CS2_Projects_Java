/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltadizzy.javaintroduction;

import javax.swing.JOptionPane;

/**
 *
 * @author DeltaDizzy / EJ Braswell
 */
public class Main 
{
    public static void main(String[] args)
    {   
        String fname = "";
        int age;
        fname = JOptionPane.showInputDialog("What is your name?");
        age = Integer.parseInt(JOptionPane.showInputDialog("How old are you"));
        System.out.println(String.format("Hello %s, you look good for %d.", fname, age));
    }
}
