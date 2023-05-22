package uacm.edu.mx.proyectomascotas;

public class Mascota {

    private String descripcion;
    private String edad;
    private String mh;
    private String color;
    private String pelaje;
    private String nombre;
    private int ranking;
    private int foto;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getMh() {
        return mh;
    }

    public void setMh(String mh) {
        this.mh = mh;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Mascota(String descripcion, String edad, String mh, String color, String pelaje, String nombre, int ranking, int foto) {
        this.descripcion = descripcion;
        this.edad = edad;
        this.mh = mh;
        this.color = color;
        this.pelaje = pelaje;
        this.nombre = nombre;
        this.ranking = ranking;
        this.foto = foto;
    }
}
