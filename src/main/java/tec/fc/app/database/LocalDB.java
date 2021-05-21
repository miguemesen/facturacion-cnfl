package tec.fc.app.database;

import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.Reporte;
import tec.fc.app.domain.Solicitud;
import tec.fc.app.domain.Tarjeta;
import tec.fc.app.domain.cliente.Persona;
import tec.fc.app.domain.contrato.GenericContrato;

import java.util.ArrayList;

public class LocalDB {

    public ArrayList<Persona> personas;
    public ArrayList<GenericContrato> contratos;
    public ArrayList<Medidor> medidores;
    public ArrayList<Reporte> reportes;
    public ArrayList<Tarjeta> tarjetas;
    public ArrayList<Solicitud> solicitudes;




    public LocalDB(ArrayList<Persona> personas, ArrayList<GenericContrato> contratos, ArrayList<Medidor> medidores, ArrayList<Reporte> reportes,ArrayList<Tarjeta> tarjetas, ArrayList<Solicitud> solicitudes) {
        this.personas = personas;
        this.contratos = contratos;
        this.medidores = medidores;
        this.reportes = reportes;
        this.tarjetas = tarjetas;
        this.solicitudes = solicitudes;
    }
}
