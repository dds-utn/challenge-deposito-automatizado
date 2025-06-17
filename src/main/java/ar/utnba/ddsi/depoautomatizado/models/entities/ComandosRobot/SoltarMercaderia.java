package ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class SoltarMercaderia implements ComandoRobot{
    @Override
    public void ejecutar(Robot robot) {
        robot.almacenarComando(this);
        robot.soltarMercaderia();
    }
    @Override
    public void ejecutarInvertido(Robot robot) {
        robot.agarrarMercaderia();
    }
}
