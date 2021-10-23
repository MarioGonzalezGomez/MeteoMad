package model;

import java.util.List;

public class Informe {
    private String nombreCiudad;
    private long fechaInicioMedicion;
    private Long fechaFinMedicion;
    private String nombreEstacion; //pueden ser más de una, valorar una lista de estaciones
    private List<Meteo> infoMeteo;
    private List<Contaminacion> infoContaminacion;



}
