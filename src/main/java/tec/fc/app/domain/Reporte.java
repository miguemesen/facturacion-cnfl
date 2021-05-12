package tec.fc.app.domain;

import java.util.Date;

public class Reporte implements Entity{
    private Integer id;
    private Date date;
    private int kWh;
    private Integer medidorId;

    public Reporte(Integer id, Date date, int kWh, Integer medidorId) {
        this.id = id;
        this.date = date;
        this.kWh = kWh;
        this.medidorId = medidorId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getMedidorId() {
        return medidorId;
    }

    public void setMedidorId(Integer medidorId) {
        this.medidorId = medidorId;
    }
}
