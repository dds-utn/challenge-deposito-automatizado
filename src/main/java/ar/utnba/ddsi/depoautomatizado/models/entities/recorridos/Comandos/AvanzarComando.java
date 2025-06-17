package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AvanzarComando implements Comando {
    private int distancia;

    public AvanzarComando(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public void ejecutar(Robot robot) {
        robot.avanzar(distancia);
    }

    @Override
    public boolean esRealizable(Robot robot) {
        return robot.puedeRecorrerDistancia(distancia);
    }
}
