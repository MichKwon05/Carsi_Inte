package mx.edu.utez.Int_DBN.dto;

public class MembersDto {
    private String nombre;
    private String nacionalidad;
    private String cumpleanos;
    private String posicion;

    public MembersDto() {
    }

    public MembersDto( String nombre, String nacionalidad, String cumpleanos, String posicion) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.cumpleanos = cumpleanos;
        this.posicion = posicion;
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
