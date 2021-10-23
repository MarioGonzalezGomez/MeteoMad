package model;
import lombok.Data;

@Data
public class MedicionContaminacion {

    private String medicionMediaMensual; //String porque quiero concatenar con unidad de medida
    private String momentoYvalorMaximo;
    private String getMomentoYvalorMinimo;
    private String graficaEvolucionMensual; //por dias a nivel mensual


    public MedicionContaminacion(String medicionMediaMensual, String momentoYvalorMaximo, String getMomentoYvalorMinimo, String graficaEvolucionMensual) {
        this.medicionMediaMensual = medicionMediaMensual;
        this.momentoYvalorMaximo = momentoYvalorMaximo;
        this.getMomentoYvalorMinimo = getMomentoYvalorMinimo;
        this.graficaEvolucionMensual = graficaEvolucionMensual;
    }

    public MedicionContaminacion() {
    }
}
