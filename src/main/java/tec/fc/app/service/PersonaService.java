package tec.fc.app.service;

import tec.fc.app.domain.Entity;
import tec.fc.app.domain.cliente.Persona;

import java.util.List;

public interface PersonaService {

    Persona getByName(String name);

    List<Persona> getAll();

    Persona getById(Integer id);

    void addNew(Persona persona);

    void update(Persona persona);

    void delete(Integer id);
}
