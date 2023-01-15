package xml.z1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xml.z1.db.ExistManager;

@Repository
public class ZigoviRepository {

    private String collectionId = "/db/zigovi";
    private ExistManager existManager;

    @Autowired
    public ZigoviRepository(ExistManager existManager){
        this.existManager = existManager;
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
}
