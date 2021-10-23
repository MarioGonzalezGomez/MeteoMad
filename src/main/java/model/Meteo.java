package model;
import lombok.Data;

@Data
public class Meteo {
    private MedicionMeteo temperatura;
    private MedicionMeteo radiacionSolar;
    private MedicionMeteo precipitacion;
    private MedicionMeteo humedad;
    private MedicionMeteo velocidadViento;

}
