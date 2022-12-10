//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.10 at 10:07:27 PM CET 
//


package xml.z1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Primerak_znaka">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Spisak_robe_i_usluga">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Punomocje">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Generalno_punomocje_ranije_prilozeno">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Punomocje_ce_biti_naknadno_dostavljeno">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Opsti_akt_o_kolektivnom_zigu_garancije">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Dokaz_o_pravu_prvenstva">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Dokaz_o_uplati_takse">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "primerakZnaka",
    "spisakRobeIUsluga",
    "punomocje",
    "generalnoPunomocjeRanijePrilozeno",
    "punomocjeCeBitiNaknadnoDostavljeno",
    "opstiAktOKolektivnomZiguGarancije",
    "dokazOPravuPrvenstva",
    "dokazOUplatiTakse"
})
@XmlRootElement(name = "Priklozi_uz_zahtev")
public class PrikloziUzZahtev {

    @XmlElement(name = "Primerak_znaka", defaultValue = "false")
    protected boolean primerakZnaka;
    @XmlElement(name = "Spisak_robe_i_usluga", defaultValue = "false")
    protected boolean spisakRobeIUsluga;
    @XmlElement(name = "Punomocje", defaultValue = "false")
    protected boolean punomocje;
    @XmlElement(name = "Generalno_punomocje_ranije_prilozeno", defaultValue = "false")
    protected boolean generalnoPunomocjeRanijePrilozeno;
    @XmlElement(name = "Punomocje_ce_biti_naknadno_dostavljeno", defaultValue = "false")
    protected boolean punomocjeCeBitiNaknadnoDostavljeno;
    @XmlElement(name = "Opsti_akt_o_kolektivnom_zigu_garancije", defaultValue = "false")
    protected boolean opstiAktOKolektivnomZiguGarancije;
    @XmlElement(name = "Dokaz_o_pravu_prvenstva", defaultValue = "false")
    protected boolean dokazOPravuPrvenstva;
    @XmlElement(name = "Dokaz_o_uplati_takse", defaultValue = "false")
    protected boolean dokazOUplatiTakse;

    /**
     * Gets the value of the primerakZnaka property.
     * 
     */
    public boolean isPrimerakZnaka() {
        return primerakZnaka;
    }

    /**
     * Sets the value of the primerakZnaka property.
     * 
     */
    public void setPrimerakZnaka(boolean value) {
        this.primerakZnaka = value;
    }

    /**
     * Gets the value of the spisakRobeIUsluga property.
     * 
     */
    public boolean isSpisakRobeIUsluga() {
        return spisakRobeIUsluga;
    }

    /**
     * Sets the value of the spisakRobeIUsluga property.
     * 
     */
    public void setSpisakRobeIUsluga(boolean value) {
        this.spisakRobeIUsluga = value;
    }

    /**
     * Gets the value of the punomocje property.
     * 
     */
    public boolean isPunomocje() {
        return punomocje;
    }

    /**
     * Sets the value of the punomocje property.
     * 
     */
    public void setPunomocje(boolean value) {
        this.punomocje = value;
    }

    /**
     * Gets the value of the generalnoPunomocjeRanijePrilozeno property.
     * 
     */
    public boolean isGeneralnoPunomocjeRanijePrilozeno() {
        return generalnoPunomocjeRanijePrilozeno;
    }

    /**
     * Sets the value of the generalnoPunomocjeRanijePrilozeno property.
     * 
     */
    public void setGeneralnoPunomocjeRanijePrilozeno(boolean value) {
        this.generalnoPunomocjeRanijePrilozeno = value;
    }

    /**
     * Gets the value of the punomocjeCeBitiNaknadnoDostavljeno property.
     * 
     */
    public boolean isPunomocjeCeBitiNaknadnoDostavljeno() {
        return punomocjeCeBitiNaknadnoDostavljeno;
    }

    /**
     * Sets the value of the punomocjeCeBitiNaknadnoDostavljeno property.
     * 
     */
    public void setPunomocjeCeBitiNaknadnoDostavljeno(boolean value) {
        this.punomocjeCeBitiNaknadnoDostavljeno = value;
    }

    /**
     * Gets the value of the opstiAktOKolektivnomZiguGarancije property.
     * 
     */
    public boolean isOpstiAktOKolektivnomZiguGarancije() {
        return opstiAktOKolektivnomZiguGarancije;
    }

    /**
     * Sets the value of the opstiAktOKolektivnomZiguGarancije property.
     * 
     */
    public void setOpstiAktOKolektivnomZiguGarancije(boolean value) {
        this.opstiAktOKolektivnomZiguGarancije = value;
    }

    /**
     * Gets the value of the dokazOPravuPrvenstva property.
     * 
     */
    public boolean isDokazOPravuPrvenstva() {
        return dokazOPravuPrvenstva;
    }

    /**
     * Sets the value of the dokazOPravuPrvenstva property.
     * 
     */
    public void setDokazOPravuPrvenstva(boolean value) {
        this.dokazOPravuPrvenstva = value;
    }

    /**
     * Gets the value of the dokazOUplatiTakse property.
     * 
     */
    public boolean isDokazOUplatiTakse() {
        return dokazOUplatiTakse;
    }

    /**
     * Sets the value of the dokazOUplatiTakse property.
     * 
     */
    public void setDokazOUplatiTakse(boolean value) {
        this.dokazOUplatiTakse = value;
    }

}
