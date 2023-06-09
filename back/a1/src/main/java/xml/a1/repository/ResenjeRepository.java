package xml.a1.repository;

import org.springframework.stereotype.Repository;
import xml.a1.db.ExistReader;
import xml.a1.db.ExistWriter;
import xml.a1.model.Resenje;

@Repository
public class ResenjeRepository {
    public void save(Resenje resenje) throws Exception {
        ExistWriter existWriter = new ExistWriter();
        Resenje newResenje = existWriter.saveResenje(
                "resenja-autorska",
                resenje.getBrojResenja() + ".xml",
                resenje);
    }

    public Resenje getByBrojPrijave(String brojPrijave) throws Exception {
        ExistReader existReader = new ExistReader();
        return existReader.getResenjeByBrojPrijave(brojPrijave);
    }
}
