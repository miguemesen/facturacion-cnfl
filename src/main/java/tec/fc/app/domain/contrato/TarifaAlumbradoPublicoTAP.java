package tec.fc.app.domain.contrato;

public class TarifaAlumbradoPublicoTAP extends GenericContrato{
    public TarifaAlumbradoPublicoTAP(Integer contractNumber, int contractPromiseeId, int tipo) { // Tipo 3
        super(contractNumber, contractPromiseeId, tipo);
    }

    public double getTarifa(){
        return 3.22;
    }
}
