package xml.p1.dto;

import xml.p1.model.ZahtevZaPriznanjePatenta;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
public class RequestPatent {

    @XmlElement
    private NazivPronalaskaDTO nazivPronalaska;

    @XmlElement
    private PodnosilacDTO podnosilac;

    @XmlElement
    private PronalazacDTO pronalazac;

    @XmlElement
    private PredstavnikDTO predstavnik;

    @XmlElement
    private DostavljanjeDTO dostavljanje;

    @XmlElement
    private ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijavaDTO zahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava;

    @XmlElement
    private XMLGregorianCalendar datumPodnosenja;

    @XmlElement
    private String brojPrijave;

    public RequestPatent() {}

    public RequestPatent(NazivPronalaskaDTO nazivPronalaska, PodnosilacDTO podnosilac,
                         PronalazacDTO pronalazac, PredstavnikDTO predstavnik,
                         DostavljanjeDTO dostavljanje,
                         ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijavaDTO zahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava) {
        this.nazivPronalaska = nazivPronalaska;
        this.podnosilac = podnosilac;
        this.pronalazac = pronalazac;
        this.predstavnik = predstavnik;
        this.dostavljanje = dostavljanje;
        this.zahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava = zahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava;
    }

    public RequestPatent(ZahtevZaPriznanjePatenta zahtev) {
        this.podnosilac = new PodnosilacDTO(zahtev);
        this.pronalazac = new PronalazacDTO(zahtev.getPronalazacPatenta());
        this.datumPodnosenja = zahtev.getPopunjavaZavod().getDatumPrijema();
        this.brojPrijave = zahtev.getPopunjavaZavod().getBrojPrijave();
    }

    public NazivPronalaskaDTO getNazivPronalaska() {
        return this.nazivPronalaska;
    }

    public void setNazivPronalaska(NazivPronalaskaDTO nazivPronalaska) {
        this.nazivPronalaska = nazivPronalaska;
    }

    public PodnosilacDTO getPodnosilac() {
        return this.podnosilac;
    }

    public void setPodnosilac(PodnosilacDTO podnosilac) {
        this.podnosilac = podnosilac;
    }

    public PronalazacDTO getPronalazac() {
        return this.pronalazac;
    }

    public void setPronalazac(PronalazacDTO pronalazac) {
        this.pronalazac = pronalazac;
    }

    public PredstavnikDTO getPredstavnik() {
        return this.predstavnik;
    }

    public void setPredstavnik(PredstavnikDTO predstavnik) {
        this.predstavnik = predstavnik;
    }

    public DostavljanjeDTO getDostavljanje() {
        return this.dostavljanje;
    }

    public void setDostavljanje(DostavljanjeDTO dostavljanje) {
        this.dostavljanje = dostavljanje;
    }

    public ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijavaDTO getZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava() {
        return this.zahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava;
    }

    public void setZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava(ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijavaDTO zahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava) {
        this.zahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava = zahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava;
    }

    public XMLGregorianCalendar getDatumPodnosenja() {
        return datumPodnosenja;
    }

    public void setDatumPodnosenja(XMLGregorianCalendar datumPodnosenja) {
        this.datumPodnosenja = datumPodnosenja;
    }

    public String getBrojPrijave() {
        return brojPrijave;
    }

    public void setBrojPrijave(String brojPrijave) {
        this.brojPrijave = brojPrijave;
    }
}
