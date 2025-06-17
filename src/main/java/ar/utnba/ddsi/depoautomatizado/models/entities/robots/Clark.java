package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

public class Clark extends Robot {
    
    public Clark(Long id) {
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