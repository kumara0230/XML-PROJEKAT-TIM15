package xml.p1.fuseki;

import org.apache.xalan.xsltc.trax.TransformerFactoryImpl;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import xml.p1.model.ZahtevZaPriznanjePatenta;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

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

	private static final String XSLT_FILE = "xsl/zahtev_metadata.xsl";
	private static final String RDF_FILE = "rdf/rdfOutput.rdf";

	public MetadataExtractor() throws SAXException, IOException {
		
		// Set up the XSLT transformer factory
		transformerFactory = new TransformerFactoryImpl();
	}

	/**
	 * Generates RDF/XML based on RDFa metadata from an XML containing
	 * input stream by applying GRDDL XSL transformation.
	 *
	 * @param source XML containing source
	 */
	public void extractMetadata(Source source) throws FileNotFoundException, TransformerException, URISyntaxException {
		URL res = getClass().getClassLoader().getResource(RDF_FILE);
		String rdfFile = String.valueOf(Paths.get(res.toURI()));

		URL resource = getClass().getClassLoader().getResource(XSLT_FILE);
		String xsltFile = String.valueOf(Paths.get(resource.toURI()));

		OutputStream out = new FileOutputStream(rdfFile);

		// Create transformation source
		StreamSource transformSource = new StreamSource(new File(xsltFile));

		// Initialize GRDDL transformer object
		Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

		// Set the indentation properties
		grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
		grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

		// Initialize result stream
		StreamResult result = new StreamResult(out);

		// Trigger the transformation
		grddlTransformer.transform(source, result);

	}

	public void extractMetadataFromFile() throws FileNotFoundException, TransformerException, URISyntaxException {
		String filePath = "src/main/resources/xsd/instance1.xml";
		InputStream in = new FileInputStream(filePath);

		// Initialize transformation subject
		StreamSource source = new StreamSource(in);
		extractMetadata(source);
	}

	public void extractFromZahtev(ZahtevZaPriznanjePatenta zahtev) throws JAXBException, FileNotFoundException, TransformerException, URISyntaxException {
		JAXBContext context = JAXBContext.newInstance(ZahtevZaPriznanjePatenta.class);
		JAXBSource source = new JAXBSource(context, zahtev);
		extractMetadata(source);
	}


}
