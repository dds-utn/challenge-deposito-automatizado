package ar.utnba.ddsi.depoautomatizado.models.entities.robots;


import ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot.ComandoRobot;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos.EstrategiaObstaculo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
public abstract class Robot {
    @Setter private Long id;
    private boolean disponible;
    @Setter private EstrategiaObstaculo estrategiaObstaculo;
    private final List<ComandoRobot> comandosEjecutados = new ArrayList<>();

    public void setDisponible(boolean valor){
        this.disponible = valor;
        comandosEjecutados.clear();
    }

    public Robot (Long id) {
        this.id = id;
        this.disponible = true;
    }

    public void comandosInvertidos(ComandoRobot comandoRobot){
        comandoRobot.ejecutarInvertido(this);
    }

    public void intentarAvanzar(int unidadesAMoverse) {
        if (! avanzar(unidadesAMoverse)){
            estrategiaObstaculo.manejarObstaculo(this);
        }
    }

    public void volverAlInicio() {
        comandosEjecutados.forEach(this::comandosInvertidos);
    }

    public void almacenarComando(ComandoRobot comandoRealizado){
        comandosEjecutados.add(comandoRealizado);
    }

    public void reintentarUltimoComando(){
        ComandoRobot comandoRobot = comandosEjecutados.get(comandosEjecutados.size()-1);
        comandoRobot.ejecutar(this);
    }

    public abstract boolean avanzar(int unidadesAMoverse);

    public abstract void elevar(int unidadesAElevarse);

    public abstract void agarrarMercaderia();

    public abstract void soltarMercaderia();

    public abstract void girar(int anguloRotacion);

    public abstract void esquivarObstaculo();
}