package tec.fc.app;

import java.util.Date;

public class AppPrints {

     void printSeleccionTipoUsuario(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Por favor indicar el tipo de usuario");
        System.out.println("Ingrese 1 si es un cliente o 2 si es un funcionario");

    }



    void printInicioSessionId(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Por favor iniciar sesión");
        System.out.println("Ingrese su id:");

    }

    void printMenuCliente(String name){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Hola " + name + ", bienvenide al sistema de facturacion del CNFL");
        System.out.println("________________________________________________________________________________________");
        System.out.println("A continuación se le mostrará un menu con las opciones");
        System.out.println("que tiene disponibles, ingrese el número de la opción");
        System.out.println("que desea ver");

    }

    void printMenuFuncionario(String name){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Hola funcionarie " + name + ", bienvenide al sistema de facturacion del CNFL");

    }

    void printUsuarioNoEncontrado(int idIngresado){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe, no existe un usario en el sistema que tenga el id: " + idIngresado);
        System.out.println("Por favor re intente con un id diferente");
    }

    void printTipoUsuarioNoValido(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Por favor ingrese un tipo de usario válido");
    }

    void printMenuClienteOpciones(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Menu:");
        System.out.println("1. Mis medidores");
        System.out.println("2. Pagos pendientes");
        System.out.println("3. Mis tarjetas");
        System.out.println("4. Solicitar nuevo medidor");
        System.out.println("5. Apelaciones");
        System.out.println("6. Reportes");
        System.out.println("7. Salir");
    }

    void printReportes(int idReporte, Date fecha, int kWh_punta, int kWh_valle, int kWh_noche, double monto, boolean isPagoPendiente){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id del reporte: " + idReporte);
        System.out.println("Fecha: " + fecha.toString());
        System.out.println("kWh punta: " + kWh_punta);
        System.out.println("kWh valle: " + kWh_valle);
        System.out.println("kWh noche: " + kWh_noche);
        System.out.println("Monto a pagar: " + monto);
        if (isPagoPendiente){
            System.out.println("Pago pendiente: sí");
        } else {
            System.out.println("Pago pendiente: no");
        }
    }

    void printApelaciones(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Para realizar una apelacion debe ingresar el id del reporte que desea apelar");
        System.out.println("Podrá ver todos sus reportes con su respectivo id en la sección de reportes en el menu.");
        System.out.println("________________________________________________________________________________________");
        System.out.println("1. Realizar apelación");
        System.out.println("2. Mis apelaciones");
        System.out.println("3. Salir");
    }

    void printReporteNoPerteneceCliente(int idCliente, int idReporte){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe, el usuario con id: " + idCliente + " no posee un reporte con id: "+ idReporte);
        System.out.println("Por favor re intente con un id de reporte diferente");
    }

    void printSolicitudNoExiste(int idReporte){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe, no existe una apelación con el id: " + idReporte);
    }


    void printMenuFuncionarioOpciones(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Menu:");
        System.out.println("1. Medidores");
        System.out.println("2. Clientes");
        System.out.println("3. Reportes");
        System.out.println("4. Apelaciones");
        System.out.println("5. Salir");
    }

    void printOpcionUnoFuncionario(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("1. Ver todos los medidores");
        System.out.println("2. Buscar medidor por id");
        System.out.println("3. Actualizar medidor");
        System.out.println("4. Eliminar medidor");
        System.out.println("5. Agregar nuevo medidor");
        System.out.println("6. Regresar al menu");
    }

    void printVerTodosLosMedidores(int idMedidor, int contractNumber, String contractPromiseeName, String tipoContrato){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id de medidor: " + idMedidor);
        System.out.println("Número contrato medidor: " + contractNumber);
        System.out.println("Tipo de contrato: " + tipoContrato);
        System.out.println("Propietario del contrato: " + contractPromiseeName);
    }

    void printPagosPendients(int idMedidor, double montoPendiente){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id de medidor: " + idMedidor);
        System.out.println("Monto pendiente: "+ montoPendiente);
    }

    void printOpcionRealizarPago(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Si desea realizar un pago ingrese 1");
        System.out.println("Si desea volver al menu, ingrese cualquier tecla");
    }

    void printRealizarPago(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese el id del medidor que desea pagar");
    }


    void printMisMedidores(int idMedidor, String tipoMedidor, int pagoPendiente){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id de medidor: " + idMedidor);
        System.out.println("Tipo de contrato: " + tipoMedidor);
        System.out.println("Pagos pendientes: "+ pagoPendiente);
    }

    void printRegresarMenu(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese cualquier tecla para regresar al menu");
    }

    void printClienteNoTieneEseMedidor(int idCliente, int idMedidor){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe, el cliente con id: " + idCliente + " no posee un medidor con id: " + idMedidor);
    }

    void printMisTarjetas(int idTarjeta, long cardNumber, double saldo){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id de tarjeta: " + idTarjeta);
        System.out.println("Número de tarjeta: " + cardNumber);
        System.out.println("Saldo de tarjeta: " + saldo);
    }


    void printOpcionPagoTarjetas(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese el id de la tarjeta con la cual desea pagar");
    }

