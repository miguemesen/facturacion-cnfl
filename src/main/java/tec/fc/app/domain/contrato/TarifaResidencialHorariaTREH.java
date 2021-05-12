package tec.fc.app.domain.contrato;

import tec.fc.app.domain.Entity;

public class TarifaResidencialHorariaTREH extends GenericContrato{


    public TarifaResidencialHorariaTREH(Integer contractNumber, int contractPromiseeId) {
        super(contractNumber, contractPromiseeId);
        tarifa = 10;
    }



}
