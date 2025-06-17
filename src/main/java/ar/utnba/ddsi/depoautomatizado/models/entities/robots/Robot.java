package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    protected boolean disponible;
    protected Boolean mercaderiaAgarrada;
    private EstrategiaObstaculo estrategiaObstaculo;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
        this.mercaderiaAgarrada = false;
    }

    public void mover(Posicion posicion) {
        try {
            this.moverAPosicion(posicion);
        } catch (Exception e) {
            manejarObstaculo();
        }
    }

    abstract void moverAPosicion(Posicion posicion);

    public abstract void agarrar(Posicion posicion);

    public abstract void soltar(Posicion posicion);

    public void manejarObstaculo() {
        this.estrategiaObstaculo.manejarObstaculo(this);
    }

}