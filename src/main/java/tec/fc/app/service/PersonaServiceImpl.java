package tec.fc.app.service;



import tec.fc.app.dao.PersonaDAO;
import tec.fc.app.domain.cliente.Persona;

import java.util.List;

public class PersonaServiceImpl implements PersonaService{

    private PersonaDAO personaDAO;

    public PersonaServiceImpl(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    @Override
    public List getAll() {
        return this.personaDAO.findAll();
    }

    @Override
    public Object getById(Integer id) {
        return this.personaDAO.findById(id);
    }

    @Override
    public void addNew(Object o) {
        this.personaDAO.save((Persona) o);
    }

    @Override
    public void update(Object o) {
        this.personaDAO.update((Persona) o);
    }

    @Override
    public void delete(Integer id) {
        this.personaDAO.delete(id);
    }

    @Override
    public Persona getByName(String name) {
        return null;
    }
}
