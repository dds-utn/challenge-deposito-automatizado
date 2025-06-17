package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EsquivarObstaculoStrategyTest {
  @Test
  void manejarObstaculo_debeManejarObstaculo() {
    Robot robot = Mockito.mock(Robot.class);
    EsquivarObstaculoStrategy strategy = new EsquivarObstaculoStrategy();

    strategy.manejarObstaculo(robot);

    Mockito.verify(robot).manejarObstaculo();
  }
}
