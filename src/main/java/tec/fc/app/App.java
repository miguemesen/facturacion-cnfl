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
        TarifaResidencialHorariaTREH xd = new TarifaResidencialHorariaTREH(1,15);
        System.out.println(xd.calculoCobro(1500));

        Date date = new SimpleDateFormat("dd/MM/y").parse("30/10/2021");
        System.out.println(date);

        Medidor medidor = new Medidor();
        Reporte reporte = new Reporte(3,date,3000);
        medidor.agregarReporte(reporte);
        System.out.println(medidor.getReporteById(3).getkWh());

        medidor.getReporteById(3).setkWh(2500);

        System.out.println(medidor.getReporteById(3).getkWh());
    }
}
