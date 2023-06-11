package xml.p1.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;

public class ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijavaDTO {

    @XmlElement
    private String brojRanijePrijave1;
    @XmlElement
    private XMLGregorianCalendar datumPodnosenjaRanijePrijave1;
    @XmlElement
    private String dvoslovnaOznaka1;

    @XmlElement
    private String brojRanijePrijave2;
    @XmlElement
    private XMLGregorianCalendar datumPodnosenjaRanijePrijave2;
    @XmlElement
    private String dvoslovnaOznaka2;


    public ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijavaDTO() {}

    public ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijavaDTO(String brojRanijePrijave1,
                                                               XMLGregorianCalendar datumPodnosenjaRanijePrijave1,
                                                               String dvoslovnaOznaka1, String brojRanijePrijave2,
                                                               XMLGregorianCalendar datumPodnosenjaRanijePrijave2,
                                                               String dvoslovnaOznaka2) {
        this.brojRanijePrijave1 = brojRanijePrijave1;
        this.datumPodnosenjaRanijePrijave1 = datumPodnosenjaRanijePrijave1;
        this.dvoslovnaOznaka1 = dvoslovnaOznaka1;
        this.brojRanijePrijave2 = brojRanijePrijave2;
        this.datumPodnosenjaRanijePrijave2 = datumPodnosenjaRanijePrijave2;
        this.dvoslovnaOznaka2 = dvoslovnaOznaka2;
    }


    public String getBrojRanijePrijave1() {
        return this.brojRanijePrijave1;
    }

    public void setBrojRanijePrijave1(String brojRanijePrijave1) {
        this.brojRanijePrijave1 = brojRanijePrijave1;
    }

    public XMLGregorianCalendar getDatumPodnosenjaRanijePrijave1() {
        return this.datumPodnosenjaRanijePrijave1;
    }

    public void setDatumPodnosenjaRanijePrijave1(XMLGregorianCalendar datumPodnosenjaRanijePrijave1) {
        this.datumPodnosenjaRanijePrijave1 = datumPodnosenjaRanijePrijave1;
    }

    public String getDvoslovnaOznaka1() {
        return this.dvoslovnaOznaka1;
    }

    public void setDvoslovnaOznaka1(String dvoslovnaOznaka1) {
        this.dvoslovnaOznaka1 = dvoslovnaOznaka1;
    }

    public String getBrojRanijePrijave2() {
        return this.brojRanijePrijave2;
    }

    public void setBrojRanijePrijave2(String brojRanijePrijave2) {
        this.brojRanijePrijave2 = brojRanijePrijave2;
    }

    public XMLGregorianCalendar getDatumPodnosenjaRanijePrijave2() {
        return this.datumPodnosenjaRanijePrijave2;
    }

    public void setDatumPodnosenjaRanijePrijave2(XMLGregorianCalendar datumPodnosenjaRanijePrijave2) {
        this.datumPodnosenjaRanijePrijave2 = datumPodnosenjaRanijePrijave2;
    }

    public String getDvoslovnaOznaka2() {
        return this.dvoslovnaOznaka2;
    }

    public void setDvoslovnaOznaka2(String dvoslovnaOznaka2) {
        this.dvoslovnaOznaka2 = dvoslovnaOznaka2;
    }
}
