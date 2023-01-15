<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:p1="http://ftn.uns.ac.rs/p1" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://ftn.uns.ac.rs/p1 file:/C:/Users/LAZAR/Desktop/XML_i_web_servisi/Projekat/Projekat/XML-PROJEKAT-TIM15/back/p1/src/main/resources/xsd/p1schema.xsd"
>
    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8"/>
                <title>Zahtev za unošenje u evidenciju i deponovanje autorskih dela</title>

                <style type="text/css">


                    *{
                    margin:0;
                    padding:0;
                    font-size:14px;
                    }

                    body { font-family: sans-serif;

                    }

                    table {
                    font-family: serif;
                    border-collapse: collapse;
                    margin: 50px 20px 0px 20px;
                    width: 100%;
                    }
                    th, td {
                    text-align: left;

                    }

                    th {
                    background-color: #4caf50;
                    font-family: sans-serif;
                    color: white;
                    }

                    .uputstvo{
                    margin:0;
                    margin-left: 20px; !important
                    }
                    .title-table{
                    text-align:center;
                    }
                    .text{
                    padding: 10px 0 20px 5px;
                    }
                    .line{
                    border-collapse: collapse;
                    border-top-style: solid;
                    border-top-width: 1px;
                    }
                    .ustanova{
                    margin: 0 0 0 20px;
                    }
                    .title{
                    margin: 0;text-align: center; font-weight:bold; font-size: 20px;
                    }
                    .row-title{
                    margin: 0; font-weight:bold; font-size: 14px;
                    }
                    .description{
                    text-align: center;
                    margin:0;
                    margin-top: 50px;
                    }
                    .left-border{
                    border-collapse: collapse;
                    border-left-style: solid;
                    border-left-width: 1px;
                    }
                    .right-border{
                    border-collapse: collapse;
                    border-right-style: solid;
                    border-right-width: 1px;
                    }
                    .top-border{
                    border-collapse: collapse;
                    border-top-style: solid;
                    border-top-width: 1px;
                    }
                    .bottom-border{
                    border-collapse: collapse;
                    border-bottom-style: solid;
                    border-bottom-width: 1px;
                    }
                    .all-border{
                    border-collapse: collapse;
                    border-left-style: solid;
                    border-left-width: 1px;
                    border-right-style: solid;
                    border-right-width: 1px;
                    border-top-style: solid;
                    border-top-width: 1px;
                    border-bottom-style: solid;
                    border-bottom-width: 1px;
                    }

                </style>
            </head>
            <body>
                <xsl:variable name="ujedno_pronalazac" select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta"/>
                <p style="text-align:right; font-size:12px; color:silver;">Obrazac P-1</p>
                <table style="width: 70%" class="all-border">
                    <tr>
                        <td style="padding: 5px; margin: 0;">
                            <p class="title-table">Popunjava Zavod</p>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding: 0; margin: 0;" class="line">
                            <table style="margin:0;">
                                <tr>
                                    <td style="width:90%; padding:5px;">
                                        <p style="padding: 5px">Broj prijave</p>
                                        <p style="padding: 0 0 10px 100px">
                                            <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Popunjava_zavod/p1:Broj_prijave"/> <xsl:text></xsl:text>
                                        </p>
                                    </td>
                                    <td style="width:10%">
                                        <p>(21)</p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table style="margin:0;" class="top-border">
                                <tr>
                                    <td style="width:40% padding:5px;">
                                        <p class="text">Datum prijema</p>
                                        <p style="text-align: center; font-weight: bold;">
                                            <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Popunjava_zavod/p1:Datum_prijema"/><xsl:text></xsl:text>
                                        </p>
                                    </td>
                                    <td style="width:50% padding:5px;" class="left-border">
                                        <p class="text">Priznati datum podnošenja	(22)</p>
                                        <p style="text-align: center; font-weight: bold;">
                                            <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Priznati_datum_podnosenja"/><xsl:text></xsl:text>
                                        </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td class="line" style="padding:5px;">
                            <p class="text">Pečat i potpis</p>
                        </td>
                    </tr>
                </table>
                <div>
                    <p class="ustanova">Republika Srbija</p>
                    <p class="ustanova">Zavod za intelektualnu svojinu</p>
                    <p class="ustanova">Kneginje Ljubice broj 5</p>
                    <p class="ustanova">11000 Beograd</p>
                </div>
                <div>
                    <p class="title">ZAHTEV</p>
                    <p class="title">ZA PRIZNANJE PATENTA</p>
                    <p class="description">(popuniti pisaćom mašinom ili računarom)</p>
                </div>
                <table  style="margin-bottom:10px; margin-top:0px; width:100%" class="all-border">
                    <tbody class="all-border">
                        <tr>
                            <td style="padding: 15px 5px;">
                                <table style="margin:0;">
                                    <tr>
                                        <td style="width:20%">
                                            <p class="row-title">Polje broj I</p>
                                        </td>
                                        <td style="width:75%">
                                            <p class="row-title">NAZIV PRONALASKA</p>
                                        </td>
                                        <td style="width:5%">
                                            <p>(54)</p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td style="padding: 5px 5px 20px 5px;">
                            </td>
                        </tr>
                        <tr>
                            <td class="line" style="padding: 7px 5px; ">
                                <p>Na srpskom jeziku:
                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Naziv_pronalaska/p1:Naziv_pronalaska_na_srpskom"/><xsl:text></xsl:text>
                                </p>
                                <p>Na engleskom jeziku:
                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Naziv_pronalaska/p1:Naziv_pronalaska_na_engleskom"/><xsl:text></xsl:text>
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="line" style="padding: 10px 5px;">
                                <table style="margin:0;">
                                    <tr>
                                        <td style="width:20%">
                                            <p class="row-title">Polje broj II</p>
                                        </td>
                                        <td style="width:40%">
                                            <p class="row-title">PODNOSILAC PRIJAVE</p>
                                        </td>
                                        <xsl:if test="$ujedno_pronalazac='true'">
                                            <td style="width:40%">
                                                <p>&#x2610; Podnosilac prijave je i pronalazac </p>
                                            </td>
                                        </xsl:if>
                                        <td style="width:5%">
                                            <p>(71)</p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <table style="margin:0;" class="top-border bottom-border">
                                    <tr>
                                        <td style="width:70%">
                                            <table style="margin:0;">
                                                <tr><td>
                                                    <table style="margin:0;">
                                                        <tr>
                                                            <td style="padding: 5px 5px 130px 5px; width:50%;
		                                                            ">
                                                                <p>Ime i prezime / Poslovno ime:
                                                                    <span style="font-size:12px;">(prezime / poslovno ime upisati velikim slovima)</span>
                                                                </p>
                                                                <p>
                                                                    <xsl:variable name="lice" select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/@xsi_type"/>
                                                                    <xsl:choose>
                                                                        <xsl:when test="substring($lice,5)='TFizicko_lice'">
                                                                            <p>
                                                                                <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Ime"/> <xsl:text></xsl:text>&#160;
                                                                                <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Prezime"/> <xsl:text></xsl:text>
                                                                            </p>
                                                                        </xsl:when>
                                                                        <xsl:otherwise>
                                                                            <p>
