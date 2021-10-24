package model;
import lombok.Data;
import java.util.List;

@Data
public class MedicionMeteo extends Medicion{


    private List<String> diasLlovidos; //lista dias llovidos y precipitacion de cada dia
    private String histogramaDiasLlovidos;

    public MedicionMeteo() {
    }
}
