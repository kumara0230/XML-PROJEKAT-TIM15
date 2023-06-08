package xml.users.repository;

import xml.users.db.ReadUnmarshal;
import xml.users.db.WriteMarshal;
import xml.users.model.Korisnik;

public class UserRepository {

    public Korisnik saveUser(Korisnik korisnik) throws Exception {
        WriteMarshal writeMarshal = new WriteMarshal();
        return writeMarshal.writeKorisnik("korisnici", korisnik.getEmail() + ".xml", korisnik);
    }

    public Korisnik getUserByEmail(String email) throws Exception {
        ReadUnmarshal readUnmarshal = new ReadUnmarshal();
        return readUnmarshal.readKorisnik("korisnici", email + ".xml");
    }
}
