package tec.fc.app.domain;

import java.util.Date;

public class Reporte implements Entity{
    private Integer id;
    private Date date;
    private int kWh_punta;
    private int kWh_valle;
    private int kWh_noche;
    private Integer medidorId;
    private boolean pagoPendiente;

    public Reporte(Integer id, Date date, int kWh_punta, int kWh_valle, int kWh_noche, Integer medidorId, boolean pagoPendiente) {
        this.id = id;
        this.date = date;
        this.kWh_punta = kWh_punta;
        this.kWh_valle = kWh_valle;
        this.kWh_noche = kWh_noche;
        this.medidorId = medidorId;
        this.pagoPendiente = pagoPendiente;
    }

    public boolean isPagoPendiente() {
        return pagoPendiente;
    }

    public void setPagoPendiente(boolean pagoPendiente) {
        this.pagoPendiente = pagoPendiente;
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

    public int getkWh_valle() {
        return kWh_valle;
    }

    public void setkWh_valle(int kWh_valle) {
        this.kWh_valle = kWh_valle;
    }

    public int getkWh_noche() {
        return kWh_noche;
    }

    public void setkWh_noche(int kWh_noche) {
        this.kWh_noche = kWh_noche;
    }

    public int getkWh_punta() {
        return kWh_punta;
    }

    public void setkWh_punta(int kWh_punta) {
        this.kWh_punta = kWh_punta;
    }

    public Integer getMedidorId() {
        return medidorId;
    }

    public void setMedidorId(Integer medidorId) {
        this.medidorId = medidorId;
    }
}
