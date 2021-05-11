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
}
