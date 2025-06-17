package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private boolean obstaculizado;
    private EstrategiaObstaculo estrategiaObstaculo;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
        this.obstaculizado = false;
    }

    public abstract void avanzar(int unidades);
    public abstract void girar(int grados);
    public abstract void elevar(int unidades);
    public abstract void recojerPaquete();
    public abstract void dejarPaquete();

    public void manejarObstaculo(){
        this.estrategiaObstaculo.manejarObstaculo(this);
    }
}