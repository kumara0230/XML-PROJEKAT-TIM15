<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:str="http://exslt.org/strings"
                extension-element-prefixes="str">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8"/>
                <title>Zahtev za priznavanje ziga </title>

                <style type="text/css">
                    *{
                    margin:0;
                    padding:0;
                    }

                    body { font-family: sans-serif;

                    }
                    p{
                    margin: 5px 5px 0 5px;

                    }
                    table {
                    font-family: serif;
                    border-collapse: collapse;
                    margin: 0px 20px 20px 20px;
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
                    tr, td { border-collapse: collapse;
                    border-style: solid;
                    border-width: 1px;
                    margin:0; padding:0;}

                    .title{
                    margin: 0;text-align: center; font-weight:bold; font-size: 20px; border-width:10px;
                    }
                    .subtitle{
                    margin:0; font-weight:bold; text-align: center; margin-bottom: 20px;
                    }
                    .tel-info{
                    margin-bottom: 0;
                    margin-top: 0;
                    }
                    .mail-info{
                    margin-bottom: 0;
                    margin-top: 0;
                    }
                    .description{
                    text-align: center;
                    margin:0;
                    }
                    .question{
                    padding: 5px 5px 0 0 ;
                    }
                    .question-in{
                    border-collapse: collapse;
                    border-style: solid;
                    border-width: 1px;
                    }
                    .answer{
                    height:100px;
                    }
                    .table-in{
                    margin: 0 !important;
                    padding:0;
                    width:100%;
                    }
                    .uputstvo{
                    margin:0;
                    margin-left: 20px !important;
                    margin-bottom:140px;

                    }

                </style>
            </head>
            <body>

                <div>
                    <p class="title">ZAHTEV ZA PRIZNANJE ZIGA</p>
                    <p class="subtitle">Zavodu za intelektualnu svojinu, Kneginje Ljubice 5, 11000 Beograd</p>
                    <p class="description">(popuniti na racunaru)</p>
                </div>
                <table style="margin-bottom:0;">
                    <tr>
                        <td class="question">
                            <p><span style="font-weight:bold;">1. Podnosilac prijave: </span>ime i prezime/poslovno ime, ulica i broj, postanski broj, mesto,
                                drzava prebivalista/sedista:</p>
                        </td>
                    </tr>
                    <tr><td class="question">
                        <p class="answer">
                            <xsl:for-each select="Zahtev_za_priznanje_ziga/Podaci_o_podnosiocu_prijave">
                                <xsl:variable name="lice" select="@xsi:type"/>
                                <xsl:choose>
                                    <xsl:when test="//Podaci_o_podnosiocu_prijave/ime">
                                        <p>
                                            <xsl:value-of select="//Podaci_o_podnosiocu_prijave/ime"/> <xsl:text></xsl:text>&#160;
                                            <xsl:value-of select="//Podaci_o_podnosiocu_prijave/prezime"/> <xsl:text></xsl:text>
                                        </p>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <p>
                                            <xsl:value-of select="Naziv"/><xsl:text></xsl:text>
                                        </p>
                                    </xsl:otherwise>
                                </xsl:choose>
                                <p>
                                    <xsl:value-of select="Adresa/Ulica"/> <xsl:text></xsl:text> &#160;
                                    <xsl:value-of select="Adresa/Ulicni_broj"/> <xsl:text></xsl:text>,
                                    <xsl:value-of select="Adresa/Postanski_broj"/> <xsl:text></xsl:text> &#160;
                                    <xsl:value-of select="Adresa/Mesto"/> <xsl:text></xsl:text>
                                </p>
                                <p>
                                    <xsl:value-of select="//Podaci_o_podnosiocu_prijave/drzavljanstvo"/> <xsl:text></xsl:text>
                                </p>
                            </xsl:for-each>
                        </p>
                    </td></tr>
                    <tr>
                        <td>
                            <table style="margin:0; width: 100%;">
                                <tr>
                                    <td>
                                        <p class="tel-info">telefon:
                                            <xsl:for-each select="Zahtev_za_priznanje_ziga/Podaci_o_podnosiocu_prijave">
                                                <xsl:value-of select="Kontakt/Telefon"/><xsl:text></xsl:text>&#160;
                                            </xsl:for-each>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="mail-info">e-mail:
                                            <xsl:for-each select="Zahtev_za_priznanje_ziga/Podaci_o_podnosiocu_prijave">
                                                <xsl:value-of select="Kontakt/Email"/><xsl:text></xsl:text>&#160;
                                            </xsl:for-each>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="mail-info">faks:
                                            <xsl:for-each select="Zahtev_za_priznanje_ziga/Podaci_o_podnosiocu_prijave">
                                                <xsl:value-of select="Kontakt/Faks"/><xsl:text></xsl:text>&#160;
                                            </xsl:for-each>
                                        </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td class="question">
                            <p><span style="font-weight:bold;">2. Podaci_o_punomocniku: </span>ime i prezime/poslovno ime, ulica i broj, postanski broj, mesto, drzava
                                prebivalista/sedista:</p>
                        </td>
                    </tr>
                    <tr><td class="question"><p class="answer">
                        <xsl:variable name="lice" select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/@xsi:type"/>
                        <xsl:choose>
                            <xsl:when test="//Podaci_o_punomocniku/ime">
                                <p>
                                    <xsl:value-of select="//Podaci_o_punomocniku/ime"/> <xsl:text></xsl:text>&#160;
                                    <xsl:value-of select="//Podaci_o_punomocniku/prezime"/> <xsl:text></xsl:text>
                                </p>
                            </xsl:when>
                            <xsl:otherwise>
                                <p>
                                    <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/Naziv"/><xsl:text></xsl:text>
                                </p>
                            </xsl:otherwise>
                        </xsl:choose>
                        <p>
                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/Adresa/Ulica"/> <xsl:text></xsl:text> &#160;
                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/Adresa/Ulicni_broj"/> <xsl:text></xsl:text>,
                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/Adresa/Postanski_broj"/> <xsl:text></xsl:text> &#160;
                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/Adresa/Mesto"/> <xsl:text></xsl:text>
                        </p>
                        <p>
                            <xsl:value-of select="//Podaci_o_punomocniku/drzavljanstvo"/> <xsl:text></xsl:text>
                        </p>
                    </p></td></tr>
                    <tr>
                        <td>
                            <table style="margin:0; width: 100%;">
                                <tr>
                                    <td>
                                        <p class="tel-info">telefon:<xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/Kontakt/Telefon"/><xsl:text></xsl:text>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="mail-info">e-mail:<xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/Kontakt/Email"/><xsl:text></xsl:text>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="mail-info">faks:<xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_punomocniku/Kontakt/Faks"/><xsl:text></xsl:text>
                                        </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td class="question">
                            <p><span style="font-weight:bold;">3. Podaci o zajednickom predstavniku ako postoji vise podnosilaca prijave: </span></p>
                        </td>
                    </tr>
                    <tr><td class="question"><p class="answer" style="padding-bottom:15px;">
                        <p>
                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_zajednickom_predstavniku/Adresa/Ulica"/> <xsl:text></xsl:text> &#160;
                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_zajednickom_predstavniku/Adresa/Ulicni_broj"/> <xsl:text></xsl:text>,
                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_zajednickom_predstavniku/Adresa/Postanski_broj"/> <xsl:text></xsl:text> &#160;
                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_zajednickom_predstavniku/Adresa/Mesto"/> <xsl:text></xsl:text>
                        </p>
                    </p>
                    </td></tr>
                    <tr>
                        <td>
                            <table style="margin:0; width: 100%;">
                                <tr>
                                    <td>
                                        <p class="tel-info">telefon:<xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_zajednickom_predstavniku/Kontakt/Telefon"/><xsl:text></xsl:text>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="mail-info">e-mail:<xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_zajednickom_predstavniku/Kontakt/Email"/><xsl:text></xsl:text>
                                        </p>
                                    </td>
                                    <td>
                                        <p class="mail-info">faks:<xsl:value-of select="Zahtev_za_priznanje_ziga/Podaci_o_zajednickom_predstavniku/Kontakt/Faks"/><xsl:text></xsl:text>
                                        </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr style="margin:0; padding:0;">
                        <td style="margin:0; padding:0;">
                            <table class="table-in">
                                <tr style="margin:0; padding:0;">
                                    <td style="width:70%;">
                                        <table class="table-in">
                                            <tr style="margin:0; padding:0;"><td>
                                                <p><span style="font-weight:bold;">4. Prijava se podnosi za (upisati X):</span></p>
                                            </td></tr>
                                            <tr style="margin:0; padding:0;">
                                                <td>
                                                    <table class="table-in">
                                                        <tr style="margin:0; padding:0;">
                                                            <td style="width:10%">
                                                                <p><span style="font-weight:bold;">a)</span></p>
                                                            </td>
                                                            <td style="width:70%;">
                                                                <table class="table-in">
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question"><p>individualni zig</p></td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question"><p>kolektivni zig</p></td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question"><p>zig garancije</p></td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td style="width:20%">
                                                                <table class="table-in">
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question">
                                                                            <xsl:choose>
                                                                                <xsl:when test="Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_ziga = 'INDIVIDUALNI'">
                                                                                    <p style="text-align:center;">x</p>
                                                                                </xsl:when>
                                                                                <xsl:otherwise>
                                                                                    <p>&#160;</p>
                                                                                </xsl:otherwise>
                                                                            </xsl:choose>
                                                                        </td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question">
                                                                            <xsl:choose>
                                                                                <xsl:when test="Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_ziga = 'KOLEKTIVNI'">
                                                                                    <p style="text-align:center;">x</p>
                                                                                </xsl:when>
                                                                                <xsl:otherwise>
                                                                                    <p>&#160;</p>
                                                                                </xsl:otherwise>
                                                                            </xsl:choose>
                                                                        </td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question">
                                                                            <xsl:choose>
                                                                                <xsl:when test="Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_ziga = 'ZIG GENERACIJE'">
                                                                                    <p style="text-align:center;">x</p>
                                                                                </xsl:when>
                                                                                <xsl:otherwise>
                                                                                    <p>&#160;</p>
                                                                                </xsl:otherwise>
                                                                            </xsl:choose>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                            <tr style="margin:0; padding:0;">
                                                <td style="margin:0; padding:0;">
                                                    <table class="table-in">
                                                        <tr style="margin:0; padding:0;">
                                                            <td style="width:10%">
                                                                <p><span style="font-weight:bold;">b)</span></p>
                                                            </td>
                                                            <td style="width:70%">
                                                                <table class="table-in">
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question"><p>verbalni znak (znak u reci)</p></td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question"><p>graficki znak; boju, kombinaciju boja</p></td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question"><p>kombinovani znak</p></td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question"><p>trodimenzionalni znak</p></td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question"><p>drugu vrstu znaka (navesti koju)</p></td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                            <td style="width:20%">
                                                                <table class="table-in">
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question">
                                                                            <xsl:choose>
                                                                                <xsl:when test="Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_znaka = 'verbalni znak'">
                                                                                    <p style="text-align:center;">x</p>
                                                                                </xsl:when>
                                                                                <xsl:otherwise>
                                                                                    <p>&#160;</p>
                                                                                </xsl:otherwise>
                                                                            </xsl:choose>
                                                                        </td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question">
                                                                            <xsl:choose>
                                                                                <xsl:when test="Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_znaka = 'grafički znak'">
                                                                                    <p style="text-align:center;">x</p>
                                                                                </xsl:when>
                                                                                <xsl:otherwise>
                                                                                    <p>&#160;</p>
                                                                                </xsl:otherwise>
                                                                            </xsl:choose>
                                                                        </td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question">
                                                                            <xsl:choose>
                                                                                <xsl:when test="Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_znaka = 'kombinovani znak'">
                                                                                    <p style="text-align:center;">x</p>
                                                                                </xsl:when>
                                                                                <xsl:otherwise>
                                                                                    <p>&#160;</p>
                                                                                </xsl:otherwise>
                                                                            </xsl:choose>
                                                                        </td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question">
                                                                            <xsl:choose>
                                                                                <xsl:when test="Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_znaka = 'trodimenzionalni znak'">
                                                                                    <p style="text-align:center;">x</p>
                                                                                </xsl:when>
                                                                                <xsl:otherwise>
                                                                                    <p>&#160;</p>
                                                                                </xsl:otherwise>
                                                                            </xsl:choose>
                                                                        </td>
                                                                    </tr>
                                                                    <tr style="margin:0; padding:0;">
                                                                        <td class="question">
                                                                            <xsl:choose>
                                                                                <xsl:when test="Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_znaka = 'trodimenzionalni znak' or Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_znaka = 'kombinovani znak' or Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_znaka = 'grafički znak' or Zahtev_za_priznanje_ziga/Prijava_se_podnosi_za/Vrsta_znaka = 'verbalni znak'">
                                                                                    <p>&#160;</p>
                                                                                </xsl:when>
                                                                                <xsl:otherwise>
                                                                                    <p style="text-align:center;"><xsl:value-of select="Zahtev_za_priznanje_ziga/Vrsta_znaka"/> <xsl:text></xsl:text></p>
                                                                                </xsl:otherwise>
                                                                            </xsl:choose>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </td>
                                            </tr>
                                            <tr style="margin:0; padding:0;"><td class="question" style=" margin:0; padding:0; padding:5px 5px 20px 5px;">
                                                <p><span style="font-weight:bold;">5. Naznacenje boje, odnosno boja iz kojih se znak sastoji:</span>
                                                    <xsl:value-of select="Zahtev_za_priznanje_ziga/Naznacenje_boje"/> <xsl:text></xsl:text>
                                                </p>
                                            </td></tr>
                                            <tr style="margin:0; padding:0;"><td class="question" style=" margin:0; padding:0; padding:5px 5px 15px 5px;">
                                                <p><span style="font-weight:bold;">6. Transliteracija znaka*:</span>
                                                    <xsl:value-of select="Zahtev_za_priznanje_ziga/Transliteracija_znaka"/> <xsl:text></xsl:text></p>
                                            </td></tr>
                                            <tr style="margin:0; padding:0;"><td class="question" style="margin:0; padding:0; padding:5px 5px 15px 5px;">
                                                <p><span style="font-weight:bold;">7. Prevod znaka*:</span>
                                                    <xsl:value-of select="//Prevod_znaka"/> <xsl:text></xsl:text></p>
                                            </td></tr>
                                            <tr style="margin:0; padding:0;"><td class="question" style="margin:0; padding:0; padding:5px 5px 20px 5px;">
                                                <p><span style="font-weight:bold;">8. Opis znaka:</span>
                                                    <xsl:value-of select="Zahtev_za_priznanje_ziga/Opis_znaka"/> <xsl:text></xsl:text></p>
                                            </td></tr>
                                        </table>
                                    </td>
                                    <td style="width:50%;">
                                        <table class="table-in">
                                            <tr style="margin:0; padding:0;">
                                                <td>
                                                    <p><span style="font-weight:bold;">v) izgled znaka:</span></p>
                                                </td>
                                            </tr>
                                            <tr style="margin:0; padding:0;">
                                                <td><p>
                                                    <img style="width: 200px; height:200px; margin-bottom:220px;">
                                                        <xsl:attribute name="src">
                                                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Izgled_znaka"/>
                                                        </xsl:attribute>
                                                    </img>
                                                </p></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr style="margin:0; padding:0;">
                        <td class="question">
                            <p><span style="font-weight:bold;">9. Zaokruziti brojeve klasa robe i usluga prema Nicanskoj klasifikaciji : </span></p>
                        </td>
                    </tr>
                    <tr style="margin:0; padding:0;">
                        <td>
                            <table class="table-in" style="width:100%">
                                <tr>
                                    <xsl:variable name="match" select="Zahtev_za_priznanje_ziga/Nicanska_klasifikacija"/>
                                    <xsl:for-each select="(//node())[23 >= position()]">
                                        <xsl:variable name="currentNumber" select="position()"/>
                                        <xsl:choose>
                                            <xsl:when test="string($currentNumber) = str:tokenize($match,' ')">
                                                <td style=" background-color:silver;"><xsl:value-of select="$currentNumber"/></td>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <td><xsl:value-of select="$currentNumber"/></td>
                                            </xsl:otherwise>
                                        </xsl:choose>
                                    </xsl:for-each>
                                </tr>
                                <tr>
                                    <xsl:variable name="match" select="Zahtev_za_priznanje_ziga/Nicanska_klasifikacija"/>
                                    <xsl:for-each select="(//node())[22 >= position()]">
                                        <xsl:variable name="currentNumber" select="position()+23"/>
                                        <xsl:choose>
                                            <xsl:when test="string($currentNumber) = str:tokenize($match,' ')">
                                                <td style="background-color:silver;"><xsl:value-of select="$currentNumber"/></td>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <td><xsl:value-of select="$currentNumber"/></td>
                                            </xsl:otherwise>
                                        </xsl:choose>
                                    </xsl:for-each>
                                    <td> </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr style="margin:0; padding:0;">
                        <td class="question" style="padding:5px 5px 10px 5px;">
                            <p><span style="font-weight:bold;">10. Zatrazeno pravo prvenstva i osnov: </span>
                                <xsl:value-of select="Zahtev_za_priznanje_ziga/Zatrazeno_pravo_prvenstva_i_osnov"/> <xsl:text></xsl:text>
                            </p>
                        </td>
                    </tr>
                </table>
                <p class="uputstvo">*Popuniti samo ako je znak ili element znaka ispisan slovima koja nisu cirilicna ili latinicna</p>

                <table style="margin-bottom:30px;">
                    <tr style="margin:0; padding:0;">
                        <td style="margin:0; padding:0; width:60%;">
                            <table class="table-in" style="margin:0; padding:0;">
                                <tr>
                                    <td class="question">
                                        <p><span style="font-weight:bold;">11. Placene takse: </span></p>
                                    </td>
                                    <td>
                                        <p><span style="font-weight:bold;">Dinara </span></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="question" style="padding:20px 5px 5px 5px;">
                                        <p><span style="font-weight:bold;">a) osnovna taksa </span></p>
                                    </td>
                                    <td class="question">
                                        <p><xsl:value-of select="Zahtev_za_priznanje_ziga/Takse_placene_u_dinarima/Osnovna_taksa"/> <xsl:text></xsl:text></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="question" style="padding:20px 5px 5px 5px;">
                                        <p><span style="font-weight:bold;">b) za
                                            <xsl:variable name="match" select="Zahtev_za_priznanje_ziga/Nicanska_klasifikacija"/>
                                            <xsl:value-of select="count(str:tokenize($match,' '))"/>
                                            klasa </span></p>
                                    </td>
                                    <td class="question">
                                        <p><xsl:value-of select="Zahtev_za_priznanje_ziga/Takse_placene_u_dinarima/Za_odredjenu_klasu"/> <xsl:text></xsl:text></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="question" style="padding:20px 5px 5px 5px;">
                                        <p><span style="font-weight:bold;">v) za graficko resenje </span></p>
                                    </td>
                                    <td class="question">
                                        <p><xsl:value-of select="Zahtev_za_priznanje_ziga/Takse_placene_u_dinarima/Za_graficko_resenje"/> <xsl:text></xsl:text></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding:20px 5px 0 0;">
                                        <p><span style="font-weight:bold;">UKUPNO </span></p>
                                    </td>
                                    <td>
                                        <p><xsl:value-of select="Zahtev_za_priznanje_ziga/Takse_placene_u_dinarima/Ukupno"/> <xsl:text></xsl:text></p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td style=" margin:0; padding:0; width:40%;">
                            <p style="margin:0; text-align: center; margin-bottom: 100px; font-weight: bold;">Potpis podnosioca zahteva</p>
                            <p style="margin:0; text-align: center; font-style:italic; font-size: 12px; margin-bottom: 50px;">
                                * Pecat, ukoliko je potreban u skladu sa zakonom</p>
                        </td>
                    </tr>
                </table>

                <table>
                    <tr>
                        <td class="question" style="padding:30px 5px 5px 5px;">
                            <h4 class="title">POPUNJAVA ZAVOD</h4>
                        </td>
                    </tr>
                    <tr  style="margin:0; padding:0;">
                        <td  style="margin:0; padding:0;">
                            <table class="table-in" style="margin:0; padding:0;">
                                <tr style="margin:0; padding:0;">
                                    <td style="width:60%; margin:0; padding:0;">
                                        <table class="table-in" style="margin:0; padding:0;">
                                            <tr>
                                                <td style="padding:5px 5px 15px 5px;">
                                                    <p><span style="font-weight:bold;">Prilozi uz zahtev:</span></p>
                                                </td>
                                            </tr>
                                            <tr stzle="padding:0;">
                                                <td class="question" style="padding:5px 5px 15px 5px; width:70%;">
                                                    <p>Primerak znaka</p>
                                                </td>
                                                <td class="question" style="width:30%;">
                                                    <p>
                                                        <xsl:choose>
                                                            <xsl:when test="Zahtev_za_priznanje_ziga/Popunjava_zavod/Priklozi_uz_zahtev/Primerak_znaka = 'true'">
                                                                <p>
                                                                    Dostavljeno
                                                                </p>
                                                            </xsl:when>
                                                            <xsl:otherwise>
                                                                <p>
                                                                    Nije dostavljeno
                                                                </p>
                                                            </xsl:otherwise>
                                                        </xsl:choose>
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="question" style="padding:5px 5px 15px 5px; width:70%;">
                                                    <p>Spisak robe i usluga**</p>
                                                </td>
                                                <td class="question" style="width:30%;">
                                                    <p>
                                                        <xsl:choose>
                                                            <xsl:when test="Zahtev_za_priznanje_ziga/Popunjava_zavod/Priklozi_uz_zahtev/Spisak_robe_i_usluga = 'true'">
                                                                <p>
                                                                    Dostavljeno
                                                                </p>
                                                            </xsl:when>
                                                            <xsl:otherwise>
                                                                <p>
                                                                    Nije dostavljeno
                                                                </p>
                                                            </xsl:otherwise>
                                                        </xsl:choose>
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="question" style="padding:5px 5px 15px 5px; width:70%;">
                                                    <p>Punomocje</p>
                                                </td>
                                                <td class="question" style="width:30%;">
                                                    <p>
                                                        <xsl:choose>
                                                            <xsl:when test="Zahtev_za_priznanje_ziga/Popunjava_zavod/Priklozi_uz_zahtev/Punomocje = 'true'">
                                                                <p>
                                                                    Dostavljeno
                                                                </p>
                                                            </xsl:when>
                                                            <xsl:otherwise>
                                                                <p>
                                                                    Nije dostavljeno
                                                                </p>
                                                            </xsl:otherwise>
                                                        </xsl:choose>
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="question" style="padding:5px 5px 15px 5px; width:70%;">
                                                    <p>Generalno punomocje ranije prilozeno</p>
                                                </td>
                                                <td class="question" style="width:30%;">
                                                    <p>
                                                        <xsl:choose>
                                                            <xsl:when test="Zahtev_za_priznanje_ziga/Popunjava_zavod/Priklozi_uz_zahtev/Generalno_punomocje_ranije_prilozeno = 'true'">
                                                                <p>
                                                                    Dostavljeno
                                                                </p>
                                                            </xsl:when>
                                                            <xsl:otherwise>
                                                                <p>
                                                                    Nije dostavljeno
                                                                </p>
                                                            </xsl:otherwise>
                                                        </xsl:choose>
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="question" style="padding:5px 5px 15px 5px; width:70%;">
                                                    <p>Punomocje ce biti naknadno dostavljeno</p>
                                                </td>
                                                <td class="question" style="width:30%;">
                                                    <p>
                                                        <xsl:choose>
                                                            <xsl:when test="Zahtev_za_priznanje_ziga/Popunjava_zavod/Priklozi_uz_zahtev/Punomocje_ce_biti_naknadno_dostavljeno = 'true'">
                                                                <p>
                                                                    Dostavljeno
                                                                </p>
                                                            </xsl:when>
                                                            <xsl:otherwise>
                                                                <p>
                                                                    Nije dostavljeno
                                                                </p>
                                                            </xsl:otherwise>
                                                        </xsl:choose>
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="question" style="padding:5px 5px 15px 5px; width:70%;">
                                                    <p>Opsti akt o kolektivnom ziguu garancije</p>
                                                </td>
                                                <td class="question" style="width:30%;">
                                                    <p>
                                                        <xsl:choose>
                                                            <xsl:when test="Zahtev_za_priznanje_ziga/Popunjava_zavod/Priklozi_uz_zahtev/Opsti_akt_o_kolektivnom_zigu_garancije = 'true'">
                                                                <p>
                                                                    Dostavljeno
                                                                </p>
                                                            </xsl:when>
                                                            <xsl:otherwise>
                                                                <p>
                                                                    Nije dostavljeno
                                                                </p>
                                                            </xsl:otherwise>
                                                        </xsl:choose>
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="question" style="padding:5px 5px 15px 5px; width:70%;">
                                                    <p>Dokaz o pravu prvenstva</p>
                                                </td>
                                                <td class="question" style="width:30%;">
                                                    <p>
                                                        <xsl:choose>
                                                            <xsl:when test="Zahtev_za_priznanje_ziga/Popunjava_zavod/Priklozi_uz_zahtev/Dokaz_o_pravu_prvenstva = 'true'">
                                                                <p>
                                                                    Dostavljeno
                                                                </p>
                                                            </xsl:when>
                                                            <xsl:otherwise>
                                                                <p>
                                                                    Nije dostavljeno
                                                                </p>
                                                            </xsl:otherwise>
                                                        </xsl:choose>
                                                    </p>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="question" style="padding:5px 5px 15px 5px; width:70%;">
                                                    <p>Dokaz o uplati takse</p>
                                                </td>
                                                <td class="question" style=" width:30%;">
                                                    <p>
                                                        <xsl:choose>
                                                            <xsl:when test="Zahtev_za_priznanje_ziga/Popunjava_zavod/Priklozi_uz_zahtev/Dokaz_o_uplati_takse = 'true'">
                                                                <p>
                                                                    Dostavljeno
                                                                </p>
                                                            </xsl:when>
                                                            <xsl:otherwise>
                                                                <p>
                                                                    Nije dostavljeno
                                                                </p>
                                                            </xsl:otherwise>
                                                        </xsl:choose>
                                                    </p>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td style="width:40%;">
                                        <p style="text-align: center;">Broj prijave ziga:</p>
                                        <p style="text-align: center; ">
                                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Popunjava_zavod/Broj_prijave_ziga"/><xsl:text></xsl:text>
                                        </p>
                                        <p style="text-align: center; margin-bottom: 15px; font-weight: bold;"> Datum podnosenja: </p>
                                        <p style="text-align: center; font-weight: bold;">
                                            <xsl:value-of select="Zahtev_za_priznanje_ziga/Popunjava_zavod/Datum_podnosenja"/><xsl:text></xsl:text>
                                        </p>
                                        <p style="text-align: center; font-weight: bold;"> ________________________</p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>

                <p style="margin: 50px 20px;">
                    **Uz zaokruzivanje broja klase robe/usluga Nicanske klasifikacije u rubrici 9 dostavlja se i spisak koji sadrzi konkretne nazive robe koju podnosilac prijave proizvodi, odnosno usluga koje pruza. U cilju odredjenja obima zastite koja se stice zigom, spisak treba da sadrzi jasne i precizne nazive robe i usluga. U tu svrhu mogu se koristiti pojmovi iz detaljne Liste roba i usluga ili MGS Manager aplikacije, dostupnih na sajtu Zavoda. Ukoliko se u spisak unose termini iz Liste klasa Nicanske klasifikacije, zastita obuhvata samo tako imenovane, konkretne robe/usluge u njihovom jasnom i nedvosmislenom znacenju.
                </p>
                <img style="width: 200px; height:200px;">
                    <xsl:attribute name="src">
                        <xsl:value-of select="Zahtev_za_priznanje_ziga/Kod"/>
                    </xsl:attribute>
                </img>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>