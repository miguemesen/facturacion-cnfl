package tec.fc.app;

import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.Reporte;
import tec.fc.app.domain.Tarjeta;
import tec.fc.app.domain.contrato.GenericContrato;
import tec.fc.app.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AppTerminal {

    private ContratoService contratoService;
    private MedidorService medidorService;
    private PersonaService personaService;
    private ReporteService reporteService;
    private TarjetaService tarjetaService;
    private SolicitudService solicitudService;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    AppPrints appPrints = new AppPrints();
    int Cliente = 1;
    int Funcionario = 2;

    public AppTerminal(ContratoService contratoService, MedidorService medidorService, PersonaService personaService, ReporteService reporteService, TarjetaService tarjetaService, SolicitudService solicitudService) {
        this.contratoService = contratoService;
        this.medidorService = medidorService;
        this.personaService = personaService;
        this.reporteService = reporteService;
        this.tarjetaService = tarjetaService;
        this.solicitudService = solicitudService;
    }



    private void seleccionTipoUsuario() throws IOException {
        this.appPrints.printSeleccionTipoUsuario();

        int tipoUsuario = Integer.parseInt(this.reader.readLine());

        if (tipoUsuario == this.Cliente){
            inicioSesionClienteId();
        }
        else if (tipoUsuario == this.Funcionario){
            appPrints.printInicioSessionId();
            inicioSesionFuncionarioId();
        } else {
            appPrints.printTipoUsuarioNoValido();
            seleccionTipoUsuario();
        }
    }


    //________________________________________________________________________________________________________________________
    // Inicio de session como cliente o funcionario
    //________________________________________________________________________________________________________________________

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

    private void inicioSesionFuncionarioId() throws IOException {
        int idIngresado = 0;
        try {
            idIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException | IOException e) {
            inicioSesionFuncionarioId();
        }

        if (personaService.getById(idIngresado) != null && personaService.getById(idIngresado).isFuncionario()){
            appPrints.printMenuFuncionario(personaService.getById(idIngresado).getName());
            menuFuncionario();
        } else {
            appPrints.printUsuarioNoEncontrado(idIngresado);
            seleccionTipoUsuario();
        }

    }

    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________




    //________________________________________________________________________________________________________________________
    // Proceso para hacer un pago con tarjeta como cliente
    //________________________________________________________________________________________________________________________

    private void realizarPago(int idCliente) throws IOException {
        appPrints.printRealizarPago();
        int idMedidor = 0;
        try {
            idMedidor = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException | IOException e) {
            opcionRealizarPago(idCliente);
            realizarPago(idCliente);
        }

        for (GenericContrato genericContrato : this.contratoService.getByPromiseeId(idCliente)){
            if (this.medidorService.getByContractNumber(genericContrato.getId()).getId() == idMedidor){ // Verificamos si el medidor le pertenece a ese cliente

                if (pagoTarjeta(
                        idCliente,
                        this.reporteService.getKWhPagosPendientesByMedidorId(idMedidor) * this.contratoService.getById(this.medidorService.getById(idMedidor).getContractNumber()).getTarifa()
                )){ // Ingresa tarjeta, verificamos si la tarjeta pertenece al cliente y si tienen saldo suficiente

                    for (Reporte reporte : this.reporteService.getListPagosPendientesByMedidorId(idMedidor)){
                        this.reporteService.update(new Reporte(reporte.getId(),reporte.getDate(),reporte.getkWh(),reporte.getMedidorId(),false));
                    }
                    menuCliente(idCliente);
                }
                menuCliente(idCliente);
            }

        }
        appPrints.printClienteNoTieneEseMedidor(idCliente,idMedidor);
        menuCliente(idCliente);

    }

    private boolean pagoTarjeta(int idCliente, int montoPorPagar) throws IOException {
        appPrints.printOpcionPagoTarjetas();

        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException | IOException e) {
            pagoTarjeta(idCliente, montoPorPagar);
        }

        for (Tarjeta tarjeta: tarjetaService.getByOwnerId(idCliente)){ // Verificamos que la tarjeta ingresada pertenezca al cliente
            if (tarjeta.getId() == opcionIngresado){
                if (tarjeta.getSaldo() >= montoPorPagar){
                    tarjeta.setSaldo(tarjeta.getSaldo() - montoPorPagar);
                    return true;
                }
                appPrints.printSaldoInsuficiente();
                return false;
            }
        }
        appPrints.printTarjetaEquivocada(idCliente);
        return false;
    }


    private void opcionRealizarPago(int idCliente) throws IOException {

        appPrints.printOpcionRealizarPago();

        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException | IOException e) {
            opcionRealizarPago(idCliente);
        }

        // Confirma realizar pago
        if (opcionIngresado == 1){
            realizarPago(idCliente);
        } else { // Regresar al menu principal
            menuCliente(idCliente);
        }
    }
    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________



    //________________________________________________________________________________________________________________________
    // Opciones de Menu Funcionario
    //________________________________________________________________________________________________________________________

    // Medidores
    private void opcionUnoFuncionario() throws IOException {
        appPrints.printOpcionUnoFuncionario();
        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException | IOException e) {
            opcionUnoFuncionario();
        }

        if (opcionIngresado == 1){
            for (GenericContrato genericContrato : this.contratoService.getAll()){
                appPrints.printVerTodosLosMedidores(genericContrato.getId(),this.personaService.getById(genericContrato.getContractPromiseeId()).getName());
            }
            regresarAlMenuDeMedidores();

        }
        else if (opcionIngresado == 2){
            System.out.println("No implementado");
        }
        else if (opcionIngresado == 6){
            menuFuncionario();
        }
    }

    private void opcionDosFuncionario(){}

    private void opcionTresFuncionario(){}

    private void opcionCuatroFuncionario(){

    }

    private void opcionCincoFuncionario() throws IOException {
        seleccionTipoUsuario();
    }


    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________


    //________________________________________________________________________________________________________________________
    // Regresa al funcionario al menu de medidores
    //________________________________________________________________________________________________________________________

    private void regresarAlMenuDeMedidores() throws IOException {
        appPrints.printRegresarMenu();
        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException | IOException e) {
            regresarAlMenuDeMedidores();
        }
        opcionUnoFuncionario();
    }
    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________


    //________________________________________________________________________________________________________________________
    // Regresa al funcionario al menu de funcionario
    //________________________________________________________________________________________________________________________

    private void regresarAlMenuFuncionario() throws IOException {
        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException | IOException e) {
            regresarAlMenuFuncionario();
        }
        menuFuncionario();
    }
    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________


    //________________________________________________________________________________________________________________________
    // Regresa al cliente al menu de cliente
    //________________________________________________________________________________________________________________________

    private void regresarAlMenu(int idCliente) throws IOException {
        appPrints.printRegresarMenu();
        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException | IOException e) {
            regresarAlMenu(idCliente);
        }
        menuCliente(idCliente);
    }
    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________



    //________________________________________________________________________________________________________________________
    // Opciones de Menu cliente
    //________________________________________________________________________________________________________________________

    // Mis medidores
    private void opcionUno(int idCliente) throws IOException {
        for (GenericContrato genericContrato : this.contratoService.getByPromiseeId(idCliente)){
            appPrints.printMisMedidores(
                    medidorService.getByContractNumber(genericContrato.getId()).getId(),
                    genericContrato.getTarifa(),
                    reporteService.getIntPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId()));
        }
        regresarAlMenu(idCliente);
    }

    // Pagos pendientes
    private void opcionDos(int idCliente) throws IOException {
        for (GenericContrato genericContrato : this.contratoService.getByPromiseeId(idCliente)){
            if (reporteService.getIntPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId()) != 0){ // verificamos si el medidor tiene pagos pendientes
                appPrints.printPagosPendients(
                        medidorService.getByContractNumber(genericContrato.getId()).getId(),
                        reporteService.getKWhPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId()) * genericContrato.getTarifa() // multiplicamos los kwh acumulados por la tarifa del respectivo medidor
                );
            }
        }
        opcionRealizarPago(idCliente);
    }

    // Mis tarjetas
    private void opcionTres(int idCliente) throws IOException {
        for (Tarjeta tarjeta : tarjetaService.getByOwnerId(idCliente)){
            appPrints.printMisTarjetas(tarjeta.getId(),tarjeta.getCardNumber(), tarjeta.getSaldo());
        }
        regresarAlMenu(idCliente);
    }

    // Solicitar nuevo medidor
    private void opcionCuatro(int idCliente){



    }

    // Apelacion
    private void opcionCinco(int idCliente) throws IOException{
        appPrints.printApelacionIngresarIdReporte();
        int idReporte = 0;
        String descripcion = "";
        try {
            idReporte = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
            opcionCinco(idCliente);
        }

        appPrints.printApelacionIngresarDescripcion();
        try {
            descripcion = this.reader.readLine();
        } catch (IOException e) {
            opcionCinco(idCliente);
        }
        appPrints.printApelacionGracias();

        regresarAlMenu(idCliente);
    }

    // Salir / devuelve al inicio de la app
    private void opcionSeis() throws IOException {
        seleccionTipoUsuario();
    }



    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________





    //________________________________________________________________________________________________________________________
    // Menu de Funcionario
    //________________________________________________________________________________________________________________________

    private void menuFuncionario() throws IOException{
        appPrints.printMenuFuncionarioOpciones();
        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
            menuFuncionario();
        }

        if (opcionIngresado == 1){
            opcionUnoFuncionario(); // Medidores
        }
        else if (opcionIngresado == 2){
            opcionDosFuncionario();
        }
        else if(opcionIngresado == 5){
            opcionCincoFuncionario();
        }
    }

    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________





    //________________________________________________________________________________________________________________________
    // Menu de Cliente
    //________________________________________________________________________________________________________________________

    private void menuCliente(int idCliente) throws IOException {
        appPrints.printMenuClienteOpciones();

        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
            menuCliente(idCliente);
        }

        if (opcionIngresado == 1){
            opcionUno(idCliente);
        }
        else if (opcionIngresado == 2){
            opcionDos(idCliente);
        }
        else if (opcionIngresado == 3){
            opcionTres(idCliente);
        }
        else if (opcionIngresado ==4){
            opcionCuatro(idCliente);
        }
        else if(opcionIngresado == 5 ){
            opcionCinco(idCliente);
        }
        else if (opcionIngresado == 6){
            opcionSeis();
        } else {
            menuCliente(idCliente);
        }
    }

    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________







    //________________________________________________________________________________________________________________________
    // Inicio de aplicación
    //________________________________________________________________________________________________________________________

    public void start() throws IOException {
        seleccionTipoUsuario();
    }
    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________

}
