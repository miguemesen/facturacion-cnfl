package tec.fc.app.service;

import tec.fc.app.dao.TarjetaDAO;
import tec.fc.app.domain.Tarjeta;

import java.util.ArrayList;
import java.util.List;

public class TarjetaServiceImpl implements TarjetaService{

    private TarjetaDAO tarjetaDAO;

    public TarjetaServiceImpl(TarjetaDAO tarjetaDAO) {
        this.tarjetaDAO = tarjetaDAO;
    }

    @Override
    public Integer getLastId() {
        return this.tarjetaDAO.getLastId();
    }

    @Override
    public List<Tarjeta> getByOwnerId(Integer id) {
        ArrayList<Tarjeta> list = new ArrayList<>();

        for (Tarjeta tarjeta : this.tarjetaDAO.findAll()){
            if (tarjeta.getOwnerId() == id){
                list.add(tarjeta);
            }
        }
        return list;
    }

    @Override
    public List<Tarjeta> getAll() {
        return this.tarjetaDAO.findAll();
    }

    @Override
    public Tarjeta getById(Integer id) {
        return this.tarjetaDAO.findById(id);
    }

    @Override
    public void addNew(Tarjeta tarjeta) {
        this.tarjetaDAO.save(tarjeta);
    }

    @Override
    public void delete(Integer idTarjeta) {
        this.tarjetaDAO.delete(idTarjeta);
    }
}
