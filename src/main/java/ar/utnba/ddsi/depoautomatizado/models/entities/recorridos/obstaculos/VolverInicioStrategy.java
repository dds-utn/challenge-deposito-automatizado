package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.DetenerRecorridoException;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public class VolverInicioStrategy implements EstrategiaObstaculo {
    
    @Override
    public void manejarObstaculo(Robot robot) {
        robot.volverAlInicio();
        throw new DetenerRecorridoException("VolverAlInicio");
    }
} 