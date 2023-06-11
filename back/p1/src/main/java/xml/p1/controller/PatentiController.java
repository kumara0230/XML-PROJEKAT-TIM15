package xml.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xml.p1.dto.RequestPatent;
import xml.p1.model.ZahtevZaPriznanjePatenta;
import xml.p1.service.PatentiService;
import xml.p1.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "patenti")
@CrossOrigin
public class PatentiController {
    private PatentiService patentiService;
    private UserService userService;

    @Autowired
    public PatentiController(PatentiService service, UserService userService) {
        super();
        this.patentiService = service;
        this.userService = userService;
    }

    @PostMapping(value = "/new-request", consumes = "application/xml")
    public ResponseEntity<?> newReq(@RequestBody RequestPatent requestPatent, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

            if (userService.authorizeUser(token, false)) {
                ZahtevZaPriznanjePatenta zahtev = patentiService.kreirajZahtev(requestPatent);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/existFusekiSave")
    public ResponseEntity<?> existFusekiSave() {
        try {
            this.patentiService.existFusekiSave();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/getFileFromExistTest")
    public ResponseEntity<?> getFileFromExistTest() {
        String xmlFile = null;
        try {
            xmlFile = this.patentiService.getFileFromExistTest();
            return new ResponseEntity<>(xmlFile, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/pdf")
    public ResponseEntity<?> convertToPdf() throws Exception {
        this.patentiService.toPdf();
        return new ResponseEntity<>("Success", HttpStatus.OK);
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
        ArrayList<String> result = patentiService.searchByMetadata(naziv, godina);
        String output = "";
        for (String r : result) {
            output += "\n" + r;
        }
        System.out.println("OUTPUT: " + output);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }


}
