package xml.a1.dto;

import javax.xml.bind.annotation.XmlElement;

public class DeloPreradeDTO {

    @XmlElement
    private String naslovIzvornogDela;
    @XmlElement
    private String ime;
    @XmlElement
    private String prezime;
    @XmlElement
    private String pseudonim;
    @XmlElement
    private String godinaSmrti;

    public String getNaslovIzvornogDela() {
        return naslovIzvornogDela;
    }

    public void setNaslovIzvornogDela(String naslovIzvornogDela) {
        this.naslovIzvornogDela = naslovIzvornogDela;
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

    public String getPseudonim() {
        return pseudonim;
    }

    public void setPseudonim(String pseudonim) {
        this.pseudonim = pseudonim;
    }

    public String getGodinaSmrti() {
        return godinaSmrti;
    }

    public void setGodinaSmrti(String godinaSmrti) {
        this.godinaSmrti = godinaSmrti;
    }
}
