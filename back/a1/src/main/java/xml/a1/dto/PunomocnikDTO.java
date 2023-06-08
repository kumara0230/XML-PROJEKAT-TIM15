package xml.a1.dto;

import javax.xml.bind.annotation.XmlElement;

public class PunomocnikDTO {

    @XmlElement
    private AdresaDTO adresa;
    @XmlElement
    private String ime;
    @XmlElement
    private String prezime;

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
