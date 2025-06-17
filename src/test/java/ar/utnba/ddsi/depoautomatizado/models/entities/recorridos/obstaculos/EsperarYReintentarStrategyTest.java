package ar.utnba.ddsi.depoautomatizado.models.entities.recorridos.obstaculos;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ar.utnba.ddsi.depoautomatizado.models.entities.robots.Robot;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.Avanzar;
import ar.utnba.ddsi.depoautomatizado.models.entities.robots.instrucciones.InstruccionRobot;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EsperarYReintentarStrategyTest {
  @Test
  void manejarObstaculo_debeEsperarYReintentar() {
    Robot robot = Mockito.mock(Robot.class);
    EsperarYReintentarStrategy strategy = new EsperarYReintentarStrategy(1); // espera 100ms

    when(robot.ultimaInstruccion()).thenReturn(Mockito.mock(InstruccionRobot.class));
    strategy.manejarObstaculo(robot);

    Mockito.verify(robot).setObstaculizado(false);
  }
}
