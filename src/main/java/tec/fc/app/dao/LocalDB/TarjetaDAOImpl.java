package tec.fc.app.dao.LocalDB;

import tec.fc.app.dao.TarjetaDAO;
import tec.fc.app.domain.Tarjeta;

import java.util.ArrayList;

public class TarjetaDAOImpl extends GenericDAOImpl<Tarjeta,Integer> implements TarjetaDAO {
    public TarjetaDAOImpl(ArrayList<Tarjeta> table) {
        super(table);
    }

}
