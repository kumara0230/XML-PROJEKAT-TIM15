package xml.a1.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
