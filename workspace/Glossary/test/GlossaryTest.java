import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class GlossaryTest {

    // Testing generateTerm
    @Test
    public void testGenerateTerm_Hello() {
        String input = "hello a common greeting";
        String term = Glossary.generateTerm(input, "output");
        String termExp = "hello";
        assertEquals(term, termExp);
    }

    @Test
    public void testGenerateTerm_I() {
        String input = "I a name that one calls oneself";
        String term = Glossary.generateTerm(input, "output");
        String termExp = "I";
        assertEquals(term, termExp);
    }

    @Test
    public void testGenerateTerm_Antiestablishmentarian() {
        String input = "Antiestablishmentarian a person who is opposed to the establishment";
        String term = Glossary.generateTerm(input, "output");
        String termExp = "Antiestablishmentarian";
        assertEquals(term, termExp);
    }

    // Testing sortAToZ
    @Test
    public void testSortAToZ_0() {
        String[] arr = new String[0];
        String[] arrExp = new String[0];
        Glossary.sortAToZ(arr);

        assertTrue(Arrays.equals(arr, arrExp));
    }

    @Test
    public void testSortAToZ_1() {
        String[] arr = { "hello" };
        String[] arrExp = { "hello" };
        Glossary.sortAToZ(arr);

        assertTrue(Arrays.equals(arr, arrExp));
    }

    @Test
    public void testSortAToZ_4() {
        String[] arr = { "hello", "ello", "hillo", "o" };
        String[] arrExp = { "ello", "hello", "hillo", "o" };
        Glossary.sortAToZ(arr);

        assertTrue(Arrays.equals(arr, arrExp));
    }

    @Test
    public void testSortAToZ_4WithSpaces() {
        String[] arr = { "My name is Isaac", "My name is Joe", "My ", "Z" };
        String[] arrExp = { "My ", "My name is Isaac", "My name is Joe", "Z" };
        Glossary.sortAToZ(arr);

        assertTrue(Arrays.equals(arr, arrExp));
    }

    // Testing generateList
    @Test
    public void testGenerateList_1() {
        String inFileName = "data/test1.txt";
        String outFolder = "output";

        Glossary.generateList(inFileName, outFolder);

        SimpleReader input = new SimpleReader1L(outFolder + "/Isaac.html");
        String l1 = input.nextLine();
        String l2 = input.nextLine();
        String l3 = input.nextLine();
        String l4 = input.nextLine();

        String l1Exp = "<html> <body> <p style=\"color:#FF0000\">";
        String l2Exp = "<strong> <em>Isaac</em> </strong> </p>";
        String l3Exp = "<p>the coolest personin the entire world";
        String l4Exp = "</p> </body> </html>";

        assertEquals(l1, l1Exp);
        assertEquals(l2, l2Exp);
        assertEquals(l3, l3Exp);
        assertEquals(l4, l4Exp);

        input.close();
    }

    @Test
    public void testGenerateList_2() {
        String inFileName = "data/test2.txt";
        String outFolder = "output";

        Glossary.generateList(inFileName, outFolder);

        SimpleReader inputC = new SimpleReader1L(outFolder + "/Calculus.html");
        String l1 = inputC.nextLine();
        String l2 = inputC.nextLine();
        String l3 = inputC.nextLine();
        String l4 = inputC.nextLine();

        String l1Exp = "<html> <body> <p style=\"color:#FF0000\">";
        String l2Exp = "<strong> <em>Calculus</em> </strong> </p>";
        String l3Exp = "<p>It's fun sometimes";
        String l4Exp = "</p> </body> </html>";

        assertEquals(l1, l1Exp);
        assertEquals(l2, l2Exp);
        assertEquals(l3, l3Exp);
        assertEquals(l4, l4Exp);

        SimpleReader inputM = new SimpleReader1L(outFolder + "/Mythology.html");
        inputM.nextLine();
        l2 = inputM.nextLine();
        l3 = inputM.nextLine();

        l2Exp = "<strong> <em>Mythology</em> </strong> </p>";
        l3Exp = "<p>Very interesting";

        assertEquals(l2, l2Exp);
        assertEquals(l3, l3Exp);

        inputC.close();
        inputM.close();
    }
}
