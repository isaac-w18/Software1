import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        int subExpression = 0;

        // if the root of exp is an operation, recursive call must take place
        if (!exp.hasAttribute("value")) {
            String op = exp.label();

            // recursive call to evaluate both children
            int first = evaluate(exp.child(0));
            int second = evaluate(exp.child(1));

            // which expression based off of operation name
            if (op.equals("plus")) {
                subExpression = first + second;
            } else if (op.equals("minus")) {
                subExpression = first - second;
            } else if (op.equals("times")) {
                subExpression = first * second;
            } else {
                subExpression = first / second;
            }

        } else {
            // subExpression becomes the number and simply returns itself as an int
            subExpression = Integer.parseInt(exp.attributeValue("value"));
        }

        return subExpression;
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