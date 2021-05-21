package tec.fc.app.service;

import tec.fc.app.dao.MedidorDAO;
import tec.fc.app.domain.Medidor;

import java.util.List;

public class MedidorServiceImpl implements MedidorService{

    private MedidorDAO medidorDAO;

    public MedidorServiceImpl(MedidorDAO medidorDAO) {
        this.medidorDAO = medidorDAO;
    }

    @Override
    public List getAll() {
        return this.medidorDAO.findAll();
    }

    @Override
    public Medidor getById(Integer id) {
        return this.medidorDAO.findById(id);
    }

    @Override
    public void addNew(Medidor o) {
        this.medidorDAO.save((Medidor) o);
    }

    @Override
    public void update(Medidor o) {
        this.medidorDAO.update((Medidor) o);
    }

    @Override
    public void delete(Integer id) {
        this.medidorDAO.delete(id);
    }

    @Override
    public Medidor getByContractNumber(Integer contractNumber) {
        return this.medidorDAO.getByContractNumber(contractNumber);
    }
}
