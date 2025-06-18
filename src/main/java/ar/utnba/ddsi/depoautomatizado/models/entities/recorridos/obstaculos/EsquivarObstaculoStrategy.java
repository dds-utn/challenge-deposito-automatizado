package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class EsquivarObstaculoStrategy implements EstrategiaObstaculo {

        @Override
        public void manejarObstaculo(Robot robot) {
            robot.esquivarObstaculo();
        }

} 