package xml.z1.dto;

import xml.z1.model.TFizickoLice;
import xml.z1.model.TLice;
import xml.z1.model.TPravnoLice;
import xml.z1.model.ZahtevZaPriznanjeZiga;

import javax.xml.bind.annotation.XmlElement;

public class PunomocnikDTO {

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

    public PunomocnikDTO() {

    }

    public PunomocnikDTO(ZahtevZaPriznanjeZiga zahtev) {
        TLice punomocnik = zahtev.getPodaciOPunomocniku();

        if (punomocnik instanceof TFizickoLice) {
            TFizickoLice fizickoLice = (TFizickoLice) punomocnik;
            this.ime = fizickoLice.getIme();
            this.prezime = fizickoLice.getPrezime();
        } else {
            TPravnoLice pravnoLice = (TPravnoLice) punomocnik;
            this.poslovnoIme = pravnoLice.getPoslovnoIme();
        }
        this.email = zahtev.getPodaciOPunomocniku().getKontakt().getEmail();

    }

    public AdresaDTO getAdresa() {
        return adresa;
    }

    public void setAdresa(AdresaDTO adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaks() {
        return faks;
    }

    public void setFaks(String faks) {
        this.faks = faks;
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

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getPoslovnoIme() {
        return poslovnoIme;
    }

    public void setPoslovnoIme(String poslovnoIme) {
        this.poslovnoIme = poslovnoIme;
    }
}
