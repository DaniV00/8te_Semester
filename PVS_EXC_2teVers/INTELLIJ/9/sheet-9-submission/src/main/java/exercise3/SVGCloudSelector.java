import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class SVGCloudSelector {

    public static void main(String[] args) {
        // Pfad zur SVG-Datei
        String filePath = "path/to/your/svgfile.svg";
        selectCloudElements(filePath);
    }

    // Methode zum Selektieren der Wolkenelemente in der SVG-Datei
    public static void selectCloudElements(String filePath) {
        try {
            // Dokument einlesen
            File inputFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Normalisieren des Dokuments
            doc.getDocumentElement().normalize();

            // XPath-Objekt erstellen
            XPath xPath = XPathFactory.newInstance().newXPath();

            // XPath-Ausdruck zum Selektieren der Wolkenelemente
            String expression = "//ellipse[@class='cloud']";

            // XPath-Ausdruck auswerten
            XPathExpression xPathExpression = xPath.compile(expression);
            NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);

            // Ausgabe der gefundenen Wolkenelemente
            System.out.println("Gefundene Wolkenelemente: " + nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Cloud Element " + (i + 1) + ": " + nodeList.item(i).getAttributes().getNamedItem("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
