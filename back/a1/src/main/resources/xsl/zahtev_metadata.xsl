<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:a1="http://www.ftn.uns.ac.rs/a1"
                xmlns:pred="http://www.ftn.uns.ac.rs/a1/pred/"
>
    <xsl:template match="/">
        <rdf:RDF>
            <xsl:apply-templates />
        </rdf:RDF>
    </xsl:template>

    <xsl:template match="a1:Zahtev">
        <rdf:Description rdf:about="http://www.ftn.uns.ac.rs/a1/{./a1:Popunjava_zavod/a1:Broj_prijave}">
            <pred:Broj_prijave>
                <xsl:value-of select="./a1:Popunjava_zavod/a1:Broj_prijave"/>
            </pred:Broj_prijave>
            <pred:Datum_podnosenja>
                <xsl:value-of select="./a1:Popunjava_zavod/a1:Datum_podnosenja"/>
            </pred:Datum_podnosenja>
            <pred:EmailPodnosioca>
                <xsl:value-of select="./a1:Podnosilac/a1:Email"/>
            </pred:EmailPodnosioca>
            <pred:Naslov_dela>
                <xsl:value-of select="./a1:Delo/a1:Naslov_dela"/>
            </pred:Naslov_dela>
            <pred:Vrsta_dela>
                <xsl:value-of select="./a1:Delo/a1:Vrsta_autorskog_dela"/>
            </pred:Vrsta_dela>
        </rdf:Description>
    </xsl:template>

</xsl:stylesheet>