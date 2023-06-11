package xml.p1.dto;

import javax.xml.bind.annotation.XmlElement;

public class PredstavnikDTO {

    @XmlElement
    private AdresaDTO adresa;
    @XmlElement
    private String brojTelefona;
    @XmlElement
    private String email;
    @XmlElement
    private String faks;
    @XmlElement
    private String ime;
    @XmlElement
    private String prezime;
    @XmlElement
    private String drzavljanstvo;
    @XmlElement
    private String poslovnoIme;

    @XmlElement
    private String punomocnik;
    @XmlElement
    private Boolean zajednicki_predstavnik;


    public PredstavnikDTO() {}

    public PredstavnikDTO(AdresaDTO adresa, String brojTelefona,
                          String email, String faks, String ime,
                          String prezime, String drzavljanstvo,
                          String poslovnoIme, String punomocnik,
                          Boolean zajednicki_predstavnik) {
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.faks = faks;
        this.ime = ime;
        this.prezime = prezime;
        this.drzavljanstvo = drzavljanstvo;
        this.poslovnoIme = poslovnoIme;
        this.punomocnik = punomocnik;
        this.zajednicki_predstavnik = zajednicki_predstavnik;
    }


    public AdresaDTO getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaDTO adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return this.brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaks() {
        return this.faks;
    }

    public void setFaks(String faks) {
        this.faks = faks;
    }

    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getDrzavljanstvo() {
        return this.drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getPoslovnoIme() {
        return this.poslovnoIme;
    }

    public void setPoslovnoIme(String poslovnoIme) {
        this.poslovnoIme = poslovnoIme;
    }

    public String getPunomocnik() {
        return this.punomocnik;
    }

    public void setPunomocnik(String punomocnik) {
        this.punomocnik = punomocnik;
    }

    public Boolean getZajednicki_predstavnik() {
        return this.zajednicki_predstavnik;
    }

    public void setZajednicki_predstavnik(Boolean zajednicki_predstavnik) {
        this.zajednicki_predstavnik = zajednicki_predstavnik;
    }
}
