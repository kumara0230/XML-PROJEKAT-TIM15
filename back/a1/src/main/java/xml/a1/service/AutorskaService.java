package xml.a1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import xml.a1.dto.RequestAutorskoDelo;
import xml.a1.dto.XMLDto;
import xml.a1.fuseki.FusekiReader;
import xml.a1.fuseki.FusekiWriter;
import xml.a1.fuseki.MetadataExtractor;
import xml.a1.jaxb.JaxB;
import xml.a1.model.Zahtev;
import xml.a1.repository.AutorskaRepository;
import xml.a1.transformers.PDFTransformer;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AutorskaService {

    private final JaxB jaxB;
    private final AutorskaRepository autorskaRepository;
    private final MetadataExtractor metadataExtractor;
    private final PDFTransformer pdfTransformer;
    private final AutorskaMapper autorskaMapper;


    @Autowired
    public AutorskaService(JaxB jaxB, AutorskaRepository autorskaRepository, MetadataExtractor metadataExtractor,
                           PDFTransformer pdfTransformer, AutorskaMapper autorskaMapper) {
        this.jaxB = jaxB;
        this.autorskaRepository = autorskaRepository;
        this.metadataExtractor = metadataExtractor;
        this.pdfTransformer = pdfTransformer;
        this.autorskaMapper = autorskaMapper;
    }


    public String jaxBTest(XMLDto dto) throws Exception {
//        JAXBContext context = JAXBContext.newInstance(User.class);

        Zahtev zahtev = jaxB.unmarshall(Zahtev.class, dto.getText());
        zahtev.getDelo().setNaslovDela("NOVI NASLOV DELA");
        System.out.println(zahtev.getDelo().getNaslovDela());

        return jaxB.marshall(Zahtev.class, zahtev);
    }


    public void saveFileFromString(String text) throws Exception {
        autorskaRepository.saveAutorska(text);
//        metadataExtractor.extractMetadata(text);
//        FusekiWriter.saveRDF();
    }

    public ArrayList<String> searchByMetadata(String naziv, String godina) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("naziv", naziv);
        params.put("godina", godina);

        ArrayList<String> result = FusekiReader.executeQuery(params);
        return result;
    }

    public void existFusekiSave() throws Exception {
        this.autorskaRepository.saveAutorskaFromFile();
        metadataExtractor.extractMetadataFromFile();
        FusekiWriter.saveRDF();
    }

    public String getFileFromExistTest() throws Exception {
        return this.autorskaRepository.getFileFromExistTest();
    }

    public void saveZahtevToDatabases(XMLDto zahtev) throws Exception {

        String xmlTxt = this.jaxB.marshall(Zahtev.class, zahtev.getText());

        autorskaRepository.saveAutorska(xmlTxt);
//        metadataExtractor.extractMetadata(xmlTxt);
//        FusekiWriter.saveRDF();
    }

    public void toPdf() throws Exception {
        Node file = this.autorskaRepository.getFileAsNode();
        this.pdfTransformer.parseToPdf(file);
    }

    public Zahtev kreirajZahtev(RequestAutorskoDelo requestAutorskoDelo) throws Exception {
        Zahtev zahtev = autorskaMapper.mapAutorska(requestAutorskoDelo);
        this.autorskaRepository.save(zahtev);
        return zahtev;
    }
}