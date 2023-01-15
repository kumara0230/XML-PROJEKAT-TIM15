<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:p1="http://ftn.uns.ac.rs/p1"
                xmlns:pred="http://www.ftn.uns.ac.rs/p1/pred/"
>
    <xsl:template match="/">
        <rdf:RDF>
            <xsl:apply-templates />
        </rdf:RDF>
    </xsl:template>

    <xsl:template match="p1:Zahtev_za_priznanje_patenta">
        <rdf:Description rdf:about="http://www.ftn.uns.ac.rs/p1/{./p1:Popunjava_zavod/p1:Broj_prijave}">
            <pred:Broj_prijave>
                <xsl:value-of select="./p1:Popunjava_zavod/p1:Broj_prijave"/>
            </pred:Broj_prijave>
            <pred:Datum_prijema>
                <xsl:value-of select="./p1:Popunjava_zavod/p1:Datum_prijema"/>
            </pred:Datum_prijema>
            <pred:EmailPodnosioca>
                <xsl:value-of select="./p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Kontakt/p1:Email"/>
            </pred:EmailPodnosioca>
            <pred:Naziv_pronalaska_na_srpskom>
                <xsl:value-of select="./p1:Naziv_pronalaska/p1:Naziv_pronalaska_na_srpskom"/>
            </pred:Naziv_pronalaska_na_srpskom>
            <pred:Naziv_pronalaska_na_engleskom>
                <xsl:value-of select="./p1:Naziv_pronalaska/p1:Naziv_pronalaska_na_engleskom"/>
            </pred:Naziv_pronalaska_na_engleskom>
            <pred:Dostavljanje_elektronskim_putem>
                <xsl:value-of select="./p1:Dostavljanje/p1:Dostavljanje_elektronskim_putem"/>
            </pred:Dostavljanje_elektronskim_putem>
        </rdf:Description>
    </xsl:template>

</xsl:stylesheet>