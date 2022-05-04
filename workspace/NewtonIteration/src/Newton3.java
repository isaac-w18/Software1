import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Isaac Frank
 *
 */
public final class Newton3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton3() {
    }

    /**
     * Returns the approximate square root of x.
     *
     * @param x
     *            the input to calculate the square root of
     *
     * @param relError
     *            the input for the relative error allowed
     *
     * @return r, the approximate square root of x.
     */
    private static double sqrt(double x, double relError) {
        // Allows method to work for user input 0.0
        if (x == 0.0) {
            return 0.0;
        }
        double r = x;
        double error = Math.abs(r * r - x) / x;
        // r becomes the average of r and r/x until the error is within range
        while (error >= (relError * relError)) {
            r = (r + x / r) / 2;
            error = Math.abs(r * r - x) / x;
        }
        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        // Opening input and output
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        out.print("Input relative error: ");
        double relError = in.nextDouble();

        String ans = "y";

        // Loop to allow user to repeatedly calculate roots
        while (ans.equals("y")) {
            out.print(
                    "Do you wish to calculate another square root? (enter 'y'): ");
            ans = in.nextLine();
            // Checking user input if 'y', then calling method with input x
            if (ans.equals("y")) {
                out.print("Enter a double: ");
                double x = in.nextDouble();
                out.println("Approximate sqrt " + sqrt(x, relError));
            }
        }

        // Closing input and output streams
        in.close();
        out.close();
    }

}
