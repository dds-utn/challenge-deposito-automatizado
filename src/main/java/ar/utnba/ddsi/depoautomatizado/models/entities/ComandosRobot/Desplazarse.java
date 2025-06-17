package ar.utnba.ddsi.depoautomatizado.models.entities.ComandosRobot;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Desplazarse implements ComandoRobot{
    private Posicion posicion;

    @Override
    public void ejecutar(Robot robot) {
        robot.desplazarse(posicion);
    }
}
