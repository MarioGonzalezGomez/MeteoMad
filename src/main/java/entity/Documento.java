package entity;

import lombok.Data;
import model.Meteo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Data
public class Documento {
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
    private List<String> medicionesPorhora = new ArrayList<>();// if campo 9 es h01 hora=1;
    private List<StringTokenizer> datosCiudad;
    private Documento medicionesDia;
    private List<Documento> medicionesCiudad = new ArrayList<>();


    public List<Documento> mapeoDocumento() {

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
                String token =linea.nextToken();

                if (!token.contains("V")) { //Poner en un solo if.
                    if (!token.contains("N")) {
                        medicionesDia.medicionesPorhora.add(token);
                        //hay valores N (no validos) Se excluyen de la media.
                        //Intentar excluir valores String
                    }
                }
            }
            medicionesCiudad.add(medicionesDia);
        }

        for (Documento medicion : medicionesCiudad
        ) {

            System.out.println(medicion.toString());

        }

        return medicionesCiudad;
    }


    public String generarFecha() {
        String fecha;
        fecha = medicionesDia.getAno() + "-" + medicionesDia.getMes() + "-" + medicionesDia.getDia();
        return fecha;

    }


    @Override
    public String toString() {
        return "Documento{" +
                "provincia=" + provincia +
                ", municipio=" + municipio +
                ", estacion=" + estacion +
                ", magnitud=" + magnitud +
                ", puntoMuestreo='" + puntoMuestreo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", medicionesPorhora=" + medicionesPorhora +
                '}';
    }
}




