package tec.fc.app.domain.cliente;

public abstract class Persona {

    private int id;
    private String name;
    private String address;

    public Persona(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
