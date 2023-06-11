package xml.p1.dto;

import javax.xml.bind.annotation.XmlElement;

public class DostavljanjeDTO {

    @XmlElement
    private AdresaDTO adresa;

    @XmlElement
    private Boolean dostavljanje_elektronskim_putem;


    public DostavljanjeDTO() {}

    public DostavljanjeDTO(AdresaDTO adresa, Boolean dostavljanje_elektronskim_putem) {
        this.adresa = adresa;
        this.dostavljanje_elektronskim_putem = dostavljanje_elektronskim_putem;
    }


    public AdresaDTO getAdresa() {
        return this.adresa;
    }

    public void setAdresa(AdresaDTO adresa) {
        this.adresa = adresa;
    }

    public Boolean getDostavljanje_elektronskim_putem() {
        return this.dostavljanje_elektronskim_putem;
    }

    public void setDostavljanje_elektronskim_putem(Boolean dostavljanje_elektronskim_putem) {
        this.dostavljanje_elektronskim_putem = dostavljanje_elektronskim_putem;
    }
}
