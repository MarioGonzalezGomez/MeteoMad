package service;
//Clase donde se generará la informacion meteorologica
//Por cada magnitud se creará un objeto y se le introducirá sus valores.
//Valores: TemperaturaMediaMensual, Momento y temperatura maxima.
//Cada objeto se meterá dentro de una lista de tipo <Medicion>

import entity.Documento;
import model.Medicion;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class InfoMeteoGenerate {


    List<Documento> listaDocumento;
    List<Medicion> listaMagnitudesCalculadas = new ArrayList<>();

    public List<Documento> generarInformacionMeteo(List<Documento> listaDocumento) {

        this.listaDocumento = listaDocumento;
        mapearMagnitud();

        return this.listaDocumento;

    }

    public void mapearMagnitud() {

        for (Documento documento : listaDocumento) {

            switch (documento.getMagnitud()
            ) {
                case 81:
                    Medicion velocidadviento = new Medicion();
                    listaMagnitudesCalculadas.add(calcularMagnitud(velocidadviento));

                case 82:
                    Medicion direccionViento = new Medicion();
                    listaMagnitudesCalculadas.add(calcularMagnitud(direccionViento));

                case 83:
                    Medicion temperatura = new Medicion();
                    listaMagnitudesCalculadas.add(calcularMagnitud(temperatura));

                case 86:
                    Medicion humedadRelativa = new Medicion();
                    listaMagnitudesCalculadas.add(calcularMagnitud(humedadRelativa));

                case 87:
                    Medicion presionAtmosferica = new Medicion();
                    listaMagnitudesCalculadas.add(calcularMagnitud(presionAtmosferica));

                case 88:
                    Medicion radiacionSolar = new Medicion();
                    listaMagnitudesCalculadas.add(calcularMagnitud(radiacionSolar));

                case 89:
                    Medicion precipitacion = new Medicion();
                    listaMagnitudesCalculadas.add(calcularMagnitud(precipitacion));


            }
        }

    }

    public Medicion calcularMagnitud(Medicion magnitud) {

        System.out.println("La temperatura media diaria");
        Float suma=null;
        for (Documento doc : listaDocumento
        ) {
            for (int i = 0; i < doc.getMedicionesPorhora().size(); i++) {


                suma=suma+ Float.parseFloat(doc.getMedicionesPorhora().get(i));


            }


        }
return null;

    }





}
