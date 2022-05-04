import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Extension of {@code NaturalNumber2} with secondary operations implemented as
 * instance methods: add, subtract, and power.
 *
 * @author Put your name here
 *
 */
public final class NaturalNumberInstanceOps extends NaturalNumber2 {

    /**
     * No-argument constructor.
     */
    public NaturalNumberInstanceOps() {
    }

    /**
     * Constructor from {@code int}.
     *
     * @param i
     *            {@code int} to initialize from
     */
    public NaturalNumberInstanceOps(int i) {
        super(i);
    }

    /**
     * Constructor from {@code String}.
     *
     * @param s
     *            {@code String} to initialize from
     */
    public NaturalNumberInstanceOps(String s) {
        super(s);
    }

    /**
     * Constructor from {@code NaturalNumber}.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     */
    public NaturalNumberInstanceOps(NaturalNumber n) {
        super(n);
    }

    @Override
    public void add(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        /**
         * @decreases n
         */
        int thisLowDigit = this.divideBy10();
        int nLowDigit = n.divideBy10();
        if (!n.isZero()) {
            this.add(n);
        }
        thisLowDigit += nLowDigit;
        if (thisLowDigit >= RADIX) {
            thisLowDigit -= RADIX;
            this.increment();
        }
        this.multiplyBy10(thisLowDigit);
        n.multiplyBy10(nLowDigit);
    }

    @Override
    public void subtract(NaturalNumber n) {
        assert n != null : "Violation of: n is not null";
        assert this.compareTo(n) >= 0 : "Violation of: this >= n";

        NaturalNumber zero = new NaturalNumber2(0);
        if (n.compareTo(zero) > 0) {
            int thisOnes = this.divideBy10();
            int nOnes = n.divideBy10();

            // subtract
            int onesDifference = thisOnes - nOnes;
            if (onesDifference < 0) {
                // recursive call
                this.decrement();
                thisOnes = RADIX;
                while (onesDifference < 0) {
                    thisOnes--;
                    onesDifference++;
                }
            } else {
                thisOnes -= nOnes;
            }
            this.subtract(n);
            this.multiplyBy10(thisOnes);

            n.multiplyBy10(nOnes);
        }

    }

    @Override
    public void power(int p) {
        assert p >= 0 : "Violation of: p >= 0";

        NaturalNumber copy = new NaturalNumber2(this);
        NaturalNumber original = new NaturalNumber2(this);

        // recursive call if p > 1
        if (p > 1) {
            copy.power(p / 2);
            this.power(p / 2);
            this.multiply(copy);
            if (p % 2 != 0) {
                this.multiply(original);
            }
        }

    }

}