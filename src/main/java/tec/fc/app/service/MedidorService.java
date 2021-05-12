package tec.fc.app.service;

import tec.fc.app.domain.Entity;
import tec.fc.app.domain.Medidor;

import java.util.List;

public interface MedidorService{

    Medidor getByContractNumber(Integer contractNumber);

    List<Medidor> getAll();

    Medidor getById(Integer id);

    void addNew(Medidor medidor);

    void update(Medidor medidor);

    void delete(Integer id);
}
