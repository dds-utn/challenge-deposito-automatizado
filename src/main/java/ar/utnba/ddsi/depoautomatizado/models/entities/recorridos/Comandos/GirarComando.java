package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class GirarComando implements Comando {
    private int grados;

    public GirarComando(int grados) {
        this.grados = grados;
    }

    @Override
    public void ejecutar(Robot robot) {
        robot.girar(grados);
    }

    @Override
    public boolean esRealizable(Robot robot) {
        return robot.puedeGirar(grados);
    }
}
