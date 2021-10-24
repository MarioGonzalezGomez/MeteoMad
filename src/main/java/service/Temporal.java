package service;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.HashMap;

public class Temporal {
    HashMap<String, String> ciudad_cod;
    JFreeChart evolucionTemperatura = null;
    DefaultCategoryDataset datos= new DefaultCategoryDataset();

    public Temporal() {
        ciudad_cod = new HashMap<>();
    }


    public void mapearCiudadCodigo() {
        //Cuando el usuario meta el dato de la ciudad, antes de compararlo con el map, le haremos varias modificaciones:
        //un toLowerCase, trim, y eliminando carácteres especiales (como el - de Rivas-Vaciamadrid), normalize()
        // para quitar acentos y la virgulilla (Ya lo he probado y la transforma en una n, así que escribo
        // Orusco de Tajuña como tajuna

        ciudad_cod.put("alcaladehenares","28005002");
        ciudad_cod.put("alcobendas","28006004");
        ciudad_cod.put("alcorcón","28007004");
        ciudad_cod.put("algete","28009001");
        ciudad_cod.put("aranjuez","28013002");
        ciudad_cod.put("arganda del rey","28014002");
        ciudad_cod.put("elatazar","28016001");
        ciudad_cod.put("colmenar viejo","28045002");
        ciudad_cod.put("collado villalba","28047002");
        ciudad_cod.put("coslada","28049003");
        ciudad_cod.put("fuenlabrada","28058004");
        ciudad_cod.put("getafe","28065014");
        ciudad_cod.put("guadalixdelasierra","28067001");
        ciudad_cod.put("leganes","28074007");
        ciudad_cod.put("majadahonda","28080003");
        ciudad_cod.put("mostoles","28092005");
        ciudad_cod.put("oruscodetajuna","28102001");
        ciudad_cod.put("puertodecotos","28120001");
        ciudad_cod.put("rivasvaciamadrid","28123002");
        ciudad_cod.put("sanmartindevaldeiglesias","28133002");
        ciudad_cod.put("torrejondeardoz","28148004");
        ciudad_cod.put("valdemoro","28161001");
        ciudad_cod.put("villadelprado","28171001");
        ciudad_cod.put("villarejodesalvanes","28180001");
    }
}
