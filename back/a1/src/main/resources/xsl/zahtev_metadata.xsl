<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:a1="http://www.ftn.uns.ac.rs/a1"
                xmlns="http://www.ftn.uns.ac.rs/a1"
                xmlns:pred="http://www.ftn.uns.ac.rs/a1/pred/"
>
    <xsl:template match="/">
        <rdf:RDF>
            <rdf:Description rdf:about="Zahtev">
                <xsl:variable name="broj_prijave">
                    <xsl:value-of select="//Popunjava_zavod/Broj_prijave"/>
                </xsl:variable>
                <xsl:variable name="datum_podnosenja">
                    <xsl:value-of select="//Popunjava_zavod/Datum_podnosenja"/>
                </xsl:variable>
                <xsl:variable name="email_podnosioca">
                    <xsl:value-of select="//Podnosilac/Email"/>
                </xsl:variable>
                <xsl:variable name="ime_podnosioca">
                    <xsl:value-of select="//Podnosilac/Ime"/>
                </xsl:variable>
                <xsl:variable name="prezime_podnosioca">
                    <xsl:value-of select="//Podnosilac/Prezime"/>
                </xsl:variable>
                <xsl:variable name="poslovno_ime_podnosioca">
                    <xsl:value-of select="//Podnosilac/poslovno_ime"/>
                </xsl:variable>
                <xsl:variable name="naslov_dela">
                    <xsl:value-of select="//Delo/Naslov_dela"/>
                </xsl:variable>
                <xsl:variable name="vrsta_dela">
                    <xsl:value-of select="//Delo/Vrsta_autorskog_dela"/>
                </xsl:variable>


                <a1:broj_prijave>
                    <xsl:value-of select="$broj_prijave"/>
                </a1:broj_prijave>
                <a1:datum_podnosenja>
                    <xsl:value-of select="$datum_podnosenja"/>
                </a1:datum_podnosenja>
                <a1:email_podnosioca>
                    <xsl:value-of select="$email_podnosioca"/>
                </a1:email_podnosioca>

                <xsl:choose>
                    <xsl:when test="$ime_podnosioca">
                        <a1:ime_podnosioca>
                            <xsl:value-of select="$ime_podnosioca"/>
                        </a1:ime_podnosioca>
                        <a1:prezime_podnosioca>
                            <xsl:value-of select="$prezime_podnosioca"/>
                        </a1:prezime_podnosioca>
                    </xsl:when>
                    <xsl:otherwise>
                        <a1:poslovno_ime_podnosioca>
                            <xsl:value-of select="$poslovno_ime_podnosioca"/>
                        </a1:poslovno_ime_podnosioca>
                    </xsl:otherwise>
                </xsl:choose>

                <a1:naslov_dela>
                    <xsl:value-of select="$naslov_dela"/>
                </a1:naslov_dela>
                <a1:vrsta_dela>
                    <xsl:value-of select="$vrsta_dela"/>
                </a1:vrsta_dela>
            </rdf:Description>
        </rdf:RDF>
    </xsl:template>
</xsl:stylesheet>