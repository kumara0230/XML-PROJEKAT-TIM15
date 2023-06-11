package xml.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import xml.p1.dto.RequestPatent;
import xml.p1.dto.ResenjeDTO;
import xml.p1.fuseki.FusekiReader;
import xml.p1.fuseki.FusekiWriter;
import xml.p1.fuseki.MetadataExtractor;
import xml.p1.jaxb.JaxB;
import xml.p1.model.Resenje;
import xml.p1.model.ZahtevZaPriznanjePatenta;
import xml.p1.repository.PatentRepository;
import xml.p1.repository.ResenjeRepository;
import xml.p1.transformers.PDFTransformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatentiService {

    private final JaxB jaxB;
    private final PatentRepository patentiRepository;
    private final MetadataExtractor metadataExtractor;
    private final PDFTransformer pdfTransformer;
    private final PatentiMapper patentiMapper;
    private final ResenjeMapper resenjeMapper;
    private final ResenjeRepository resenjeRepository;


    @Autowired
    public PatentiService(JaxB jaxB, PatentRepository patentiRepository, MetadataExtractor metadataExtractor, PDFTransformer pdfTransformer, PatentiMapper patentiMapper, ResenjeMapper resenjeMapper, ResenjeRepository resenjeRepository) {
        this.jaxB = jaxB;
        this.patentiRepository = patentiRepository;
        this.metadataExtractor = metadataExtractor;
        this.pdfTransformer = pdfTransformer;
        this.patentiMapper = patentiMapper;
        this.resenjeMapper = resenjeMapper;
        this.resenjeRepository = resenjeRepository;
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

    public void toPdf() throws Exception {
//        Node file = this.patentiRepository.getFileAsNode();
//        this.pdfTransformer.parseToPdf(file);
    }

//    public void saveZahtevToDatabases(XMLDto zahtev) throws Exception {
//
//        String xmlTxt = this.jaxB.marshall(ZahtevZaPriznanjePatenta.class, zahtev.getText());
//
//        patentiRepository.savePatent(xmlTxt);
////        metadataExtractor.extractMetadata(xmlTxt);
////        FusekiWriter.saveRDF();
//    }

    public ZahtevZaPriznanjePatenta kreirajZahtev(RequestPatent requestPatent) throws Exception {
        ZahtevZaPriznanjePatenta zahtev = patentiMapper.mapPatent(requestPatent);
        this.patentiRepository.save(zahtev);
        return zahtev;
    }

    public List<ZahtevZaPriznanjePatenta> getAll(String token) throws Exception {
        List<ZahtevZaPriznanjePatenta> retList = new ArrayList<>();
        List<ZahtevZaPriznanjePatenta> requests = patentiRepository.getAllRequests();
//        for (ZahtevZaPriznanjePatenta req : requests) {
//            Resenje resenje = resenjeRepository.getByBrojPrijave(req.getPopunjavaZavod().getBrojPrijave());
//
//            if (userService.authorizeUser(token, true)) {
//                // za sluzbenika svi neobradjeni zahtevi
//                if (resenje == null) {
//                    retList.add(req);
//                }
//            } else {
//                // za korisnika svi odobreni zahtevi
//                if (resenje != null && resenje.isOdobreno()) {
//                    retList.add(req);
//                }
//            }
//        }
        return requests;
    }

    public Resenje makeResenje(ResenjeDTO resenjeDTO) throws Exception {
        Resenje resenje = resenjeMapper.mapResenje(resenjeDTO);
        resenjeRepository.save(resenje);
        return resenje;
    }
}
