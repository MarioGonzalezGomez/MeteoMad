import service.LectorCsv;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Número de parámetros incorrecto: para usar este programa necesitas introducir dos parámetros: " +
                    "1.nombre de la ciudad de la que se desean obtener los datos " +
                    "2. directorio donde queremos guardar el informe resultante");
        } else {
            File directorio = new File(args[1]);
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    System.out.println("El directorio ha sido creado con éxito");
                } else {
                    System.out.println("Error al crear el directorio");
                }
            }

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


}
