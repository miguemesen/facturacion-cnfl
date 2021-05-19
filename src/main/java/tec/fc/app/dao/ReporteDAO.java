package tec.fc.app.dao;

import tec.fc.app.domain.Reporte;

import java.util.List;

public interface ReporteDAO extends GenericDAO<Reporte,Integer> {

    List<Reporte> getByMedidorId(Integer id);
}
