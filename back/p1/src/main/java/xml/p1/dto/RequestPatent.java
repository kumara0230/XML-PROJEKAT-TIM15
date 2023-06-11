package xml.p1.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
}
