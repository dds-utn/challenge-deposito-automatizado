package ar.utnba.ddsi.depoautomatizado.models.entities.robots.comandos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface Command {

    public void ejecutar(Robot robot);
}
