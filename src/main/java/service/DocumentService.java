package service;

import entity.Documento;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

//CLASE QUE MAPEA EL CSV A OBJETOS.
public class DocumentService {

    private List<StringTokenizer> datosCiudad;
    private Documento medicionesDia;
    private List<Documento> medicionesCiudad = new ArrayList<>();
    private Documento miDocumento;


    public List<Documento> mapeoDocumento(List<StringTokenizer> datosCiudad) throws ParseException {

        this.datosCiudad = datosCiudad;
        medicionesDia = new Documento();
        for (StringTokenizer linea : datosCiudad) { //Cada linea es la medicion de una magnitud
            medicionesDia = new Documento();
            medicionesDia.setProvincia(Integer.parseInt(linea.nextToken()));
            medicionesDia.setMunicipio(Integer.parseInt(linea.nextToken()));
            medicionesDia.setEstacion(Integer.parseInt(linea.nextToken()));
            medicionesDia.setMagnitud(Integer.parseInt(linea.nextToken()));
            medicionesDia.setPuntoMuestreo(linea.nextToken());
            medicionesDia.setAno(Integer.parseInt(linea.nextToken()));
            medicionesDia.setMes(Integer.parseInt(linea.nextToken()));
            medicionesDia.setDia(Integer.parseInt(linea.nextToken()));
            medicionesDia.setFecha(generarFecha());

            while (linea.hasMoreTokens()) {

                String token = linea.nextToken();
                if (!token.contains("V")) { //Poner en un solo if.
                    if (!token.contains("N")) {

                            //convierto los valores a Double para poder operar con ellos.
                            NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
                            double number = nf.parse(token).doubleValue();
                            medicionesDia.getMedicionesPorhora().add(number);

                    }
                }
                if(token.contains("")){

                    medicionesDia.getMedicionesConValidaciones().add(token);
                }
                else {
                    medicionesDia.getMedicionesConValidaciones().add(token);
                }


            }
            medicionesCiudad.add(medicionesDia);
            //Double media= medicionesDia.generarMediaDiaria();
        }
        return medicionesCiudad;

    }


    public void printDocumento(List<Documento>listaDocu){

        for (Documento medicion : listaDocu
        ) {
            System.out.println(medicion.toString());
        }
    }

    public String generarFecha() {
        String fecha;
        fecha = medicionesDia.getAno() + "-" + medicionesDia.getMes() + "-" + medicionesDia.getDia();
        return fecha;

    }

}