import service.LectorCsv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Número de parámetros incorrecto: para usar este programa necesitas introducir dos parámetros: " +
                    "1.nombre de la ciudad de la que se desean obtener los datos " +
                    "2. directorio donde queremos guardar el informe resultante");
        } else {
            long initTime = System.currentTimeMillis();
            Path directorio = Paths.get(args[1]);

            if (Files.notExists(directorio)) {
                Files.createDirectory(Paths.get(args[1]));
                System.out.println("El directorio se ha creado con éxito");
            }

            String urlMeteo = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "calidad_aire_datos_meteo_mes.csv";
            File datosMeteo = new File(urlMeteo);
            String urlContaminacion = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "calidad_aire_datos_mes.csv";
            File datosContaminacion = new File(urlMeteo);

            String ciudad = args[0];

            //implementar metodo asincronia
            ExecutorService executorService = Executors.newFixedThreadPool(3);


            LectorCsv lCsv = new LectorCsv();
            System.out.println("Lector de CSV by Andrea Gómez De Pablo y Mario González Gómez");
            System.out.println("Informe de datos de " + ciudad);
            System.out.println("Fecha de inicio de la medición: ");
            System.out.println("Fecha de fin de la medición: ");
            System.out.println("Estación/estaciones asociadas: ");
            //Todos estos sysos son temporales, será la información que irá en el documento generado
            System.out.println("************************   DATOS METEO     *******************************");
            lCsv.leerCsv(datosMeteo, ciudad);
            System.out.println(" ************************   DATOS CONTAMINACION     *******************************");
            lCsv.leerCsv(datosContaminacion, ciudad);
            LocalDate ld = LocalDate.now();
            Calendar cldr = Calendar.getInstance();

            System.out.println("Informe generado el " + ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear() + " a las "
                    + cldr.get(Calendar.HOUR_OF_DAY) + ":" + cldr.get(Calendar.MINUTE) + ":" + cldr.get(Calendar.SECOND) +
                    " en " + (System.currentTimeMillis() - initTime) / 1000 + " segundos.");
        }
    }


}
