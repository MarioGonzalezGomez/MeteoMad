package model;
import lombok.Data;
import java.util.List;

@Data
public class MedicionMeteo {

    private String mediaMensual;  //String porque quiero concatenar con unidad de medida
    private String momentoYmaxima;
    private String getMomentoYminima;
    private String graficaEvolucionMensual;  // por dias a nivel mensual//tipo??????

    //Para lluvia
    private List<String> diasLlovidos; //lista dias llovidos y precipitacion de cada dia
    private String histogramaDiasLlovidos;


    public MedicionMeteo(String mediaMensual, String momentoYmaxima, String getMomentoYminima, String graficaEvolucionMensual) {
        this.mediaMensual = mediaMensual;
        this.momentoYmaxima = momentoYmaxima;
        this.getMomentoYminima = getMomentoYminima;
        this.graficaEvolucionMensual = graficaEvolucionMensual;


    }
    //Contructor solo para precipitaciones
    public MedicionMeteo(String mediaMensual, String momentoYmaxima, String getMomentoYminima, String graficaEvolucionMensual, List<String> diasLlovidos, String histogramaDiasLlovidos) {
        this.mediaMensual = mediaMensual;
        this.momentoYmaxima = momentoYmaxima;
        this.getMomentoYminima = getMomentoYminima;
        this.graficaEvolucionMensual = graficaEvolucionMensual;
        this.diasLlovidos = diasLlovidos;
        this.histogramaDiasLlovidos = histogramaDiasLlovidos;
    }
    public MedicionMeteo() {
    }
}
