package ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface ComandoRobot {
    public void ejecutar(Robot robot);
    public void ejecutarInvertido(Robot robot);
}
