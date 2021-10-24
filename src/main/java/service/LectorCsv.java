package service;

import entity.Documento;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class LectorCsv {

    public List<Documento> leerCsv(File file, String ciudad) throws IOException {
        Documento doc = new Documento();
        System.out.println(ciudad);
        ciudad= (Normalizer.normalize(ciudad, Normalizer.Form.NFD)).toLowerCase().replace("-","").replace(" ","");
        System.out.println(ciudad);
        String codCiudad= Temporal.CIUDAD_COD.get(ciudad);
        System.out.println(codCiudad);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        StringTokenizer st;
        List<StringTokenizer> datosCiudad = new ArrayList<>();

        while (line != null) {
            //normalizo la línea para casos como las estaciones donde necesitamos
            // leer la línea con la ciudad ( y no sabemos si esta está escrita correctamente, en mayus, con o sin acentos...
            if (line.matches(".*;" + codCiudad + ".*") || (Normalizer.normalize(line, Normalizer.Form.NFD)).toLowerCase().replace("-","").replace(" ","").contains(ciudad)) {
                st = new StringTokenizer(line, ";");
                datosCiudad.add(st);
                line = br.readLine();
            } else {
                line = br.readLine();
            }
        }
        doc.setDatosCiudad(datosCiudad);
        return doc.mapeoDocumento();
    }
}
