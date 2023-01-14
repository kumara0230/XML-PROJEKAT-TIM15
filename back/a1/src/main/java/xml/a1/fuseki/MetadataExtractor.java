package xml.a1.fuseki;

import java.io.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

/**
 * 
 * Primer demonstrira ekstrakciju RDFa metapodataka iz 
 * XML dokumenta primenom GRDDL (Gleaning Resource Descriptions 
 * from Dialects of Languages) transformacije.
 * 
 */
@Component
public class MetadataExtractor {
	
	private TransformerFactory transformerFactory;

	private static final String XSLT_FILE = "src/main/resources/xsl/grddl.xsl";
	private static final String RDF_FILE = "src/main/resources/rdf/metadata.rdf";

	public MetadataExtractor() throws SAXException, IOException {
		
		// Setup the XSLT transformer factory
		transformerFactory = new TransformerFactoryImpl();
	}

	/**
	 * Generates RDF/XML based on RDFa metadata from an XML containing 
	 * input stream by applying GRDDL XSL transformation.
	 *  
	 * @param in XML containing input stream
	 */
	public void extractMetadata(String in) throws FileNotFoundException, TransformerException {

		OutputStream out = new FileOutputStream(new File(RDF_FILE));

		// Create transformation source
		StreamSource transformSource = new StreamSource(new File(XSLT_FILE));

		// Initialize GRDDL transformer object
		Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

		// Set the indentation properties
		grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
		grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

		// Initialize transformation subject
		StreamSource source = new StreamSource(new StringReader(in));

		// Initialize result stream
		StreamResult result = new StreamResult(out);

		// Trigger the transformation
		grddlTransformer.transform(source, result);
		
	}
	
//
//	public void test() throws Exception {
//
//		System.out.println("[INFO] " + MetadataExtractor.class.getSimpleName());
//
//		String filePath = "gen/grddl_metadata.rdf";
//
//		InputStream in = new FileInputStream(new File("data/rdfa/contacts.xml"));
//
//		OutputStream out = new FileOutputStream(filePath);
//
//		extractMetadata(in, out);
//
//		System.out.println("[INFO] File \"" + filePath + "\" generated successfully.");
//
//		System.out.println("[INFO] End.");
//
//	}
//
//	public static void main(String[] args) throws Exception {
//		new MetadataExtractor().test();
//	}

}
