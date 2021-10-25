package service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EscritorFichero {
    public void escribirFichero(String rutaDirectorio, String ciudad, List<String> datos) throws IOException {
        List<String> imprimir = new ArrayList<>();
        LocalDate ld = LocalDate.now();
        Path filePath = Paths.get(rutaDirectorio + File.separator + ciudad + "-" + ld.getDayOfMonth() + "-" + ld.getMonth() + "-" + ld.getYear() + ".html");
        //Ruta para probar funcionamiento
        //Path filePath = Paths.get("C:\\Users\\Mario\\Desktop");
        Files.createFile(filePath);
        //Con esta opción se sobreescribirá el documento si hay otro llamado igual
        // Files.write(filePath, datos, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        String lineaOutput;
        byte[] strToBytes = new byte[0];
        //Para insertar imagen con markdown se pone ![texto descriptivo](enlace a la imagen)
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    lineaOutput = ">Lector de CSV by ***Andrea Gómez De Pablo*** y ***Mario González Gómez***";
                    strToBytes = lineaOutput.getBytes();
                    lineaOutput = "___";
                    strToBytes = lineaOutput.getBytes();
                    break;
                case 1:
                    lineaOutput = "![Portada del informe](https://d7lju56vlbdri.cloudfront.net/var/ezwebin_site/storage/images/_aliases/img_1col/noticias/madrid-es-la-ciudad-europea-con-mayor-nivel-de-contaminacion-por-no2-y-mortalidad-asociada/8552348-12-esl-MX/Madrid-es-la-ciudad-europea-con-mayor-nivel-de-contaminacion-por-NO2-y-mortalidad-asociada.jpg)";
                    strToBytes = lineaOutput.getBytes();
                    break;
                case 2:
                    lineaOutput = "#Informe de datos de " + ciudad;
                    strToBytes = lineaOutput.getBytes();
                    break;
                case 3:
                    lineaOutput = "-Fecha de inicio de la medición: ";
                    strToBytes = lineaOutput.getBytes();
                    break;
                case 4:
                    lineaOutput = "-Fecha de fin de la medición: ";
                    strToBytes = lineaOutput.getBytes();
                    break;
                case 5:
                    lineaOutput = "-Estación/estaciones asociadas: ";
                    strToBytes = lineaOutput.getBytes();
                    break;
                case 6:
                    break;
                default:
                    lineaOutput = "ERROR- LÍNEA NO LEÍDA";
                    strToBytes = lineaOutput.getBytes();
            }
            Files.write(filePath, strToBytes, StandardOpenOption.CREATE);
        }


    }
}
