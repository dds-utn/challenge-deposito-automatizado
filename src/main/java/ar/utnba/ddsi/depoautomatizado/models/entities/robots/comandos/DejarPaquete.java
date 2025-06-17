package ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class DejarPaquete implements Command {
    @Override
    public void ejecutar(Robot robot){
        robot.dejarPaquete();
    }
}
