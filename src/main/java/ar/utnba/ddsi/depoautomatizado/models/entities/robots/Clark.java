package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;

public class Clark extends Robot {
    
    public Clark(Long id) {
        super(id);
    }

    @Override
    void moverAPosicion(Posicion posicion) {
        // TODO: no sabemos cómo se mueve
    }

    @Override
    public void agarrar(Posicion posicion) {
        if(!mercaderiaAgarrada) {
            mercaderiaAgarrada = true;
            // TODO: no sabemos cómo se agarra
        } else {
            throw new RuntimeException("Ya tiene mercadería agarrada");
        }
    }

    @Override
    public void soltar(Posicion posicion) {
        // TODO: no sabemos cómo se mueve
        if(!mercaderiaAgarrada) {
            // TODO: no sabemos cómo se suelta
            mercaderiaAgarrada = false;
        } else {
            throw new RuntimeException("No tiene mercadería agarrada");
        }
    }
} 