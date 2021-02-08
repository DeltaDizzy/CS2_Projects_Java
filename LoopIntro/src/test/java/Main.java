import javax.swing.*;

public class Main
{
    /**
     * @author EJ Braswell
     */
    public static void main(String[] args)
    {
        // add 3 bowling scores to calculate series sum and avg
        int g = 1; // num games
        int series = 0; // total score
        double avg = 0.0;
        for (int i=0;i<3;i++)
        {
            series += Integer.parseInt(JOptionPane.showInputDialog(String.format("Game %d:", g)));
            g++;
        }

        avg = series/g;

        // output
        JOptionPane.showMessageDialog(null, String.format("Series Score:%d\nAverage Score: %f", series, avg));
    }
}
