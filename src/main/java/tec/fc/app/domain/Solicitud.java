package tec.fc.app.domain;

public class Solicitud implements Entity{

    private Integer id;
    private Integer idCliente;
    private int tipo; // Tendrá un 1 si es una apelación y 2 si es una solicitud de medidor
    private String descripcion;
    private String respuesta;
    private boolean solucionado;

    public Solicitud(Integer id, int tipo, String descripcion, Integer idCliente) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.respuesta = null;
        this.solucionado = false;
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public int getTipo() {
        return tipo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public boolean isSolucionado() {
        return solucionado;
    }

    public void setSolucionado(boolean solucionado) {
        this.solucionado = solucionado;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
        return id;
    }
}
