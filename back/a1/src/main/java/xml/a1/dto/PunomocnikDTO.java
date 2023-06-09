package xml.a1.dto;

import xml.a1.model.Punomocnik;

import javax.xml.bind.annotation.XmlElement;

public class PunomocnikDTO {

    @XmlElement
    private AdresaDTO adresa;
    @XmlElement
    private String ime;
    @XmlElement
    private String prezime;

    public PunomocnikDTO() {}
    public PunomocnikDTO(Punomocnik punomocnik) {
        this.adresa = new AdresaDTO(punomocnik.getAdresa());
        this.ime = punomocnik.getIme();
        this.prezime = punomocnik.getPrezime();
    }

    public AdresaDTO getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaDTO adresa) {
        this.adresa = adresa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
