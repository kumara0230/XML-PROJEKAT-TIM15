package xml.a1.dto;


import xml.a1.model.Delo;

import javax.xml.bind.annotation.XmlElement;

public class DeloDTO {

    @XmlElement
    private String naslov;
    @XmlElement
    private String vrsta;
    @XmlElement
    private String formaZapisa;
    @XmlElement
    private String alternativniNaziv;
    @XmlElement
    private boolean deloStvorenoURadnomOdnosu;
    @XmlElement
    private String nacinKoriscenjaDela;
    @XmlElement
    private DeloPreradeDTO deloPrerade;
    public DeloDTO() {}
    public DeloDTO(Delo delo) {
        this.naslov = delo.getNaslovDela();
        this.vrsta = delo.getVrstaAutorskogDela();
        this.formaZapisa = delo.getFormaZapisa();
        this.deloStvorenoURadnomOdnosu = delo.isDeloStvorenoURadnomOdnosu();
        this.nacinKoriscenjaDela = delo.getNacinKoriscenjaDela();

        if (delo.getAlternativniNaslov() != null)
            this.alternativniNaziv = delo.getAlternativniNaslov();

        if (delo.getDeloPrerade() != null)
            this.deloPrerade = new DeloPreradeDTO(delo.getDeloPrerade());

    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getFormaZapisa() {
        return formaZapisa;
    }

    public void setFormaZapisa(String formaZapisa) {
        this.formaZapisa = formaZapisa;
    }

    public String getAlternativniNaziv() {
        return alternativniNaziv;
    }

    public void setAlternativniNaziv(String alternativniNaziv) {
        this.alternativniNaziv = alternativniNaziv;
    }

    public boolean isDeloStvorenoURadnomOdnosu() {
        return deloStvorenoURadnomOdnosu;
    }

    public void setDeloStvorenoURadnomOdnosu(boolean deloStvorenoURadnomOdnosu) {
        this.deloStvorenoURadnomOdnosu = deloStvorenoURadnomOdnosu;
    }

    public String getNacinKoriscenjaDela() {
        return nacinKoriscenjaDela;
    }

    public void setNacinKoriscenjaDela(String nacinKoriscenjaDela) {
        this.nacinKoriscenjaDela = nacinKoriscenjaDela;
    }

    public DeloPreradeDTO getDeloPrerade() {
        return deloPrerade;
    }

    public void setDeloPrerade(DeloPreradeDTO deloPrerade) {
        this.deloPrerade = deloPrerade;
    }
}
