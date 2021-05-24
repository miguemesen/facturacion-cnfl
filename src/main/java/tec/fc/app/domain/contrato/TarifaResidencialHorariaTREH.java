package tec.fc.app.domain.contrato;

import tec.fc.app.domain.Entity;

public class TarifaResidencialHorariaTREH extends GenericContrato{ // Tipo 1


    public TarifaResidencialHorariaTREH(Integer contractNumber, int contractPromiseeId, int tipo) {
        super(contractNumber, contractPromiseeId, tipo);
    }


    public double getTarifa_punta(int kWh) {
        if (kWh <=501){
            return 189.34;
        }
        return 153.14;
    }

    public double getTarifa_valle(int kWh) {
        if (kWh <=501){
            return 76.42;
        }
        return 62.78;
    }

    public double getTarifa_noche(int kWh) {
        if (kWh <=501){
            return 35.37;
        }
        return 26.28;
    }
}
