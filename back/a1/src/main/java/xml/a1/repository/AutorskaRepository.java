package xml.a1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Node;
import xml.a1.db.ExistManager;


@Repository
public class AutorskaRepository {
    private String collectionId = "/db/autorska";
    private ExistManager existManager;

    @Autowired
    public AutorskaRepository(ExistManager existManager) {
        this.existManager = existManager;
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

    public Node getFileAsNode() throws Exception {
        String documentId = "saveFromFileTest.xml";
        return existManager.getZahtevAsNode(collectionId, documentId);
    }
}