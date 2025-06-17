package ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class SoltarMercaderia implements ComandoRobot{
    @Override
    public void ejecutar(Robot robot) {
        robot.soltarMercaderia();
    }
}
