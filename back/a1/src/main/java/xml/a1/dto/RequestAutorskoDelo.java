package xml.a1.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestAutorskoDelo {

    @XmlElement
    private PodnosilacDTO podnosilacDTO;

    @XmlElement
    private AutorDTO autorDTO;

    @XmlElement
    private PunomocnikDTO punomocnikDTO;

    @XmlElement
    private DeloDTO deloDTO;

    public PodnosilacDTO getPodnosilacDTO() {
        return podnosilacDTO;
    }

    public void setPodnosilacDTO(PodnosilacDTO podnosilacDTO) {
        this.podnosilacDTO = podnosilacDTO;
    }

    public AutorDTO getAutorDTO() {
        return autorDTO;
    }

    public void setAutorDTO(AutorDTO autorDTO) {
        this.autorDTO = autorDTO;
    }

    public PunomocnikDTO getPunomocnikDTO() {
        return punomocnikDTO;
    }

    public void setPunomocnikDTO(PunomocnikDTO punomocnikDTO) {
        this.punomocnikDTO = punomocnikDTO;
    }

    public DeloDTO getDeloDTO() {
        return deloDTO;
    }

    public void setDeloDTO(DeloDTO deloDTO) {
        this.deloDTO = deloDTO;
    }
}
