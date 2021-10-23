import service.LectorCsv;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //TODO:Se debe pedir por parámetro la ciudad y el directorio donde se quiere guardar la info (Si no existe, se crea)
        //Este string es temporal para probar el lector
        String ciudad= "Leganés";
        String codCiudad="28074007";
        LectorCsv lCsv = new LectorCsv();
        //C:\Users\Mario\Desktop\Tocha\MeteoMad\src\main\resources\datos
        String urlMeteo = System.getProperty("user.dir")+ File.separator+ "src"+File.separator+"main"+File.separator+"resources"+File.separator+ "datos" +File.separator+"calidad_aire_datos_meteo_mes.csv";
        File datosMeteo = new File(urlMeteo);
        lCsv.leerCsv(datosMeteo, codCiudad);
    }

}
