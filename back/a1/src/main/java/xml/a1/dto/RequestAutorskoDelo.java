package xml.a1.dto;

import org.junit.runner.Request;
import xml.a1.model.Zahtev;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
public class RequestAutorskoDelo {

    @XmlElement
    private PodnosilacDTO podnosilac;

    @XmlElement
    private AutorDTO autor;

    @XmlElement
    private PunomocnikDTO punomocnik;

    @XmlElement
    private DeloDTO delo;

    @XmlElement
    private XMLGregorianCalendar datumPodnosenja;

    @XmlElement
    private String brojPrijave;

    public RequestAutorskoDelo(Zahtev zahtev) {
        this.podnosilac = new PodnosilacDTO(zahtev);
        if (zahtev.getAutor() != null) this.autor = new AutorDTO(zahtev.getAutor());
        if (zahtev.getPunomocnik() != null) this.punomocnik = new PunomocnikDTO(zahtev.getPunomocnik());
        this.delo = new DeloDTO(zahtev.getDelo());
        this.datumPodnosenja = zahtev.getPopunjavaZavod().getDatumPodnosenja();
        this.brojPrijave = zahtev.getPopunjavaZavod().getBrojPrijave();
    }

    public RequestAutorskoDelo() {}
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

    public PodnosilacDTO getPodnosilac() {
        return podnosilac;
    }

    public void setPodnosilac(PodnosilacDTO podnosilac) {
        this.podnosilac = podnosilac;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    public PunomocnikDTO getPunomocnik() {
        return punomocnik;
    }

    public void setPunomocnik(PunomocnikDTO punomocnik) {
        this.punomocnik = punomocnik;
    }

    public DeloDTO getDelo() {
        return delo;
    }

    public void setDelo(DeloDTO delo) {
        this.delo = delo;
    }
}
