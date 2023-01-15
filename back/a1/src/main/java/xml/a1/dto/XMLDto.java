package xml.a1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import xml.a1.model.Zahtev;

import javax.xml.bind.annotation.XmlRootElement;

public class XMLDto {

    private String text;

    public XMLDto() {
        super();
    }

    public XMLDto(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
