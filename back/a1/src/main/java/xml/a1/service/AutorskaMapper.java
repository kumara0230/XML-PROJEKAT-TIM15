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
        zahtev.setPodnosilac(parsePodnosilac(requestAutorskoDelo.getPodnosilac()));
        zahtev.setPodnosilacAutor(requestAutorskoDelo.getPodnosilac().isPodnosilacAutor());
        zahtev.setAutor(parseAutor(requestAutorskoDelo));
        zahtev.setPunomocnik(parsePunomocnik(requestAutorskoDelo));
        zahtev.setDelo(parseDelo(requestAutorskoDelo.getDelo()));
        zahtev.setPopunjavaZavod(popuniZavod(requestAutorskoDelo));
        // opis dela???
        return zahtev;
    }

    private PopunjavaZavod popuniZavod(RequestAutorskoDelo requestAutorskoDelo) throws DatatypeConfigurationException {
        PopunjavaZavod popunjavaZavod = new PopunjavaZavod();
        Date now = new Date();
        popunjavaZavod.setBrojPrijave("A-" + now.getTime());
        popunjavaZavod.setDatumPodnosenja(genDatumPodnosenja());
        // opis?
        return popunjavaZavod;
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
        delo.setNacinKoriscenjaDela(deloDTO.getNacinKoriscenjaDela());
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
            podnosilac.setPoslovnoIme(podnosilacDTO.getPoslovnoIme());
            podnosilac.setAdresa(mapAddress(podnosilacDTO.getAdresa()));
            Kontakt k = new Kontakt();
            k.setEmail(podnosilacDTO.getEmail());
            k.setBrojTelefona(podnosilacDTO.getBrojTelefona());
            k.setFaks(podnosilacDTO.getFaks());
            podnosilac.setKontakt(k);
            return podnosilac;
        } else {                                                // fizicko lice
            TFizickoLice podnosilac = new TFizickoLice();
            podnosilac.setAdresa(mapAddress(podnosilacDTO.getAdresa()));
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
        if (requestAutorskoDelo.getAutor() == null) return null;

        Autor autor = new Autor();

        if (requestAutorskoDelo.getAutor().isAutorAnoniman()) {
            autor.setAutorAnoniman(true);
            return autor;
        }
        autor.setAutorAnoniman(false);

        if (requestAutorskoDelo.getAutor().getPseudonim() != null)
            autor.setPseudonimAutora(requestAutorskoDelo.getAutor().getPseudonim());

        if (requestAutorskoDelo.getPodnosilac().isPodnosilacAutor()) return autor;

        TFizickoLice fizickoLice = new TFizickoLice();
        fizickoLice.setDrzavljanstvo(requestAutorskoDelo.getAutor().getDrzavljanstvo());
        fizickoLice.setIme(requestAutorskoDelo.getAutor().getIme());
        fizickoLice.setPrezime(requestAutorskoDelo.getAutor().getPrezime());

        if (requestAutorskoDelo.getAutor().getGodinaSmrti() != null)
            autor.setGodinaSmrti(requestAutorskoDelo.getAutor().getGodinaSmrti());
        else {
            fizickoLice.setAdresa(mapAddress(requestAutorskoDelo.getAutor().getAdresa()));
            Kontakt k = new Kontakt();
            k.setFaks(requestAutorskoDelo.getAutor().getFaks());
            k.setBrojTelefona(requestAutorskoDelo.getAutor().getBrojTelefona());
            k.setEmail(requestAutorskoDelo.getAutor().getEmail());
            fizickoLice.setKontakt(k);
        }
        autor.setLice(fizickoLice);
        return autor;
    }

    private Punomocnik parsePunomocnik(RequestAutorskoDelo requestAutorskoDelo) {
        if (requestAutorskoDelo.getPunomocnik() == null) {
            return null;
        }
        Punomocnik punomocnik = new Punomocnik();
        punomocnik.setAdresa(mapAddress(requestAutorskoDelo.getPunomocnik().getAdresa()));
        punomocnik.setIme(requestAutorskoDelo.getPunomocnik().getIme());
        punomocnik.setPrezime(requestAutorskoDelo.getPunomocnik().getPrezime());
        return punomocnik;
    }

}

