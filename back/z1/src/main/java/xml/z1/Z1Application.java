package xml.z1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;
import xml.a1.util.MyValidationEventHandler;
import xml.z1.model.ZahtevZaPriznanjeZiga;


import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@SpringBootApplication
public class Z1Application {

	public static void main(String[] args) {
		//SpringApplication.run(A1Application.class, args);
		try {
			System.out.println("[INFO] Example: JAXB unmarshalling/marshalling.\n");

			// Definiše se JAXB kontekst (putanja do paketa sa JAXB bean-ovima)
			JAXBContext context = JAXBContext.newInstance("xml.z1.model");

			// Unmarshaller je objekat zadužen za konverziju iz XML-a u objektni model
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// Marshaller je objekat zadužen za konverziju iz objektnog u XML model
			Marshaller marshaller = context.createMarshaller();
			// Podešavanje marshaller-a
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


			// XML schema validacija
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(new File("./data/Z1_Schema1.xsd"));

			// Podešavanje unmarshaller-a za XML schema validaciju
			unmarshaller.setSchema(schema);
			unmarshaller.setEventHandler(new MyValidationEventHandler());

			ZahtevZaPriznanjeZiga zahtev = (ZahtevZaPriznanjeZiga) unmarshaller.unmarshal(new File("./data/z1.xml"));
			marshaller.marshal(zahtev, System.out);

			System.out.println("\n\n\n=============================================\n\n");

			// Izmena nad objektnim modelom dodavanjem novog odseka
			zahtev.setOpisZnaka("--------------- NOVI OPIS ZNAKA -----------");

			// Umesto System.out-a, može se koristiti FileOutputStream
			marshaller.marshal(zahtev, new FileOutputStream(new File("./data/z1Marshaller.xml")));
			marshaller.marshal(zahtev, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		}
	}
}
