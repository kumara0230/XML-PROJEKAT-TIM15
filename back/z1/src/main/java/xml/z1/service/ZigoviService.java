package xml.z1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xml.z1.dto.ResenjeDTO;
import xml.z1.dto.ZigRequest;
import xml.z1.fuseki.FusekiReader;
import xml.z1.fuseki.FusekiWriter;
import xml.z1.fuseki.MetadataExtractor;
import xml.z1.jaxb.JaxB;
import xml.z1.model.Resenje;
import xml.z1.model.ZahtevZaPriznanjeZiga;
import xml.z1.repository.ResenjeRepository;
import xml.z1.repository.ZigoviRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZigoviService {

    private final JaxB jaxB;
    private final ZigoviRepository zigoviRepository;
    private final MetadataExtractor metadataExtractor;
    private final ZigMapper zigMapper;
    private final ResenjeRepository resenjeRepository;
    private final UserService userService;
    private final ResenjeMapper resenjeMapper;


    @Autowired
    public ZigoviService(JaxB jaxB, ZigoviRepository zigoviRepository, MetadataExtractor metadataExtractor, ZigMapper zigMapper, ResenjeRepository resenjeRepository, UserService userService, ResenjeMapper resenjeMapper) {
        this.jaxB = jaxB;
        this.zigoviRepository = zigoviRepository;
        this.metadataExtractor = metadataExtractor;
        this.zigMapper = zigMapper;
        this.resenjeRepository = resenjeRepository;
        this.userService = userService;
        this.resenjeMapper = resenjeMapper;
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

    public ZahtevZaPriznanjeZiga kreirajZahtev(ZigRequest zigRequest) throws Exception{
        ZahtevZaPriznanjeZiga zahtev = zigMapper.mapZig(zigRequest);
        this.zigoviRepository.save(zahtev);
        return zahtev;
    }

    public List<ZahtevZaPriznanjeZiga> getAll(String token) throws Exception {
        List<ZahtevZaPriznanjeZiga> retList = new ArrayList<>();
        List<ZahtevZaPriznanjeZiga> requests = zigoviRepository.getAllRequests();
        for (ZahtevZaPriznanjeZiga req : requests) {
            Resenje resenje = resenjeRepository.getByBrojPrijave(req.getPopunjavaZavod().getBrojPrijaveZiga());

            if (userService.authorizeUser(token, true)) {
                // za sluzbenika svi neobradjeni zahtevi
                if (resenje == null) {
                    retList.add(req);
                }
            } else {
                // za korisnika svi odobreni zahtevi
                if (resenje != null && resenje.isOdobreno()) {
                    retList.add(req);
                }
            }
        }
        return retList;
    }

    public Resenje makeResenje(ResenjeDTO resenjeDTO) throws Exception {
        Resenje resenje = resenjeMapper.mapResenje(resenjeDTO);
        resenjeRepository.save(resenje);
        return resenje;

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
