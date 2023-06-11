package xml.a1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xml.a1.dto.DateRangeDTO;
import xml.a1.dto.RequestAutorskoDelo;
import xml.a1.dto.ResenjeDTO;
import xml.a1.dto.XMLDto;
import xml.a1.model.Resenje;
import xml.a1.model.Zahtev;
import xml.a1.service.AutorskaService;
import xml.a1.service.PdfGenerator;
import xml.a1.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "autorska")
@CrossOrigin
public class AutorskaController {
    private final AutorskaService autorskaService;
    private final UserService userService;
    private final PdfGenerator pdfGenerator;

    @Autowired
    public AutorskaController(AutorskaService service, UserService userService, PdfGenerator pdfGenerator) {
        super();
        this.autorskaService = service;
        this.userService = userService;
        this.pdfGenerator = pdfGenerator;
    }

    @PostMapping(value = "/new-request", consumes = "application/xml")
    public ResponseEntity<?> newReq(@RequestBody RequestAutorskoDelo requestAutorskoDelo, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

            if (userService.authorizeUser(token, false)) {
                Zahtev zahtev = autorskaService.kreirajZahtev(requestAutorskoDelo);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all", produces = "application/xml")
    public ResponseEntity<?> getAll(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

            List<Zahtev> zahtevi = autorskaService.getAll(token);
            List<RequestAutorskoDelo> zahteviDTO = new ArrayList<>();
            for (Zahtev zahtev : zahtevi) {
                zahteviDTO.add(new RequestAutorskoDelo(zahtev));
            }
            return new ResponseEntity<>(zahteviDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/new-resenje", consumes = "application/xml")
    public ResponseEntity<?> napraviResenje(@RequestBody ResenjeDTO resenjeDTO, HttpServletRequest request) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (userService.authorizeUser(token, true)) {
            Resenje resenje = autorskaService.makeResenje(resenjeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


    @GetMapping(value = "/generate-pdf/{format}/{brZahteva}")
    public ResponseEntity<?> generateDoc(@PathVariable String format, @PathVariable String brZahteva) {
        try {
            // Generisanje PDF/HTML fajla na osnovu xsl fajla i XML podataka
            ByteArrayOutputStream outputStream = pdfGenerator.generatePdfOrHtml(format, brZahteva);

            // Kreiranje ByteArrayResource od generisanog fajla
            ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

            // Postavljanje HTTP zaglavlja za download
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + brZahteva + "." + format);

            // Vraćanje odgovora sa generisanim fajlom i zaglavljima
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE))
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/generate-report", consumes = "application/xml")
    public ResponseEntity<?> generateDoc(@RequestBody DateRangeDTO dateRangeDTO) {
        try {
            // Generisanje PDF/HTML fajla na osnovu xsl fajla i XML podataka

            ByteArrayOutputStream outputStream = autorskaService.generateReport(dateRangeDTO);

            // Kreiranje ByteArrayResource od generisanog fajla
            ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

            // Postavljanje HTTP zaglavlja za download
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");

            // Vraćanje odgovora sa generisanim fajlom i zaglavljima
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE))
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/existFusekiSave")
    public ResponseEntity<?> existFusekiSave() {
        try {
            this.autorskaService.existFusekiSave();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/getFileFromExistTest")
    public ResponseEntity<?> getFileFromExistTest() {
        String xmlFile = null;
        try {
            xmlFile = this.autorskaService.getFileFromExistTest();
            return new ResponseEntity<>(xmlFile, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/pdf")
    public ResponseEntity<?> convertToPdf() throws Exception {
        this.autorskaService.toPdf();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping(value = "/jaxB", consumes = MediaType.APPLICATION_XML_VALUE, produces = "application/xml")
    public ResponseEntity<String> getChangedXMLJaxB(@RequestBody XMLDto dto) throws Exception {
        String response = autorskaService.jaxBTest(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/saveToExistAndRdf", consumes = "application/json")
    public ResponseEntity<String> addFakultet(@RequestBody XMLDto zahtev) throws Exception {
        autorskaService.saveZahtevToDatabases(zahtev);
        return new ResponseEntity<String>("Works", HttpStatus.OK);
    }

    @GetMapping("fusekiSearch/{naziv}/{godina}")
    public ResponseEntity<String> searchFromRDF(@PathVariable("naziv") String naziv, @PathVariable("godina") String godina) throws IOException {
        ArrayList<String> result = autorskaService.searchByMetadata(naziv, godina);
        String output = "";
        for (String r : result) {
            output += "\n" + r;
        }
        System.out.println("OUTPUT: " + output);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }


}
