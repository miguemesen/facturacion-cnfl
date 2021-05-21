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
        System.out.println("Hola funcionario " + name + ", bienvenide al sistema de facturacion del CNFL");

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

    void printReportes(int idReporte, Date fecha, int tarifa, int kWh, int monto){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id reporte: " + idReporte);
        System.out.println("Fecha: " + fecha.toString());
        System.out.println("Tarifa kWh: " + tarifa);
        System.out.println("kWh: " + kWh);
        System.out.println("Monto a pagar: " + monto);
    }

    void printApelaciones(){
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
        System.out.println("3. Solicitudes de Medidor");
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

    void printVerTodosLosMedidores(int contractNumber, String contractPromiseeName){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Número contrato medidor: " + contractNumber);
        System.out.println("Propietario del contrato: " + contractPromiseeName);
    }

    void printPagosPendients(int idMedidor, int montoPendiente){
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


    void printMisMedidores(int idMedidor, int tarifaMedidor, int pagoPendiente){
        System.out.println("________________________________________________________________________________________");
        System.out.println("Id de medidor: " + idMedidor);
        System.out.println("Tarifa de medidor: " + tarifaMedidor);
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

    void printMisTarjetas(int idTarjeta, long cardNumber, int saldo){
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
        System.out.println("1. Sí");
        System.out.println("2. No");
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


}

