package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;

public class Drone extends Robot {
    
    public Drone(Long id) {
        super(id);
    }

    public boolean desplazarse(Posicion nuevaPosicion){
        return true;
        //TODO
    };

    public void agarrarMercaderia(){
        //TODO
    };

    public void soltarMercaderia(){
        //TODO
    };

    public void esquivarObstaculo(){
        //TODO
    };
}