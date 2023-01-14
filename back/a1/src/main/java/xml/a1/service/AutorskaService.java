package xml.a1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.a1.dto.XMLDto;
import xml.a1.fuseki.FusekiReader;
import xml.a1.fuseki.FusekiWriter;
import xml.a1.fuseki.MetadataExtractor;
import xml.a1.jaxb.JaxB;
import xml.a1.model.Zahtev;
import xml.a1.repository.AutorskaRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AutorskaService {

//    private final DOMParser domParser;
    private final JaxB jaxB;
    private final AutorskaRepository autorskaRepository;
    private final MetadataExtractor metadataExtractor;

//    public XMLService(DOMParser domParser, JaxB jaxB, AutorskaRepository autorskaRepository, MetadataExtractor metadataExtractor) {
//        this.domParser = domParser;
//        this.jaxB = jaxB;
//        this.autorskaRepository = autorskaRepository;
//        this.metadataExtractor = metadataExtractor;
//    }

    @Autowired
    public AutorskaService(JaxB jaxB, AutorskaRepository autorskaRepository, MetadataExtractor metadataExtractor) {
        this.jaxB = jaxB;
        this.autorskaRepository = autorskaRepository;
        this.metadataExtractor = metadataExtractor;
    }

//    public String playWithXML(XMLDto dto) throws Exception {
//        Document document = domParser.buildDocumentFromText(dto.getText());
//        NodeList profesori = document.getElementsByTagName("profesor");
//
//        for (int i = 0; i < profesori.getLength(); i++) {
//            Element profesor = (Element) profesori.item(i);
//            profesor.setAttribute("id", "prof" + i);
//
//            Element titula = document.createElement("Titila");
//            titula.appendChild(document.createTextNode("Profesor"));
//            profesor.appendChild(titula);
//        }
//
//        return domParser.getDocumentAsString(document);
//    }

    public String jaxBTest(XMLDto dto) throws Exception {
//        JAXBContext context = JAXBContext.newInstance(User.class);

        Zahtev zahtev = (Zahtev) jaxB.unmarshall(Zahtev.class, dto.getText());
        zahtev.getDelo().setNaslovDela("NOVI NASLOV DELA");
        System.out.println(zahtev.getDelo().getNaslovDela());

        return jaxB.marshall(Zahtev.class, zahtev);
    }


    public void saveFileFromString(String text) throws Exception {
        autorskaRepository.saveAutorska(text);
        metadataExtractor.extractMetadata(text);
        FusekiWriter.saveRDF();
    }

    public ArrayList<String> searchByMetadata(String naziv, String godina) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("naziv", naziv);
        params.put("godina", godina);

        ArrayList<String> result = FusekiReader.executeQuery(params);
        return result;
    }

    public void saveFromFileToExist() throws Exception {
        this.autorskaRepository.saveAutorskaFromFile();
    }

    public String getFileFromExistTest() throws Exception {
        return this.autorskaRepository.getFileFromExistTest();
    }
}