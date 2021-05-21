package tec.fc.app.domain.cliente;

import tec.fc.app.domain.Entity;

public class Persona implements Entity {

    private Integer id;
    private String name;
    private String address;
    private boolean personaFisica;
    private boolean funcionario;

    public Persona(Integer id, String name, String address, boolean personaFisica, boolean funcionario) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.personaFisica = personaFisica;
        this.funcionario = funcionario;
    }

    public boolean isPersonaFisica() {
        return personaFisica;
    }

    public void setPersonaFisica(boolean personaFisica) {
        this.personaFisica = personaFisica;
    }

    public boolean isFuncionario() {
        return funcionario;
    }

    public void setFuncionario(boolean funcionario) {
        this.funcionario = funcionario;
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