    void printSaldoInsuficiente(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("El saldo de la tarjeta es insuficiente para realizar el pago deseado");
    }

    void printTarjetaEquivocada(int idCliente){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe, la tarjeta ingresada no pertenece al cliente con id: " + idCliente);
    }

    void printApelacionIngresarIdReporte(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese el id del reporte/pago pendiente que desea apelar");
    }

    void printApelacionIngresarDescripcion(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese un texto donde explica la razón de su disconformidad");
    }

    void printApelacionGracias(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Su apelación será evaluada por un funcionario, podrá ver la respuesta a su apelación");
        System.out.println("en la opción de 'Mis apelaciones' en el menu de apelaciones. Muchas gracias.");
    }

    void printSolicitudes(int idReporte, String descripcion, String nombreCliente){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Reporte id: " + idReporte);
        System.out.println("Nombre cliente: " + nombreCliente);
        System.out.println("Descripción: " + descripcion);
    }

    void printMisApelaciones(int idReporte, String descripcion, String respuesta){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Reporte id: " + idReporte);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Respuesta: " + respuesta);
    }

    void printOpcionesApelacion(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Para solucionar una apelacion ingrese 1");
        System.out.println("Para volver al menu ingrese cualquier otra tecla");
    }

    void printSolucionApelacionIngreseId(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese el id de la apelacion que desea solucionar");
    }

    void printConformidadConRespuesta(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Está satisfeche con la respuesta recibida?");
        System.out.println("1. Sí, deseo terminar el proceso de apelación");
        System.out.println("2. No, deseo seguir hablando con el funcionario");
    }

    void printApelacionSatisfecha(String clienteName){
        System.out.println("________________________________________________________________________________________");
        System.out.println("En CNFL nos preocupamos por nuestros clientes y nos enorgullece");
        System.out.println("brindar el mejor servicio, muchas gracias "+ clienteName);
    }

    void printSolucionApelacionRespuesta(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese una respuesta al cliente");
    }

    void printTodosClientes(int id, String name, String address, boolean personaFisica){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + name);
        System.out.println("Address: " + address);
        if (personaFisica){
            System.out.println("Tipo persona: Física");
        } else {
            System.out.println("Tipo persona: Jurídica");
        }
    }


    void printReportesParaFuncionario(int idReporte, Date fecha, int kWh_punta, int kWh_valle, int kWh_noche, int idMedidor){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id reporte: " + idReporte);
        System.out.println("Fecha: " + fecha.toString());
        System.out.println("kWh punta: " + kWh_punta);
        System.out.println("kWh valle: " + kWh_valle);
        System.out.println("kWh noche: " + kWh_noche);
        System.out.println("Id medidor: " + idMedidor);
    }

    void printArreglarReporte(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Desea modificar el reporte?");
        System.out.println("________________________________________________________________________________________");
        System.out.println("Si desea modificar los kWh, ingrese 1");
        System.out.println("Si no desea realizar alguna modificación, ingrese cualquier tecla");
    }

    void printModificarKWhPunta(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese los nuevos kWh punta");
    }

    void printModificarKWhValle(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese los nuevos kWh valle");
    }

    void printModificarKWhNoche(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese los nuevos kWh noche");
    }

    void printPagoExitoso(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Pago exitoso!");
    }

    void printMenuTarjetas(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("1. Ver mis tarjetas");
        System.out.println("2. Agregar tarjeta nueva");
        System.out.println("3. Eliminar tarjeta");
        System.out.println("4. Salir");
    }

    void printAgregarNumeroTarjeta(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese el número de tarjeta");
    }

    void printAgregarSaldo(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese saldo de tarjeta");
    }

    void printIngreseIdEliminarTarjeta(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese el id de la tarjeta que desea eliminar");
    }

    void printTarjetaEliminadaConExito(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Tarjeta eliminada con éxito");
    }

    void printNoImplementadoCliente(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe usuario, por ahora no está disponible esta opción desde la aplicación.");
        System.out.println("Para más información: https://www.cnfl.go.cr");
    }

    void printNoImplementadoFuncionario(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe funcionario, por ahora no está disponible esta opción desde la aplicación.");
        System.out.println("Para más información comunicarse con la sede central de CNFL.");
    }

    void printInformacionContrato(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Para más información sobre los tipos de contrato:");
        System.out.println("https://www.cnfl.go.cr/documentos/transparencia/consolidado_tarifas.pdf");
    }

    void printBuscarMedidorPorId(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese el id del medidor que desea buscar");
    }

    void printMedidorNoExiste(int idMedidor){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe, no exista un medidor con el id: " + idMedidor);
    }

    void printReporteNoExiste(int idReporte){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Disculpe, no exista un reporte con el id: " + idReporte);
    }

    void printReportesDeMedidor(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Reportes del medidor");
        System.out.println("________________________________________________________________________________________");
        System.out.println("");
    }

    void printIngreseIdReporte(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Ingrese el id del reporte que desea buscar");
    }

    void printOpcionSeisCliente(){
        System.out.println("________________________________________________________________________________________");
        System.out.println("1. Ver reportes con pago pendiente");
        System.out.println("2. Ver reportes con pago realizado");
        System.out.println("3. Salir");
    }
}

