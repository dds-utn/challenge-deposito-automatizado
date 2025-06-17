package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.mantenimiento.Iobserver;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class LlamarMantenimientoStrategy implements EstrategiaObstaculo {
    private Iobserver observer;

    @Override
    public void manejarObstaculo(Robot robot) {
        observer.notificarMantenimiento(robot);
        robot.setDetener(true);
    }
} 