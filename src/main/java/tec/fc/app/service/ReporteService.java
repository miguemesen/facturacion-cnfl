package tec.fc.app.service;


import tec.fc.app.domain.Reporte;

import java.util.List;

public interface ReporteService extends GenericService{

    List<Reporte> getByMedidorId(Integer id);
}
