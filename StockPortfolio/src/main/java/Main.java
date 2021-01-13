import javax.swing.*;
import java.awt.*;

public class Main
{
    /**
    * @author EJ Braswell
    **/
    public static void main(String[] args)
    {
        String stockName = "";
        int numShares = 0;
        // Discount = 5% on buys over 50k
        double stockPrice = 0.0, totalCost = 0.0, discount = 0.0, finalCost = 0.0;
        stockName = JOptionPane.showInputDialog("Stock Name: ");
        numShares = Integer.parseInt(JOptionPane.showInputDialog("Number of Shares to Buy: "));
        stockPrice = Double.parseDouble(JOptionPane.showInputDialog("Stock Price: "));

        // calculation
        totalCost = numShares * stockPrice;

        if (totalCost > 50000)
        {
            discount = 0.05*totalCost;
        }

        finalCost = totalCost - discount;

        System.out.println(String.format("You just bought %d shares of %s at %f per share for a final cost of $%f.", numShares, stockName, stockPrice, finalCost));
    }
}
