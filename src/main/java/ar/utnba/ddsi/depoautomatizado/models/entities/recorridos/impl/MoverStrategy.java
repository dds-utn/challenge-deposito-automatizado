package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.impl;

import ar.utnba.ddsi.depoautomatizado.models.entities.mercaderias.Posicion;
import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.IMovimiento;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MoverStrategy implements IMovimiento {

    final Posicion posicionRelativa;

    @Override
    public void moverRobot(Robot robot) {
        robot.mover(posicionRelativa);
    }
}
