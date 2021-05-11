package tec.fc.app.domain;

import java.util.Date;

public class Reporte {
    private int id;
    private Date date;
    private int kWh;
    private int medidorId;

    public Reporte(int id, Date date, int kWh, int medidorId) {
        this.id = id;
        this.date = date;
        this.kWh = kWh;
        this.medidorId = medidorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getkWh() {
        return kWh;
    }

    public void setkWh(int kWh) {
        this.kWh = kWh;
    }
}
