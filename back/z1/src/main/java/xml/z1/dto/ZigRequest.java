package xml.z1.dto;


import xml.z1.model.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
public class ZigRequest {

    @XmlElement
    private PodnosilacDTO podnosilac;

    @XmlElement
    private PunomocnikDTO punomocnik;

    @XmlElement
    private String tip_ziga;

    @XmlElement
    private String vrsta_ziga;

    @XmlElement
    private String boje;

    @XmlElement
    private String opis;

    @XmlElement
    private Integer klasa;

    @XmlElement
    private String prava;

    @XmlElement
    private String transliteracija;

    @XmlElement
    private String prevod;

    @XmlElement
    private String izgled;

    @XmlElement
    private String brojPrijave;

    @XmlElement
    private XMLGregorianCalendar datumPodnosenja;

    public ZigRequest() {

    }
    public ZigRequest(ZahtevZaPriznanjeZiga zahtev) {
        this.podnosilac = new PodnosilacDTO(zahtev);
        this.punomocnik = new PunomocnikDTO(zahtev);
        this.tip_ziga = zahtev.getPrijavaSePodnosiZa().getVrstaZiga();
        this.vrsta_ziga = zahtev.getPrijavaSePodnosiZa().getVrstaZnaka();
        this.boje = zahtev.getNaznacenjeBoje();
        this.opis = zahtev.getOpisZnaka();
        this.klasa = zahtev.getNicanskaKlasifikacija();
        this.prava = zahtev.getZatrazenoPravoPrvenstvaIOsnov();
        this.transliteracija = zahtev.getTransliteracijaZnaka();
        this.prevod = zahtev.getPrevodZnaka();
        this.brojPrijave = zahtev.getPopunjavaZavod().getBrojPrijaveZiga();
        this.datumPodnosenja = zahtev.getPopunjavaZavod().getDatumPodnosenja();
    }


    public PodnosilacDTO getPodnosilac() {
        return podnosilac;
    }

    public void setPodnosilac(PodnosilacDTO podnosilac) {
        this.podnosilac = podnosilac;
    }

    public PunomocnikDTO getPunomocnik() {
        return punomocnik;
    }

    public void setPunomocnik(PunomocnikDTO punomocnik) {
        this.punomocnik = punomocnik;
    }

    public String getTip_ziga() {
        return tip_ziga;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setTip_ziga(String tip_ziga) {
        this.tip_ziga = tip_ziga;
    }

    public String getVrsta_ziga() {
        return vrsta_ziga;
    }

    public void setVrsta_ziga(String vrsta_ziga) {
        this.vrsta_ziga = vrsta_ziga;
    }

    public String getBoje() {
        return boje;
    }

    public void setBoje(String boje) {
        this.boje = boje;
    }

    public Integer getKlasa() {
        return klasa;
    }

    public void setKlasa(Integer klasa) {
        this.klasa = klasa;
    }

    public String getPrava() {
        return prava;
    }

    public void setPrava(String prava) {
        this.prava = prava;
    }

    public String getTransliteracija() {
        return transliteracija;
    }

    public void setTransliteracija(String transliteracija) {
        this.transliteracija = transliteracija;
    }

    public String getPrevod() {
        return prevod;
    }

    public void setPrevod(String prevod) {
        this.prevod = prevod;
    }

    public String getIzgled() {
        return izgled;
    }

    public void setIzgled(String izgled) {
        this.izgled = izgled;
    }

    public String getBrojPrijave() {
        return brojPrijave;
    }

    public void setBrojPrijave(String brojPrijave) {
        this.brojPrijave = brojPrijave;
    }

    public XMLGregorianCalendar getDatumPodnosenja() {
        return datumPodnosenja;
    }

    public void setDatumPodnosenja(XMLGregorianCalendar datumPodnosenja) {
        this.datumPodnosenja = datumPodnosenja;
    }
}
