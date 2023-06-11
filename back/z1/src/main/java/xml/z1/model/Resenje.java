package xml.z1.model;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "brojResenja",
        "datumResenja",
        "imeSluzbenika",
        "prezimeSluzbenika",
        "emailPodnosioca",
        "brojZahteva",
        "odobreno",
        "sifra",
        "obrazlozenje"
})
@XmlRootElement(name = "Resenje")
public class Resenje {

    @XmlElement(name = "Broj_resenja", required = true)
    protected String brojResenja;
    @XmlElement(name = "Datum_resenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumResenja;
    @XmlElement(name = "odobreno")
    protected boolean odobreno;
    protected String sifra;
    protected String obrazlozenje;
    @XmlElement(name = "Broj_zahteva", required = true)
    protected String brojZahteva;
    @XmlElement(name = "Ime_sluzbenika", required = true)
    protected String imeSluzbenika;
    @XmlElement(name = "Prezime_sluzbenika", required = true)
    protected String prezimeSluzbenika;

    @XmlElement(name = "Email_podnosioca", required = true)
    protected String emailPodnosioca;

    public String getEmailPodnosioca() {
        return emailPodnosioca;
    }

    public void setEmailPodnosioca(String emailPodnosioca) {
        this.emailPodnosioca = emailPodnosioca;
    }

    public String getBrojResenja() {
        return brojResenja;
    }

    public void setBrojResenja(String brojResenja) {
        this.brojResenja = brojResenja;
    }

    /**
     * Gets the value of the datumResenja property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDatumResenja() {
        return datumResenja;
    }

    /**
     * Sets the value of the datumResenja property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDatumResenja(XMLGregorianCalendar value) {
        this.datumResenja = value;
    }

    /**
     * Gets the value of the odobreno property.
     */
    public boolean isOdobreno() {
        return odobreno;
    }

    /**
     * Sets the value of the odobreno property.
     */
    public void setOdobreno(boolean value) {
        this.odobreno = value;
    }

    /**
     * Gets the value of the sifra property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSifra(String value) {
        this.sifra = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setObrazlozenje(String value) {
        this.obrazlozenje = value;
    }

    /**
     * Gets the value of the brojZahteva property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrojZahteva() {
        return brojZahteva;
    }

    /**
     * Sets the value of the brojZahteva property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrojZahteva(String value) {
        this.brojZahteva = value;
    }

    public String getImeSluzbenika() {
        return imeSluzbenika;
    }

    public void setImeSluzbenika(String imeSluzbenika) {
        this.imeSluzbenika = imeSluzbenika;
    }

    public String getPrezimeSluzbenika() {
        return prezimeSluzbenika;
    }

    public void setPrezimeSluzbenika(String prezimeSluzbenika) {
        this.prezimeSluzbenika = prezimeSluzbenika;
    }
}
