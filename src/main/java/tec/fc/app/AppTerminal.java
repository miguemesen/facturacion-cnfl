package tec.fc.app;

import tec.fc.app.domain.Reporte;
import tec.fc.app.domain.Solicitud;
import tec.fc.app.domain.Tarjeta;
import tec.fc.app.domain.cliente.Persona;
import tec.fc.app.domain.contrato.*;
import tec.fc.app.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        System.out.println("Arreglar seleccionTipoUsuario con try catch");
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
        System.out.println("Arreglar inicioSesionClienteId con try catch");
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


    private double cobroDeReporte(int idReporte){
        Reporte reporte = this.reporteService.getById(idReporte);

        if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaResidencialHorariaTREH.class){ // Tipo 1
            TarifaResidencialHorariaTREH contrato = (TarifaResidencialHorariaTREH) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return reporte.getkWh_punta() * contrato.getTarifa_punta(reporte.getkWh_punta()) + reporte.getkWh_valle() * contrato.getTarifa_valle(reporte.getkWh_valle()) + reporte.getkWh_noche() * contrato.getTarifa_noche(reporte.getkWh_noche());
        }
        else if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaResidencialTRE.class){ // Tipo 2
            TarifaResidencialTRE contrato = (TarifaResidencialTRE) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return contrato.getTarifa(reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche()) * (reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche());
        }
        else if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaAlumbradoPublicoTAP.class) { //Tipo 3
            TarifaAlumbradoPublicoTAP contrato = (TarifaAlumbradoPublicoTAP) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return contrato.getTarifa() * (reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche());
        }
        else if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaIndustrialTIN.class){ // Tipo 4
            TarifaIndustrialTIN contrato = (TarifaIndustrialTIN) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return contrato.getTarifa(reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche()) * (reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche());
        }
        else if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaMediaTensionTMT.class){ // Tipo 5
            TarifaMediaTensionTMT contrato = (TarifaMediaTensionTMT) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return reporte.getkWh_punta() * contrato.getTarifa_punta() + reporte.getkWh_valle() * contrato.getTarifa_valle() + reporte.getkWh_noche() * contrato.getTarifa_noche();
        }
        else if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaMediaTensionTMtb.class){ // Tipo 6
            TarifaMediaTensionTMtb contrato = (TarifaMediaTensionTMtb) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return reporte.getkWh_punta() * contrato.getTarifa_punta() + reporte.getkWh_valle() * contrato.getTarifa_valle() + reporte.getkWh_noche() * contrato.getTarifa_noche();
        }
        else if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaPreferencialDeCaracterSocialTCS.class){ // Tipo 7
            TarifaPreferencialDeCaracterSocialTCS contrato =(TarifaPreferencialDeCaracterSocialTCS) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return contrato.getTarifa(reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche()) * (reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche());
        }
        else if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaPromocionalTPRO.class){ // Tipo 8
            TarifaPromocionalTPRO contrato = (TarifaPromocionalTPRO) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return contrato.getTarifa(reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche()) * (reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche());
        }
        else if (this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber()).getClass() == TarifaComercialYServiciosTCO.class){
            TarifaComercialYServiciosTCO contrato = (TarifaComercialYServiciosTCO) this.contratoService.getById(this.medidorService.getById(reporte.getMedidorId()).getContractNumber());
            return contrato.getTarifa(reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche()) * (reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche());
        }
        else {
            System.out.println("Hubo un problema en cobroDeReporte");
            return 0;
        }
    }


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

                double montoPendiente = 0;
                for (Reporte reporte : this.reporteService.getListPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId())){
                    montoPendiente = montoPendiente + cobroDeReporte(reporte.getId());
                }

                if (pagoTarjeta(idCliente, montoPendiente)){ // Ingresa tarjeta, verificamos si la tarjeta pertenece al cliente y si tienen saldo suficiente

                    for (Reporte reporte : this.reporteService.getListPagosPendientesByMedidorId(idMedidor)){
                        this.reporteService.update(new Reporte(reporte.getId(),reporte.getDate(),reporte.getkWh_punta(), reporte.getkWh_valle(), reporte.getkWh_noche(),reporte.getMedidorId(),false));
                    }
                    menuCliente(idCliente);
                }
                menuCliente(idCliente);
            }

        }
        appPrints.printClienteNoTieneEseMedidor(idCliente,idMedidor);
        menuCliente(idCliente);

    }

    private boolean pagoTarjeta(int idCliente, double montoPorPagar) throws IOException {
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

        if (opcionIngresado == 1){ // Ver todos los medidores
            for (GenericContrato genericContrato : this.contratoService.getAll()){
                appPrints.printVerTodosLosMedidores(genericContrato.getId(),this.personaService.getById(genericContrato.getContractPromiseeId()).getName());
            }
            regresarAlMenuDeMedidores();

        }
        else if (opcionIngresado == 2){ // Buscar medidor por id
            System.out.println("No implementado");
        }

        else if (opcionIngresado == 3){ // Actualizar medidor
            System.out.println("No implementado");
        }
        else if (opcionIngresado == 4){ // Eliminar medidor
            System.out.println("No implementado");
        }
        else if (opcionIngresado == 5){ // Agregar nuevo medidor
            System.out.println("No implementado");
        }
        else if (opcionIngresado == 6){ // Regresar al menu
            menuFuncionario();
        }
    }

    private void opcionDosFuncionario() throws IOException {
        for (Persona persona : this.personaService.getAll()){
            appPrints.printTodosClientes(persona.getId(),persona.getName(),persona.getAddress(), persona.isPersonaFisica());
        }
        regresarAlMenuFuncionario();
    }

    private void opcionTresFuncionario(){
        System.out.println("No implementado");
    }

    private void opcionCuatroFuncionario() throws IOException {
        for (Solicitud solicitud : this.solicitudService.getAll()){
            if (!solicitud.isSolucionado()){ // Si la solicitud no se ha solucionado se hace print
                appPrints.printSolicitudes(solicitud.getId(),solicitud.getDescripcion(), personaService.getById(solicitud.getIdCliente()).getName() );
            }
        }
        if (this.solicitudService.getAll().size() != 0){
            opcionesApelacion();
        } else {
            menuFuncionario();
        }


    }

    private void opcionCincoFuncionario() throws IOException { // Salir
        seleccionTipoUsuario();
    }


    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________


    private void opcionesApelacion() throws IOException {
        appPrints.printOpcionesApelacion();
        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
            opcionesApelacion();
        }

        if (opcionIngresado == 1){ // Desea solucionar una apelacion
            solucionApelacion();
        } else {
            menuFuncionario();
        }
    }

    private void solucionApelacion() throws IOException {
        appPrints.printSolucionApelacionIngreseId();
        int idReporte = 0;
        try {
            idReporte = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
            solucionApelacion();
        }

        if (this.solicitudService.getById(idReporte) == null){
            appPrints.printSolicitudNoExiste(idReporte);
        }

        else if (this.solicitudService.getById(idReporte) != null && !this.solicitudService.getById(idReporte).isSolucionado()){ // Verificamos que no esté solucionado
            appPrints.printSolucionApelacionRespuesta();
            String respuesta = this.reader.readLine();
            this.solicitudService.getById(idReporte).setRespuesta(respuesta);
            this.solicitudService.getById(idReporte).setSolucionado(true);
        }

        regresarAlMenuFuncionario();

    }

    private void arreglarReporte(int idReporte){

    }

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
        appPrints.printRegresarMenu();
        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
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


    private String tipoMedidor(int tipoMedidor){
        if (tipoMedidor == 1){
            return "Tarifa Residencial Horaria T-REH";
        }
        else if (tipoMedidor == 2){
            return "Tarifa Residencial T-RE";
        }
        else if (tipoMedidor == 3){
            return "Tarifa Alumbrado Público T-AP";
        }
        else if (tipoMedidor == 4){
            return "Tarifa Industrial T-IN";
        }
        else if (tipoMedidor == 5){
            return "Tarifa Media Tensión T-MT";
        }
        else if (tipoMedidor == 6){
            return "Tarifa Media Tensión T-MTb";
        }
        else if (tipoMedidor == 7){
            return "Tarifa Preferencial de Carácter Social T-CS";
        }
        else if (tipoMedidor == 8){
            return "Tarifa Promocional T-PRO";
        }
        else if (tipoMedidor == 9){
            return "Tarifa Comercios y Servicios T-CO";
        }
        return "";
    }

    //________________________________________________________________________________________________________________________
    // Opciones de Menu cliente
    //________________________________________________________________________________________________________________________

    // Mis medidores
    private void opcionUno(int idCliente) throws IOException {
        for (GenericContrato genericContrato : this.contratoService.getByPromiseeId(idCliente)){
            appPrints.printMisMedidores(
                    medidorService.getByContractNumber(genericContrato.getId()).getId(),
                    tipoMedidor(genericContrato.getTipo()),
                    reporteService.getIntPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId()));
        }
        regresarAlMenu(idCliente);
    }

    // Pagos pendientes
    private void opcionDos(int idCliente) throws IOException {
        for (GenericContrato genericContrato : this.contratoService.getByPromiseeId(idCliente)){
            if (reporteService.getIntPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId()) != 0){ // verificamos si el medidor tiene pagos pendientes
                double montoPendiente = 0;
                for (Reporte reporte : this.reporteService.getListPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId())){
                    montoPendiente = montoPendiente + cobroDeReporte(reporte.getId());
                }

                appPrints.printPagosPendients(
                        medidorService.getByContractNumber(genericContrato.getId()).getId(),
                        montoPendiente
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
    private void opcionCuatro(int idCliente) throws IOException {
        System.out.println("Implementar");
        menuCliente(idCliente);
    }

    // Apelaciones
    private void opcionCinco(int idCliente) throws IOException{
        appPrints.printApelaciones();
        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
            opcionCinco(idCliente);
        }

        if (opcionIngresado == 1){ // Realizar Apelacion
            appPrints.printApelacionIngresarIdReporte();
            int idReporte = 0;
            try {
                idReporte = Integer.parseInt(this.reader.readLine());
            } catch (NumberFormatException e) {
                opcionCinco(idCliente);
            }

            if (reporteAndClient(idReporte,idCliente)){
                realizarApelacion(idReporte,idCliente);
                regresarAlMenu(idCliente);
            } else {
                appPrints.printReporteNoPerteneceCliente(idCliente,idReporte);
                regresarAlMenu(idCliente);
            }

        }
        else if (opcionIngresado == 2){ // Mis apelaciones
            for (Solicitud solicitud : this.solicitudService.getAll()){
                if (solicitud.getIdCliente() == idCliente && solicitud.isSolucionado()){
                    appPrints.printMisApelaciones(solicitud.getId(),solicitud.getDescripcion(),solicitud.getRespuesta());
                    conformidadConRespuesta(solicitud.getId(), idCliente);
                }
            }

            regresarAlMenu(idCliente);
        }
        else if (opcionIngresado == 3){ // Salir
            menuCliente(idCliente);
        } else {
            opcionCinco(idCliente);
        }

    }

    private void opcionSeis(int idCliente) throws IOException { // Reportes

        for (GenericContrato genericContrato : this.contratoService.getByPromiseeId(idCliente)){
            if (reporteService.getIntPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId()) != 0){ // verificamos si el medidor tiene pagos pendientes
                for (Reporte reporte : this.reporteService.getListPagosPendientesByMedidorId(this.medidorService.getByContractNumber(genericContrato.getId()).getId())){
                    appPrints.printReportes(reporte.getId(),reporte.getDate(),reporte.getkWh_punta() + reporte.getkWh_valle() + reporte.getkWh_noche(), cobroDeReporte(reporte.getId()), reporte.isPagoPendiente());
                }
            }
        }
        regresarAlMenu(idCliente);

    }


    // Salir / devuelve al inicio de la app
    private void opcionSiete() throws IOException {
        seleccionTipoUsuario();
    }



    //________________________________________________________________________________________________________________________
    //________________________________________________________________________________________________________________________


    private boolean reporteAndClient(int idReporte, int idCliente){
        for (GenericContrato genericContrato : this.contratoService.getByPromiseeId(idCliente)){
            if (reporteService.getIntPagosPendientesByMedidorId(medidorService.getByContractNumber(genericContrato.getId()).getId()) != 0){ // verificamos si el medidor tiene pagos pendientes
                for (Reporte reporte : this.reporteService.getListPagosPendientesByMedidorId(this.medidorService.getByContractNumber(genericContrato.getId()).getId())){
                    if (reporte.getId() == idReporte){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void realizarApelacion(int idReporte, int idCliente){

        String descripcion = "";
        appPrints.printApelacionIngresarDescripcion();
        try {
            descripcion = this.reader.readLine();
        } catch (IOException e) {
            realizarApelacion(idReporte, idCliente);
        }
        appPrints.printApelacionGracias();

        if (this.solicitudService.getById(idReporte) == null){
            this.solicitudService.addNew(new Solicitud(idReporte,1,descripcion, idCliente));
        } else {
            this.solicitudService.update(new Solicitud(idReporte,1,descripcion,idCliente));
        }


    }

    private void conformidadConRespuesta(int idReporte, int idCliente) throws IOException {
        appPrints.printConformidadConRespuesta();

        int opcionIngresado = 0;
        try {
            opcionIngresado = Integer.parseInt(this.reader.readLine());
        } catch (NumberFormatException e) {
            conformidadConRespuesta(idReporte, idCliente);
        }

        if (opcionIngresado == 1){ // Sí está conforme
            this.solicitudService.delete(idReporte);
            appPrints.printApelacionSatisfecha(this.personaService.getById(idCliente).getName());
            regresarAlMenu(idCliente);
        }
        else if (opcionIngresado == 2){ // No está conforme
            this.solicitudService.getById(idReporte).setSolucionado(false);
            realizarApelacion(idReporte,idCliente);
        } else {
            conformidadConRespuesta(idReporte, idCliente);
        }
    }



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

        if (opcionIngresado == 1){ // Medidores
            opcionUnoFuncionario();
        }
        else if (opcionIngresado == 2){ // Clientes
            opcionDosFuncionario();
        }
        else if (opcionIngresado == 3){
            opcionTresFuncionario();
        }
        else if (opcionIngresado == 4){
            opcionCuatroFuncionario();
        }
        else if(opcionIngresado == 5){ // Salir
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
            opcionSeis(idCliente);
        }
        else if (opcionIngresado == 7){
            opcionSiete();
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
