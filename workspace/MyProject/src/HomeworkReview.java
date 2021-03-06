import java.util.Comparator;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.naturalnumber.NaturalNumberKernel;
import components.queue.Queue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;

/**
 * Put a short phrase describing the program here.
 *
 * @author Isaac Frank
 *
 */
public final class HomeworkReview {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HomeworkReview() {
    }

    /**
     * Tests if x, y, and z are all equal to each other.
     *
     * @param x
     *            any integer
     *
     * @param y
     *            any integer
     *
     * @param z
     *            any integer
     *
     * @return true if x, y, z are equal and false otherwise
     */
    private static boolean allTheSame(int x, int y, int z) {
        return x == y && y == z;
    }

    /**
     * Tests if x, y, and z are all different each other.
     *
     * @param x
     *            any integer
     *
     * @param y
     *            any integer
     *
     * @param z
     *            any integer
     *
     * @return true if x, y, z have no equalities and false otherwise
     */
    private static boolean allDifferent(int x, int y, int z) {
        return x != y && y != z && x != z;
    }

    /**
     * Tests if x, y, and z are all sorted in ascending order.
     *
     * @param x
     *            any integer
     *
     * @param y
     *            any integer
     *
     * @param z
     *            any integer
     *
     * @return true if x, y, z are in ascending order and false otherwise
     */
    private static boolean sorted(int x, int y, int z) {
        return x <= y && y <= z;
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {
        NaturalNumber tmp = new NaturalNumber2(n2);
        n1.transferFrom(n2);
        n2.transferFrom(tmp);
    }

    /**
     * Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        n.multiply(new NaturalNumber2(n));
    }

    /**
     * Reverses a String.
     *
     * @ensures <pre>
     * {@code reversedString = rev(s)}
     * </pre>
     * @param s
     * @return rev(s)
     */
    private static String reversedString(String s) {
        if (s.length() > 0) {
            return reversedString(s.substring(1)) + s.charAt(0);
        }
        return s;
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        NaturalNumber i = new NaturalNumber2(n);
        int digits = 0;
        if (!i.isZero()) {
            i.divideBy10();
            digits = numberOfDigits(i) + 1;
        }
        return digits;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        NaturalNumber i = new NaturalNumber2(n);
        int sum = i.divideBy10();
        if (!i.isZero()) {
            sum += sumOfDigits(i);
        }
        return sum;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber naturalSumOfDigits(NaturalNumber n) {
        NaturalNumber i = new NaturalNumber2(n);
        NaturalNumber sum = new NaturalNumber2(i.divideBy10());
        if (!i.isZero()) {
            sum.add(naturalSumOfDigits(i));
        }
        return sum;
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    public static void divideBy2(NaturalNumber n) {
        int ones = n.divideBy10();
        if (!n.isZero()) {
            int tens = n.divideBy10();
            if (tens % 2 != 0) {
                ones += NaturalNumberKernel.RADIX;
            }
            n.multiplyBy10(tens);
            divideBy2(n);
        }

        ones /= 2;
        n.multiplyBy10(ones);

    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        boolean palindrome = true;
        if (s.length() > 1) {
            palindrome = s.charAt(0) == (s.charAt(s.length() - 1));
            String temp = s.substring(1, s.length() - 1);
            if (palindrome) {
                palindrome = isPalindrome(temp);
            }
        }
        return palindrome;
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {

        NaturalNumber ans = new NaturalNumber2(1);
        while (!n.isZero()) {
            NaturalNumber digit = new NaturalNumber2(n.divideBy10());
            ans.multiply(digit);
        }
        return ans;
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {

        int digit = n.divideBy10();
        NaturalNumber product = new NaturalNumber2(digit);
        if (!n.isZero()) {
            product.multiply(productOfDigits2(n));
        }
        n.multiplyBy10(digit);
        return product;
    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {

        int lastDigit = n.divideBy10();
        int other = 0;
        if (!n.isZero()) {
            other = toInt(n) * NaturalNumberKernel.RADIX;
        }
        n.multiplyBy10(lastDigit);
        return other + lastDigit;
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}. ??*
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree},
     *         ??*???????????????? false otherwise ??* @ensures <pre>
     * findTag =
     *?????? [true if the given tag appears in the given {@code XMLTree}, false otherwise]
     * </pre> ??
     */
    private static boolean findTag(XMLTree xml, String tag) {

        boolean found = false;
        if (xml.isTag()) {
            if (xml.label().equals(tag)) {
                found = true;
            }
            int i = 0;
            while (!found && i < xml.numberOfChildren()) {
                found = findTag(xml.child(i), tag);
                i++;
            }
        }
        return found;
    }

    /**
     * Returns number of occurences of a digit in a NaturalNumber.
     *
     * @param n
     *
     * @param d
     *
     * @return num occurences
     *
     * @requires 0 <= d < 9
     *
     */
    public static int digitCount(NaturalNumber n, int d) {
        int last = n.divideBy10();
        int count = 0;
        if (last == d) {
            count++;
        }
        if (!n.isZero()) {
            count += digitCount(n, d);
        }
        n.multiplyBy10(last);
        return count;
    }

    /**
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        char a = s[0];
        if (s.length > 1) {
            char[] shorter = new char[s.length - 1];
            for (int i = 0; i < s.length - 1; i++) {
                shorter[i] = s[i + 1];
            }
            reverseString(shorter);
            for (int i = 0; i < s.length - 1; i++) {
                s[i] = shorter[i];
            }
        }
        s[s.length - 1] = a;
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @param <T>
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public static <T> void flip2(Queue<T> q) {
        if (q.length() > 0) {
            T x = q.dequeue();
            flip2(q);
            q.enqueue(x);
        }
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * perms(q * <removeMin>, #q)  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {

        int index = 0;
        String min = q.dequeue();
        q.enqueue(min);
        ;
        for (int i = 1; i < q.length(); i++) {
            String test = q.dequeue();
            if (order.compare(min, test) < 0) {
                min = test;
                index = i;
            }
            q.enqueue(test);
        }

        q.rotate(index + 1);

        return q.dequeue();
    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [#q ordered by the relation computed by order.compare]
     */
    public static void sort(Queue<String> q, Comparator<String> order) {

        Queue<String> temp = q.newInstance();
        while (q.length() > 0) {
            temp.enqueue(removeMin(q, order));
        }
        q.transferFrom(temp);
    }

    public static void subtract(NaturalNumber ths, NaturalNumber n) {
        int last1 = ths.divideBy10();
        int last2 = n.divideBy10();
        int dif = last1 - last2;
        if (dif < 0) {
            ths.decrement();
            dif += 10;
        }
        if (!n.isZero()) {
            subtract(ths, n);
        }
        ths.multiplyBy10(dif);
        n.multiplyBy10(last2);
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
         * Queue<String> test = new Queue2<>(); test.enqueue("1");
         * test.enqueue("2"); test.enqueue("3"); test.enqueue("4"); for (int i =
         * 0; i < test.length(); i++) { String x = test.dequeue();
         * out.println(x); test.enqueue(x); }
         *
         * flip2(test);
         *
         * for (int i = 0; i < test.length(); i++) { String x = test.dequeue();
         * out.println(x); test.enqueue(x); }
         */
        in.close();
        out.close();

    }

}
