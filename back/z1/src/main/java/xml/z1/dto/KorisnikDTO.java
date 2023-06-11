package xml.z1.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class KorisnikDTO {

    @XmlElement
    private String email;
    @XmlElement
    private String password;
    @XmlElement
    private String name;
    @XmlElement
    private String lastName;
    @XmlElement
    private boolean sluzbenik;

    public KorisnikDTO() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isSluzbenik() {
        return sluzbenik;
    }
}
