package tec.fc.app.service;

import tec.fc.app.domain.Solicitud;

import java.util.List;

public interface SolicitudService {

    Solicitud getById(Integer id);

    List<Solicitud> getAll();

    void addNew(Solicitud solicitud);

    void update(Solicitud solicitud);

    void delete(Integer id);
}
