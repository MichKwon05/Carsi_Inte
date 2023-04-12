package mx.edu.utez.Int_DBN.model.members;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Members {
    @Id
    private int id;
    private String nombre;
    private String nacionalidad;
    private String cumpleanos;
    private String posicion;

    public Members() {}
    public Members(int id, String nombre, String nacionalidad, String cumpleanos, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.cumpleanos = cumpleanos;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(String cumpleanos) {
        this.cumpleanos = cumpleanos;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
