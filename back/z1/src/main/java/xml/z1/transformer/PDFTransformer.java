package xml.z1.transformer;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.text.DocumentException;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import xml.z1.fuseki.FusekiWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

@Component
public class PDFTransformer {

    private static DocumentBuilderFactory documentFactory;
    private static TransformerFactory transformerFactory;

    public static final String XSL_FILE = "xsl/z1.xsl";
    public static final String HTML_FILE = "gen/z1.html";
    public static final String PDF_FILE = "gen/z1.pdf";

//    public static final String XML_FILE = "xsd/instance1.xml";

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
     *
     * @param filePath
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public ByteArrayOutputStream generatePDF(String filePath, ByteArrayOutputStream xhtmlFile) throws IOException, DocumentException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PdfWriter pdfWriter = new PdfWriter(output);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(new PageSize(780, 2000));
        HtmlConverter.convertToPdf(new ByteArrayInputStream(xhtmlFile.toByteArray()), pdfDocument);

        return output;
    }

    public ByteArrayOutputStream generateHTML(Node node, String xslFile) throws Exception {

        try {

            // Initialize Transformer instance
            StreamSource transformSource = new StreamSource(new File(xslFile));
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Generate XHTML
            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

            // Transform DOM to HTML
            DOMSource source = new DOMSource(node);

            ByteArrayOutputStream result = new ByteArrayOutputStream();

//            StreamResult result = new StreamResult(new FileOutputStream(HTML_FILE));
            transformer.transform(source, new StreamResult(result));
            return result;

        } catch (TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
            throw new Exception();
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

    public ByteArrayOutputStream parseToPdf(String format, Node node) throws Exception {
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
        URL res = FusekiWriter.class.getClassLoader().getResource(PDF_FILE);
        String pdfFilePath = String.valueOf(Paths.get(res.toURI()));

        res = FusekiWriter.class.getClassLoader().getResource(XSL_FILE);
        String xslFilePath = String.valueOf(Paths.get(res.toURI()));

        res = FusekiWriter.class.getClassLoader().getResource(HTML_FILE);
        String htmlFilePath = String.valueOf(Paths.get(res.toURI()));

        File pdfFile = new File(pdfFilePath);

        if (!pdfFile.getParentFile().exists()) {
            System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
            pdfFile.getParentFile().mkdir();
        }

        ByteArrayOutputStream htmlOutput = generateHTML(node, xslFilePath);
        ByteArrayOutputStream pdfOutput = generatePDF(pdfFilePath, htmlOutput);

        System.out.println("[INFO] File \"" + pdfFilePath + "\" generated successfully.");
        System.out.println("[INFO] End.");

        return (format.equals("html")) ? htmlOutput : pdfOutput;
    }
}
