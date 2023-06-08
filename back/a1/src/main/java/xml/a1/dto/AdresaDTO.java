package xml.a1.dto;

import xml.a1.model.Adresa;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigInteger;

public class AdresaDTO {
    @XmlElement
    private String ulica;
    @XmlElement
    private BigInteger broj;
    @XmlElement
    private String mesto;
    @XmlElement
    private int postanskiBroj;

    public AdresaDTO() {}
    public AdresaDTO(Adresa adresa) {
        this.ulica = adresa.getUlica();
        this.broj = adresa.getBroj();
        this.mesto = adresa.getMesto();
        this.postanskiBroj = adresa.getPostanskiBroj();
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }
}
