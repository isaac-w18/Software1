import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIO() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here
         */

        int[] array = { 1, 2, 3, 3, 4, 5, 5, 6, 3, 3, 6, 1, 6, 1, 6, 7, 7, 7,
                8 };
        int a = array[0];
        int b = array[1];
        int duplicate = -1;
        for (int i = 1; i < array.length - 1; i++) {
            if (a == b && a != duplicate) {
                duplicate = a;
                out.print(duplicate);
            }
            duplicate = a;
            a = array[i];
            b = array[i + 1];
        }

        /*
         *
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
