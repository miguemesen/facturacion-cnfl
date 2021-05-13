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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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



    public static void main( String[] args ) throws ParseException, IOException {

        ApplicationContext applicationContext = ApplicationContext.init();
        AppPrints appPrints = new AppPrints();

        ContratoService contratoService = applicationContext.getContratoService();
        MedidorService medidorService = applicationContext.getMedidorService();
        PersonaService personaService = applicationContext.getPersonaService();
        ReporteService reporteService = applicationContext.getReporteService();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        seleccionTipoUsuario(reader);
    }

    public static void seleccionTipoUsuario(BufferedReader reader) throws IOException {
        int Cliente = 1;
        int Funcionario = 2;
        AppPrints appPrints = new AppPrints();
        appPrints.printSeleccionTipoUsuario();

        int tipoUsuario = Integer.parseInt(reader.readLine());

        if (tipoUsuario == Cliente){

        }
        else if (tipoUsuario == Funcionario){

        }
    }

    public static void inicioSesion(BufferedReader reader, int tipoUsuario, ReporteService reporteService){

    }

}
