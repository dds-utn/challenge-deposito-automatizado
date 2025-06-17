package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Drone extends Robot {


    public Drone(Long id) {
        super(id);
    }

    //TODO
    @Override
    public void avanzar(int distancia) {
        // lógica para que Clark avance
    }

    @Override
    public void girar(int grados) {
        // lógica para que Clark gire
    }

    @Override
    public void recojerPaquete() {
        // lógica para recoger paquete
    }

    @Override
    public void dejarPaquete() {
        // lógica para dejar paquete
    }

}