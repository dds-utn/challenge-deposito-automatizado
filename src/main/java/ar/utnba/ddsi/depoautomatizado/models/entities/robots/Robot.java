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
    private Posicion posicion;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
        this.posicion = new Posicion(0,0,0);
    }
    public abstract void avanzar(int distancia);
    public abstract void girar(int distancia);
    public abstract void recojerPaquete();
    public abstract void dejarPaquete();
} 