package tec.fc.app.domain.contrato;

public abstract class GenericContrato {

    private int contractNumber;
    private int contractPromiseeId;
    protected int tarifa;

    public GenericContrato(int contractNumber, int contractPromiseeId) {
        this.contractNumber = contractNumber;
        this.contractPromiseeId = contractPromiseeId;
    }

    public int calculoCobro(int kWh_consumidos){
        return kWh_consumidos * tarifa;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getContractPromiseeId() {
        return contractPromiseeId;
    }

    public void setContractPromiseeId(int contractPromiseeId) {
        this.contractPromiseeId = contractPromiseeId;
    }
}
