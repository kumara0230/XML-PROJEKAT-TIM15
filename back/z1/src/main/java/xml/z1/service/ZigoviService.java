package xml.z1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.z1.fuseki.FusekiReader;
import xml.z1.fuseki.FusekiWriter;
import xml.z1.fuseki.MetadataExtractor;
import xml.z1.jaxb.JaxB;
import xml.z1.repository.ZigoviRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ZigoviService {

    private final JaxB jaxB;
    private final ZigoviRepository zigoviRepository;
    private final MetadataExtractor metadataExtractor;


    @Autowired
    public ZigoviService(JaxB jaxB, ZigoviRepository zigoviRepository, MetadataExtractor metadataExtractor) {
        this.jaxB = jaxB;
        this.zigoviRepository = zigoviRepository;
        this.metadataExtractor = metadataExtractor;
    }

//
//    public String jaxBTest(XMLDto dto) throws Exception {
////        JAXBContext context = JAXBContext.newInstance(User.class);
//
//        Zahtev zahtev = jaxB.unmarshall(Zahtev.class, dto.getText());
//        zahtev.getDelo().setNaslovDela("NOVI NASLOV DELA");
//        System.out.println(zahtev.getDelo().getNaslovDela());
//
//        return jaxB.marshall(Zahtev.class, zahtev);
//    }
//

    public void saveFileFromString(String text) throws Exception {
        zigoviRepository.saveAutorska(text);
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
        this.zigoviRepository.saveAutorskaFromFile();
        metadataExtractor.extractMetadataFromFile();
        FusekiWriter.saveRDF();
    }

    public String getFileFromExistTest() throws Exception {
        return this.zigoviRepository.getFileFromExistTest();
    }
//
//    public void saveZahtevToDatabases(XMLDto zahtev) throws Exception {
//
//        String xmlTxt = this.jaxB.marshall(Zahtev.class, zahtev.getText());
//
//        autorskaRepository.saveAutorska(xmlTxt);
////        metadataExtractor.extractMetadata(xmlTxt);
////        FusekiWriter.saveRDF();
//    }
}
