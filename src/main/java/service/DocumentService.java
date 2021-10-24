package service;

import entity.Documento;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DocumentService {

    private List<StringTokenizer> datosCiudad;
    private Documento medicionesDia;
    private List<Documento> medicionesCiudad = new ArrayList<>();
    private Documento miDocumento;


    public List<Documento> mapeoDocumento(List<StringTokenizer> datosCiudad) {

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
                        medicionesDia.getMedicionesPorhora().add(token);

                    }
                }
            }
            medicionesCiudad.add(medicionesDia);
            //Double media= medicionesDia.generarMediaDiaria();
        }
        for (Documento medicion : medicionesCiudad
        ) {
            System.out.println(medicion.toString());
        }

        InfoMeteoGenerate informeteo = new InfoMeteoGenerate();
        informeteo.generarInformacionMeteo(medicionesCiudad);
        return medicionesCiudad;

    }

    public String generarFecha() {
        String fecha;
        fecha = medicionesDia.getAno() + "-" + medicionesDia.getMes() + "-" + medicionesDia.getDia();
        return fecha;

    }

}
