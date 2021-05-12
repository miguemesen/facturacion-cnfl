package tec.fc.app.dao.LocalDB;

import tec.fc.app.dao.ReporteDAO;
import tec.fc.app.domain.Reporte;

import java.util.ArrayList;

public class ReporteDAOImpl extends GenericDAOImpl<Reporte, Integer> implements ReporteDAO {
    public ReporteDAOImpl(ArrayList<Reporte> table) {
        super(table);
    }
}
