package tec.fc.app.service;

import tec.fc.app.domain.Entity;
import tec.fc.app.domain.Medidor;

public interface MedidorService extends GenericService{

    Medidor getByContractNumber(Integer contractNumber);


}
