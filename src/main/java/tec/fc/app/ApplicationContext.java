package tec.fc.app;

import tec.fc.app.dao.ContratoDAO;
import tec.fc.app.dao.MedidorDAO;
import tec.fc.app.dao.PersonaDAO;
import tec.fc.app.dao.ReporteDAO;
import tec.fc.app.database.LocalDB;
import tec.fc.app.service.ContratoService;
import tec.fc.app.service.MedidorService;
import tec.fc.app.service.PersonaService;
import tec.fc.app.service.ReporteService;

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


}
