package xml.a1.service;

import org.springframework.stereotype.Service;
import xml.a1.dto.ResenjeDTO;
import xml.a1.model.Resenje;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class ResenjeMapper {
    public Resenje mapResenje(ResenjeDTO resenjeDTO) throws Exception {
        Resenje resenje = new Resenje();
        Date now = new Date();
        resenje.setBrojResenja("RA-" + now.getTime());
        resenje.setDatumResenja(genDatumResenja());
        resenje.setImeSluzbenika(resenjeDTO.getImeSluzbenika());
        resenje.setPrezimeSluzbenika(resenjeDTO.getPrezimeSluzbenika());
        resenje.setBrojZahteva(resenjeDTO.getBrZahteva());

        if (resenjeDTO.getObrazlozenje() != null) {                 // odbijen
            resenje.setObrazlozenje(resenjeDTO.getObrazlozenje());
            resenje.setOdobreno(false);
        }
        else {                                                      // prihvacen
            resenje.setSifra("SA-" + now.getTime());
            resenje.setOdobreno(true);
        }
        return resenje;
    }

    private XMLGregorianCalendar genDatumResenja() throws DatatypeConfigurationException {
        Date now = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(now);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }
}
