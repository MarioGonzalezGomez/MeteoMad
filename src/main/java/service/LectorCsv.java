package service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LectorCsv {


    public void leerCsv(File file, String codCIudad) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder line = new StringBuilder(br.readLine());
        StringTokenizer st;

        while (line != null) {
            st = new StringTokenizer(line.toString(), ";");
            line = null;
            line.append(br.readLine());
            while (st.hasMoreTokens() == true) {
                System.out.print(st.nextToken());
            }


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
}
