package tec.fc.app.service;

import tec.fc.app.dao.SolicitudDAO;
import tec.fc.app.domain.Solicitud;

import java.util.List;

public class SolicitudServiceImpl implements SolicitudService{

    private SolicitudDAO solicitudDAO;

    public SolicitudServiceImpl(SolicitudDAO solicitudDAO) {
        this.solicitudDAO = solicitudDAO;
    }

    @Override
    public Solicitud getById(Integer id) {
        return this.solicitudDAO.findById(id);
    }

    @Override
    public List<Solicitud> getAll() {
        return this.solicitudDAO.findAll();
    }

    @Override
    public void addNew(Solicitud solicitud) {
        this.solicitudDAO.save(solicitud);
    }

    @Override
    public void update(Solicitud solicitud) {
        this.solicitudDAO.update(solicitud);
    }

    @Override
    public void delete(Integer id) {
        this.solicitudDAO.delete(id);
    }
}
