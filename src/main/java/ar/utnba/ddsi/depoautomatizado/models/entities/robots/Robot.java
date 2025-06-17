package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private EstrategiaObstaculo estrategiaObstaculo;
    private Posicion posicionDescanso;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
    }

    public void intentarDesplazarse(Posicion nuevaPosicion) {
        if (! desplazarse(nuevaPosicion)){
            estrategiaObstaculo.manejarObstaculo(this);
        }
    }

    public abstract boolean desplazarse(Posicion nuevaPosicion);

    public abstract void agarrarMercaderia();

    public abstract void soltarMercaderia();

    public abstract void esquivarObstaculo();
}