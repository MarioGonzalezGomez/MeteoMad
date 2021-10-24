package service;

import lombok.Data;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.HashMap;

@Data
public class Temporal {
    final static HashMap<String, String> COD_CIUDAD = mapearCiudadCodigo();

    public Temporal() {
        mapearCiudadCodigo();
    }

    public void hacerGrafica() {
        JFreeChart evolucionTemperatura = null;
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.addValue(27, "Grafica 1", "Uno");
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
