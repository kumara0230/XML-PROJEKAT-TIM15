package xml.a1.dto;

import javax.xml.bind.annotation.XmlElement;

public class PunomocnikDTO {

    @XmlElement
    private AdresaDTO adresaDTO;
    @XmlElement
    private String ime;
    @XmlElement
    private String prezime;

    public AdresaDTO getAdresaDTO() {
        return adresaDTO;
    }

    public void setAdresaDTO(AdresaDTO adresaDTO) {
        this.adresaDTO = adresaDTO;
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
