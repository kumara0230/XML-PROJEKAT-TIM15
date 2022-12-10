//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.10 at 09:05:51 PM CET 
//


package xml.p1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="Broj_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Datum_prijema" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Priznati_datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "brojPrijave",
    "datumPrijema",
    "priznatiDatumPodnosenja"
})
@XmlRootElement(name = "Popunjava_zavod")
public class PopunjavaZavod {

    @XmlElement(name = "Broj_prijave", required = true)
    protected String brojPrijave;
    @XmlElement(name = "Datum_prijema", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPrijema;
    @XmlElement(name = "Priznati_datum_podnosenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar priznatiDatumPodnosenja;

    /**
     * Gets the value of the brojPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojPrijave() {
        return brojPrijave;
    }

    /**
     * Sets the value of the brojPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojPrijave(String value) {
        this.brojPrijave = value;
    }

    /**
     * Gets the value of the datumPrijema property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPrijema() {
        return datumPrijema;
    }

    /**
     * Sets the value of the datumPrijema property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPrijema(XMLGregorianCalendar value) {
        this.datumPrijema = value;
    }

    /**
     * Gets the value of the priznatiDatumPodnosenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPriznatiDatumPodnosenja() {
        return priznatiDatumPodnosenja;
    }

    /**
     * Sets the value of the priznatiDatumPodnosenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPriznatiDatumPodnosenja(XMLGregorianCalendar value) {
        this.priznatiDatumPodnosenja = value;
    }

}
