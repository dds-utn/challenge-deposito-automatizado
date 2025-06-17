package ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Avanzar implements ComandoRobot{
    private int unidadesAMoverse;

    @Override
    public void ejecutar(Robot robot) {
        robot.almacenarComando(this);
        robot.intentarAvanzar(unidadesAMoverse);
    }

    @Override
    public void ejecutarInvertido(Robot robot) {
        robot.intentarAvanzar(-unidadesAMoverse);
    }
}
