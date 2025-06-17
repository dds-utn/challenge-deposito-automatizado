package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EsperarYReintentarStrategyTest {
  @Test
  void manejarObstaculo_debeEsperarYReintentar() {
    Robot robot = Mockito.mock(Robot.class);
    EsperarYReintentarStrategy strategy = new EsperarYReintentarStrategy(1); // espera 100ms

    strategy.manejarObstaculo(robot);

    Mockito.verify(robot).setObstaculizado(false);
  }
}
