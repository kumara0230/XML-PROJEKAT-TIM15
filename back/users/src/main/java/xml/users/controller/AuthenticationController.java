package xml.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xml.users.dto.KorisnikDTO;
import xml.users.dto.LoginRequest;
import xml.users.dto.LoginResponse;
import xml.users.model.Korisnik;
import xml.users.service.UserService;
import xml.users.util.TokenUtils;

@RestController
@RequestMapping(value = "auth")
@CrossOrigin
public class AuthenticationController {

    private final UserService userService;
    private final TokenUtils tokenUtils;


    public AuthenticationController(UserService userService, TokenUtils tokenUtils) {
        this.userService = userService;
        this.tokenUtils = tokenUtils;
    }


    @PostMapping(value = "/login", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginDTO) {
        try {
            Korisnik korisnik = userService.getUserByEmail(loginDTO.getEmail());
            if (korisnik == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            if (korisnik.getLozinka().equals(loginDTO.getPassword())) {
                String token = tokenUtils.generateToken(korisnik);
                return new ResponseEntity<>(new LoginResponse(token), HttpStatus.OK);
            } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/register", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<KorisnikDTO> register(@RequestBody KorisnikDTO korisnikDTO) {
        try {
            Korisnik korisnik = userService.register(korisnikDTO);
            return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/{token}", produces = "application/xml")
    public ResponseEntity<KorisnikDTO> getUserFromJwt(@PathVariable("token") String token) {
        try {
            String email = tokenUtils.getUsernameFromToken(token);
            Korisnik korisnik = userService.getUserByEmail(email);
            return new ResponseEntity<>(new KorisnikDTO(korisnik), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
