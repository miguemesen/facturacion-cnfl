package tec.fc.app.domain;

import java.util.ArrayList;

public class Medidor {

    private ArrayList<Reporte> historial = new ArrayList<>();

    public void agregarReporte(Reporte reporte){
        this.historial.add(reporte);
    }

    public Reporte getReporteById(int id){
        for (Reporte reporte : historial){
            if (reporte.getId() == id){
                return reporte;
            }
        }
        return null;
    }


}
