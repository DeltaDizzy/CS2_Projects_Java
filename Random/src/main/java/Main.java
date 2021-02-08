import javax.swing.*;
import java.util.Random;

/**
 * @author EJ Braswell
 * */

public class Main
{
    public static void main(String[] args)
    {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int numCount = 0;
        int startNum = Integer.parseInt(JOptionPane.showInputDialog("Starting Number:"));

        int endNum = r.nextInt(startNum*20-startNum*5)+startNum*5;
        System.out.println(String.format("End Number Is: %d", endNum));

        // start - 50
        // end - 55-70

        //count up by ones
        for (int i=startNum; i<=endNum; i++)
        {
            //System.out.println(i);
            sb.append(String.format("%d, ", i));
            sum += i;
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Waited");
            }*/
        }
        sb.append("\n");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        // count down by twos
        for (int i=endNum; i>=startNum; i-=2)
        {
            //System.out.println(i);
            sb.append(String.format("%d, ", i));
            sum += i;
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Waited");
            }*/
        }
        double avg = sum / sb.length();
        System.out.println(sb.toString());
        System.out.println(String.format("Average: %s", avg));

    }
}
