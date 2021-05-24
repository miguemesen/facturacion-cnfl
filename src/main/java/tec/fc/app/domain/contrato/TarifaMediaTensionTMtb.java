package tec.fc.app.domain.contrato;

public class TarifaMediaTensionTMtb extends GenericContrato{
    public TarifaMediaTensionTMtb(Integer contractNumber, int contractPromiseeId, int tipo) { // Tipo 6
        super(contractNumber, contractPromiseeId, tipo);
    }

    public double getTarifa_punta() {
        return 108.19;
    }

    public double getTarifa_valle() {
        return 37.17;
    }

    public double getTarifa_noche() {
        return 23.86;
    }
}
