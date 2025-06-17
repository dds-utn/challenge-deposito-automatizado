package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.DetenerRecorridoException;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class LlamarMantenimientoStrategy implements EstrategiaObstaculo {

    @Override
    public void manejarObstaculo(Robot robot) {
        robot.llamarMantenimiento();
        throw new DetenerRecorridoException("LlamarMantenimiento");
    }
} 