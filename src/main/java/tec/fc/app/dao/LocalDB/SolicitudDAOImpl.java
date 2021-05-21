package tec.fc.app.dao.LocalDB;

import tec.fc.app.dao.SolicitudDAO;
import tec.fc.app.domain.Solicitud;

import java.util.ArrayList;

public class SolicitudDAOImpl extends GenericDAOImpl<Solicitud,Integer> implements SolicitudDAO {

    public SolicitudDAOImpl(ArrayList<Solicitud> table) {
        super(table);
    }
}
