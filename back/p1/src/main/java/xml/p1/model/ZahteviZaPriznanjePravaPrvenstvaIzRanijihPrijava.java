//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.10 at 09:05:51 PM CET 
//


package xml.p1.model;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{p1ns}Zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava" maxOccurs="unbounded" minOccurs="0"/>
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
    "zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava"
})
@XmlRootElement(name = "Zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava")
public class ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava {

    @XmlElement(name = "Zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava")
    protected List<ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava> zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava;

    /**
     * Gets the value of the zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava }
     * 
     * 
     */
    public List<ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava> getZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava() {
        if (zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava == null) {
            zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava = new ArrayList<ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava>();
        }
        return this.zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava;
    }

    public void setZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava(List<ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava> zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava) {
        this.zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava = zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava;
    }
}
