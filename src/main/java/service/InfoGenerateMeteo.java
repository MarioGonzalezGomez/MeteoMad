package service;
//CLASE QUE CALCULARÁ LOS DATOS REQUERIDOS PARA LA INFORMACION METEOROLOGICA DE CADA MAGNITUD.

import entity.Documento;
import model.Medicion;
import model.MedicionPrecipitacion;

import java.util.ArrayList;
import java.util.List;

public class InfoGenerateMeteo {

    List<Documento> listaDocumento = new ArrayList<>();
    List<Medicion> listaMagnitudesCalculadas = new ArrayList<>();
    List<Double> mediasDiarias = new ArrayList<>();

    Medicion velocidadviento = new Medicion("Velocidad viento");
    Medicion direccionViento = new Medicion("Direccion Viento");
    Medicion temperatura = new Medicion("Temperatura");
    Medicion humedadRelativa = new Medicion("Humedad relativa");
    Medicion presionAtmosferica = new Medicion("Presion atmosferica");
    Medicion radiacionSolar = new Medicion("Radiacion solar");
    MedicionPrecipitacion precipitacion = new MedicionPrecipitacion();



    public List<Medicion> generarInformacionMeteo(List<Documento> listaDocumento) {

        this.listaDocumento = listaDocumento;
        mapearMagnitudMeteo();
        setearMagnitudValores(velocidadviento);
        listaMagnitudesCalculadas.add(velocidadviento);
        setearMagnitudValores(direccionViento);
        listaMagnitudesCalculadas.add(direccionViento);
        setearMagnitudValores(temperatura);
        listaMagnitudesCalculadas.add(temperatura);
        setearMagnitudValores(humedadRelativa);
        listaMagnitudesCalculadas.add(humedadRelativa);
        setearMagnitudValores(presionAtmosferica);
        listaMagnitudesCalculadas.add(presionAtmosferica);
        setearMagnitudValores(radiacionSolar);
        listaMagnitudesCalculadas.add(radiacionSolar);
        setearMagnitudValores(precipitacion);
        listaMagnitudesCalculadas.add(precipitacion);

        return this.listaMagnitudesCalculadas;

    }

    public void mapearMagnitudMeteo() {

        for (Documento documento : listaDocumento) {
            switch (documento.getMagnitud()
            ) {
                case 81:
                    //calcularMediaMensual(documento.getMedicionesPorhora());
                    (velocidadviento.getMediasMedicionesDiarias()).add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    velocidadviento.getMedicionesMensuales().addAll(documento.getMedicionesPorhora());
                    break;
                case 82:
                    direccionViento.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    direccionViento.getMedicionesMensuales().addAll(documento.getMedicionesPorhora());
                    break;
                case 83:
                    temperatura.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    temperatura.getMedicionesMensuales().addAll(documento.getMedicionesPorhora());
                    break;
                case 86:
                    humedadRelativa.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    humedadRelativa.getMedicionesMensuales().addAll(documento.getMedicionesPorhora());
                    break;
                case 87:
                    presionAtmosferica.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    presionAtmosferica.getMedicionesMensuales().addAll(documento.getMedicionesPorhora());
                    break;
                case 88:
                    radiacionSolar.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    radiacionSolar.getMedicionesMensuales().addAll(documento.getMedicionesPorhora());
                    break;
                case 89:
                    precipitacion.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    precipitacion.getMedicionesMensuales().addAll(documento.getMedicionesPorhora());
                    break;
            }
        }

    }

    public Double calcularMediaDiaria(List<Double> listaDocumento) {


        double sum = 0;
        double mediaDiaria = 0;
        //List<Double>mediasDiarias = new ArrayList<>();
        for (Double valor : listaDocumento) {

            for (int i = 0; i < listaDocumento.size(); i++) {

                sum += listaDocumento.get(i);
            }

        }
        mediaDiaria = sum / listaDocumento.size();
        mediasDiarias.add(mediaDiaria);
        return mediaDiaria;
    }

    public double calcularMediaMensual(List<Double> listaMedicionesDiarias) {

        double suma = 0;
        double media = 0;
        for (Double mediaDiaria : listaMedicionesDiarias
        ) {
            suma += mediaDiaria;

        }
        media = suma / listaDocumento.size();

        return (double) Math.round(media * 100d) / 100d;

    }

    public void calcularMomentoyMaxima() {


        for (Documento doc : listaDocumento
        ) {
            for (int i = 0; i < doc.getMedicionesConValidaciones().size(); i++) {
                doc.getMedicionesConValidaciones().get(i);
            }

        }


    }


    public void setearMagnitudValores(Medicion magnitud) { //Metodo que le setea a cada magnitud los valores requeridos.

        magnitud.setMediaMensual(calcularMediaMensual(magnitud.getMediasMedicionesDiarias()));
        // magnitud.setMomentoYmaxima(calcularMomentoYminima);

    }


}



