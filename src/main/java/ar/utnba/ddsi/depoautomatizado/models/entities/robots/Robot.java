package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.ObstaculoException;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private EstrategiaObstaculo estrategiaObstaculo;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
    }

    public void avanzar(Integer pasos) {
        try {
            avanzarParticular(pasos);
        } catch (Exception e) {
            failOver();
        }
    }
    public abstract void avanzarParticular(Integer pasos);


    public void girar (Integer grados) {
        try {
            girarParticular(grados);
        } catch (ObstaculoException e) {
            failOver();
        }
    }
    public abstract void girarParticular(Integer grados);


    public void elevar (Integer metros) {
        try {
            elevarParticular(metros);
        } catch (ObstaculoException e) {
            failOver();
        }
    }
    public abstract void elevarParticular(Integer metros);


    public void recogerPaquete () {
        try {
            recogerPaqueteParticular();
        } catch (ObstaculoException e) {
            failOver();
        }
    }
    public abstract void recogerPaqueteParticular();

    public void dejarPaquete () {
        try {
            dejarPaqueteParticular();
        } catch (ObstaculoException e) {
            failOver();
        }
    }
    public abstract void dejarPaqueteParticular();

    //-------------------ACCIONES ANTE UN OBSTÁCULO---------------------------------------------//

    public abstract void esquivarObstaculo();

    public abstract void llamarMantenimiento();

    public abstract void volverAlInicio();

    //-------------------FAIL OVER--------------------------------------------------------------//

    public void failOver(){
        estrategiaObstaculo.manejarObstaculo(this);
    }
}
