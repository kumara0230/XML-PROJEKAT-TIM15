package xml.users.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "email",
        "lozinka",
        "ime",
        "prezime",
        "isSluzbenik"
})
@XmlRootElement(name = "korisnik")
public class Korisnik {

    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String lozinka;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    @XmlElement(required = true)
    protected boolean isSluzbenik;

    /**
     * Gets the value of the email property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the lozinka property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * Sets the value of the lozinka property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLozinka(String value) {
        this.lozinka = value;
    }

    /**
     * Gets the value of the ime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the isSluzbenik property.
     */
    public boolean isSluzbenik() {
        return isSluzbenik;
    }

    /**
     * Sets the value of the isSluzbenik property.
     */
    public void setIsSluzbenik(boolean value) {
        this.isSluzbenik = value;
    }
}
