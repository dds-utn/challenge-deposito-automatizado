package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AgarrarComando implements Comando {
    @Override
    public void ejecutar(Robot robot) {
        robot.agarrar();
    }

    @Override
    public boolean esRealizable(Robot robot) {
        return robot.puedeAgarrar();
    }
}
