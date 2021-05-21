package tec.fc.app.dao.LocalDB;

import tec.fc.app.dao.ReporteDAO;
import tec.fc.app.domain.Reporte;

import java.util.ArrayList;
import java.util.List;

public class ReporteDAOImpl extends GenericDAOImpl<Reporte, Integer> implements ReporteDAO {
    public ReporteDAOImpl(ArrayList<Reporte> table) {
        super(table);
    }

    @Override
    public List<Reporte> getByMedidorId(Integer id) {
        ArrayList<Reporte> reporteList = new ArrayList<>();
        for (Reporte reporte : this.table){
            if (reporte.getMedidorId().equals(id)){
                reporteList.add(reporte);
            }
        }
        return reporteList;
    }
}
