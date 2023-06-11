<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:pred="http://www.ftn.uns.ac.rs/z1/pred/"
>
    <xsl:template match="/">
        <rdf:RDF>
            <xsl:apply-templates />
        </rdf:RDF>
    </xsl:template>

    <xsl:template match="Zahtev_za_priznanje_ziga">
        <rdf:Description rdf:about="http://www.ftn.uns.ac.rs/z1/{./Popunjava_zavod/Broj_prijave_ziga}">
            <pred:Broj_prijave>
                <xsl:value-of select="./Popunjava_zavod/Broj_prijave_ziga"/>
            </pred:Broj_prijave>
            <pred:Datum_podnosenja>
                <xsl:value-of select="./Popunjava_zavod/Datum_podnosenja"/>
            </pred:Datum_podnosenja>
            <pred:EmailPodnosioca>
                <xsl:value-of select="./Podaci_o_podnosiocu_prijave/Kontakt/Email"/>
            </pred:EmailPodnosioca>
            <pred:Vrsta_ziga>
                <xsl:value-of select="./Prijava_se_podnosi_za/Vrsta_ziga"/>
            </pred:Vrsta_ziga>
            <pred:Vrsta_znaka>
                <xsl:value-of select="./Prijava_se_podnosi_za/Vrsta_znaka"/>
            </pred:Vrsta_znaka>
            <pred:Nicanska_klasifikacija>
                <xsl:value-of select="./Nicanska_klasifikacija"/>
            </pred:Nicanska_klasifikacija>
        </rdf:Description>
    </xsl:template>

</xsl:stylesheet>