package tec.fc.app.domain.contrato;

import tec.fc.app.domain.Entity;

public abstract class GenericContrato implements Entity {

    private Integer id;
    private int contractPromiseeId;
    private int tipo;

    public GenericContrato(Integer contractNumber, int contractPromiseeId, int tipo) {
        this.id = contractNumber;
        this.contractPromiseeId = contractPromiseeId;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

}
