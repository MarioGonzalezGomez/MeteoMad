package model;

import lombok.Data;

@Data
public class Medicion {
    //Campos en comun de mediciones tanto meteo como contaminacion
    private String mediaMensual;  //String porque quiero concatenar con unidad de medida
    private String momentoYmaxima;
    private String getMomentoYminima;
    private String graficaEvolucionMensual;  // por dias a nivel mensual//tipo??????



}
