package tec.fc.app.service;

import tec.fc.app.dao.ReporteDAO;
import tec.fc.app.domain.Reporte;

import java.util.List;

public class ReporteServiceImpl implements ReporteService{

    private ReporteDAO reporteDAO;

    @Override
    public List getAll() {
        return this.reporteDAO.findAll();
    }

    @Override
    public Object getById(Integer id) {
        return this.reporteDAO.findById(id);
    }

    @Override
    public void addNew(Object o) {
        this.reporteDAO.save((Reporte) o);
    }

    @Override
    public void update(Object o) {
        this.reporteDAO.update((Reporte) o);
    }

    @Override
    public void delete(Integer id) {
        this.reporteDAO.delete(id);
    }

    @Override
    public List<Reporte> getByMedidorId(Integer id) {
        return null;
    }
}
