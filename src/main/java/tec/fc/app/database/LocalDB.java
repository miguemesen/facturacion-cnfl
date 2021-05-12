package tec.fc.app.database;

import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.Reporte;
import tec.fc.app.domain.cliente.Persona;
import tec.fc.app.domain.contrato.GenericContrato;

import java.util.ArrayList;

public class LocalDB {

    public ArrayList<Persona> personas;
    public ArrayList<GenericContrato> contratos;
    public ArrayList<Medidor> medidores;
    public ArrayList<Reporte> reportes;
}