<!--                                                                                <xsl:value-of select="p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/Naziv"/><xsl:text></xsl:text>-->
                                                                            </p>
                                                                        </xsl:otherwise>
                                                                    </xsl:choose>
                                                                </p>
                                                            </td>
                                                            <td style="padding: 5px 5px 130px 5px; width:50%;" class="left-border ">
                                                                <p>Ulica i broj, poštanski broj, mesto i država:</p>
                                                                <P>
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Adresa/p1:Ulica"/> <xsl:text></xsl:text> &#160;
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Adresa/p1:Broj"/> <xsl:text></xsl:text>
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Adresa/p1:Postanski_broj"/> <xsl:text></xsl:text> &#160;
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Adresa/p1:Mesto"/> <xsl:text></xsl:text>
                                                                </P>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td></tr>
                                                <tr><td style="padding: 5px 5px 5px 5px;">
                                                    <table style="margin:0; border-top:1px;">
                                                        <tr>
                                                            <td>
                                                                <p>Državljanstvo:
                                                                    <xsl:variable name="lice" select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/@xsi:type"/>
                                                                    <xsl:if test="substring($lice,5)='TFizicko_lice'">
                                                                        <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Drzavljanstvo"/> <xsl:text></xsl:text> &#160;
                                                                    </xsl:if>
                                                                </p>
                                                            </td>
                                                            <td style="font-size: 14px;">
                                                                <p>(popuniti samo za fizicka lica)</p>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td></tr>
                                            </table>
                                        </td>
                                        <td style="width:30%" >
                                            <table style="margin:0; border-left:1px;" class="left-border">
                                                <tr><td style="padding: 5px 5px 15px 5px;" class="left-border"><p>Broj telefona:</p>
                                                    <p>
                                                        <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Kontakt/p1:Telefon"/> <xsl:text></xsl:text> &#160;
                                                    </p>
                                                </td></tr>
                                                <tr><td style="padding: 5px 5px 15px 5px;" class="top-border left-border"><p>Broj faksa:</p>
                                                    <p>
                                                        <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Kontakt/p1:Faks"/> <xsl:text></xsl:text> &#160;
                                                    </p>
                                                </td></tr>
                                                <tr><td style="padding: 5px 5px 15px 5px;" class="top-border left-border"><p>E-mail:</p>
                                                    <p>
                                                        <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Podnosilac_prijave/p1:Podaci_o_licu/p1:Kontakt/p1:Email"/> <xsl:text></xsl:text> &#160;
                                                    </p>
                                                </td></tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <table style="margin-top:0; margin-bottom:0px;" class="all-border">
                    <tr>
                        <td style="padding: 10px 5px 5px 5px;">
                            <table style="margin:0;">
                                <tr>
                                    <td style="width:20%">
                                        <p class="row-title">Polje broj III </p>
                                    </td>
                                    <td style="width:40%">
                                        <p class="row-title"> PRONALAZAC </p>
                                    </td>
                                    <td style="width:5%">
                                        <p>(72)</p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td style="border-bottom:1px;">
                            <p style="font-size: 12px; margin:0; padding:0; padding-left:5px; padding-bottom:5px;">(ako su svi pronalazači ujedno i podnosioci prijave, polje broj III se ne popunjava)</p>
                            <p style="font-size: 12px; margin:0; padding:0; padding-left:5px;">* Ako svi podnosioci prijave nisu i pronalazači, dostavlja se izjava podnosilaca prijave o osnovu sticanja prava na podnošenje prijave u odnosu na pronalazače koji nisu i podnosioci prijave i u tom slučaju u polje broj III se unose podaci o svim pronalazačim</p>
                            <xsl:variable name="anoniman" select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/@anoniman"/>
                            <xsl:if test="$anoniman='true'">
                                <p style="margin:0; padding:0; margin-right:50px; text-align:right; font-weight:bold;">Pronalazač ne želi da bude naveden u prijavi</p>
                            </xsl:if>
                            <p style="font-size: 12px; margin:0; padding:0; padding-left:5px;  padding-bottom:5px;">(ako pronalazač ne želi da bude naveden u prijavi polje broj III se ne popunjava)</p>
                            <p style="font-size: 12px; margin:0; padding:0; padding-left:5px;">*Ako pronalazač ne želi da bude naveden u prijavi, potrebno je dostaviti potpisanu izjavu pronalazača da ne želi da bude naveden.</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table style="margin:0;" class="top-border bottom-border">
                                <tr>
                                    <xsl:variable name="anoniman" select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/@anoniman"/>
                                    <td style="width:70%">
                                        <table style="margin:0;">
                                            <tr><td>
                                                <table style="margin:0;">

                                                    <tr>
                                                        <td style="padding: 5px 5px 130px 5px; width:50%;
		                                                            ">
                                                            <p>Ime i prezime / Poslovno ime:
                                                                <span style="font-size:12px;">(prezime / poslovno ime upisati velikim slovima)</span>
                                                            </p>
                                                            <xsl:if test="$anoniman='false' and $ujedno_pronalazac='false'">
                                                                <p>
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/Ime"/> <xsl:text></xsl:text> &#160;
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/Prezime"/> <xsl:text></xsl:text>
                                                                </p>
                                                            </xsl:if>

                                                        </td>
                                                        <td style="padding: 5px 5px 130px 5px; width:50%;" class="left-border">
                                                            <p>Ulica i broj, poštanski broj, mesto i država:</p>

                                                            <xsl:if test="$anoniman='false' and $ujedno_pronalazac='false'">
                                                                <p>
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/p1:Adresa/p1:Ulica"/> <xsl:text></xsl:text> &#160;
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/p1:Adresa/p1:Broj"/> <xsl:text></xsl:text> &#160;
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/p1:Adresa/p1:Postanski_broj"/> <xsl:text></xsl:text> &#160;
                                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/p1:Adresa/p1:Mesto"/> <xsl:text></xsl:text> &#160;

                                                                </p>
                                                            </xsl:if>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td></tr>

                                        </table>
                                    </td>
                                    <td style="width:30%" >
                                        <table style="margin:0;" class="left-border">
                                            <tr><td style="padding: 5px 5px 15px 5px;"><p>Broj telefona:</p>

                                                <xsl:if test="$anoniman='false' and $ujedno_pronalazac='false'">
                                                    <p>
                                                        <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/p1:Kontakt/p1:Telefon"/> <xsl:text></xsl:text> &#160;
                                                    </p>
                                                </xsl:if>
                                            </td></tr>
                                            <tr><td style="padding: 5px 5px 15px 5px;" class="top-border"><p>Broj faksa:</p>


                                                <xsl:if test="$anoniman='false' and $ujedno_pronalazac='false'">
                                                    <p>
                                                        <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/p1:Kontakt/p1:Faks"/> <xsl:text></xsl:text> &#160;
                                                    </p>
                                                </xsl:if>
                                            </td></tr>
                                            <tr><td style="padding: 5px 5px 15px 5px;" class="top-border left-boder"><p>E-pošta:</p>

                                                <xsl:if test="$anoniman='false' and $ujedno_pronalazac='false'">
                                                    <p>
                                                        <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Pronalazac_patenta/p1:Kontakt/p1:Email"/> <xsl:text></xsl:text> &#160;
                                                    </p>
                                                </xsl:if>
                                            </td></tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>




                <table style="margin-top:10px;" class="all-border">
                    <tr>
                        <td style="padding: 10px 5px 5px 5px;">
                            <table style="margin:0;">
                                <tr>
                                    <td style="width:15%">
                                        <p class="row-title">Polje broj IV  </p>
                                    </td>
                                    <td style="width:20%; margin-left:20px;">
                                        <p class="row-title">PUNOMOCNIK </p>
                                    </td>
                                    <!-- LOGIKA -->
                                    <xsl:variable name="punomocnik" select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Punomocnik"/>
                                    <xsl:variable name="zajednicki" select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Zajednicki_predstavnik"/>
                                    <xsl:if test="$punomocnik='zastupanje'">
                                        <td style="width:60%">
                                            <p class="row-title">PUNOMOCNIK ZA ZASTUPANJE  </p>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="$punomocnik='prijem_pismena'">
                                        <td style="width:60%">
                                            <p class="row-title">PUNOMOCNIK ZA PRIJEM PISMENA  </p>
                                        </td>
                                    </xsl:if>
                                    <xsl:if test="$zajednicki='true'">
                                        <td style="width:60%">
                                            <p class="row-title">ZAJEDNICKI PREDSTAVNIK</p>
                                        </td>
                                    </xsl:if>
                                    <td style="width:5%">
                                        <p>(74)</p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td style="border-bottom:1px;">
                            <p style="font-size: 12px; margin:0; padding:0 5px;">* Punomoćnik za zastupanje je lice koje po ovlašćenju podnosioca prijave preduzima radnje u upravnom postupku u granicama punomoćja</p>
                            <p style="font-size: 12px; margin:0; padding:0 5px;">* Punomoćnik za prijem pismena je lice koje je podnosilac prijave odredio kao lice kome se  upućuju sva pismena naslovljena na podnosioca</p>
                            <p style="font-size: 12px; margin:0; padding:0 5px; padding-bottom: 15px;">* Zajedniči prestavnik je podnosilac prijave koga su podnosioci prijave, u slučaju da prijavu podnosi više lica, odredili da istupa u postupku pred organom ako podnosioci nisu imenovali zajedničkog punomoćnika za zastupanje</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table style="margin:0;" class="top-border bottom-border">
                                <tr>
                                    <td style="width:70%">
                                        <table style="margin:0;">
                                            <tr><td>
                                                <table style="margin:0;">
                                                    <tr>
                                                        <td style="padding: 5px 5px 130px 5px; width:50%;
		                                                            ">
                                                            <p>Ime i prezime / Poslovno ime:
                                                                <span style="font-size:12px;">(prezime / poslovno ime upisati velikim slovima)</span>
                                                            </p>
                                                            <p>
                                                                <xsl:variable name="lice" select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/@xsi:type"/>
                                                                <xsl:choose>
                                                                    <xsl:when test="substring($lice,5)='TFizicko_lice'">
                                                                        <p>
                                                                            <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/Ime"/> <xsl:text></xsl:text>&#160;
                                                                            <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/Prezime"/> <xsl:text></xsl:text>
                                                                        </p>
                                                                    </xsl:when>
                                                                    <xsl:otherwise>
                                                                        <p>
                                                                            <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/Naziv"/><xsl:text></xsl:text>
                                                                        </p>
                                                                    </xsl:otherwise>
                                                                </xsl:choose>
                                                            </p>
                                                        </td>
                                                        <td style="padding: 5px 5px 130px 5px; width:50%;" class="left-border">
                                                            <p>Ulica i broj, poštanski broj, mesto i država:</p>
                                                            <P>
                                                                <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/p1:Adresa/p1:Ulica"/> <xsl:text></xsl:text> &#160;
                                                                <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/p1:Adresa/p1:Broj"/> <xsl:text></xsl:text>,
                                                                <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/p1:Adresa/p1:Postanski_broj"/> <xsl:text></xsl:text> &#160;
                                                                <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/p1:Adresa/p1:Mesto"/> <xsl:text></xsl:text>

                                                            </P>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td></tr>
                                        </table>
                                    </td>
                                    <td style="width:30%" >
                                        <table style="margin:0;" class="left-border">
                                            <tr><td style="padding: 5px 5px 15px 5px;"><p>Broj telefona:</p>
                                                <p>
                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/p1:Kontakt/p1:Telefon"/> <xsl:text></xsl:text> &#160;
                                                </p>
                                            </td></tr>
                                            <tr><td style="padding: 5px 5px 15px 5px;" class="top-border"><p>Broj faksa:</p>
                                                <p>
                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/p1:Kontakt/p1:Faks"/> <xsl:text></xsl:text> &#160;
                                                </p>
                                            </td></tr>
                                            <tr><td style="padding: 5px 5px 15px 5px;" class="top-border left-border"><p>E-pošta:</p>
                                                <p>
                                                    <xsl:value-of select="//p1:Zahtev_za_priznanje_patenta/p1:Predstavnik_patenta/p1:Podaci_o_licu/p1:Kontakt/p1:Email"/> <xsl:text></xsl:text> &#160;
                                                </p>
                                            </td></tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td style="border-top:1px; padding: 15px 5px 5px 5px;">
                            <table style="margin:0;">
                                <tr>
                                    <td style="width:20%; ">
                                        <p class="row-title">Polje broj V </p>
                                    </td>
                                    <td style="width:80%; ">
                                        <p class="row-title">ADRESA ZA DOSTAVLJANJE </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td style="border-bottom:1px;  padding: 0px 5px 20px 5px;">
                            <p>(ovo polje se popunjava ako podnosilac prijave, zajednicki predstavnik ili punomocnik želi da se dostavljanje podnesaka vrši na drugoj adresi od njegove navedene adrese)</p>
                        </td>
                    </tr>
                    <tr>
                        <td style="padding: 10px 5px 0 5px;" class="top-border">
                            <p>Ulica i broj, poštanski broj i mesto:</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="line" style="padding: 10px 5px 15px 5px;">
                            <table style="margin:0;">
                                <tr>
                                    <td style="width:20%">
                                        <p class="row-title">Polje broj VI </p>
                                    </td>
                                    <td style="width:80%">
                                        <p class="row-title">NACIN DOSTAVLJANJA </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <xsl:variable name="nacin_dostavljanja" select="//p1:Zahtev_za_priznanje_patenta/p1:Dostavljanje/p1:Dostavljanje_elektronskim_putem"/>
                        <xsl:if test="$nacin_dostavljanja='true'">

                            <td style="padding: 5px 5px 5px 5px; margin:0;" class="top-border">
                                <p>Podnosilac prijave je saglasan da Zavod vrši dostavljanje pismena iskljucivo elektronskim putem u formi elektronskog dokumenta (u ovom slucaju neophodna je registracija na portalu „eUprave”)</p>
                            </td>
                        </xsl:if>
                    </tr>
                    <tr>
                        <xsl:variable name="nacin_dostavljanja" select="//p1:Zahtev_za_priznanje_patenta/p1:Dostavljanje/p1:Dostavljanje_elektronskim_putem"/>
                        <xsl:if test="$nacin_dostavljanja='false'">
                            <td style="padding: 0px 5px 5px 5px; margin:0;">
                                <p>Podnosilac prijave je saglasan da Zavod vrši dostavljanje pismena u papirnoj formi </p>
                            </td>
                        </xsl:if>
                    </tr>
                    <tr>
                        <td style="padding: 10px 5px 10px 5px;">
                            <table style="margin:0;">
                                <tr>
                                    <td style="width:20%">
                                        <p class="row-title">Polje broj VII </p>
                                    </td>
                                    <td style="width:75%">
                                        <p class="row-title">ZAHTEV ZA PRIZNANJE PRAVA PRVENSTVA IZ RANIJIH PRIJAVA:  </p>
                                    </td>
                                    <td style="width:5%">
                                        <p class="row-title">(30)  </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
                <table  style="margin-top:0;" class="all-border">
                    <thead>
                        <tr>
                            <td style="width:4%; text-align:center;  padding:5px;" class="right-border">Br.</td>
                            <td style="width:32%; text-align:center; border-left:1px;  padding:5px;">Datum podnošenja ranije prijave</td>
                            <td style="width:32%; text-align:center; padding:5px;" class="right-border left-brder">Broj ranije prijave</td>
                            <td style="width:32%; text-align:center; padding:5px;">Dvoslovna oznaka države, regionalne ili međunarodne organizacije</td>
                        </tr>
                        <tr>
                            <xsl:for-each select="//p1:Zahtev_za_priznanje_patenta/p1:Zahtevi_za_priznanje_prava_prvenstva_iz_ranijih_prijava/p1:Zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava">
                                <td style="width:4%;padding-top: 5px;" class="right-border top-border">
                                    <xsl:value-of select="position()"/>
                                </td>
                                <td style="width:32%; padding-top: 5px;" class="top-border">
                                    <p>
                                        <xsl:value-of select="//p1:Datum_podnosenja_ranije_prijave"/> <xsl:text></xsl:text>
                                    </p>
                                </td>
                                <td style="width:32%; padding-top: 5px;" class="left-border right-border top-border">
                                    <p>
                                        <xsl:value-of select="//p1:Broj_ranije_prijave"/> <xsl:text></xsl:text>
                                    </p>
                                </td>
                                <td style="width:32%; padding-top: 5px;" class="top-border">
                                    <p>
                                        <xsl:value-of select="//p1:Dvoslovna_oznaka_drzave_regionalne_ili_medjunarodne_organizacije"/> <xsl:text></xsl:text>
                                    </p>
                                </td>
                            </xsl:for-each>
                        </tr>
                    </thead>
                </table>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>