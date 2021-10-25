package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Medicion {

    //Meter todo esto en un constructor
    private String nombre;
    List<Double> mediasMedicionesDiarias = new ArrayList<>();
    private Double mediaMensual;
    private String momentoYmaxima;
    private String getMomentoYminima;
    private String graficaEvolucionMensual;
    List<Double> medicionesMensuales = new ArrayList<>();
    private String unidadMedida;


    public Medicion() {
    }

    public Medicion(String nombre, List<Double> mediasMedicionesDiarias, Double mediaMensual, String momentoYmaxima, String getMomentoYminima, String graficaEvolucionMensual) {
        this.nombre = nombre;
        this.mediasMedicionesDiarias = mediasMedicionesDiarias;
        this.mediaMensual = mediaMensual;
        this.momentoYmaxima = momentoYmaxima;
        this.getMomentoYminima = getMomentoYminima;
        this.graficaEvolucionMensual = graficaEvolucionMensual;
    }

    public Medicion(String nombre) {
        this.nombre = nombre;
    }
}
