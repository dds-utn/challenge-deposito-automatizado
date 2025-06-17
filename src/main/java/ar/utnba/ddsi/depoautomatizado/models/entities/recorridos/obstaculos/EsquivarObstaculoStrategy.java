package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.Comando;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

import java.util.List;

public class EsquivarObstaculoStrategy implements EstrategiaObstaculo {
    @Override
    public void manejarObstaculo(Robot robot) {
        robot.esquivarObstaculo();
        robot.getComandosHistorial().get(robot.getComandosHistorial().size() -1).ejecutar(robot);
    }
} 