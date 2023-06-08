package xml.a1.dto;

public class ResenjeDTO {

    private String imeSluzbenika;
    private String prezimeSluzbenika;
    private String brZahteva;
    private String obrazlozenje;
    private boolean odobren;

    public ResenjeDTO() {

    }

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }

    public String getImeSluzbenika() {
        return imeSluzbenika;
    }

    public void setImeSluzbenika(String imeSluzbenika) {
        this.imeSluzbenika = imeSluzbenika;
    }

    public String getPrezimeSluzbenika() {
        return prezimeSluzbenika;
    }

    public void setPrezimeSluzbenika(String prezimeSluzbenika) {
        this.prezimeSluzbenika = prezimeSluzbenika;
    }

    public String getBrZahteva() {
        return brZahteva;
    }

    public void setBrZahteva(String brZahteva) {
        this.brZahteva = brZahteva;
    }

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public void setObrazlozenje(String obrazlozenje) {
        this.obrazlozenje = obrazlozenje;
    }
}
