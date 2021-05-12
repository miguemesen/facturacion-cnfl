package tec.fc.app.service;

import tec.fc.app.domain.Entity;
import tec.fc.app.domain.contrato.GenericContrato;

import java.util.List;

public interface ContratoService extends GenericService{

    List<GenericContrato> getByPromiseeId(Integer id);

}
