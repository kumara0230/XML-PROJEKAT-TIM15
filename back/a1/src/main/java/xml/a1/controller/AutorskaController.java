package xml.a1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xml.a1.dto.XMLDto;
import xml.a1.service.AutorskaService;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/xml/a1")
public class AutorskaController {
    private AutorskaService service;

    @Autowired
    public AutorskaController(AutorskaService service) {
        super();
        this.service = service;
    }

//    @PostMapping(value = "/dodaj-autorska", consumes = "application/xml", produces = "application/xml")
//    public ResponseEntity<ObrazacAutorskoDeloDTO> kreirajZahtev(@RequestBody ObrazacAutorskoDeloCreationDTO obrazacAutorskoDeloCreationDTO, HttpServletRequest request) {
//        try {
//            String token = tokenUtils.getAuthHeaderFromHeader(request);
//            if (autorskaService.proveriKorisnika(token, false)) {
//                ObrazacAutorskoDelo obrazacAutorskoDelo = autorskaService.kreirajZahtev(obrazacAutorskoDeloCreationDTO);
//                return new ResponseEntity<>(new ObrazacAutorskoDeloDTO(obrazacAutorskoDelo), HttpStatus.CREATED);
//            }
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

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

    @GetMapping(value = "/pdf")
    public ResponseEntity<?> convertToPdf() throws Exception {
        this.service.toPdf();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping(value = "/jaxB", consumes = MediaType.APPLICATION_XML_VALUE, produces = "application/xml")
    public ResponseEntity<String> getChangedXMLJaxB(@RequestBody XMLDto dto) throws Exception {
        String response = service.jaxBTest(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/saveToExistAndRdf", consumes = "application/json")
    public ResponseEntity<String> addFakultet(@RequestBody XMLDto zahtev) throws Exception {
        service.saveZahtevToDatabases(zahtev);
        return new ResponseEntity<String>("Works", HttpStatus.OK);
    }

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
