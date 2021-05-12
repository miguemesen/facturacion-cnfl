package tec.fc.app.dao.LocalDB;

import tec.fc.app.dao.PersonaDAO;
import tec.fc.app.domain.cliente.Persona;

import java.util.ArrayList;

public class PersonaDAOImpl extends GenericDAOImpl<Persona, Integer> implements PersonaDAO {
    public PersonaDAOImpl(ArrayList<Persona> table) {
        super(table);
    }
}
