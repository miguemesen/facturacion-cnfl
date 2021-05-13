package tec.fc.app;

import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.contrato.GenericContrato;
import tec.fc.app.service.ContratoService;
import tec.fc.app.service.MedidorService;
import tec.fc.app.service.PersonaService;
import tec.fc.app.service.ReporteService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AppTerminal {

    private ContratoService contratoService;
    private MedidorService medidorService;
    private PersonaService personaService;
    private ReporteService reporteService;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    AppPrints appPrints = new AppPrints();
    int Cliente = 1;
    int Funcionario = 2;

    public AppTerminal(ContratoService contratoService, MedidorService medidorService, PersonaService personaService, ReporteService reporteService) {
        this.contratoService = contratoService;
        this.medidorService = medidorService;
        this.personaService = personaService;
        this.reporteService = reporteService;
    }

    private void seleccionTipoUsuario() throws IOException {
        this.appPrints.printSeleccionTipoUsuario();

        int tipoUsuario = Integer.parseInt(this.reader.readLine());

        if (tipoUsuario == this.Cliente){
            inicioSesionClienteId();
        }
        else if (tipoUsuario == this.Funcionario){
            inicioSesionFuncionarioId();
        } else {
            appPrints.printTipoUsuarioNoValido();
            seleccionTipoUsuario();
        }
    }

    private void inicioSesionClienteId() throws IOException {
        appPrints.printInicioSessionId();
        int idIngresado = Integer.parseInt(this.reader.readLine());
        if (personaService.getById(idIngresado) != null){ // Si el resultado es null significa que el cliente no existe en nuestra BD
            appPrints.printMenuCliente(personaService.getById(idIngresado).getName());
            menuCliente(idIngresado);
        } else {
            appPrints.printUsuarioNoEncontrado(idIngresado);
            seleccionTipoUsuario();
        }
    }

    private void inicioSesionFuncionarioId(){}

    private void menuCliente(int idCliente) throws IOException {
        appPrints.printMenuCliente();

        int opcionIngresado = Integer.parseInt(this.reader.readLine());

        if (opcionIngresado == 1){
            for (GenericContrato genericContrato : contratoService.getByPromiseeId(idCliente)){
                appPrints.printMisMedidores(medidorService.getByContractNumber(genericContrato.getId()).getId(),genericContrato.getTarifa(),0);

            }

        }
    }

    public void start() throws IOException {
        seleccionTipoUsuario();
    }
}
