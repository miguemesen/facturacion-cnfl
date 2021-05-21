package tec.fc.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import tec.fc.app.domain.Medidor;
import tec.fc.app.domain.Reporte;
import tec.fc.app.domain.Tarjeta;
import tec.fc.app.domain.cliente.Persona;
import tec.fc.app.domain.contrato.GenericContrato;
import tec.fc.app.domain.contrato.TarifaResidencialHorariaTREH;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JSONParser {

    private File file;
    private ObjectMapper mapper;
    private JsonNode node;

    public JSONParser(){
        file = new File("src/main/resources/data.json");
        mapper = new ObjectMapper();

        try {
            node = mapper.readTree(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Persona> cargarPersonas(){
        ArrayList<Persona> listPersonas = new ArrayList<>();
        ArrayNode personas = (ArrayNode) node.get("personas");
        if (personas != null){
            for (int i = 0; i < personas.size(); i++){
                JsonNode persona = personas.get(i);
                int id = persona.get("id").asInt();
                String name = persona.get("name").asText();
                String address = persona.get("address").asText();
                boolean personaFisica = Boolean.parseBoolean(persona.get("personaFisica").asText());
                boolean funcionario = Boolean.parseBoolean(persona.get("funcionario").asText());

                Persona newPersona = new Persona(id,name,address,personaFisica,funcionario);
                listPersonas.add(newPersona);
            }
        }
        return listPersonas;
    }

    public ArrayList<GenericContrato> cargarContratos() {
        ArrayList<GenericContrato> listContratos = new ArrayList<>();
        ArrayNode contratos = (ArrayNode) node.get("contratos");
        if (contratos != null) {
            for (int i = 0; i < contratos.size(); i++) {
                JsonNode contrato = contratos.get(i);
                int contractNumber = contrato.get("contractNumber").asInt();
                int contractPromiseeId = contrato.get("contractPromiseeId").asInt();

                TarifaResidencialHorariaTREH contratoTREH = new TarifaResidencialHorariaTREH(contractNumber, contractPromiseeId);
                listContratos.add(contratoTREH);
            }
        }
        return listContratos;
    }

    public ArrayList<Medidor> cargarMedidores() {
        ArrayList<Medidor> listMedidores = new ArrayList<>();
        ArrayNode medidores = (ArrayNode) node.get("medidores");
        if (medidores != null) {
            for (int i = 0; i < medidores.size(); i++) {
                JsonNode medidor = medidores.get(i);
                int id = medidor.get("id").asInt();
                int contractNumber = medidor.get("contractNumber").asInt();

                Medidor newMedidor = new Medidor(id, contractNumber);
                listMedidores.add(newMedidor);
            }
        }
        return listMedidores;
    }


    public ArrayList<Tarjeta> cargarTarjetas() {
        ArrayList<Tarjeta> listTarjetas = new ArrayList<>();
        ArrayNode tarjetas = (ArrayNode) node.get("tarjetas");
        if (tarjetas != null) {
            for (int i = 0; i < tarjetas.size(); i++) {
                JsonNode tarjeta = tarjetas.get(i);
                int id = tarjeta.get("id").asInt();
                int cardNumber = tarjeta.get("cardNumber").asInt();
                int ownerId = tarjeta.get("ownerId").asInt();
                int saldo = tarjeta.get("saldo").asInt();

                Tarjeta newTarjeta = new Tarjeta(id, cardNumber, ownerId,saldo);
                listTarjetas.add(newTarjeta);
            }
        }
        return listTarjetas;
    }


    public ArrayList<Reporte> cargarReportes() throws ParseException {
        ArrayList<Reporte> listReportes = new ArrayList<>();
        ArrayNode reportes = (ArrayNode) node.get("reportes");
        if (reportes != null) {
            for (int i = 0; i < reportes.size(); i++) {
                JsonNode reporte = reportes.get(i);
                int id = reporte.get("id").asInt();
                int medidorId = reporte.get("medidorId").asInt();
                int kWh = reporte.get("kWh").asInt();
                Date date = new SimpleDateFormat("dd/MM/y").parse(reporte.get("date").asText());
                boolean pagoPendiente = Boolean.parseBoolean(reporte.get("pagoPendiente").asText());

                Reporte newReporte = new Reporte(id,date,kWh,medidorId,pagoPendiente);
                listReportes.add(newReporte);
            }
        }
        return listReportes;
    }

}
