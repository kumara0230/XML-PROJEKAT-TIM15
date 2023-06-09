package xml.a1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Node;
import xml.a1.db.ExistManager;
import xml.a1.db.ExistReader;
import xml.a1.db.ExistWriter;
import xml.a1.fuseki.FusekiWriter;
import xml.a1.fuseki.MetadataExtractor;
import xml.a1.model.Zahtev;

import java.util.List;


@Repository
public class AutorskaRepository {
    private String collectionId = "/db/autorska";
    private ExistManager existManager;
    private final MetadataExtractor metadataExtractor;

    @Autowired
    public AutorskaRepository(ExistManager existManager, MetadataExtractor metadataExtractor) {
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
    }

    public void saveAutorska(String text) throws Exception {
        existManager.storeFromText(collectionId, "saveFromText", text);
    }

    public void saveAutorskaFromFile() throws Exception {
        String filePath = "src/main/resources/xsd/instance1.xml";
        existManager.store(collectionId, "saveFromFileTest.xml", filePath);
    }

    public String getFileFromExistTest() throws Exception {
        return (String) existManager.load(collectionId, "saveFromFileTest.xml").getContent();
    }

    public Node getFileAsNode(String documentId) throws Exception {
        return existManager.getZahtevAsNode(collectionId, documentId);
    }

    public void save(Zahtev zahtev) throws Exception {
        ExistWriter existWriter = new ExistWriter();
        Zahtev newZahtev = existWriter.saveAutorska(
                "autorska",
                zahtev.getPopunjavaZavod().getBrojPrijave() + ".xml",
                zahtev);

        metadataExtractor.extractFromZahtev(newZahtev);
        FusekiWriter.saveRDF();
    }

    public List<Zahtev> getAllRequests() throws Exception {
        ExistReader existReader = new ExistReader();
        return existReader.getAllRequests();
    }
}