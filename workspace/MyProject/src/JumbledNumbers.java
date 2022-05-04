
/**
 *
 * @author Isaac Frank
 *
 */
public final class JumbledNumbers {

    private JumbledNumbers() {
    }

    public static void main(String[] args) {
        orderNums("nineninenine");
    }

    public static void orderNums(String nums) {
        String[] digits = { "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine" };
        int[] amounts = new int[10];

        for (int i = 0; i < digits.length; i++) {
            amounts[i] = numOccurences(nums, digits[i]);
        }

        String orderedNums = "";
        for (int i = 0; i < digits.length && amounts[i] != 0; i++) {
            int j = amounts[i];
            while (j > 0) {
                orderedNums += digits[i];
                j--;
            }
        }
        System.out.println(orderedNums);
    }

    public static int numOccurences(String nums, String numToFind) {
        int occurences = 0;

        while (nums.contains(numToFind.substring(0, 1))) {
            boolean containsNumToFind = true;
            for (int i = 0; i < numToFind.length() && containsNumToFind; i++) {
                containsNumToFind = nums
                        .contains(numToFind.substring(i, i + 1));
                if (containsNumToFind) {
                    int index = nums.indexOf(numToFind.substring(i, i + 1));
                    if (index < nums.length()) {
                        nums = nums.substring(0, index)
                                + nums.substring(index + 1, nums.length());
                    } else {
                        nums = nums.substring(0, index);
                    }

                }
            }
            if (containsNumToFind) {
                occurences++;
            }
        }
        return occurences;
    }

}

/*
 * int areaBound = 20; int sum = 0; for (int n = 0; (n * n) < areaBound; n++) {
 * for (int m = 0; (m * m) < areaBound; m++) { sum += (n * n) + (m * m); } }
 */

/*
 * SimpleReader in = new SimpleReader1L(); SimpleWriter out = new
 * SimpleWriter1L();
 *
 * out.print("Enter the number of terms: "); int n = in.nextInteger(); int i =
 * 0;
 *
 * double estimate = 0.0;
 *
 * while (i < n) { estimate += Math.pow(-1, i) / (2 * i + 1); i++; }
 *
 * final double four = 4.0; estimate = estimate * four;
 *
 * out.print("Estimate of Pi: " + estimate);
 *
 * in.close(); out.close();
 */
