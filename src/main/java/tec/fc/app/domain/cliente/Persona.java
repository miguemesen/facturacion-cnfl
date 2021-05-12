package tec.fc.app.domain.cliente;

import tec.fc.app.domain.Entity;

public abstract class Persona implements Entity {

    private Integer id;
    private String name;
    private String address;

    public Persona(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
