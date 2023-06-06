package xml.users.service;

import org.springframework.stereotype.Service;
import xml.users.dto.KorisnikDTO;
import xml.users.model.Korisnik;
import xml.users.repository.UserRepository;

@Service
public class UserService {

    UserRepository userRepository = new UserRepository();

    public Korisnik getUserByEmail(String email) throws Exception {
        return userRepository.getUserByEmail(email);
    }

    public Korisnik register(KorisnikDTO korisnikDTO) throws Exception {
        Korisnik korisnik = userRepository.getUserByEmail(korisnikDTO.getEmail());
        if (korisnik != null) throw new Exception("Korisnik sa unetim korisnickim imenom vec postoji.");

        korisnik = new Korisnik();
        korisnik.setEmail(korisnikDTO.getEmail());
        korisnik.setIme(korisnikDTO.getName());
        korisnik.setPrezime(korisnikDTO.getLastName());
        korisnik.setLozinka(korisnikDTO.getPassword());
        korisnik.setIsSluzbenik(korisnikDTO.isSluzbenik());

        return userRepository.saveUser(korisnik);

    }
}
