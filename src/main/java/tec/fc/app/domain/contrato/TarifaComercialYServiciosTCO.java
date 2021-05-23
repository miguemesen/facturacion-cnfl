package tec.fc.app.domain.contrato;

public class TarifaComercialYServiciosTCO extends GenericContrato{
    public TarifaComercialYServiciosTCO(Integer contractNumber, int contractPromiseeId, int tipo) { // tipo 9
        super(contractNumber, contractPromiseeId, tipo);
    }

    public double getTarifa(int kWh){
        if (kWh <= 3000){
            return 111.79;
        }
        return 67.31;
    }
}
