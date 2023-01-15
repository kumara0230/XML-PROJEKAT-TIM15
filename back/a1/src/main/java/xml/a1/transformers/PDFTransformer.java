package xml.a1.transformers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.Charset;

@Component

public class PDFTransformer {
    private static DocumentBuilderFactory documentFactory;
    private static TransformerFactory transformerFactory;

    public static final String XSL_FILE = "src/main/resources/xsl/a1.xsl";
    public static final String HTML_FILE = "src/main/resources/gen/a1.html";
    public static final String PDF_FILE = "src/main/resources/gen/a1.pdf";
    public static final String XML_FILE = "src/main/resources/xsd/instance1.xml";

    static {
        /* Inicijalizacija DOM fabrike */
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        /* Inicijalizacija Transformer fabrike */
        transformerFactory = TransformerFactory.newInstance();

    }

    /**
     * Creates a PDF using iText Java API
     * @param filePath
     * @throws IOException
     * @throws DocumentException
     */
    public void generatePDF(String filePath, String xhtmlFile) throws IOException, DocumentException {
        // Step 1
        Document document = new Document();
        // Step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        // Step 3
        document.open();
        // Step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(xhtmlFile), Charset.forName("UTF-8"));
        // Step 5
        document.close();

    }
    public void generateHTML(Node node, String htmlFile) throws FileNotFoundException {

        try {
            // Initialize Transformer instance
            StreamSource transformSource = new StreamSource(new File(XSL_FILE));
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Generate XHTML
            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

            // Transform DOM to HTML
            DOMSource source = new DOMSource(node);
            StreamResult result = new StreamResult(new FileOutputStream(HTML_FILE));
            transformer.transform(source, result);


        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public org.w3c.dom.Document buildDocument(String xml) {

        org.w3c.dom.Document document = null;
        try {

            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(xml)));
//            document = builder.parse(new File(filePath));

            if (document != null)
                System.out.println("[INFO] File parsed with no errors.");
            else
                System.out.println("[WARN] Document is null.");

        } catch (Exception e) {
            return null;

        }

        return document;
    }

    public void parseToPdf(Node node) throws Exception {
//        // create a DocumentBuilderFactory
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//        // use the factory to create a document builder
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
//        // parse the XML file and create a Document object
////        org.w3c.dom.Document doc = builder.parse(XML_FILE);
//        org.w3c.dom.Document doc = buildDocument(file);
//        Node node = doc.getDocumentElement();

        // Creates parent directory if necessary
        File pdfFile = new File(PDF_FILE);

        if (!pdfFile.getParentFile().exists()) {
            System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
            pdfFile.getParentFile().mkdir();
        }

        generateHTML(node, XSL_FILE);
        generatePDF(PDF_FILE, HTML_FILE);

        System.out.println("[INFO] File \"" + PDF_FILE + "\" generated successfully.");
        System.out.println("[INFO] End.");
    }

}