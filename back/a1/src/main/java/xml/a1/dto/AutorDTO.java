package xml.a1.dto;

import xml.a1.model.Autor;

import javax.xml.bind.annotation.XmlElement;

public class AutorDTO {
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
    private String pseudonim;
    @XmlElement
    private String godinaSmrti;
    @XmlElement
    private boolean autorAnoniman;

    public AutorDTO(){}

    public AutorDTO(Autor autor) {
        if (autor.getPseudonimAutora() != null) {
            this.pseudonim = autor.getPseudonimAutora();
        }
        if (autor.getLice() != null && autor.getLice().getIme() != null) {
            this.ime = autor.getLice().getIme();
        }
        // ...
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

    public boolean isAutorAnoniman() {
        return autorAnoniman;
    }

    public void setAutorAnoniman(boolean autorAnoniman) {
        this.autorAnoniman = autorAnoniman;
    }
}
