package tec.fc.app.service;

import tec.fc.app.dao.ReporteDAO;
import tec.fc.app.domain.Reporte;

import java.util.ArrayList;
import java.util.List;

public class ReporteServiceImpl implements ReporteService{

    private ReporteDAO reporteDAO;

    public ReporteServiceImpl(ReporteDAO reporteDAO) {
        this.reporteDAO = reporteDAO;
    }

    @Override
    public List getAll() {
        return this.reporteDAO.findAll();
    }

    @Override
    public Reporte getById(Integer id) {
        return this.reporteDAO.findById(id);
    }

    @Override
    public void addNew(Reporte o) {
        this.reporteDAO.save((Reporte) o);
    }

    @Override
    public void update(Reporte o) {
        this.reporteDAO.update((Reporte) o);
    }

    @Override
    public void delete(Integer id) {
        this.reporteDAO.delete(id);
    }

    @Override
    public int getIntPagosPendientesByMedidorId(Integer id) {
        return this.getListPagosPendientesByMedidorId(id).size();
    }

    @Override
    public List<Reporte> getListPagosPendientesByMedidorId(Integer id) {
        ArrayList<Reporte> reportesList = new ArrayList<>();
        for (Reporte reporte : this.getByMedidorId(id)){
            if (reporte.isPagoPendiente()){
                reportesList.add(reporte);
            }
        }
        return reportesList;
    }

    @Override
    public int getKWhPagosPendientesByMedidorId(Integer id) {
        int kWh = 0;
        for (Reporte reporte : this.getListPagosPendientesByMedidorId(id)){
            kWh = kWh + reporte.getkWh();
        }
        return kWh;
    }

    @Override
    public List<Reporte> getByMedidorId(Integer id) {
        return this.reporteDAO.getByMedidorId(id);
    }
}
