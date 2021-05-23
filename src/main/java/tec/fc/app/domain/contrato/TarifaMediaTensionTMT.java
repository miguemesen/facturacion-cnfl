package tec.fc.app.domain.contrato;

public class TarifaMediaTensionTMT extends GenericContrato{
    public TarifaMediaTensionTMT(Integer contractNumber, int contractPromiseeId, int tipo) { // Tipo 5
        super(contractNumber, contractPromiseeId, tipo);
    }

    public double getTarifa_punta() {
        return 57.02;
    }

    public double getTarifa_valle() {
        return 28.51;
    }

    public double getTarifa_noche() {
        return 20.53;
    }
}
