package xml.p1.dto;

import xml.p1.model.TFizickoLice;
import xml.p1.model.TLice;
import xml.p1.model.TPravnoLice;
import xml.p1.model.ZahtevZaPriznanjePatenta;

import javax.xml.bind.annotation.XmlElement;

public class PodnosilacDTO {

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
    private boolean podnosilacPronalazac;


    public PodnosilacDTO() {}

    public PodnosilacDTO(AdresaDTO adresa, String brojTelefona,
                         String email, String faks, String ime,
                         String prezime, String drzavljanstvo,
                         String poslovnoIme, boolean podnosilacPronalazac) {
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.faks = faks;
        this.ime = ime;
        this.prezime = prezime;
        this.drzavljanstvo = drzavljanstvo;
        this.poslovnoIme = poslovnoIme;
        this.podnosilacPronalazac = podnosilacPronalazac;
    }

    public PodnosilacDTO(ZahtevZaPriznanjePatenta zahtev) {
        TLice podnosilac = zahtev.getPodnosilacPrijave().getPodaciOLicu();

        if (podnosilac instanceof TFizickoLice) {
            TFizickoLice fizickoLice = (TFizickoLice) podnosilac;
            this.ime = fizickoLice.getIme();
            this.prezime = fizickoLice.getPrezime();
        } else {
            TPravnoLice pravnoLice = (TPravnoLice) podnosilac;
            this.poslovnoIme = pravnoLice.getPoslovnoIme();
        }
        this.email = podnosilac.getKontakt().getEmail();
    }

    public AdresaDTO getAdresa() {
        return this.adresa;
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

    public boolean isPodnosilacPronalazac() {
        return this.podnosilacPronalazac;
    }

    public void setPodnosilacPronalazac(boolean podnosilacPronalazac) {
        this.podnosilacPronalazac = podnosilacPronalazac;
    }
}
