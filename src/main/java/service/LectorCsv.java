package service;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class LectorCsv {

    public void leerCsv(File file) throws IOException {
        //Files.lines
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder line = null;
        line.append(br.readLine());
        StringTokenizer st;
        //Objeto obj = new Objeto
        while (line != null) {
            //TODO:Cambiar por salida a documento
            //TODO:Comprobar que el delimitador entre elementos es ,
            st = new StringTokenizer(line.toString(), ",");
            for (int i = 0; i < st.countTokens(); i++) {
                //obj.setAttr(st.nextElement());
            }
            line.append(br.readLine());
        }
    }
}
