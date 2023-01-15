package xml.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xml.p1.service.PatentiService;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/xml/p1")
public class PatentiController {
    private PatentiService service;

    @Autowired
    public PatentiController(PatentiService service) {
        super();
        this.service = service;
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
