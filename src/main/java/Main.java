import service.LectorCsv;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) throws IOException {
        //TODO:Se debe pedir por parámetro la ciudad y el directorio donde se quiere guardar la info (Si no existe, se crea)

        String urlMeteo = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "calidad_aire_datos_meteo_mes.csv";
        File datosMeteo = new File(urlMeteo);
        String urlContaminacion = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "calidad_aire_datos_mes.csv";
        File datosContaminacion = new File(urlMeteo);

        String ciudad = "Leganés";

        //implementar metodo asincronia
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        LectorCsv lCsv = new LectorCsv();
        System.out.println("************************   DATOS METEO     *******************************");
        lCsv.leerCsv(datosMeteo, ciudad);
        System.out.println(" ************************   DATOS CONTAMINACION     *******************************");
        lCsv.leerCsv(datosContaminacion, ciudad);


    }


}
