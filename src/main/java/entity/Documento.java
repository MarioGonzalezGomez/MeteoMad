package entity;

import lombok.Data;

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
    private List<Double> medicionesPorhora = new ArrayList<>();// if campo 9 es h01 hora=1;



    @Override
    public String toString() {
        return "Mediciones día  " + fecha + "--->" +
                "provincia=" + provincia +
                ", municipio=" + municipio +
                ", estacion=" + estacion +
                ", magnitud=" + magnitud +
                ", puntoMuestreo='" + puntoMuestreo + '\'' +
                ", medicionesPorhora=" + medicionesPorhora +
                '}';
    }

}
