package xml.p1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Node;
import xml.p1.db.ExistManager;
import xml.p1.db.ExistWriter;
import xml.p1.fuseki.FusekiWriter;
import xml.p1.fuseki.MetadataExtractor;
import xml.p1.model.ZahtevZaPriznanjePatenta;

import java.io.IOException;

@Repository
public class PatentRepository {
    private String collectionId = "/db/patenti";
    private ExistManager existManager;
    private final MetadataExtractor metadataExtractor;

    @Autowired
    public PatentRepository(ExistManager existManager, MetadataExtractor metadataExtractor){
        this.existManager = existManager;
        this.metadataExtractor = metadataExtractor;
    }

    public void savePatent(String text) throws Exception {
        existManager.storeFromText(collectionId, "saveFromText", text);
    }

    public void savePatentFromFile() throws Exception {
        String filePath = "src/main/resources/xsd/instance1.xml";
        existManager.store(collectionId, "saveFromFileTestP1.xml", filePath);
    }

    public String getFileFromExistTest() throws Exception {
        return (String) existManager.load(collectionId, "saveFromFileTestP1.xml").getContent();
    }

    public Node getFileAsNode() throws Exception {
        String documentId = "saveFromFileTestP1.xml";
        return existManager.getZahtevAsNode(collectionId, documentId);
    }

    public void save(ZahtevZaPriznanjePatenta zahtev) throws Exception {
        ExistWriter existWriter = new ExistWriter();
        ZahtevZaPriznanjePatenta newZahtev = existWriter.savePatent(
                "patenti",
                zahtev.getPopunjavaZavod().getBrojPrijave() + ".xml",
                zahtev
        );

        metadataExtractor.extractFromZahtev(newZahtev);
        FusekiWriter.saveRDF();
    }

}
