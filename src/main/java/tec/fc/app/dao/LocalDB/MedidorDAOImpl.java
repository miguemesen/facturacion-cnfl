package tec.fc.app.dao.LocalDB;

import tec.fc.app.dao.MedidorDAO;
import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.contrato.GenericContrato;

import java.util.ArrayList;

public class MedidorDAOImpl extends GenericDAOImpl<Medidor, Integer> implements MedidorDAO{

    public MedidorDAOImpl(ArrayList<Medidor> table) {
        super(table);
    }
}
