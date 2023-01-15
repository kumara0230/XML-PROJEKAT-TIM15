package xml.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.p1.fuseki.FusekiReader;
import xml.p1.fuseki.FusekiWriter;
import xml.p1.fuseki.MetadataExtractor;
import xml.p1.jaxb.JaxB;
import xml.p1.model.ZahtevZaPriznanjePatenta;
import xml.p1.repository.PatentRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PatentiService {

    private final JaxB jaxB;
    private final PatentRepository patentiRepository;
    private final MetadataExtractor metadataExtractor;


    @Autowired
    public PatentiService(JaxB jaxB, PatentRepository patentiRepository, MetadataExtractor metadataExtractor) {
        this.jaxB = jaxB;
        this.patentiRepository = patentiRepository;
        this.metadataExtractor = metadataExtractor;
    }


//    public String jaxBTest(XMLDto dto) throws Exception {
////        JAXBContext context = JAXBContext.newInstance(User.class);
//
//        Zahtev zahtev = jaxB.unmarshall(Zahtev.class, dto.getText());
//        zahtev.getDelo().setNaslovDela("NOVI NASLOV DELA");
//        System.out.println(zahtev.getDelo().getNaslovDela());
//
//        return jaxB.marshall(Zahtev.class, zahtev);
//    }


    public void saveFileFromString(String text) throws Exception {
        patentiRepository.savePatent(text);
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
        this.patentiRepository.savePatentFromFile();
        metadataExtractor.extractMetadataFromFile();
        FusekiWriter.saveRDF();
    }

    public String getFileFromExistTest() throws Exception {
        return this.patentiRepository.getFileFromExistTest();
    }

//    public void saveZahtevToDatabases(XMLDto zahtev) throws Exception {
//
//        String xmlTxt = this.jaxB.marshall(ZahtevZaPriznanjePatenta.class, zahtev.getText());
//
//        patentiRepository.savePatent(xmlTxt);
////        metadataExtractor.extractMetadata(xmlTxt);
////        FusekiWriter.saveRDF();
//    }

}
