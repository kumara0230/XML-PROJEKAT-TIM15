package xml.a1.dto;

import javax.xml.bind.annotation.XmlElement;

public class PodnosilacDTO {

    @XmlElement
    private AdresaDTO adresaDTO;
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
    private boolean podnosilacAutor;

    public PodnosilacDTO() {

    }

    public AdresaDTO getAdresaDTO() {
        return adresaDTO;
    }

    public void setAdresaDTO(AdresaDTO adresaDTO) {
        this.adresaDTO = adresaDTO;
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

    public boolean isPodnosilacAutor() {
        return podnosilacAutor;
    }

    public void setPodnosilacAutor(boolean podnosilacAutor) {
        this.podnosilacAutor = podnosilacAutor;
    }
}
