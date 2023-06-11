package xml.z1.service;

import org.springframework.stereotype.Service;
import xml.z1.dto.AdresaDTO;
import xml.z1.dto.PunomocnikDTO;
import xml.z1.dto.ZigRequest;
import xml.z1.model.*;
import xml.z1.dto.PodnosilacDTO;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class ZigMapper {
    public ZahtevZaPriznanjeZiga mapZig(ZigRequest zigRequest) throws DatatypeConfigurationException {
        ZahtevZaPriznanjeZiga zahtev = new ZahtevZaPriznanjeZiga();

        zahtev.setPodaciOPodnosiocuPrijave(parsePodnosilac(zigRequest.getPodnosilac()));
        zahtev.setPodaciOPunomocniku(parsePunomocnik(zigRequest.getPunomocnik()));
        zahtev.setPrijavaSePodnosiZa(parsePrjavaSePodnosiZa(zigRequest.getVrsta_ziga(), zigRequest.getTip_ziga(), zigRequest.getIzgled()));
        zahtev.setNaznacenjeBoje(zigRequest.getBoje());
        zahtev.setOpisZnaka(zigRequest.getOpis());
        zahtev.setNicanskaKlasifikacija(zigRequest.getKlasa());
        zahtev.setZatrazenoPravoPrvenstvaIOsnov(zigRequest.getPrava());
        System.out.println(zahtev);
        if (zigRequest.getTransliteracija() != null) {
            zahtev.setTransliteracijaZnaka(zigRequest.getTransliteracija());
        }
        if (zigRequest.getPrevod() != null) {
            zahtev.setPrevodZnaka(zigRequest.getPrevod());
        }
        zahtev.setPopunjavaZavod(popuniZavod(zigRequest));
        // opis dela???
        return zahtev;
    }

    private PopunjavaZavod popuniZavod(ZigRequest zigRequest) throws DatatypeConfigurationException {
        PopunjavaZavod popunjavaZavod = new PopunjavaZavod();
        Date now = new Date();
        popunjavaZavod.setBrojPrijaveZiga("Z-" + now.getTime());
        popunjavaZavod.setDatumPodnosenja(genDatumPodnosenja());
        return popunjavaZavod;
    }

    private XMLGregorianCalendar genDatumPodnosenja() throws DatatypeConfigurationException {
        Date now = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(now);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }

    private PrijavaSePodnosiZa parsePrjavaSePodnosiZa(String vrstaZiga, String tipZiga, String izgled) {
        PrijavaSePodnosiZa prijava = new PrijavaSePodnosiZa();
        if (vrstaZiga.equals("1")) {
            prijava.setVrstaZiga("INDIVIDUALNI");
        } else if (vrstaZiga.equals("2")) {
            prijava.setVrstaZiga("KOLEKTIVNI");
        } else if (vrstaZiga.equals("3")) {
            prijava.setVrstaZiga("ZIG GENERACIJE");
        }
        else {
            prijava.setVrstaZiga("Desila se greska");
        }

        prijava.setVrstaZnaka(tipZiga);
        prijava.setIzgledZnaka(izgled);
        return prijava;
    }


    private TLice parsePodnosilac(PodnosilacDTO podnosilacDTO) {
//        if (podnosilacDTO.getPoslovnoIme() != null) {           // pravno lice
//            TPravnoLice podnosilac = new TPravnoLice();
//            podnosilac.setPoslovnoIme(podnosilacDTO.getPoslovnoIme());
//            podnosilac.setAdresa(mapAddress(podnosilacDTO.getAdresa()));
//            Kontakt k = new Kontakt();
//            k.setEmail(podnosilacDTO.getEmail());
//            k.setBrojTelefona(podnosilacDTO.getBrojTelefona());
//            k.setFaks(podnosilacDTO.getFaks());
//            podnosilac.setKontakt(k);
//            return podnosilac;
//        } else {                                                // fizicko lice
            TFizickoLice podnosilac = new TFizickoLice();
            podnosilac.setAdresa(mapAddress(podnosilacDTO.getAdresa()));
            Kontakt k = new Kontakt();
            k.setEmail(podnosilacDTO.getEmail());
            k.setTelefon(podnosilacDTO.getBrojTelefona());
            k.setFaks(podnosilacDTO.getFaks());
            podnosilac.setKontakt(k);
            podnosilac.setIme(podnosilacDTO.getIme());
            podnosilac.setPrezime(podnosilacDTO.getPrezime());
            podnosilac.setDrzavljanstvo(podnosilacDTO.getDrzavljanstvo());
            return podnosilac;
        }
//    }

    private TLice parsePunomocnik(PunomocnikDTO punomocnikDTO) {
//        if (podnosilacDTO.getPoslovnoIme() != null) {           // pravno lice
//            TPravnoLice podnosilac = new TPravnoLice();
//            podnosilac.setPoslovnoIme(podnosilacDTO.getPoslovnoIme());
//            podnosilac.setAdresa(mapAddress(podnosilacDTO.getAdresa()));
//            Kontakt k = new Kontakt();
//            k.setEmail(podnosilacDTO.getEmail());
//            k.setBrojTelefona(podnosilacDTO.getBrojTelefona());
//            k.setFaks(podnosilacDTO.getFaks());
//            podnosilac.setKontakt(k);
//            return podnosilac;
//        } else {                                                // fizicko lice
        TFizickoLice podnosilac = new TFizickoLice();
        podnosilac.setAdresa(mapAddress(punomocnikDTO.getAdresa()));
        Kontakt k = new Kontakt();
        k.setEmail(punomocnikDTO.getEmail());
        k.setTelefon(punomocnikDTO.getBrojTelefona());
        k.setFaks(punomocnikDTO.getFaks());
        podnosilac.setKontakt(k);
        podnosilac.setIme(punomocnikDTO.getIme());
        podnosilac.setPrezime(punomocnikDTO.getPrezime());
        podnosilac.setDrzavljanstvo(punomocnikDTO.getDrzavljanstvo());
        return podnosilac;
    }
//    }

    private Adresa mapAddress(AdresaDTO adresaDTO) {
        Adresa adresa = new Adresa();
        adresa.setPostanskiBroj(adresaDTO.getPostanskiBroj());
        adresa.setMesto(adresaDTO.getMesto());
        adresa.setUlica(adresaDTO.getUlica());
        adresa.setUlicniBroj(adresaDTO.getBroj());
        return adresa;
    }

}
