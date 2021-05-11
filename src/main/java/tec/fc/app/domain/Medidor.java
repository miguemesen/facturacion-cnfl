package tec.fc.app.domain;

import java.util.ArrayList;

public class Medidor {

    private int id;
    private int contractNumber;
    private ArrayList<Integer> reporteId = new ArrayList<>();

    public Medidor(int id, int contractNumber) {
        this.id = id;
        this.contractNumber = contractNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }
}
