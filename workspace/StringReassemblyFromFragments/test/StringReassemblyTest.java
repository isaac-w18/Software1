import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    @Test
    public void testCombination_Short2() {
        String s1 = "Mi";
        String s2 = "iami";
        int overlap = StringReassembly.overlap(s1, s2);
        String ans = StringReassembly.combination(s1, s2, overlap);
        String ansExpected = "Miami";

        assertEquals(ans, ansExpected);
    }

    @Test
    public void testCombination_Long1() {
        String s1 = "Four score, and seven years ago, our";
        String s2 = "years ago, our fathers brought forth";
        int overlap = StringReassembly.overlap(s1, s2);
        String ans = StringReassembly.combination(s1, s2, overlap);
        String ansExpected = "Four score, and seven years ago, our fathers brought forth";

        assertEquals(ans, ansExpected);
    }

    @Test
    public void testCombination_NoOverlap() {
        String s1 = "Software ";
        String s2 = "1";
        int overlap = StringReassembly.overlap(s1, s2);
        String ans = StringReassembly.combination(s1, s2, overlap);
        String ansExpected = "Software 1";

        assertEquals(ans, ansExpected);
    }

    @Test
    public void testCombination_Short1() {
        String s1 = "Hel";
        String s2 = "ello";
        int overlap = StringReassembly.overlap(s1, s2);
        String ans = StringReassembly.combination(s1, s2, overlap);
        String ansExpected = "Hello";

        assertEquals(ans, ansExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_AddingAString() {
        Set<String> s = new Set1L<>();
        s.add("Linear Algebra");
        String str = "Foundations 1: Discrete Structures";

        StringReassembly.addToSetAvoidingSubstrings(s, str);

        Set<String> sExpected = new Set1L<>();
        sExpected.add("Foundations 1: Discrete Structures");
        sExpected.add("Linear Algebra");

        assertEquals(s, sExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_Superstring2() {
        Set<String> s = new Set1L<>();
        s.add(" Disc");
        String str = "Foundations 1: Discrete Structures";

        StringReassembly.addToSetAvoidingSubstrings(s, str);

        Set<String> sExpected = new Set1L<>();
        sExpected.add("Foundations 1: Discrete Structures");

        assertEquals(s, sExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_Superstring1() {
        Set<String> s = new Set1L<>();
        s.add("Chinese 1102.51");
        s.add("Foundations");
        s.add("Calculus 3");
        String str = "Foundations 1: Discrete Structures";

        StringReassembly.addToSetAvoidingSubstrings(s, str);

        Set<String> sExpected = new Set1L<>();
        sExpected.add("Foundations 1: Discrete Structures");
        sExpected.add("Calculus 3");
        sExpected.add("Chinese 1102.51");

        assertEquals(s, sExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_EqualStrings() {
        Set<String> s = new Set1L<>();
        s.add("Hello");
        String str = "Hello";

        StringReassembly.addToSetAvoidingSubstrings(s, str);

        Set<String> sExpected = new Set1L<>();
        sExpected.add("Hello");

        assertEquals(s, sExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_Substring2() {
        Set<String> s = new Set1L<>();
        s.add("Hello");
        String str = "l";

        StringReassembly.addToSetAvoidingSubstrings(s, str);

        Set<String> sExpected = new Set1L<>();
        sExpected.add("Hello");

        assertEquals(s, sExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_Substring1() {
        Set<String> s = new Set1L<>();
        s.add("Software 1 is fun!");
        s.add("Calculus 3 is not.");
        String str = "Software 1";

        StringReassembly.addToSetAvoidingSubstrings(s, str);

        Set<String> sExpected = new Set1L<>();
        sExpected.add("Calculus 3 is not.");
        sExpected.add("Software 1 is fun!");

        assertEquals(s, sExpected);
    }

    @Test
    public void testAddToSetAvoidingSubstrings_EmptySet() {
        Set<String> s = new Set1L<>();
        String str = "Software 1";

        StringReassembly.addToSetAvoidingSubstrings(s, str);

        Set<String> sExpected = new Set1L<>();
        sExpected.add(str);

        assertEquals(s, sExpected);
    }

    @Test
    public void testLinesFromInput_NoNewLines() {
        Set<String> lines = new Set1L<>();
        SimpleWriter out = new SimpleWriter1L("testLines1.txt");
        out.print("HelloellolloMy");
        SimpleReader in = new SimpleReader1L("testLines1.txt");
        lines = StringReassembly.linesFromInput(in);

        Set<String> linesExpected = new Set1L<>();
        linesExpected.add("HelloellolloMy");

        assertEquals(lines, linesExpected);
    }

    @Test
    public void testLinesFromInput_SeveralRepeats() {
        Set<String> lines = new Set1L<>();
        SimpleWriter out = new SimpleWriter1L("testLines1.txt");
        out.print("Hello\nello\nllo\nMy");
        SimpleReader in = new SimpleReader1L("testLines1.txt");
        lines = StringReassembly.linesFromInput(in);

        Set<String> linesExpected = new Set1L<>();
        linesExpected.add("Hello");
        linesExpected.add("My");

        assertEquals(linesExpected, lines);
    }

    @Test
    public void testLinesFromInput_NoRepeats() {
        Set<String> lines = new Set1L<>();
        SimpleWriter out = new SimpleWriter1L("testLines1.txt");
        out.print("Hello\nMy\nName");
        SimpleReader in = new SimpleReader1L("testLines1.txt");
        lines = StringReassembly.linesFromInput(in);

        Set<String> linesExpected = new Set1L<>();
        linesExpected.add("Hello");
        linesExpected.add("My");
        linesExpected.add("Name");

        assertEquals(lines, linesExpected);
    }

    @Test
    public void testPrintWithLineSeparators_NoSquigglies() {
        String text = "Hello, my name is Isaac";
        SimpleWriter out = new SimpleWriter1L("testPrint1.txt");

        StringReassembly.printWithLineSeparators(text, out);
        SimpleReader in = new SimpleReader1L("testPrint1.txt");

        assertEquals(text, in.nextLine());

        in.close();
        out.close();
    }

    @Test
    public void testPrintWithLineSeparators_MiddleSquiggly() {
        String text = "Hello!~My name is Isaac.";
        SimpleWriter out = new SimpleWriter1L("testPrint1.txt");

        StringReassembly.printWithLineSeparators(text, out);
        SimpleReader in = new SimpleReader1L("testPrint1.txt");

        String l1 = "Hello!";
        String l2 = "My name is Isaac.";

        assertEquals(l1, in.nextLine());
        assertEquals(l2, in.nextLine());

        in.close();
        out.close();
    }

    @Test
    public void testPrintWithLineSeparators_BeginningSquiggly() {
        String text = "~Ni Hao";
        SimpleWriter out = new SimpleWriter1L("testPrint1.txt");

        StringReassembly.printWithLineSeparators(text, out);
        SimpleReader in = new SimpleReader1L("testPrint1.txt");

        String l1 = "";
        String l2 = "Ni Hao";

        assertEquals(l1, in.nextLine());
        assertEquals(l2, in.nextLine());

        in.close();
        out.close();
    }

    @Test
    public void testPrintWithLineSeparators_EndingSquiggly() {
        String text = "Hola~";
        SimpleWriter out = new SimpleWriter1L("testPrint1.txt");

        StringReassembly.printWithLineSeparators(text, out);
        SimpleReader in = new SimpleReader1L("testPrint1.txt");

        String l1 = "Hola";

        assertEquals(l1, in.nextLine());

        in.close();
        out.close();
    }

    @Test
    public void testPrintWithLineSeparators_SeveralSquigglies() {
        String text = "S~W~~1";
        SimpleWriter out = new SimpleWriter1L("testPrint1.txt");

        StringReassembly.printWithLineSeparators(text, out);
        SimpleReader in = new SimpleReader1L("testPrint1.txt");

        String l1 = "S";
        String l2 = "W";
        String l3 = "";
        String l4 = "1";

        assertEquals(l1, in.nextLine());
        assertEquals(l2, in.nextLine());
        assertEquals(l3, in.nextLine());
        assertEquals(l4, in.nextLine());

        in.close();
        out.close();
    }

}
