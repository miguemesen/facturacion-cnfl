package tec.fc.app.domain.contrato;

public class TarifaPromocionalTPRO extends GenericContrato{
    public TarifaPromocionalTPRO(Integer contractNumber, int contractPromiseeId, int tipo) { // Tipo 8
        super(contractNumber, contractPromiseeId, tipo);
    }

    public double getTarifa(int kWh){
        if (kWh <= 3000){
            return 111.79;
        }
        return 67.31;
    }
}
