package ar.utnba.ddsi.depoautomatizado.models.entities.robots;

;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public abstract class Robot {
    private Long id;
    private boolean disponible;
    private EstrategiaObstaculo estrategiaObstaculo;
    private List<Comando> comandosHistorial;

    Robot(Long id) {
        this.id = id;
        this.disponible = true;
        this.comandosHistorial = new ArrayList<>();
    }

    public boolean puedeRealizarComando(Comando comando){
        return comando.esRealizable(this);
    }

    public boolean detectarObstaculo(Comando comando){
        if(this.puedeRealizarComando(comando))
            return false;

        estrategiaObstaculo.manejarObstaculo(this);
        return true;
    }

    public void agregarComandoHistorial(Comando comando){
        this.comandosHistorial.add(comando);
    }

    public void limpiarHistorialComandos(){
        this.comandosHistorial.clear();
    }

    public abstract void avanzar(int distancia);
    public abstract void girar(int grados);
    public abstract void agarrar();
    public abstract void soltar();
    public abstract void esquivarObstaculo();

    // Cada robot concreto llama a mantenimiento, se podría calcular la ubicación de robot con el historial
    // de comandos
    public abstract void llamarAMantenimiento();

    //Cada robot concretro se fija si puede realizar el movimiento con sus sensores
    public abstract boolean puedeRecorrerDistancia(int distancia);
    public abstract boolean puedeGirar(int grados);
    public abstract boolean puedeAgarrar();
    public abstract boolean puedeSoltar();
}