<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:z1="http://www.ftn.uns.ac.rs/z1"
                xmlns:pred="http://www.ftn.uns.ac.rs/z1/pred/"
>
    <xsl:template match="/">
        <rdf:RDF>
            <xsl:apply-templates />
        </rdf:RDF>
    </xsl:template>

    <xsl:template match="z1:Zahtev_za_priznanje_ziga">
        <rdf:Description rdf:about="http://www.ftn.uns.ac.rs/a1/{./z1:Popunjava_zavod/z1:Broj_prijave_ziga}">
            <pred:Broj_prijave>
                <xsl:value-of select="./z1:Popunjava_zavod/z1:Broj_prijave_ziga"/>
            </pred:Broj_prijave>
            <pred:Datum_podnosenja>
                <xsl:value-of select="./z1:Popunjava_zavod/z1:Datum_podnosenja"/>
            </pred:Datum_podnosenja>
            <pred:EmailPodnosioca>
                <xsl:value-of select="./z1:Podaci_o_podnosiocu_prijave/z1:Kontakt/z1:Email"/>
            </pred:EmailPodnosioca>
            <pred:Vrsta_ziga>
                <xsl:value-of select="./z1:Prijava_se_podnosi_za/z1:Vrsta_ziga"/>
            </pred:Vrsta_ziga>
            <pred:Vrsta_znaka>
                <xsl:value-of select="./z1:Prijava_se_podnosi_za/z1:Vrsta_znaka"/>
            </pred:Vrsta_znaka>
            <pred:Nicanska_klasifikacija>
                <xsl:value-of select="./z1:Nicanska_klasifikacija"/>
            </pred:Nicanska_klasifikacija>
        </rdf:Description>
    </xsl:template>

</xsl:stylesheet>