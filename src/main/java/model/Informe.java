package model;



import java.util.List;

public class Informe {
    private String nombreCiudad;
    private long fechaInicioMedicion;
    private Long fechaFinMedicion;
    private String nombreEstacion; //pueden ser m?s de una, valorar una lista de estaciones
    private List<MedicionMeteo> infoMeteo;
    private List<MedicionContaminacion> infoContaminacion;


   // InfoGenerate generaInforme = new InfoGenerate();

}
