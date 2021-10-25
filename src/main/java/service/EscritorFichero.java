package service;

import model.Medicion;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

import java.io.File;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class EscritorFichero {
    public void escribirFichero(String rutaDirectorio, String ciudad, List<Medicion> datos, long initTime) throws IOException {
        Utiles util = new Utiles();
        LocalDate ld = LocalDate.now();
        Calendar cldr = Calendar.getInstance();
        Path filePath = Paths.get(rutaDirectorio + File.separator + ciudad + "-" + ld.getDayOfMonth() + "-" + ld.getMonth() + "-" + ld.getYear() + ".html");
        Files.createFile(filePath);

        JFreeChart graficoTemp = util.hacerGrafica(datos, 2, "Temperatura");
        File graficoTemperatura = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoTemp");
        ChartUtils.saveChartAsPNG(graficoTemperatura, graficoTemp, 600, 400);

        JFreeChart graficoSolar = util.hacerGrafica(datos, 5, "Radiaci�n Solar");
        File graficoRadiacionSolar = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoSolar");
        ChartUtils.saveChartAsPNG(graficoRadiacionSolar, graficoSolar, 600, 400);

        JFreeChart graficoHum = util.hacerGrafica(datos, 3, "Humedad relativa");
        File graficoHumedad = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoHumedad");
        ChartUtils.saveChartAsPNG(graficoHumedad, graficoHum, 600, 400);

        //Con esta opci�n se sobreescribir� el documento si hay otro llamado igual
        // Files.write(filePath, datos, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        StringBuilder sb = new StringBuilder("<html><head><title>Lector MGG y AGDP</title></head><body><h2>Lector de CSV by Andrea G�mez De Pablo y Mario Gonz�lez G�mez</h2>");
        sb.append("<img src=\"https://d7lju56vlbdri.cloudfront.net/var/ezwebin_site/storage/images/_aliases/img_1col/noticias/madrid-es-la-ciudad-europea-con-mayor-nivel-de-contaminacion-por-no2-y-mortalidad-asociada/8552348-12-esl-MX/Madrid-es-la-ciudad-europea-con-mayor-nivel-de-contaminacion-por-NO2-y-mortalidad-asociada.jpg\" width=\"700\" height=\"500\">");
        sb.append("<hr/><h1>Informe de datos de " + ciudad + "</h1>");
        sb.append("<ul><li>Fecha de inicio de la medici�n: </li><li>Fecha de fin de la medici�n: </li><li>Estaci�n/estaciones asociadas:</li></ul>");
        sb.append("<hr/><h2>************************   DATOS METEO   *******************************</h2>");
        sb.append("<h4>TEMPERATURA</h4><ul><li>Temperatura media mensual: " + datos.get(2).getMediaMensual() + "</li> <li>Momento y temperatura m�xima: </li> <li>Momento y temperatura m�nima:</li> </ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoTemp\"></br>");
        sb.append("<h4>RADIACI�N SOLAR</h4> <ul><li>Radiaci�n solar media mensual: " + datos.get(5).getMediaMensual() + "</li> <li>Momento y radiaci�n m�xima: </li> <li>Momento y radiaci�n m�nima:</li> </ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoSolar\"></br>");
        sb.append("<h4>PRECIPITACI�N</h4> <ul><li>Precipitaci�n media mensual: " + datos.get(6).getMediaMensual() + "</li> <li>Lista de d�as que ha llovido y precipitaci�n de cada d�a: </li></ul>");
        sb.append("<h4>HUMEDAD</h4> <ul><li>Humedad relativa media mensual: " + datos.get(3).getMediaMensual() + "</li> <li>Momento y humedad m�xima: </li> <li>Momento y humedad m�nima :</li></ul> <img src=\"" + System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos" + File.separator + "graficoHumedad\"></br>");
        sb.append("<h4>VELOCIDAD DEL VIENTO</h4> <ul><li>Velocidad media del viento mensual: " + datos.get(0).getMediaMensual() + "</li> <li>Momento y velocidad m�xima: </li> <li>Momento y velocidad m�nima :</li></ul>");
        sb.append("<p><i>Informe generado el " + ld.getDayOfMonth() + "/" + ld.getMonth() + "/" + ld.getYear() + " a las " + cldr.get(Calendar.HOUR_OF_DAY)
                + ":" + cldr.get(Calendar.MINUTE) + ":" + cldr.get(Calendar.SECOND)
                + " en " + (System.currentTimeMillis() - initTime) / 1000 + " segundos.</p></i>");

        sb.append("</body></html>");
        byte[] strToBytes;
        //Para insertar imagen con markdown se pone ![texto descriptivo](enlace a la imagen)

        String html = sb.toString();
        System.out.println(html);
        strToBytes = html.getBytes();
        Files.write(filePath, strToBytes, StandardOpenOption.CREATE);

    }


}

