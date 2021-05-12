package tec.fc.app.domain;

import java.util.ArrayList;

public class Medidor implements Entity{

    private Integer id;
    private Integer contractNumber;

    public Medidor(Integer id, Integer contractNumber) {
        this.id = id;
        this.contractNumber = contractNumber;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

}
