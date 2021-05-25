package tec.fc.app.service;


import tec.fc.app.domain.Entity;
import tec.fc.app.domain.Reporte;

import java.util.List;

public interface ReporteService{

    int getIntPagosPendientesByMedidorId(Integer id);

    List<Reporte> getListPagosPendientesByMedidorId(Integer id);

    List<Reporte> getListPagosRealizadosByMedidorId(Integer id);

    int getKWhTotalesPagosPendientesByMedidorId(Integer id);

    List<Reporte> getByMedidorId(Integer id);

    List<Reporte> getAll();

    Reporte getById(Integer id);

    void addNew(Reporte reporte);

    void update(Reporte reporte);

    void delete(Integer id);
}
