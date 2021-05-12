package tec.fc.app;

import tec.fc.app.dao.ContratoDAO;
import tec.fc.app.dao.LocalDB.ContratoDAOImpl;
import tec.fc.app.dao.LocalDB.MedidorDAOImpl;
import tec.fc.app.dao.LocalDB.PersonaDAOImpl;
import tec.fc.app.dao.LocalDB.ReporteDAOImpl;
import tec.fc.app.dao.MedidorDAO;
import tec.fc.app.dao.PersonaDAO;
import tec.fc.app.dao.ReporteDAO;
import tec.fc.app.database.LocalDB;
import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.Reporte;
import tec.fc.app.domain.cliente.Persona;
import tec.fc.app.domain.contrato.GenericContrato;
import tec.fc.app.service.*;

import java.text.ParseException;
import java.util.ArrayList;

public class ApplicationContext {

    private LocalDB localDB;

    private ContratoDAO contratoDAO;
    private ContratoService contratoService;

    private MedidorDAO medidorDAO;
    private MedidorService medidorService;

    private PersonaDAO personaDAO;
    private PersonaService personaService;

    private ReporteDAO reporteDAO;
    private ReporteService reporteService;

    private ApplicationContext(){}

    public static ApplicationContext init() throws ParseException {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.localDB = initLocalDB();

        applicationContext.contratoDAO = initContratoDAO(applicationContext.localDB);
        applicationContext.contratoService = initContratoService(applicationContext.contratoDAO);
        applicationContext.medidorDAO = initMedidorDAO(applicationContext.localDB);
        applicationContext.medidorService = initMedidorService(applicationContext.medidorDAO);
        applicationContext.personaDAO = initPersonaDAO(applicationContext.localDB);
        applicationContext.personaService = initPersonaService(applicationContext.personaDAO);
        applicationContext.reporteDAO = initReporteDAO(applicationContext.localDB);
        applicationContext.reporteService = initReporteService(applicationContext.reporteDAO);

        return applicationContext;
    }

    public static LocalDB initLocalDB() throws ParseException {
        JSONParser parser = new JSONParser();
        ArrayList<GenericContrato> contratos = parser.cargarContratos();
        ArrayList<Medidor> medidores = parser.cargarMedidores();
        ArrayList<Reporte> reportes = parser.cargarReportes();
        ArrayList<Persona> personas = parser.cargarPersonas();

        return new LocalDB(personas,contratos,medidores,reportes);
    }

    private static ContratoDAO initContratoDAO(LocalDB localDB){
        return new ContratoDAOImpl(localDB.contratos);
    }
    private static ContratoService initContratoService(ContratoDAO contratoDAO){
        return new ContratoServiceImpl(contratoDAO);
    }

    private static MedidorDAO initMedidorDAO(LocalDB localDB){
        return new MedidorDAOImpl(localDB.medidores);
    }
    public static MedidorService initMedidorService(MedidorDAO medidorDAO){
        return new MedidorServiceImpl(medidorDAO);
    }

    public static PersonaDAO initPersonaDAO(LocalDB localDB){
        return new PersonaDAOImpl(localDB.personas);
    }
    public static PersonaService initPersonaService(PersonaDAO personaDAO){
        return new PersonaServiceImpl(personaDAO);
    }

    public static ReporteDAO initReporteDAO(LocalDB localDB){
        return new ReporteDAOImpl(localDB.reportes);
    }
    public static ReporteService initReporteService(ReporteDAO reporteDAO){
        return new ReporteServiceImpl(reporteDAO);
    }

    public ContratoService getContratoService() {
        return contratoService;
    }

    public MedidorService getMedidorService() {
        return medidorService;
    }

    public PersonaService getPersonaService() {
        return personaService;
    }

    public ReporteService getReporteService() {
        return reporteService;
    }
}
