package tec.fc.app;

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
        System.out.println("5. Salir");
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


}

