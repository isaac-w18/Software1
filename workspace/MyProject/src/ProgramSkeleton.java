/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramSkeleton {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramSkeleton() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        System.out.print(numberOfPointsInCircle(2000));
    }

    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        if (xCoord > 0 && xCoord < 2 && yCoord > 0 && yCoord < 2) {
            return Math.sqrt(
                    Math.pow(xCoord - 1, 2.0) + Math.pow(yCoord - 1, 2.0)) < 1;
        }
        return false;
    }

    /**
     * Generates n pseudo-random points in the [0.0,2.0) x [0.0,2.0) square and
     * returns the number that fall in the circle of radius 1.0 centered at the
     * point (1.0, 1.0).
     *
     * @param n
     *            the number of points to generate
     * @return the number of points that fall in the circle
     */
    private static int numberOfPointsInCircle(int n) {

        int count = 0;

        for (int i = 0; i < n; i++) {
            double x = 2 * Math.random();
            double y = 2 * Math.random();
            if (pointIsInCircle(x, y)) {
                count++;
            }
        }
        return count;
    }
}
