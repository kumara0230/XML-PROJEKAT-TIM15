package xml.p1.repository;

import org.springframework.stereotype.Repository;
import xml.p1.db.ExistReader;
import xml.p1.db.ExistWriter;
import xml.p1.model.Resenje;

@Repository
public class ResenjeRepository {
    public void save(Resenje resenje) throws Exception {
        ExistWriter existWriter = new ExistWriter();
        Resenje newResenje = existWriter.saveResenje(
                "resenja-patent",
                resenje.getBrojResenja() + ".xml",
                resenje);
    }

    public Resenje getByBrojPrijave(String brojPrijave) throws Exception {
        ExistReader existReader = new ExistReader();
        return existReader.getResenjeByBrojPrijave(brojPrijave);
    }
}
