package service;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.HashMap;

public class Temporal {
    final static HashMap<String, String> CIUDAD_COD = new HashMap<>();

    public Temporal() {
       mapearCiudadCodigo();
    }

    public void hacerGrafica() {
        JFreeChart evolucionTemperatura = null;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.addValue(27, "Grafica 1", "Uno");
    }

    public void mapearCiudadCodigo() {
        //Cuando el usuario meta el dato de la ciudad, antes de compararlo con el map, le haremos varias modificaciones:
        //un toLowerCase, trim, y eliminando carácteres especiales (como el - de Rivas-Vaciamadrid), normalize()
        // para quitar acentos y la virgulilla (Ya lo he probado y la transforma en una n, así que escribo
        // Orusco de Tajuña como tajuna

        CIUDAD_COD.put("alcaladehenares", "28005002");
        CIUDAD_COD.put("alcobendas", "28006004");
        CIUDAD_COD.put("alcorcón", "28007004");
        CIUDAD_COD.put("algete", "28009001");
        CIUDAD_COD.put("aranjuez", "28013002");
        CIUDAD_COD.put("arganda del rey", "28014002");
        CIUDAD_COD.put("elatazar", "28016001");
        CIUDAD_COD.put("colmenar viejo", "28045002");
        CIUDAD_COD.put("collado villalba", "28047002");
        CIUDAD_COD.put("coslada", "28049003");
        CIUDAD_COD.put("fuenlabrada", "28058004");
        CIUDAD_COD.put("getafe", "28065014");
        CIUDAD_COD.put("guadalixdelasierra", "28067001");
        CIUDAD_COD.put("leganes", "28074007");
        CIUDAD_COD.put("majadahonda", "28080003");
        CIUDAD_COD.put("mostoles", "28092005");
        CIUDAD_COD.put("oruscodetajuna", "28102001");
        CIUDAD_COD.put("puertodecotos", "28120001");
        CIUDAD_COD.put("rivasvaciamadrid", "28123002");
        CIUDAD_COD.put("sanmartindevaldeiglesias", "28133002");
        CIUDAD_COD.put("torrejondeardoz", "28148004");
        CIUDAD_COD.put("valdemoro", "28161001");
        CIUDAD_COD.put("villadelprado", "28171001");
        CIUDAD_COD.put("villarejodesalvanes", "28180001");
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
