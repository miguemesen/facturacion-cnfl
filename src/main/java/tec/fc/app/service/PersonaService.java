package tec.fc.app.service;

import tec.fc.app.domain.cliente.Persona;

public interface PersonaService extends GenericService{

    Persona getByName(String name);
}
