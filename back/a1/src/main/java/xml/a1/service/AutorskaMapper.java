package xml.a1.service;

import org.springframework.stereotype.Service;
import xml.a1.dto.AdresaDTO;
import xml.a1.dto.DeloDTO;
import xml.a1.dto.PodnosilacDTO;
import xml.a1.dto.RequestAutorskoDelo;
import xml.a1.model.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class AutorskaMapper {

    public Zahtev mapAutorska(RequestAutorskoDelo requestAutorskoDelo) throws DatatypeConfigurationException {

        Zahtev zahtev = new Zahtev();
        zahtev.setPodnosilac(parsePodnosilac(requestAutorskoDelo.getPodnosilacDTO()));
        zahtev.setPodnosilacAutor(requestAutorskoDelo.getPodnosilacDTO().isPodnosilacAutor());
        zahtev.setAutor(parseAutor(requestAutorskoDelo));
        zahtev.setPunomocnik(parsePunomocnik(requestAutorskoDelo));
        zahtev.setDelo(parseDelo(requestAutorskoDelo.getDeloDTO()));
        zahtev.setPopunjavaZavod(popuniZavod(requestAutorskoDelo));
        // opis dela???
        return zahtev;
    }

    private PopunjavaZavod popuniZavod(RequestAutorskoDelo requestAutorskoDelo) throws DatatypeConfigurationException {
        PopunjavaZavod popunjavaZavod = new PopunjavaZavod();
        popunjavaZavod.setBrojPrijave("A-" + String.valueOf(LocalDateTime.now()));
        popunjavaZavod.setDatumPodnosenja(genDatumPodnosenja());
    }

    private XMLGregorianCalendar genDatumPodnosenja() throws DatatypeConfigurationException {
        Date now = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(now);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return xmlGregorianCalendar;
    }

    private Delo parseDelo(DeloDTO deloDTO) {
        Delo delo = new Delo();

        delo.setNaslovDela(deloDTO.getNaslov());
        if (deloDTO.getAlternativniNaziv() != null) delo.setAlternativniNaslov(deloDTO.getAlternativniNaziv());
        delo.setVrstaAutorskogDela(deloDTO.getVrsta());
        delo.setFormaZapisa(deloDTO.getFormaZapisa());
        delo.setNacinKoriscenjaDela(deloDTO.getNacinKoriscenja());
        delo.setDeloStvorenoURadnomOdnosu(deloDTO.isDeloStvorenoURadnomOdnosu());

        if (deloDTO.getDeloPrerade() != null) {
            DeloPrerade deloPrerade = new DeloPrerade();
            Autor a = new Autor();
            TFizickoLice fizickoLice = new TFizickoLice();
            fizickoLice.setIme(deloDTO.getDeloPrerade().getIme());
            fizickoLice.setPrezime(deloDTO.getDeloPrerade().getPrezime());
            a.setLice(fizickoLice);
            if (deloDTO.getDeloPrerade().getGodinaSmrti() != null)
                a.setGodinaSmrti(deloDTO.getDeloPrerade().getGodinaSmrti());
            if (deloDTO.getDeloPrerade().getPseudonim() != null)
                a.setPseudonimAutora(deloDTO.getDeloPrerade().getPseudonim());
            deloPrerade.setAutor(a);
            deloPrerade.setNaslovIzvornogDela(deloDTO.getDeloPrerade().getNaslovIzvornogDela());
            delo.setDeloPrerade(deloPrerade);
        }
        return delo;
    }

    private TLice parsePodnosilac(PodnosilacDTO podnosilacDTO) {
        if (podnosilacDTO.getPoslovnoIme() != null) {           // pravno lice
            TPravnoLice podnosilac = new TPravnoLice();
            podnosilac.setPoslovnoIme(podnosilac.getPoslovnoIme());
            podnosilac.setAdresa(mapAddress(podnosilacDTO.getAdresaDTO()));
            Kontakt k = new Kontakt();
            k.setEmail(podnosilacDTO.getEmail());
            k.setBrojTelefona(podnosilacDTO.getBrojTelefona());
            k.setFaks(podnosilacDTO.getFaks());
            podnosilac.setKontakt(k);
            return podnosilac;
        } else {                                                // fizicko lice
            TFizickoLice podnosilac = new TFizickoLice();
            podnosilac.setAdresa(mapAddress(podnosilacDTO.getAdresaDTO()));
            Kontakt k = new Kontakt();
            k.setEmail(podnosilacDTO.getEmail());
            k.setBrojTelefona(podnosilacDTO.getBrojTelefona());
            k.setFaks(podnosilacDTO.getFaks());
            podnosilac.setKontakt(k);
            podnosilac.setIme(podnosilacDTO.getIme());
            podnosilac.setPrezime(podnosilacDTO.getPrezime());
            podnosilac.setDrzavljanstvo(podnosilacDTO.getDrzavljanstvo());
            return podnosilac;
        }
    }

    private Adresa mapAddress(AdresaDTO adresaDTO) {
        Adresa adresa = new Adresa();
        adresa.setPostanskiBroj(adresaDTO.getPostanskiBroj());
        adresa.setMesto(adresaDTO.getMesto());
        adresa.setUlica(adresaDTO.getUlica());
        adresa.setBroj(adresaDTO.getBroj());
        return adresa;
    }

    private Autor parseAutor(RequestAutorskoDelo requestAutorskoDelo) {
        Autor autor = new Autor();

        if (requestAutorskoDelo.getAutorDTO().isAutorAnoniman()) {
            autor.setAutorAnoniman(true);
            return autor;
        }
        autor.setAutorAnoniman(false);

        if (requestAutorskoDelo.getAutorDTO().getPseudonim() != null)
            autor.setPseudonimAutora(requestAutorskoDelo.getAutorDTO().getPseudonim());

        if (requestAutorskoDelo.getPodnosilacDTO().isPodnosilacAutor()) return autor;

        TFizickoLice fizickoLice = new TFizickoLice();
        fizickoLice.setDrzavljanstvo(requestAutorskoDelo.getAutorDTO().getDrzavljanstvo());
        fizickoLice.setIme(requestAutorskoDelo.getAutorDTO().getIme());
        fizickoLice.setPrezime(requestAutorskoDelo.getAutorDTO().getPrezime());

        if (requestAutorskoDelo.getAutorDTO().getGodinaSmrti() != null)
            autor.setGodinaSmrti(requestAutorskoDelo.getAutorDTO().getGodinaSmrti());
        else {
            fizickoLice.setAdresa(mapAddress(requestAutorskoDelo.getAutorDTO().getAdresa()));
            Kontakt k = new Kontakt();
            k.setFaks(requestAutorskoDelo.getAutorDTO().getFaks());
            k.setBrojTelefona(requestAutorskoDelo.getAutorDTO().getBrojTelefona());
            k.setEmail(requestAutorskoDelo.getAutorDTO().getEmail());
            fizickoLice.setKontakt(k);
        }
        autor.setLice(fizickoLice);
        return autor;
    }

    private Punomocnik parsePunomocnik(RequestAutorskoDelo requestAutorskoDelo) {
        if (requestAutorskoDelo.getPunomocnikDTO() == null) {
            return null;
        }
        Punomocnik punomocnik = new Punomocnik();
        punomocnik.setAdresa(mapAddress(requestAutorskoDelo.getPunomocnikDTO().getAdresaDTO()));
        punomocnik.setIme(requestAutorskoDelo.getPunomocnikDTO().getIme());
        punomocnik.setPrezime(requestAutorskoDelo.getPunomocnikDTO().getPrezime());
        return punomocnik;
    }

}

