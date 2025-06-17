package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.acciones;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class AccionResolverObstaculo implements Accion{
    @Override
    public void ejecutar(Robot robot) {
        robot.getEstrategiaObstaculo().manejarObstaculo(robot);
    }
}
