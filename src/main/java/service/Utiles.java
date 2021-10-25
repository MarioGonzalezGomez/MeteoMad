package service;

import lombok.Data;
import model.Medicion;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

@Data
public class Utiles {
    final static HashMap<String, String> COD_CIUDAD = mapearCiudadCodigo();

    public Utiles() {
        mapearCiudadCodigo();
    }

    public JFreeChart hacerGrafica(List<Medicion> mediciones, int index, String nombreTabla) {
        JFreeChart evolucionTemperatura = null;
        //Para las gráficas de pastel debemos hacer DefaultPieDataset
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        //En los pie, se utilizaria datos.setValue(nombre de la variable, dato)
        //Valor , Gráfica a la que pertenece, Texto que aparece debajo
        Medicion medicion = mediciones.get(index);
        List<Double> diarias = medicion.getMediasMedicionesDiarias();
        double acumulado = 0.0;
        for (int i = 0; i < diarias.size(); i++) {
            datos.addValue(diarias.get(i), nombreTabla, "" + (i + 1));
            acumulado = acumulado + diarias.get(i);
        }

        //Ejemplo
        //datos.addValue(27, "Grafica 1", "Uno");

        //con ChartFactory.create... nos aparecen los distintos tipos de graficas disponibles
        // titulo de grafica, titulo eje X, eje Y, DefaultCategoryDataset, orientacion de la grafica
        //definida como PlotOrientation.VERTICAL u HORIZONTAL, y 3 boolean
        //1: Si se muestra leyenda al pasar raton por encima
        //2: grupo al que pertenece
        //3: para meter una URI
        if (index == 2) {
            evolucionTemperatura = ChartFactory.createLineChart(nombreTabla + " día a día", "Día del mes", "ºC", datos, PlotOrientation.VERTICAL, true, false, false);
        }
        if (index == 5) {
            evolucionTemperatura = ChartFactory.createBarChart(nombreTabla + " día a día", "Día del mes", "ºC", datos, PlotOrientation.VERTICAL, true, false, false);
        }
        if (index == 3) {
            evolucionTemperatura = ChartFactory.createAreaChart(nombreTabla + " día a día", "Día del mes", "ºC", datos, PlotOrientation.VERTICAL, true, false, false);
        }

        // Los pie se crean similar, pero sus parametros son (nombre grafica, DefaultPieDataset, y los mismos 3 boolenos
        //Esto para poner colorinchis de fondo. También hay un background image

        evolucionTemperatura.setBackgroundPaint(new Color(250, 6, 34, 48));

        //Cambiar color lineas con setDomainGridlinePaint
        //
        return evolucionTemperatura;
    }

    public static HashMap<String, String> mapearCiudadCodigo() {
        HashMap<String, String> funcionas = new HashMap<>();
        //Cuando el usuario meta el dato de la ciudad, antes de compararlo con el map, le haremos varias modificaciones:
        //un toLowerCase, trim, y eliminando carácteres especiales (como el - de Rivas-Vaciamadrid), normalize()
        // para quitar acentos y la virgulilla (Ya lo he probado y la transforma en una n, así que escribo
        // Orusco de Tajuña como tajuna

        funcionas.put("alcaladehenares", "28005002");
        funcionas.put("alcobendas", "28006004");
        funcionas.put("alcorcón", "28007004");
        funcionas.put("algete", "28009001");
        funcionas.put("aranjuez", "28013002");
        funcionas.put("argandadelrey", "28014002");
        funcionas.put("elatazar", "28016001");
        funcionas.put("colmenarviejo", "28045002");
        funcionas.put("colladovillalba", "28047002");
        funcionas.put("coslada", "28049003");
        funcionas.put("fuenlabrada", "28058004");
        funcionas.put("getafe", "28065014");
        funcionas.put("guadalixdelasierra", "28067001");
        funcionas.put("leganes", "28074007");
        funcionas.put("majadahonda", "28080003");
        funcionas.put("mostoles", "28092005");
        funcionas.put("oruscodetajuna", "28102001");
        funcionas.put("puertodecotos", "28120001");
        funcionas.put("rivasvaciamadrid", "28123002");
        funcionas.put("sanmartindevaldeiglesias", "28133002");
        funcionas.put("torrejondeardoz", "28148004");
        funcionas.put("valdemoro", "28161001");
        funcionas.put("villadelprado", "28171001");
        funcionas.put("villarejodesalvanes", "28180001");
        return funcionas;
    }
}
//Vano intento de leer un documento con Java.Nio y usar Lamda para filtrarlo ( Con su consecuente sensación de fracaso)
/* Path path = Paths.get(file.getPath());
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> {
                Stream<String> filtrado = null;
                StringBuilder line = null;


                filtrado = lines.filter(str -> str.contains(codCIudad));
                filtrado.forEach(f -> {
                        StringTokenizer st = null;
                        st = new StringTokenizer(f.toString(), ";");

                });

            });
        }*/
