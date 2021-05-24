package tec.fc.app.domain.contrato;

public class TarifaPreferencialDeCaracterSocialTCS extends GenericContrato{
    public TarifaPreferencialDeCaracterSocialTCS(Integer contractNumber, int contractPromiseeId, int tipo) { // Tipo 7
        super(contractNumber, contractPromiseeId, tipo);
    }

    public double getTarifa(int kWh){
        if (kWh <= 3000){
            return 75.29;
        }
        return 43.35;
    }
}
