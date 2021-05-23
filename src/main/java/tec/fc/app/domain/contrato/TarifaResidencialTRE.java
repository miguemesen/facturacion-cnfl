package tec.fc.app.domain.contrato;

public class TarifaResidencialTRE extends GenericContrato{


    public TarifaResidencialTRE(Integer contractNumber, int contractPromiseeId, int tipo) { // Tipo 2
        super(contractNumber, contractPromiseeId, tipo);
    }

    public double getTarifa(int kWh){
        if (kWh <= 30){
            return 0;
        }
        else if (kWh <=200){
            return 66.16;
        }
        else if (kWh <= 300){
            return 101.53;
        }
        return 104.95;

    }
}
