package tec.fc.app;

import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.Reporte;
import tec.fc.app.domain.contrato.TarifaResidencialHorariaTREH;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {

        Date date = new SimpleDateFormat("dd/MM/y").parse("30/10/2021");
        System.out.println(date);


    }
}
