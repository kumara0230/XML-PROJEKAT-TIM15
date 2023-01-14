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

//    @PostMapping()
//    public ResponseEntity<XMLDto> getChangedXML(@RequestBody XMLDto dto) throws Exception {
//        String response = service.playWithXML(dto);
//        return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
//    }

    @GetMapping(value = "/existSaveFromFile")
    public ResponseEntity<?> saveFromFileToExist() {
        try {
            this.service.saveFromFileToExist();
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

    @PostMapping(value = "/jaxB", consumes = MediaType.APPLICATION_XML_VALUE, produces = "application/xml")
    public ResponseEntity<XMLDto> getChangedXMLJaxB(@RequestBody XMLDto dto) throws Exception {
        String response = service.jaxBTest(dto);
        return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
    }

//    @PostMapping(value = "/xonomy")
//    public ResponseEntity<String> addFakultet(@RequestBody Entitet entitet) throws Exception {
//
//        service.saveFileFromString(entitet.getText());
//        return new ResponseEntity<String>("Works", HttpStatus.OK);
//
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
