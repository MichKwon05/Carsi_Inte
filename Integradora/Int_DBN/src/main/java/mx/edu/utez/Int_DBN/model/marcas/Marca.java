package mx.edu.utez.Int_DBN.model.marcas;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marcas")
public class Marca {

    @Id
    private int id;

    /* { '_id': 1, 'nameMarca': 'Channel',
    'member': 'Kim Jennie',
    'numSongs': 2, 'ambassador': 'Global'},*/

    private String nameMarca;
    private String member;
    private int numComercials;
    private String ambassador;

    public Marca() {
    }

    public Marca(int id, String nameMarca, String member, int numComercials, String ambassador) {
        this.id = id;
        this.nameMarca = nameMarca;
        this.member = member;
        this.numComercials = numComercials;
        this.ambassador = ambassador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
