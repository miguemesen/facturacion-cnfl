package tec.fc.app.domain;

public class Solicitud implements Entity{

    private Integer id;
    private int tipo; // Tendrá un 1 si es una apelación y 2 si es una solicitud de medidor
    private String descripcion;

    public Solicitud(Integer id, int tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Integer getId() {
        return null;
    }
}
