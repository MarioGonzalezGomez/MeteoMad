package model;
import lombok.Data;
@Data


public class Contaminacion {

    private MedicionContaminacion DioxidoAzufre;
    private MedicionContaminacion MonoxidoCarbono;
    private MedicionContaminacion MonoxidoNitrogeno;
    private MedicionContaminacion DioxidoNitrogeno;
    private MedicionContaminacion ParticulasSuspensionPM2;
    private MedicionContaminacion ParticulasSuspensionPM10;
    private MedicionContaminacion OxidosNitrogeno;
    private MedicionContaminacion Ozono;
    private MedicionContaminacion Tolueno;
    private MedicionContaminacion BlackCarbon;
    private MedicionContaminacion Benceno;
    private MedicionContaminacion HidrocarburosTotales;
    private MedicionContaminacion HidrocarburosNoMetanicos;
    private MedicionContaminacion Metaparaxileno;



}
