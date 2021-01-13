import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main
{
    /**
     *  @author EJ Braswell
     **/
    public static void main(String[] args)
    {
        double payRate = 0.0;
        int hoursWorked = 0;
        double grossPay = 0.0;
        double fedTaxRate = 0.0;
        double fedDeduction = 0.0;
        double stateDeduction = 0.0;
        final double stateTaxRate = 0.323; // this is the only number i could find for indiana state income tax
        double netPay = 0.0;

        // data input
        payRate = Double.parseDouble(JOptionPane.showInputDialog("What is your hourly pay rate?"));
        hoursWorked = Integer.parseInt(JOptionPane.showInputDialog("How many hours do you work per week?"));

        // math
        grossPay = payRate * hoursWorked;

        if (grossPay > 500)
        {
            fedTaxRate = 0.20;
        }
        else
        {
            fedTaxRate = 0.15;
        }

        fedDeduction = grossPay*fedTaxRate;
        stateDeduction = grossPay*stateTaxRate;

        netPay = grossPay - fedDeduction - stateDeduction;

        String output = String.format("Income Summary:\nHourly Rate: $%f\nHours/Week: %d\nGross Salary: $%f\nFederal Income Tax: $%f\nState Income Tax: $%f\nNet Income: $%f\n", payRate, hoursWorked, grossPay, fedDeduction, stateDeduction, netPay);

        System.out.println(output);
        /**
         * %s = string
         * %d = decimal int
         * %f = floating point
         * %t = date/time
         */
    }
}
