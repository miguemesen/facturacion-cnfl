package tec.fc.app.service;

import tec.fc.app.dao.ContratoDAO;
import tec.fc.app.domain.Entity;
import tec.fc.app.domain.contrato.GenericContrato;

import java.util.ArrayList;
import java.util.List;

public class ContratoServiceImpl implements ContratoService {

    private ContratoDAO contratoDAO;

    public ContratoServiceImpl(ContratoDAO contratoDAO) {
        this.contratoDAO = contratoDAO;
    }

    @Override
    public List<GenericContrato> getByPromiseeId(Integer id) {
        ArrayList<GenericContrato> list = new ArrayList<>();

        for (GenericContrato genericContrato : this.contratoDAO.findAll()){
            if (genericContrato.getContractPromiseeId() == id){
                list.add(genericContrato);
            }
        }
        return list;
    }

    @Override
    public List<GenericContrato> getAll() {
        return this.contratoDAO.findAll();
    }

    @Override
    public GenericContrato getById(Integer id) {
        return this.contratoDAO.findById(id);
    }

    @Override
    public void addNew(Object o) {
        this.contratoDAO.save((GenericContrato) o);
    }

    @Override
    public void update(Object o) {
        this.contratoDAO.update((GenericContrato) o);
    }

    @Override
    public void delete(Integer id) {
        this.contratoDAO.delete(id);
    }
}
