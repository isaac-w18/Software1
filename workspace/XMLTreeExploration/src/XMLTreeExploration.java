import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeExploration {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires <pre>
     * [the label of the root of xt is a tag]  and
     * [xt has at least one child]  and  out.is_open
     * </pre>
     * @ensures <pre>
     * out.content = #out.content * [the label of the middle child
     *  of xt, whether the root of the middle child is a tag or text,
     *  and if it is a tag, the number of children of the middle child]
     * </pre>
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        int numChildren = xt.numberOfChildren();
        XMLTree middleChild = xt.child(numChildren / 2);
        out.println("Middle Child's Label: " + middleChild.label());
        if (middleChild.isTag()) {
            out.println("Middle Child's Label is a Tag.");
            out.println("Middle Child's Number of Children: "
                    + middleChild.numberOfChildren());
        } else {
            out.println("Middle Child's Label is Text.");
        }

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

        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/"
                        + "extras/instructions/xmltree-model/columbus-weather.xml");
        out.println("XML TREE");
        out.println(xml.toString());
        //xml.display();
        if (xml.isTag()) {
            out.println("Root of xml is a tag");
        } else {
            out.println("Root of xml is a label");
        }
        out.println(xml.label());

        XMLTree results = xml.child(0);
        out.println("RESULTS XML TREE");
        out.println(results.toString());

        XMLTree channel = results.child(0);
        out.println("CHANNEL XML TREE");
        out.println(channel.toString());
        out.println("Number of children: " + channel.numberOfChildren());

        XMLTree title = channel.child(1);
        out.println("TITLE XML TREE");
        out.println(title.toString());

        XMLTree titleText = title.child(0);
        out.println(titleText.label());

        out.println(xml.child(0).child(0).child(1).child(0).label());

        final int astronomyIndex = 10;
        XMLTree astronomy = channel.child(astronomyIndex);
        out.println("Astronomy has attribute sunset: "
                + astronomy.hasAttribute("sunset"));
        out.println("Astronomy has attribute midday: "
                + astronomy.hasAttribute("midday"));
        out.println(astronomy.attributeValue("sunrise"));
        out.println(astronomy.attributeValue("sunset"));

        if (channel.isTag() && channel.numberOfChildren() > 0) {
            printMiddleNode(channel, out);
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
