package tec.fc.app.service;

import tec.fc.app.domain.Entity;
import tec.fc.app.domain.contrato.GenericContrato;

import java.util.List;

public interface ContratoService{

    List<GenericContrato> getByPromiseeId(Integer id);

    List<GenericContrato> getAll();

    GenericContrato getById(Integer id);

    void addNew(GenericContrato t);

    void update(GenericContrato t);

    void delete(Integer id);

}
