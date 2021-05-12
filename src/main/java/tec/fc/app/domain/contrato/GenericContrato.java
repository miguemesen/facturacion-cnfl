package tec.fc.app.domain.contrato;

import tec.fc.app.domain.Entity;

public abstract class GenericContrato implements Entity {

    private Integer id;
    private int contractPromiseeId;
    protected int tarifa;


    public GenericContrato(Integer contractNumber, int contractPromiseeId) {
        this.id = contractNumber;
        this.contractPromiseeId = contractPromiseeId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getContractPromiseeId() {
        return contractPromiseeId;
    }

    public void setContractPromiseeId(int contractPromiseeId) {
        this.contractPromiseeId = contractPromiseeId;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }
}
