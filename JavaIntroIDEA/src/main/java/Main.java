import javax.swing.*;

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
