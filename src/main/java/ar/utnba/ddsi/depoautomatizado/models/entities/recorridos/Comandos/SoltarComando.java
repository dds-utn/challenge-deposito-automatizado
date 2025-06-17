package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class SoltarComando implements Comando {
    @Override
    public void ejecutar(Robot robot) {
        robot.soltar();
    }

    @Override
    public boolean esRealizable(Robot robot) {
        return robot.puedeSoltar();
    }
}
