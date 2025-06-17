package ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Recorrido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compartimiento {
    private String id;
    private Posicion posicion;
    private Recorrido recorrido;

    public Compartimiento(String id, Posicion posicion) {
        this.id = id;
        this.posicion = posicion;
    }
}