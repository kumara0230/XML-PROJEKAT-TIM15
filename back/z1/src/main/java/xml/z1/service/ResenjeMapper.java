package xml.z1.service;

import org.springframework.stereotype.Service;
import xml.z1.dto.ResenjeDTO;
import xml.z1.model.Resenje;

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
        resenje.setBrojResenja("RZ-" + now.getTime());
        resenje.setDatumResenja(genDatumResenja());
        resenje.setImeSluzbenika(resenjeDTO.getImeSluzbenika());
        resenje.setPrezimeSluzbenika(resenjeDTO.getPrezimeSluzbenika());
        resenje.setBrojZahteva(resenjeDTO.getBrZahteva());
        resenje.setEmailPodnosioca(resenjeDTO.getEmailPodnosioca());

        if (resenjeDTO.getObrazlozenje() != null) {                 // odbijen
            resenje.setObrazlozenje(resenjeDTO.getObrazlozenje());
            resenje.setOdobreno(false);
        }
        else {                                                      // prihvacen
            resenje.setSifra("SZ-" + now.getTime());
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
