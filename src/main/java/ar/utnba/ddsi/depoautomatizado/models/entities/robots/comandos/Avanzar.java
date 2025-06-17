package ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class Avanzar implements Command {
    int distancia;

    public Avanzar(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public void ejecutar(Robot robot) {
        robot.avanzar(distancia);
    }

}
