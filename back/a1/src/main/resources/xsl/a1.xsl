<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:a1="http://www.ftn.uns.ac.rs/a1" version="2.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>

    <xsl:template match="/">
        <html>
            <style>
                body {
                border: 2px solid black;
                }
                h1, h2 {
                text-align: center;
                }
                .box {
                border-bottom: 2px solid black;
                padding: 1%;
                }
                .section1 {
                padding: 1%;
                }
                .item {
                margin-bottom: 40px;
                }
                .answer {
                color: navy;
                }
            </style>
            <body>
                <div class="box">
                    <strong>ZAVOD ZA INTELEKTUALNU SVOJINU - OBRAZAC A-1</strong>
                    <br/>
                    Beograd, Kneginje Ljubice 5
                    <br/>
                    <h1>
                        ZAHTEV ZA UNOŠENJE U EVIDENCIJU I DEPONOVANjE AUTORSKIH DELA
                    </h1>
                </div>

                <div class="section1">
                    <div class="item">
                        1) Podnosilac - ime, prezime, adresa i drzavljanstvo autora ili drugog nosioca autorskog prava
                        ako je podnosilac fizičko lice, odnosno poslovno ime i sedište nosioca autorskog prava ako je
                        podnosilac pravno lice*:
                        <table>
                            <tbody>
                                <tr>
                                    <td class="answer">
                                        <xsl:value-of select="//a1:Podnosilac/a1:Ime"/>
                                    </td>
                                    <xsl:choose>
                                        <xsl:when test="//a1:Podnosilac/a1:sediste">
                                            <td class="answer">
                                                <xsl:value-of select="//a1:Podnosilac/a1:sediste"/>
                                            </td>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <td class="answer">
                                                <xsl:value-of select="//a1:Podnosilac/a1:prezime"/>
                                            </td>
                                            <td class="answer">
                                                <xsl:value-of select="//a1:Podnosilac/a1:drzavljanstvo"/>
                                            </td>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                    <td class="answer">
                                        <xsl:value-of select="//a1:Podnosilac/a1:telefon"/>
                                    </td>
                                    <td class="answer">
                                        <xsl:value-of select="//a1:Podnosilac/a1:email"/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="item">
                        3) Ime, prezime i adresa punomocnika, ako se prijava podnosi preko punomoćnika:
                        <p class="answer">
                            <xsl:choose>
                                <xsl:when test="//a1:Punomocnik/a1:ime">
                                    <xsl:value-of select="//a1:Podnosilac/a1:ime"/>
                                    <xsl:text> </xsl:text>
                                    <xsl:value-of select="//a1:Podnosilac/a1:prezime"/>
                                    <xsl:text>, </xsl:text>
                                    <xsl:value-of select="//a1:Podnosilac/a1:adresa"/>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:text>Nema punomoćnika</xsl:text>
                                </xsl:otherwise>
                            </xsl:choose>
                        </p>
                    </div>
                    <div class="item">
                        2) Pseudonim ili znak autora, (ako ga ima):
                        <p class="answer">
                            <xsl:choose>
                                <xsl:when test="//a1:Podnosilac/a1:pseudonim">
                                    <xsl:value-of select="//a1:Podnosilac/a1:pseudonim"/>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:text>Nema pseudonima</xsl:text>
                                </xsl:otherwise>
                            </xsl:choose>
                        </p>
                    </div>
                    <div class="item">
                        4) Naslov autorskog dela, odnosno alternativni naslov, ako ga ima, po kome autorsko delo može da
                        se identifikuje*:
                        <p class="answer">
                            <xsl:value-of select="//a1:Delo/a1:naslov"/>
                        </p>
                        <p class="answer">
                            <xsl:value-of select="//a1:Delo/a1:alternativni_naslov"/>
                        </p>
                    </div>
                    <div class="item">
                        5) Podaci o naslovu autorskog dela na kome se zasniva delo prerade, ako je u pitanju autorsko
                        delo prerade, kao i podatak o autoru izvornog dela:

                    </div>
                    <div class="item">
                        6) Podaci o vrsti autorskog dela (književno delo, muzičko delo, likovno delo, računarski program
                        i dr.) *:
                        <p class="answer">
                            <xsl:value-of select="//a1:Delo/a1:vrsta_dela"/>
                        </p>
                    </div>
                    <div class="item">
                        7) Podaci o formi zapisa autorskog dela (štampani tekst, optički disk i slično) *:
                        <p class="answer">
                            <xsl:value-of select="//a1:Delo/a1:forma_zapisa"/>
                        </p>
                    </div>
                    <div class="item">
                        8) Podaci o autoru ako podnosilac prijave iz tačke 1. ovog zahteva nije autor i to: prezime,
                        ime, adresa i državljanstvo autora (grupe autora ili koautora), a ako su u pitanju jedan ili
                        više autora koji nisu živi, imena autora i godine smrti autora a ako je u pitanju autorsko delo
                        anonimnog autora navod da je autorsko delo delo anonimnog autora:
                    </div>
                    <div class="item">
                        9) Podatak da li je u pitanju autorsko delo stvoreno u radnom odnosu:
                        <p class="answer">
                            <xsl:choose>
                                <xsl:when test="//a1:Delo/a1:radni_odnos">
                                    <xsl:text>Zasnovano je u radnom odnosu</xsl:text>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:text>Nije zasnovano u random odnosu</xsl:text>
                                </xsl:otherwise>
                            </xsl:choose>
                        </p>
                    </div>
                    <div class="item">
                        10) Način korišćenja autorskog dela ili nameravani način korišćenja autorskog dela:
                        <p class="answer">
                            <xsl:value-of select="//a1:Delo/a1:nacin_koriscenja"/>
                        </p>
                    </div>
                </div>
                <h2>
                    POPUNjAVA ZAVOD:
                </h2>
                <div class="section1">
                    <strong>Prilozi uz prijavu:</strong>
                    <div>
                        opis autorskog dela (ako je delo podneto na optičkom disku);
                    </div>
                    <div>
                        primer autorskog dela (slika, video zapis, audio zapis)
                    </div>
                </div>
                <br/>
                <br/>
                <br/>
                <div>
                    <div style="width: 25%; border: 1px solid black;">
                        <div style="border: 1px solid black; border-width: 1px 0 0 1px; height: 60px; padding: 2%;">
                            <div>
                                Broj prijave:
                            </div>
                            <div style="margin-top: 10px;">
                                <xsl:value-of select="//a1:Informacije_Zavoda/a1:broj_prijave"/>
                            </div>
                        </div>
                        <div style="border: 1px solid black; border-width: 1px 0 0 1px; height: 60px; padding: 2%;">
                            <div>
                                Datum podnosenja:
                            </div>
                            <div style="margin-top: 10px;">
                                <xsl:value-of select="//a1:Informacije_Zavoda/a1:datum_podsnosenja"/>
                            </div>
                        </div>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>