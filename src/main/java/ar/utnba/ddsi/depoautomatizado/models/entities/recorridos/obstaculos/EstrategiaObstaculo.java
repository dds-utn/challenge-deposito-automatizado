package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Adapter.RobotAdapter;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;

public interface EstrategiaObstaculo {
    void manejarObstaculo(RobotAdapter robot);
} 