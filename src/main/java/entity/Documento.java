package entity;

import lombok.Data;
import model.Meteo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Data
public class Documento {
    List<Documento> medicionesCiudad;
    Documento medicionesDia;
    private List<StringTokenizer> datosCiudad;
    private int provincia;
    private int municipio;
    private int estacion;
    private int magnitud;
    private String puntoMuestreo;
    private int ano;
    private int mes;
    private int dia;
    private String fecha;
    private int hora;
    List<String> medicionesHora = new ArrayList<>();// if campo 9 es h01 hora=1;


    public void mapeoDocumento() {


        for (StringTokenizer linea : datosCiudad) { //Cada linea es la medicion de una magnitud
            medicionesDia = new Documento();
            medicionesDia.setProvincia(Integer.parseInt(linea.nextToken()));
            medicionesDia.setMunicipio(Integer.parseInt(linea.nextToken()));
            medicionesDia.setEstacion(Integer.parseInt(linea.nextToken()));
            medicionesDia.setMagnitud(Integer.parseInt(linea.nextToken()));
            medicionesDia.setPuntoMuestreo(linea.nextToken());
            medicionesDia.setAno(Integer.parseInt(linea.nextToken()));
            medicionesDia.setMes(Integer.parseInt(linea.nextToken()));
            medicionesDia.setDia(Integer.parseInt(linea.nextToken()));
            medicionesDia.setFecha(generarFecha());


            while (linea.hasMoreTokens()) {
                medicionesHora.add(linea.nextToken());

            }

            medicionesDia.setMedicionesHora(medicionesHora);
            medicionesCiudad = new ArrayList<>();
            medicionesCiudad.add(medicionesDia);


            System.out.println(medicionesDia.toString());

        }


    }

    public String generarFecha() {
        String fecha;
        fecha = medicionesDia.getAno() + "-" + medicionesDia.getMes() + "-" + medicionesDia.getDia();
        return fecha;

    }


}



