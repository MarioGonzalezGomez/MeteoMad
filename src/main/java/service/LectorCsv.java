package service;

import entity.Documento;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LectorCsv {


    public Documento leerCsv(File file, String codCiudad) throws IOException {
        Documento doc = new Documento();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        StringTokenizer st;
        List<StringTokenizer> datosCiudad = new ArrayList<>();

       /* List<String> campos = new ArrayList<>();
        List<Double> mediciones = new ArrayList<>();
        double mediaDiaria;
        List<String> validacion = new ArrayList<>();
        List<LocalDate> fechas = new ArrayList<>();
        List<String> magnitudes = new ArrayList<>();
        List<String> estaciones = new ArrayList<>();
        int day;
        int month;
        int year;*/


        while (line != null) {
            if (line.matches(".*;" + codCiudad + ".*")) {
                st = new StringTokenizer(line, ";");
                datosCiudad.add(st);
                line = br.readLine();
               /* while (st.hasMoreTokens()) {
                    campos.add(st.nextToken());

                magnitudes.add(campos.get(3));
                estaciones.add(campos.get(2));
                year = Integer.parseInt(campos.get(5));
                month = Integer.parseInt(campos.get(6));
                day = Integer.parseInt(campos.get(7));


                fechas.add(LocalDate.of(year, month, day));

                for (int i = 8; i < campos.size(); i++) {
                    if (i % 2 == 0) {
                        mediciones.add(Double.valueOf(campos.get(i)));
                    }
                    if (i % 2 == 1) {
                        validacion.add(campos.get(i));
                    }
                }
                double valorAcumulado = 0;
                for (int i = 0; i < mediciones.size(); i++)
                    if (validacion.get(i) == "V") {
                        valorAcumulado = valorAcumulado + mediciones.get(i);
                    }
                mediaDiaria = valorAcumulado / mediciones.size();

            }*/

            }
        }
        doc.setDocumento(datosCiudad);
        return doc;
    }

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

}
