package xml.z1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Node;
import xml.z1.db.ExistManager;
import xml.z1.db.ExistReader;
import xml.z1.db.ExistWriter;
import xml.z1.fuseki.FusekiWriter;
import xml.z1.fuseki.MetadataExtractor;
import xml.z1.model.ZahtevZaPriznanjeZiga;

import java.util.List;

@Repository
public class ZigoviRepository {

    private String collectionId = "/db/zigovi";
    private ExistManager existManager;
    private final MetadataExtractor metadataExtractor;

    @Autowired
    public ZigoviRepository(ExistManager existManager, MetadataExtractor metadataExtractor){
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
    }

    public void saveAutorska(String text) throws Exception {
        existManager.storeFromText(collectionId, "saveFromText", text);
    }

    public void saveAutorskaFromFile() throws Exception {
        String filePath = "src/main/resources/xsd/z1.xml";
        existManager.store(collectionId, "saveFromFileTest.xml", filePath);
    }

    public String getFileFromExistTest() throws Exception {
        return (String) existManager.load(collectionId, "saveFromFileTest.xml").getContent();
    }

    public void save(ZahtevZaPriznanjeZiga zahtev) throws Exception {
        ExistWriter existWriter = new ExistWriter();
        ZahtevZaPriznanjeZiga newZahtev = existWriter.saveZig(
                "zigovi",
                zahtev.getPopunjavaZavod().getBrojPrijaveZiga() + ".xml",
                zahtev);

        metadataExtractor.extractFromZahtev(newZahtev);
        FusekiWriter.saveRDF();
    }

    public List<ZahtevZaPriznanjeZiga> getAllRequests() throws Exception {
        ExistReader existReader = new ExistReader();
        return existReader.getAllRequests();
    }

    public Node getFileAsNode(String documentId) throws Exception {
        return existManager.getZahtevAsNode(collectionId, documentId);
    }
}
