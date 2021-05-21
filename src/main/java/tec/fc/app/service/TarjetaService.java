package tec.fc.app.service;

import tec.fc.app.domain.Tarjeta;

import java.util.List;

public interface TarjetaService {


    List<Tarjeta> getByOwnerId(Integer id);

    List<Tarjeta> getAll();

    Tarjeta getById(Integer id);

    void addNew(Tarjeta tarjeta);

    void delete(Tarjeta tarjeta);
}
