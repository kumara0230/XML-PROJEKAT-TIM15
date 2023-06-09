<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:a1ns="a1ns"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#"
                xmlns:pred="http://www.ftn.uns.ac.rs/a1/pred/"
                exclude-result-prefixes="a1ns">

    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <rdf:RDF>
            <xsl:apply-templates select="//Zahtev"/>
        </rdf:RDF>
    </xsl:template>

    <xsl:template match="Zahtev">
        <rdf:Description rdf:about="http://www.ftn.uns.ac.rs/a1/{Popunjava_zavod/Broj_prijave}">
            <pred:Broj_prijave>
                <xsl:value-of select="Popunjava_zavod/Broj_prijave"/>
            </pred:Broj_prijave>
            <pred:Datum_podnosenja>
                <xsl:value-of select="Popunjava_zavod/Datum_podnosenja"/>
            </pred:Datum_podnosenja>
            <pred:EmailPodnosioca>
                <xsl:value-of select="Podnosilac/Kontakt/Email"/>
            </pred:EmailPodnosioca>
            <pred:Naslov_dela>
                <xsl:value-of select="Delo/Naslov_dela"/>
            </pred:Naslov_dela>
            <pred:Vrsta_dela>
                <xsl:value-of select="Delo/Vrsta_autorskog_dela"/>
            </pred:Vrsta_dela>
        </rdf:Description>
    </xsl:template>
</xsl:stylesheet>
