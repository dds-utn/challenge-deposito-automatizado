package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

public class Drone extends Robot {
    
    public Drone(Long id) {
        super(id);
    }

    public void avanzar(Integer distancia){}

    public void girar(Integer grados){}

    public void elevar(Integer altura){}

    public void recogerPaquete(){}

    public void dejarPaquete(){}
} 