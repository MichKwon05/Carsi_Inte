package mx.edu.utez.Int_DBN.dto;

public class MarcaDto {

    private String nameMarca;
    private String member;
    private int numComercials;
    private String ambassador;

    public MarcaDto() {
    }

    public MarcaDto(String nameMarca, String member, int numComercials, String ambassador) {
        this.nameMarca = nameMarca;
        this.member = member;
        this.numComercials = numComercials;
        this.ambassador = ambassador;
    }

    public String getNameMarca() {
        return nameMarca;
    }

    public void setNameMarca(String nameMarca) {
        this.nameMarca = nameMarca;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getNumComercials() {
        return numComercials;
    }

    public void setNumComercials(int numComercials) {
        this.numComercials = numComercials;
    }

    public String getAmbassador() {
        return ambassador;
    }

    public void setAmbassador(String ambassador) {
        this.ambassador = ambassador;
    }
}
