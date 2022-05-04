import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Put your name here
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_8957646889654_26() {
        NaturalNumber n = new NaturalNumber2("8957646889654");
        NaturalNumber nExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(26);
        NaturalNumber mExpected = new NaturalNumber2();
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_12_16() {
        NaturalNumber n = new NaturalNumber2(12);
        NaturalNumber nExpected = new NaturalNumber2(4);
        NaturalNumber m = new NaturalNumber2(16);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_72918209334() {
        NaturalNumber n = new NaturalNumber2("72918209334");
        NaturalNumber nExpected = new NaturalNumber2("72918209334");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_72918209331() {
        NaturalNumber n = new NaturalNumber2("72918209331");
        NaturalNumber nExpected = new NaturalNumber2("72918209331");
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_0_41_42() {
        NaturalNumber n = new NaturalNumber2();
        NaturalNumber nExpected = new NaturalNumber2();
        NaturalNumber p = new NaturalNumber2(20);
        NaturalNumber pExpected = new NaturalNumber2(20);
        NaturalNumber m = new NaturalNumber2(42);
        NaturalNumber mExpected = new NaturalNumber2(42);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_8_32_33() {
        NaturalNumber n = new NaturalNumber2(8);
        NaturalNumber nExpected = new NaturalNumber2(31);
        NaturalNumber p = new NaturalNumber2(32);
        NaturalNumber pExpected = new NaturalNumber2(32);
        NaturalNumber m = new NaturalNumber2(33);
        NaturalNumber mExpected = new NaturalNumber2(33);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_21_2_33() {
        NaturalNumber n = new NaturalNumber2(21);
        NaturalNumber nExpected = new NaturalNumber2(12);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber pExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(33);
        NaturalNumber mExpected = new NaturalNumber2(33);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    @Test
    public void testIsWitnessToCompositeness_2_4() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber wExpected = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(4);
        NaturalNumber nExpected = new NaturalNumber2(4);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
        assertEquals(nExpected, n);
        assertEquals(wExpected, w);
    }

    @Test
    public void testIsWitnessToCompositeness_5_19() {
        NaturalNumber w = new NaturalNumber2(5);
        NaturalNumber wExpected = new NaturalNumber2(5);
        NaturalNumber n = new NaturalNumber2(19);
        NaturalNumber nExpected = new NaturalNumber2(19);
        assertTrue(!CryptoUtilities.isWitnessToCompositeness(w, n));
        assertEquals(nExpected, n);
        assertEquals(wExpected, w);
    }

    @Test
    public void testIsWitnessToCompositeness_485_991() {
        NaturalNumber w = new NaturalNumber2(485);
        NaturalNumber wExpected = new NaturalNumber2(485);
        NaturalNumber n = new NaturalNumber2(991);
        NaturalNumber nExpected = new NaturalNumber2(991);
        assertTrue(!CryptoUtilities.isWitnessToCompositeness(w, n));
        assertEquals(nExpected, n);
        assertEquals(wExpected, w);
    }

    @Test
    public void testIsWitnessToCompositeness_917_1011() {
        NaturalNumber w = new NaturalNumber2(917);
        NaturalNumber wExpected = new NaturalNumber2(917);
        NaturalNumber n = new NaturalNumber2(1011);
        NaturalNumber nExpected = new NaturalNumber2(1011);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
        assertEquals(nExpected, n);
        assertEquals(wExpected, w);
    }

    @Test
    public void testIsWitnessToCompositeness_2_9000() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber wExpected = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(9000);
        NaturalNumber nExpected = new NaturalNumber2(9000);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
        assertEquals(nExpected, n);
        assertEquals(wExpected, w);
    }

    /*
     * Tests of isPrime2
     */
    @Test
    public void testIsPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(2);
        assertTrue(CryptoUtilities.isPrime2(n));
        assertEquals(nExpected, n);
    }

    @Test
    public void testIsPrime2_3() {
        NaturalNumber n = new NaturalNumber2(3);
        NaturalNumber nExpected = new NaturalNumber2(3);
        assertTrue(CryptoUtilities.isPrime2(n));
        assertEquals(nExpected, n);
    }

    @Test
    public void testIsPrime2_15() {
        NaturalNumber n = new NaturalNumber2(15);
        NaturalNumber nExpected = new NaturalNumber2(15);
        assertTrue(!CryptoUtilities.isPrime2(n));
        assertEquals(nExpected, n);
    }

    @Test
    public void testIsPrime2_1009() {
        NaturalNumber n = new NaturalNumber2(1009);
        NaturalNumber nExpected = new NaturalNumber2(1009);
        assertTrue(CryptoUtilities.isPrime2(n));
        assertEquals(nExpected, n);
    }

    @Test
    public void testIsPrime2_1013() {
        NaturalNumber n = new NaturalNumber2(1013);
        NaturalNumber nExpected = new NaturalNumber2(1013);
        assertTrue(CryptoUtilities.isPrime2(n));
        assertEquals(nExpected, n);
    }

    /*
     * Tests of generateNextLikelyPrime
     */
    @Test
    public void testGenerateNextLikelyPrime_1013() {
        NaturalNumber n = new NaturalNumber2(1013);
        NaturalNumber nExpected = new NaturalNumber2(1013);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyPrime_5004() {
        NaturalNumber n = new NaturalNumber2(5004);
        NaturalNumber nExpected = new NaturalNumber2(5009);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyPrime_6() {
        NaturalNumber n = new NaturalNumber2(6);
        NaturalNumber nExpected = new NaturalNumber2(7);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyPrime_19() {
        NaturalNumber n = new NaturalNumber2(19);
        NaturalNumber nExpected = new NaturalNumber2(19);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyPrime_100() {
        NaturalNumber n = new NaturalNumber2(100);
        NaturalNumber nExpected = new NaturalNumber2(101);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }
}
