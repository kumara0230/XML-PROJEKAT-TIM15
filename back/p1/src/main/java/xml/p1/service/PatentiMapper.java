package xml.p1.service;

import org.springframework.stereotype.Service;
import xml.p1.dto.*;
import xml.p1.model.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PatentiMapper {

    public ZahtevZaPriznanjePatenta mapPatent(RequestPatent requestPatent) throws DatatypeConfigurationException {
        ZahtevZaPriznanjePatenta zahtev = new ZahtevZaPriznanjePatenta();
        zahtev.setNazivPronalaska(parseNazivPronalaska(requestPatent.getNazivPronalaska()));
        zahtev.setPodnosilacPrijave(parsePodnosilacPrijave(requestPatent.getPodnosilac()));
        if (!requestPatent.getPodnosilac().isPodnosilacPronalazac()) {      // if false it whill set Pronalazac
            zahtev.setPronalazacPatenta(parsePronalazacPatenta(requestPatent.getPronalazac()));
        }
        else {      // if true, it whill set Pronalazac same as Podnosilac
            zahtev.setPronalazacPatenta(parsePronalazacPatentaThatIsAlsoPodnosilac(requestPatent.getPodnosilac()));
        }
        zahtev.setPredstavnikPatenta(parsePredstavnikPatenta(requestPatent.getPredstavnik()));
        zahtev.setDostavljanje(parseDostavljanje(requestPatent.getDostavljanje()));
        if (requestPatent.getZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava() != null) {
            zahtev.setZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava(parseZahtevi(requestPatent.getZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava()));
        }

        zahtev.setPopunjavaZavod(popuniZavod());
        return zahtev;
    }

    private NazivPronalaska parseNazivPronalaska(NazivPronalaskaDTO nazivPronalaskaDTO) {
        NazivPronalaska nazivPronalaska = new NazivPronalaska();

        nazivPronalaska.setNazivPronalaskaNaSrpskom(nazivPronalaskaDTO.getNazivNaSrpskom());
        nazivPronalaska.setNazivPronalaskaNaEngleskom(nazivPronalaskaDTO.getNazivNaEngleskom());
        return nazivPronalaska;
    }

    private PodnosilacPrijave parsePodnosilacPrijave(PodnosilacDTO dto) {
        if (dto.getPoslovnoIme() != null) {           // pravno lice
            PodnosilacPrijave podnosilacPrijave = new PodnosilacPrijave();

            TPravnoLice podnosilac = new TPravnoLice();
            podnosilac.setPoslovnoIme(dto.getPoslovnoIme());
            podnosilac.setAdresa(mapAddress(dto.getAdresa()));

            Kontakt k = new Kontakt();
            k.setEmail(dto.getEmail());
            k.setTelefon(dto.getBrojTelefona());
            k.setFaks(dto.getFaks());
            podnosilac.setKontakt(k);

            podnosilacPrijave.setPodaciOLicu(podnosilac);
            return podnosilacPrijave;
        } else {                                                // fizicko lice
            PodnosilacPrijave podnosilacPrijave = new PodnosilacPrijave();

            TFizickoLice podnosilac = new TFizickoLice();
            podnosilac.setAdresa(mapAddress(dto.getAdresa()));

            Kontakt k = new Kontakt();
            k.setEmail(dto.getEmail());
            k.setTelefon(dto.getBrojTelefona());
            k.setFaks(dto.getFaks());
            podnosilac.setKontakt(k);

            podnosilac.setIme(dto.getIme());
            podnosilac.setPrezime(dto.getPrezime());
            podnosilac.setDrzavljanstvo(dto.getDrzavljanstvo());

            podnosilacPrijave.setPodaciOLicu(podnosilac);
            return podnosilacPrijave;
        }

    }

    private PronalazacPatenta parsePronalazacPatenta(PronalazacDTO dto) {
        if (dto.getPoslovnoIme() != null) {           // pravno lice
            PronalazacPatenta pronalazacPatenta = new PronalazacPatenta();

            TPravnoLice podnosilac = new TPravnoLice();
            podnosilac.setPoslovnoIme(dto.getPoslovnoIme());
            podnosilac.setAdresa(mapAddress(dto.getAdresa()));

            Kontakt k = new Kontakt();
            k.setEmail(dto.getEmail());
            k.setTelefon(dto.getBrojTelefona());
            k.setFaks(dto.getFaks());
            podnosilac.setKontakt(k);

            pronalazacPatenta.setPodaciOLicu(podnosilac);
            return pronalazacPatenta;
        } else {                                                // fizicko lice
            PronalazacPatenta pronalazacPatenta = new PronalazacPatenta();

            TFizickoLice podnosilac = new TFizickoLice();
            podnosilac.setAdresa(mapAddress(dto.getAdresa()));

            Kontakt k = new Kontakt();
            k.setEmail(dto.getEmail());
            k.setTelefon(dto.getBrojTelefona());
            k.setFaks(dto.getFaks());
            podnosilac.setKontakt(k);

            podnosilac.setIme(dto.getIme());
            podnosilac.setPrezime(dto.getPrezime());
            podnosilac.setDrzavljanstvo(dto.getDrzavljanstvo());

            pronalazacPatenta.setPodaciOLicu(podnosilac);
            return pronalazacPatenta;
        }
    }

    private PronalazacPatenta parsePronalazacPatentaThatIsAlsoPodnosilac(PodnosilacDTO dto) {
        if (dto.getPoslovnoIme() != null) {           // pravno lice
            PronalazacPatenta pronalazacPatenta = new PronalazacPatenta();

            TPravnoLice podnosilac = new TPravnoLice();
            podnosilac.setPoslovnoIme(dto.getPoslovnoIme());
            podnosilac.setAdresa(mapAddress(dto.getAdresa()));

            Kontakt k = new Kontakt();
            k.setEmail(dto.getEmail());
            k.setTelefon(dto.getBrojTelefona());
            k.setFaks(dto.getFaks());
            podnosilac.setKontakt(k);

            pronalazacPatenta.setPodaciOLicu(podnosilac);
            return pronalazacPatenta;
        } else {                                                // fizicko lice
            PronalazacPatenta pronalazacPatenta = new PronalazacPatenta();

            TFizickoLice podnosilac = new TFizickoLice();
            podnosilac.setAdresa(mapAddress(dto.getAdresa()));

            Kontakt k = new Kontakt();
            k.setEmail(dto.getEmail());
            k.setTelefon(dto.getBrojTelefona());
            k.setFaks(dto.getFaks());
            podnosilac.setKontakt(k);

            podnosilac.setIme(dto.getIme());
            podnosilac.setPrezime(dto.getPrezime());
            podnosilac.setDrzavljanstvo(dto.getDrzavljanstvo());

            pronalazacPatenta.setPodaciOLicu(podnosilac);
            return pronalazacPatenta;
        }
    }

    private PredstavnikPatenta parsePredstavnikPatenta(PredstavnikDTO dto) {
        if (dto.getPoslovnoIme() != null) {           // pravno lice
            PredstavnikPatenta predstavnikPatenta = new PredstavnikPatenta();

            TPravnoLice podnosilac = new TPravnoLice();
            podnosilac.setPoslovnoIme(dto.getPoslovnoIme());
            podnosilac.setAdresa(mapAddress(dto.getAdresa()));

            Kontakt k = new Kontakt();
            k.setEmail(dto.getEmail());
            k.setTelefon(dto.getBrojTelefona());
            k.setFaks(dto.getFaks());
            podnosilac.setKontakt(k);

            predstavnikPatenta.setPodaciOLicu(podnosilac);
            return predstavnikPatenta;
        } else {                                                // fizicko lice
            PredstavnikPatenta predstavnikPatenta = new PredstavnikPatenta();

            TFizickoLice podnosilac = new TFizickoLice();
            podnosilac.setAdresa(mapAddress(dto.getAdresa()));

            Kontakt k = new Kontakt();
            k.setEmail(dto.getEmail());
            k.setTelefon(dto.getBrojTelefona());
            k.setFaks(dto.getFaks());
            podnosilac.setKontakt(k);

            podnosilac.setIme(dto.getIme());
            podnosilac.setPrezime(dto.getPrezime());
            podnosilac.setDrzavljanstvo(dto.getDrzavljanstvo());

            predstavnikPatenta.setPodaciOLicu(podnosilac);
            return predstavnikPatenta;
        }
    }

    private Dostavljanje parseDostavljanje(DostavljanjeDTO dto) {
        Dostavljanje dostavljanje = new Dostavljanje();
        dostavljanje.setAdresa(mapAddress(dto.getAdresa()));
        dostavljanje.setDostavljanjeElektronskimPutem(dto.getDostavljanje_elektronskim_putem());
        return dostavljanje;
    }

    private ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava parseZahtevi(ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijavaDTO dto) {
        ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava zahtevi = new ZahteviZaPriznanjePravaPrvenstvaIzRanijihPrijava();

        List<ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava> zahteviList = new ArrayList<ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava>();
        ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava z1 = new ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava();
        ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava z2 = new ZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava();

        if (dto.getBrojRanijePrijave1() != null || dto.getDatumPodnosenjaRanijePrijave1() != null || dto.getDvoslovnaOznaka1() != null) {
            z1.setBrojRanijePrijave(dto.getBrojRanijePrijave1());
            z1.setDatumPodnosenjaRanijePrijave(dto.getDatumPodnosenjaRanijePrijave1());
            z1.setDvoslovnaOznakaDrzaveRegionalneIliMedjunarodneOrganizacije(dto.getDvoslovnaOznaka1());
        }
        if (dto.getBrojRanijePrijave2() != null || dto.getDatumPodnosenjaRanijePrijave2() != null || dto.getDvoslovnaOznaka2() != null) {
            z2.setBrojRanijePrijave(dto.getBrojRanijePrijave2());
            z2.setDatumPodnosenjaRanijePrijave(dto.getDatumPodnosenjaRanijePrijave2());
            z2.setDvoslovnaOznakaDrzaveRegionalneIliMedjunarodneOrganizacije(dto.getDvoslovnaOznaka2());
        }

        zahteviList.add(z1);
        zahteviList.add(z2);
        zahtevi.setZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava(zahteviList);
        return zahtevi;
    }

    private PopunjavaZavod popuniZavod() throws DatatypeConfigurationException {
        PopunjavaZavod popunjavaZavod = new PopunjavaZavod();
        Date now = new Date();
        popunjavaZavod.setBrojPrijave("P-" + now.getTime());
        popunjavaZavod.setDatumPrijema(genDatumPodnosenja());
        return popunjavaZavod;
    }

    private XMLGregorianCalendar genDatumPodnosenja() throws DatatypeConfigurationException {
        Date now = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(now);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }

    private Adresa mapAddress(AdresaDTO adresaDTO) {
        Adresa adresa = new Adresa();
        adresa.setPostanskiBroj(adresaDTO.getPostanskiBroj());
        adresa.setMesto(adresaDTO.getMesto());
        adresa.setUlica(adresaDTO.getUlica());
        adresa.setBroj(adresaDTO.getBroj());
        return adresa;
    }

}
