package tec.fc.app;

import tec.fc.app.dao.ContratoDAO;
import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.Reporte;
import tec.fc.app.domain.cliente.Persona;
import tec.fc.app.domain.contrato.GenericContrato;
import tec.fc.app.domain.contrato.TarifaResidencialHorariaTREH;
import tec.fc.app.service.ContratoService;
import tec.fc.app.service.MedidorService;
import tec.fc.app.service.PersonaService;
import tec.fc.app.service.ReporteService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {

        ApplicationContext applicationContext = ApplicationContext.init();

        ContratoService contratoService = applicationContext.getContratoService();
        MedidorService medidorService = applicationContext.getMedidorService();
        PersonaService personaService = applicationContext.getPersonaService();
        ReporteService reporteService = applicationContext.getReporteService();


    }





//    Date date = new SimpleDateFormat("dd/MM/y").parse("30/10/2021");
//        System.out.println(date);
//
//
//    JSONParser parser = new JSONParser();
//    ArrayList<GenericContrato> contratos = parser.cargarContratos();
//    ArrayList<Medidor> medidores = parser.cargarMedidores();
//    ArrayList<Reporte> reportes = parser.cargarReportes();
//    ArrayList<Persona> personas = parser.cargarPersonas();
//
//
//        for (GenericContrato genericContrato : contratos){
//    System.out.println(genericContrato.getId());
//}
//
//        for (Medidor medidor : medidores){
//    System.out.println(medidor.getId());
//}
//
//        for (Reporte reporte : reportes){
//    System.out.println(reporte.getkWh());
//}
//
//        for (Persona persona : personas){
//    System.out.println(persona.getName());
//}

}
