package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos.ComandoRobot;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private boolean obstaculizado;
    private boolean detener;
    private EstrategiaObstaculo estrategiaObstaculo;
    private List<ComandoRobot> historialInstrucciones;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
        this.obstaculizado = false;
        this.detener = false;
        this.historialInstrucciones = new ArrayList<ComandoRobot>();
    }

    public abstract void avanzar(int unidades);
    public abstract void girar(int grados);
    public abstract void elevar(int unidades);
    public abstract void recogerPaquete();
    public abstract void dejarPaquete();

    public void manejarObstaculo(){
        this.estrategiaObstaculo.manejarObstaculo(this);
    }
    public boolean recorrer(List<ComandoRobot> instrucciones) {
        this.historialInstrucciones = new ArrayList<ComandoRobot>();
        for(ComandoRobot i : instrucciones) {
            i.ejecutar(this);
            this.historialInstrucciones.add(i);
            if(this.obstaculizado) {
                this.estrategiaObstaculo.manejarObstaculo(this);
                if(this.detener) {
                    return false;
                }
            }
        }
        return true;
    }
    public void volverAlInicio() {
        for(int i = this.historialInstrucciones.size() - 1; i >= 0; i--) {
            this.historialInstrucciones.get(i).inversa(this);
        }
    }
}