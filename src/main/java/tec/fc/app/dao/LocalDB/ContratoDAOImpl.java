package tec.fc.app.dao.LocalDB;


import tec.fc.app.dao.ContratoDAO;
import tec.fc.app.domain.contrato.GenericContrato;

import java.util.ArrayList;

public class ContratoDAOImpl extends GenericDAOImpl<GenericContrato, Integer> implements ContratoDAO {

    public ContratoDAOImpl(ArrayList<GenericContrato> table) {
        super(table);
    }


}
