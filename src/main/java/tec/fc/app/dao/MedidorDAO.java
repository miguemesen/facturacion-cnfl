package tec.fc.app.dao;

import tec.fc.app.domain.Medidor;

public interface MedidorDAO extends GenericDAO<Medidor, Integer> {

    Medidor getByContractNumber(Integer contractNumber);

}
