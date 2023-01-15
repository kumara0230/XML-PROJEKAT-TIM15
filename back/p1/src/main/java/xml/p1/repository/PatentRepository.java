package xml.p1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xml.p1.db.ExistManager;

@Repository
public class PatentRepository {
    private String collectionId = "/db/patenti";
    private ExistManager existManager;

    @Autowired
    public PatentRepository(ExistManager existManager){
        this.existManager = existManager;
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

}
