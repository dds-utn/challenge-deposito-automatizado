package ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rotar implements ComandoRobot {
    private int anguloGirado;

    @Override
    public void ejecutar(Robot robot) {
        robot.almacenarComando(this);
        robot.girar(anguloGirado);
    }
    @Override
    public void ejecutarInvertido(Robot robot) {
        robot.girar(-anguloGirado);
    }
}
