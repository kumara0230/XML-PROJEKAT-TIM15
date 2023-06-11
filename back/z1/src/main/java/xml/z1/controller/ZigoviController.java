package xml.z1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xml.z1.dto.ResenjeDTO;
import xml.z1.model.Resenje;
import xml.z1.model.ZahtevZaPriznanjeZiga;
import xml.z1.service.PdfGenerator;
import xml.z1.service.UserService;
import xml.z1.service.ZigoviService;
import xml.z1.dto.ZigRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/xml/z1")
public class ZigoviController {

    private ZigoviService service;
    private final UserService userService;
    private final ZigoviService zigoviService;
    private final PdfGenerator pdfGenerator;

    @Autowired
    public ZigoviController(ZigoviService service, UserService userService, ZigoviService zigoviService, PdfGenerator pdfGenerator) {
        super();
        this.service = service;
        this.userService = userService;
        this.zigoviService = zigoviService;
        this.pdfGenerator = pdfGenerator;
    }


    @PostMapping(value = "/new-request", consumes = "application/xml")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> newReq(@RequestBody ZigRequest zigRequest, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

            if (userService.authorizeUser(token, false)) {
                ZahtevZaPriznanjeZiga zahtev = service.kreirajZahtev(zigRequest);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/all", produces = "application/xml")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getAll(HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

            List<ZahtevZaPriznanjeZiga> zahtevi = zigoviService.getAll(token);
            List<ZigRequest> zahteviDTO = new ArrayList<>();
            for (ZahtevZaPriznanjeZiga zahtev : zahtevi) {
                zahteviDTO.add(new ZigRequest(zahtev));
            }
            return new ResponseEntity<>(zahteviDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/new-resenje", consumes = "application/xml")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> napraviResenje(@RequestBody ResenjeDTO resenjeDTO, HttpServletRequest request) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (userService.authorizeUser(token, true)) {
            Resenje resenje = zigoviService.makeResenje(resenjeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/existFusekiSave")
    public ResponseEntity<?> existFusekiSave() {
        try {
            this.service.existFusekiSave();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/getFileFromExistTest")
    public ResponseEntity<?> getFileFromExistTest() {
        String xmlFile = null;
        try {
            xmlFile = this.service.getFileFromExistTest();
            return new ResponseEntity<>(xmlFile, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/generate-pdf/{format}/{brZahteva}")
    @CrossOrigin(origins = "http://localhost:4200")
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



//    @PostMapping(value = "/jaxB", consumes = MediaType.APPLICATION_XML_VALUE, produces = "application/xml")
//    public ResponseEntity<String> getChangedXMLJaxB(@RequestBody XMLDto dto) throws Exception {
//        String response = service.jaxBTest(dto);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/saveToExistAndRdf", consumes = "application/json")
//    public ResponseEntity<String> addFakultet(@RequestBody XMLDto zahtev) throws Exception {
//        service.saveZahtevToDatabases(zahtev);
//        return new ResponseEntity<String>("Works", HttpStatus.OK);
//    }

    @GetMapping("fusekiSearch/{naziv}/{godina}")
    public ResponseEntity<String> searchFromRDF(@PathVariable("naziv") String naziv, @PathVariable("godina") String godina) throws IOException {
        ArrayList<String> result = service.searchByMetadata(naziv, godina);
        String output = "";
        for (String r : result) {
            output += "\n" + r;
        }
        System.out.println("OUTPUT: " + output);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }


}
