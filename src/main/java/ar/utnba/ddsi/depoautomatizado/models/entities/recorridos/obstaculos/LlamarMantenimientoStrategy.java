package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.List;

public class LlamarMantenimientoStrategy implements EstrategiaObstaculo {
    @Override
    public void manejarObstaculo(Robot robot) {
        robot.llamarAMantenimiento();
    }
} 