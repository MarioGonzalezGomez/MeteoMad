package service;
//Clase donde se generará la informacion meteorologica
//Por cada magnitud se creará un objeto y se le introducirá sus valores.
//Valores: TemperaturaMediaMensual, Momento y temperatura maxima.
//Cada objeto se meterá dentro de una lista de tipo <Medicion>

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
        calcularMagnitud(velocidadviento);
        listaMagnitudesCalculadas.add(velocidadviento);
        calcularMagnitud(direccionViento);
        listaMagnitudesCalculadas.add(direccionViento);
        calcularMagnitud(temperatura);
        listaMagnitudesCalculadas.add(temperatura);
        calcularMagnitud(humedadRelativa);
        listaMagnitudesCalculadas.add(humedadRelativa);
        calcularMagnitud(presionAtmosferica);
        listaMagnitudesCalculadas.add(presionAtmosferica);
        calcularMagnitud(radiacionSolar);
        listaMagnitudesCalculadas.add(radiacionSolar);
        calcularMagnitud(precipitacion);
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
                    break;
                case 82:
                    direccionViento.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    break;
                case 83:
                    temperatura.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    break;
                case 86:
                    humedadRelativa.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    break;
                case 87:
                    presionAtmosferica.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    break;
                case 88:
                    radiacionSolar.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
                    break;
                case 89:
                    precipitacion.getMediasMedicionesDiarias().add(calcularMediaDiaria(documento.getMedicionesPorhora()));
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

    public void calcularMagnitud(Medicion magnitud) { //Metodo que le setea a cada magnitud los valores requeridos.

        magnitud.setMediaMensual(calcularMediaMensual(magnitud.getMediasMedicionesDiarias()));
        // magnitud.setMomentoYmaxima(calcularMomentoYminima);

    }


}



