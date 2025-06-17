package ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Elevar implements ComandoRobot{
    private int unidadesAMoverse;

    @Override
    public void ejecutar(Robot robot) {
        robot.almacenarComando(this);
        robot.elevar(unidadesAMoverse);
    }

    @Override
    public void ejecutarInvertido(Robot robot) {
        robot.elevar(-unidadesAMoverse);
    }
}
