import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        // initializing first, which becomes the result of the subexpression
        NaturalNumber first = new NaturalNumber2();

        // if the root of exp is an operation, recursive call must take place
        if (!exp.hasAttribute("value")) {
            String op = exp.label();

            // recurisve call to evalute both children
            first = evaluate(exp.child(0));
            NaturalNumber second = evaluate(exp.child(1));

            // using NN methods according to operation name
            if (op.equals("plus")) {
                first.add(second);
            } else if (op.equals("minus")) {
                // reports error if expression would violate subtract's precondition
                if (first.compareTo(second) < 0) {
                    Reporter.fatalErrorToConsole(
                            "Subtraction may not result in a negative");
                }
                first.subtract(second);
            } else if (op.equals("times")) {
                first.multiply(second);
            } else {
                // reports error if expression would violate divides's precondition
                if (second.isZero()) {
                    Reporter.fatalErrorToConsole("Cannot divide by 0");
                }
                first.divide(second);
            }

        } else {
            // subExpression becomes the number and simply returns itself as an NN
            first = new NaturalNumber2(exp.attributeValue("value"));
        }

        return first;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
