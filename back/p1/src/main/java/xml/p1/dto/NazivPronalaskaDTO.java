package xml.p1.dto;

import javax.xml.bind.annotation.XmlElement;

public class NazivPronalaskaDTO {

    @XmlElement
    private String nazivNaSrpskom;

    @XmlElement
    private String nazivNaEngleskom;


    public NazivPronalaskaDTO() {}

    public NazivPronalaskaDTO(String nazivNaSrpskom, String nazivNaEngleskom) {
        this.nazivNaSrpskom = nazivNaSrpskom;
        this.nazivNaEngleskom = nazivNaEngleskom;
    }

    public String getNazivNaSrpskom() {
        return this.nazivNaSrpskom;
    }

    public void setNazivNaSrpskom(String nazivNaSrpskom) {
        this.nazivNaSrpskom = nazivNaSrpskom;
    }

    public String getNazivNaEngleskom() {
        return this.nazivNaEngleskom;
    }

    public void setNazivNaEngleskom(String nazivNaEngleskom) {
        this.nazivNaEngleskom = nazivNaEngleskom;
    }
}
